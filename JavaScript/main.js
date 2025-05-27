// Log welcome message
console.log("Welcome to the Community Portal");

// Event Class// Define the Event class with ES6+ features
class Event {
    constructor(id, name, date, location, seats = 50, category) {
        this.id = id;
        this.name = name;
        this.date = new Date(date);
        this.location = location;
        this.seats = seats;
        this.category = category;
        this.registeredUsers = new Set();
    }

    // Using concise method syntax
    checkAvailability() {
        return {
            available: this.seats > 0,
            remainingSeats: this.seats,
            isUpcoming: this.isUpcoming()
        };
    }

    // Using arrow functions and early returns for cleaner code
    registerUser = (userId) => {
        // Check if user is already registered
        if (this.registeredUsers.has(userId)) {
            throw new Error("User is already registered for this event");
        }

        // Check if seats are available
        if (this.seats <= 0) {
            throw new Error("No seats available for this event");
        }

        // Register user
        this.registeredUsers.add(userId);
        this.seats--;

        return {
            success: true,
            remainingSeats: this.seats
        };
    }

    // Using arrow functions
    cancelRegistration = (userId) => {
        // Check if user is registered
        if (!this.registeredUsers.has(userId)) {
            throw new Error("User is not registered for this event");
        }

        // Cancel registration
        this.registeredUsers.delete(userId);
        this.seats++;

        return {
            success: true,
            remainingSeats: this.seats
        };
    }

    // Using arrow function with implicit return
    isUpcoming = () => {
        const currentDate = new Date("2025-05-27"); // Updated to current date
        return this.date > currentDate;
    }

    // Static factory method to create Event from JSON data
    static fromJSON = (eventData) => {
        const { id, name, date, location, seats, category } = eventData; // Destructuring
        return new Event(id, name, date, location, seats, category);
    }

    // Get event details using Object.entries
    getDetails() {
        const details = Object.entries(this).map(([key, value]) => {
            if (key === 'date') return [key, value.toISOString().split('T')[0]];
            if (key === 'registeredUsers') return [key, Array.from(value)];
            return [key, value];
        });
        return Object.fromEntries(details);
    }
}

// Event loading and management with ES6+ features
const eventManager = {
    events: [],

    // Show/hide loading spinner with destructuring and default parameters
    toggleLoading: (show = true) => {
        const spinner = document.querySelector('#loading-spinner');
        const container = document.querySelector('#events-container');
        if (spinner && container) {
            spinner.style.display = show ? 'block' : 'none';
            container.style.display = show ? 'none' : 'grid';
        }
    },

    // Show error message with template literals
    showError: (message = 'An error occurred') => {
        const errorDiv = document.querySelector('#error-message');
        if (errorDiv) {
            errorDiv.textContent = message;
            errorDiv.style.display = 'block';
        }
    },

    // Hide error message with arrow function
    hideError: () => {
        const errorDiv = document.querySelector('#error-message');
        if (errorDiv) {
            errorDiv.style.display = 'none';
        }
    },

    // Promise-based implementation with arrow functions and template literals
    loadEventsWithPromise: () => {
        eventManager.toggleLoading(true);
        eventManager.hideError();

        return fetch('events-data.json')
            .then(response => {
                if (!response.ok) {
                    throw new Error(`HTTP error! status: ${response.status}`);
                }
                return response.json();
            })
            .then(({ events }) => { // Destructuring the response
                // Using map with the static factory method and spread operator
                eventManager.events = events.map(eventData => Event.fromJSON(eventData));
                domOperations.renderEvents();
            })
            .catch(error => {
                console.error(`Error loading events: ${error.message}`);
                eventManager.showError('Failed to load events. Please try again later.');
            })
            .finally(() => eventManager.toggleLoading(false)); // Concise arrow function
    },

    // Async/await implementation with destructuring and concise error handling
    loadEventsAsync: async () => {
        try {
            eventManager.toggleLoading();
            eventManager.hideError();

            const response = await fetch('events-data.json');
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }

            const { events } = await response.json(); // Destructuring
            
            // Using static factory method with destructuring
            eventManager.events = events.map(Event.fromJSON);

            domOperations.renderEvents();
        } catch ({ message }) { // Destructuring the error object
            console.error(`Error loading events: ${message}`);
            eventManager.showError(`Failed to load events: ${message}`);
        } finally {
            eventManager.toggleLoading(false);
        }
    },

    // Retry mechanism with default parameters and async/await
    loadEventsWithRetry: async (retries = 3, delay = 1000) => {
        for (let i = 0; i < retries; i++) {
            try {
                await eventManager.loadEventsAsync();
                return; // Success, exit the function
            } catch (error) {
                const isLastAttempt = i === retries - 1;
                if (isLastAttempt) throw error; // Last attempt failed
                
                console.log(`Attempt ${i + 1} failed, retrying in ${delay}ms...`);
                await new Promise(resolve => setTimeout(resolve, delay));
            }
        }
    },
    
    // Add a new method to get filtered events using spread operator
    getFilteredEvents: (filterFn) => {
        // Create a clone of events array using spread operator before filtering
        return [...eventManager.events].filter(filterFn);
    }
};

// Create events array using the Event class
const events = [
    new Event("cleanup", "Community Clean-up Day", "2025-06-15", "Central Park", 50, "community"),
    new Event("festival", "Summer Festival", "2025-07-04", "Downtown Square", 200, "entertainment"),
    new Event("workshop", "Gardening Workshop", "2025-05-15", "Community Center", 0, "education"),
    new Event("concert1", "Jazz Night", "2025-06-20", "City Hall", 100, "music"),
    new Event("concert2", "Rock Concert", "2025-07-15", "Stadium", 500, "music"),
    new Event("musicclass", "Guitar Workshop", "2025-06-30", "Music School", 20, "music")
];

// Array operations for event management
const eventOperations = {
    // Add a new event to the array
    addEvent: (eventDetails) => {
        const newEvent = new Event(
            eventDetails.id,
            eventDetails.name,
            eventDetails.date,
            eventDetails.location,
            eventDetails.seats,
            eventDetails.category
        );
        events.push(newEvent);
        return newEvent;
    },

    // Filter music events
    getMusicEvents: () => {
        return events.filter(event => event.category === 'music')
                     .map(event => event.getDetails());
    },

    // Format events into display cards
    formatEventCards: () => {
        return events.map(event => {
            const status = event.checkAvailability();
            return {
                title: `${event.name} (${event.category})`,
                description: `Workshop on ${event.category.charAt(0).toUpperCase() + event.category.slice(1)}`,
                date: event.date.toLocaleDateString(),
                location: event.location,
                status: status.available ? 'Available' : 'Full',
                seats: status.remainingSeats,
                cardClass: status.available && status.isUpcoming ? 'active-event' : 'inactive-event'
            };
        });
    },

    // Get upcoming music events formatted as cards
    getUpcomingMusicCards: () => {
        return events
            .filter(event => event.category === 'music' && event.isUpcoming())
            .map(event => {
                const status = event.checkAvailability();
                return {
                    title: `🎵 ${event.name}`,
                    description: `Music Event - ${event.category}`,
                    date: event.date.toLocaleDateString(),
                    location: `📍 ${event.location}`,
                    status: status.available ? '✅ Seats Available' : '❌ Sold Out',
                    seats: status.remainingSeats
                };
            });
    }
};

// Closure to track category registrations
const createRegistrationTracker = () => {
    const registrations = {};
    
    return {
        addRegistration: (category) => {
            registrations[category] = (registrations[category] || 0) + 1;
            console.log(`Total registrations for ${category}: ${registrations[category]}`);
        },
        getRegistrations: (category) => registrations[category] || 0,
        getAllRegistrations: () => ({...registrations})
    };
};

// Create registration tracker instance
const registrationTracker = createRegistrationTracker();

// Function to add a new event
const addEvent = (eventDetails) => {
    try {
        if (!eventDetails.id || !eventDetails.name || !eventDetails.date || 
            !eventDetails.location || !eventDetails.category) {
            throw new Error("Missing required event details");
        }

        const newEvent = new Event(
            eventDetails.id,
            eventDetails.name,
            eventDetails.date,
            eventDetails.location,
            eventDetails.seats,
            eventDetails.category
        );

        events.push(newEvent);
        console.log('New event added:', newEvent.getDetails());
        return newEvent;
    } catch (error) {
        console.error(`Error adding event: ${error.message}`);
        return null;
    }
};

// Function to display valid events
function displayValidEvents() {
    try {
        const validEvents = events.filter(event => {
            const status = event.checkAvailability();
            return status.available && status.isUpcoming;
        });

        if (validEvents.length === 0) {
            throw new Error("No upcoming events with available seats found.");
        }

        console.log("Upcoming Events with Available Seats:");
        validEvents.forEach(event => {
            const details = event.getDetails();
            console.log('\n-------------------');
            Object.entries(details).forEach(([key, value]) => {
                if (key !== 'registeredUsers') { // Skip showing registered users list
                    console.log(`${key}: ${value}`);
                }
            });
            console.log('-------------------');
        });

        return validEvents;
    } catch (error) {
        console.error(`Error displaying events: ${error.message}`);
        return [];
    }
}

// Function to register a user for an event
const registerUser = (userId, eventId) => {
    try {
        if (!userId || !eventId) {
            throw new Error("Both user ID and event ID are required");
        }

        const event = events.find(e => e.id === eventId);
        
        if (!event) {
            throw new Error("Event not found");
        }

        event.registerUser(userId); // Using the class method
        registrationTracker.addRegistration(event.category);
        
        const details = event.getDetails();
        console.log(`Registration successful! User ${userId} registered for ${details.name}. Seats left: ${details.seats}`);
        return true;
    } catch (error) {
        console.error(`Registration error: ${error.message}`);
        return false;
    }
};

// Higher-order function for filtering events
const filterEvents = (filterCallback) => {
    try {
        const filteredEvents = events.filter(filterCallback);
        return filteredEvents.map(event => event.getDetails());
    } catch (error) {
        console.error(`Filter error: ${error.message}`);
        return [];
    }
};

// Function to filter events by category
const filterEventsByCategory = (category) => {
    return filterEvents(event => event.category === category);
};

// Example custom filter functions that can be passed to filterEvents
const filterUpcomingEvents = event => event.isUpcoming();
const filterAvailableSeats = event => event.checkAvailability().available;
const filterByLocation = location => event => event.location.includes(location);

// Combined filter using multiple conditions
const filterAvailableUpcomingEvents = event => {
    const status = event.checkAvailability();
    return status.available && status.isUpcoming;
};

// DOM manipulation functions with jQuery and ES6+ features
const domOperations = {
    currentView: 'grid', // Track current view mode

    // Create a single event card using jQuery and destructuring
    createEventCard: (event, viewMode = 'grid') => {
        const { id, name, date, location } = event; // Destructuring event properties
        const { available, remainingSeats, isUpcoming } = event.checkAvailability(); // Destructuring status
        
        // Create card with jQuery
        const isActive = available && isUpcoming;
        const cardClass = `${viewMode === 'grid' ? 'event-card' : 'event-list-item'} ${isActive ? 'active' : 'inactive'}`;
        
        // Create jQuery element
        const $card = $('<div>')
            .addClass(cardClass)
            .attr('data-event-id', id)
            .css({
                backgroundColor: 'white',
                borderRadius: '8px',
                boxShadow: '0 2px 4px rgba(0,0,0,0.1)',
                transition: 'all 0.3s ease',
                opacity: 0 // Start with opacity 0 for fadeIn effect
            });
            
        // Add view-specific styles
        if (viewMode === 'grid') {
            $card.css({
                padding: '20px'
            });
        } else {
            $card.css({
                padding: '15px',
                marginBottom: '10px',
                display: 'flex',
                justifyContent: 'space-between',
                alignItems: 'center'
            });
        }
        
        // Create event details
        const $details = $('<div>')
            .addClass('event-details')
            .css(viewMode === 'list' ? { flex: 1 } : {});
            
        $('<h3>')
            .text(name)
            .css({
                color: '#2c3e50',
                marginBottom: '10px'
            })
            .appendTo($details);
            
        $('<p>')
            .html(`📅 ${date.toLocaleDateString()}`)
            .css('color', '#666')
            .appendTo($details);
            
        $('<p>')
            .html(`📍 ${location}`)
            .css('color', '#666')
            .appendTo($details);
            
        $('<p>')
            .html(`${available ? '✅ Available' : '❌ Full'} - ${remainingSeats} seats left`)
            .css('color', available ? '#27ae60' : '#e74c3c')
            .appendTo($details);
        
        // Create actions section
        const $actions = $('<div>')
            .addClass('event-actions')
            .css(viewMode === 'list' ? { marginLeft: '15px' } : {});
            
        const $button = $('<button>')
            .addClass('register-btn')
            .text(available ? 'Register Now' : 'Not Available')
            .css({
                backgroundColor: available ? '#3498db' : '#95a5a6',
                color: 'white',
                border: 'none',
                padding: '8px 16px',
                borderRadius: '4px',
                cursor: available ? 'pointer' : 'not-allowed',
                width: viewMode === 'grid' ? '100%' : 'auto',
                minWidth: viewMode === 'list' ? '120px' : 'auto',
                marginTop: viewMode === 'grid' ? '10px' : '0'
            });
            
        if (!available || !isUpcoming) {
            $button.prop('disabled', true);
        } else {
            // Use jQuery click handler instead of inline onclick
            $button.on('click', function() {
                registerForEvent(id);
            });
        }
        
        $actions.append($button);
        
        // Assemble the card
        $card.append($details).append($actions);
        
        // Apply fadeIn effect after a small delay
        setTimeout(() => {
            $card.animate({ opacity: 1 }, 400);
        }, 50);
        
        return $card[0]; // Return the DOM element
    },

    // Filter events using jQuery, destructuring, and ES6+ features
    filterEvents: () => {
        // Using jQuery selectors and val() method
        const searchTerm = $('#event-search').val()?.toLowerCase() ?? '';
        const category = $('#category-select').val();
        const availability = $('#availability-select').val();

        // Using spread operator to create a copy before filtering
        return [...eventManager.events].filter(event => {
            // Destructuring for cleaner code
            const { name, category: eventCategory } = event;
            const { available, isUpcoming } = event.checkAvailability();
            
            // Using includes() for search
            const matchesSearch = name.toLowerCase().includes(searchTerm);
            const matchesCategory = category === 'all' || eventCategory === category;
            
            // Using logical operators for availability check
            const matchesAvailability = availability === 'all' ||
                (availability === 'available' && available) ||
                (availability === 'upcoming' && isUpcoming);

            // Implicit return of combined conditions
            return matchesSearch && matchesCategory && matchesAvailability;
        });
    },

    // Render events with jQuery animations and ES6+ features
    renderEvents: () => {
        const $container = $('#events-container');
        if (!$container.length) return;

        const filteredEvents = domOperations.filterEvents();
        
        // Fade out existing content before replacing
        $container.fadeOut(200, function() {
            // Clear container
            $container.empty();
            
            // Set container style based on view mode
            if (domOperations.currentView === 'grid') {
                $container.css({
                    display: 'grid',
                    gridTemplateColumns: 'repeat(auto-fill, minmax(300px, 1fr))',
                    gap: '20px'
                });
            } else {
                $container.css({
                    display: 'flex',
                    flexDirection: 'column'
                });
            }
            
            // Add each event card
            filteredEvents.forEach(event => {
                const card = domOperations.createEventCard(event, domOperations.currentView);
                $container.append(card);
            });
            
            // Show message if no events found
            if (filteredEvents.length === 0) {
                $('<div>')
                    .css({
                        textAlign: 'center',
                        padding: '20px',
                        color: '#666'
                    })
                    .html('🔍 No events found matching your criteria')
                    .appendTo($container);
            }
            
            // Fade in the updated content
            $container.fadeIn(300);
        });
    },

    // Update a specific event card using jQuery and ES6+ features
    updateEventCard: (eventId) => {
        // Using find with arrow function
        const event = eventManager.events.find(({ id }) => id === eventId);
        if (!event) return;

        // Using jQuery selector
        const $oldCard = $(`[data-event-id="${eventId}"]`);
        if (!$oldCard.length) return;

        // Using destructuring for parameters
        const { currentView } = domOperations;
        const newCard = domOperations.createEventCard(event, currentView);
        
        // Use jQuery animation for smooth transition
        $oldCard.fadeOut(300, function() {
            $(this).replaceWith($(newCard).hide());
            $(newCard).fadeIn(400);
        });
    },
    
    // Add a new method to demonstrate jQuery benefits
    applyCardHoverEffects: () => {
        // Using jQuery event delegation for efficiency
        $('#events-container').on({
            mouseenter: function() {
                // Only apply effects to active cards
                if ($(this).hasClass('active')) {
                    $(this).animate({
                        transform: 'translateY(-5px)',
                        boxShadow: '0 8px 16px rgba(0,0,0,0.1)'
                    }, 200);
                }
            },
            mouseleave: function() {
                if ($(this).hasClass('active')) {
                    $(this).animate({
                        transform: 'translateY(0)',
                        boxShadow: '0 2px 4px rgba(0,0,0,0.1)'
                    }, 200);
                }
            }
        }, '.event-card, .event-list-item');
        
        console.log('jQuery hover effects applied to event cards');
    }
};

// Form handling and validation
const formHandler = {
    // Validation rules using regular expressions and validation functions
    validationRules: {
        name: {
            pattern: /^[a-zA-Z\s]{3,50}$/,
            message: 'Name must be 3-50 characters and contain only letters and spaces.'
        },
        email: {
            pattern: /^[^\s@]+@[^\s@]+\.[^\s@]+$/,
            message: 'Please enter a valid email address.'
        },
        eventId: {
            validate: value => value !== '',
            message: 'Please select an event.'
        },
        phone: {
            pattern: /^(\+\d{1,3}[- ]?)?\d{10}$/,
            message: 'Please enter a valid phone number (10 digits, optional country code).',
            optional: true
        }
    },

    // Initialize form with jQuery event handlers
    initForm: () => {
        const $form = $('#event-registration-form');
        const $eventSelect = $('#event-select');
        
        if (!$form.length || !$eventSelect.length) return;
        
        // Populate event dropdown with available events
        formHandler.populateEventOptions($eventSelect[0]); // Pass DOM element
        
        // Add form submission handler with jQuery
        $form.on('submit', formHandler.handleSubmit);
        
        // Add input validation on blur with jQuery
        $form.find('input[required], select[required]').each(function() {
            const $input = $(this);
            
            // Blur event for validation
            $input.on('blur', function() {
                formHandler.validateField(this);
            });
            
            // Input event for immediate feedback
            $input.on('input', function() {
                if ($(this).data('hasError') === 'true') {
                    formHandler.validateField(this);
                }
            });
        });
        
        // Clear error messages when form is reset
        $form.on('reset', formHandler.clearErrors);
        
        // Add visual feedback with jQuery effects
        $form.find('input, select').on('focus', function() {
            $(this).animate({
                borderColor: '#3498db'
            }, 200);
        }).on('blur', function() {
            if ($(this).data('hasError') !== 'true') {
                $(this).animate({
                    borderColor: '#ddd'
                }, 200);
            }
        });
        
        // Add jQuery click handler for register button
        $('#register-button').on('click', function() {
            // Visual feedback on click
            $(this).fadeOut(100).fadeIn(100);
        });
    },
    
    // Populate event dropdown with available events
    populateEventOptions: (selectElement) => {
        // Clear existing options except the first one
        while (selectElement.options.length > 1) {
            selectElement.remove(1);
        }
        
        // Get available events and sort by date
        const availableEvents = [...eventManager.events]
            .filter(event => {
                const { available, isUpcoming } = event.checkAvailability();
                return available && isUpcoming;
            })
            .sort((a, b) => a.date - b.date);
        
        // Add options for each available event
        availableEvents.forEach(({ id, name, date, location }) => {
            const option = document.createElement('option');
            option.value = id;
            option.textContent = `${name} - ${date.toLocaleDateString()} at ${location}`;
            selectElement.appendChild(option);
        });
    },
    
    // Handle form submission with debugging
    handleSubmit: (event) => {
        event.preventDefault(); // Prevent default form submission
        console.log('%c Form Submission Started', 'background: #3498db; color: white; padding: 2px 5px; border-radius: 3px;');
        
        const form = event.target;
        const formData = new FormData(form);
        const formElements = form.elements;
        
        // Debug: Log form data
        console.group('Form Data');
        for (const [key, value] of formData.entries()) {
            console.log(`${key}: ${value}`);
        }
        console.groupEnd();
        
        // Clear previous errors
        formHandler.clearErrors();
        console.log('Previous errors cleared');
        
        // Validate all required fields
        let isValid = true;
        console.group('Field Validation');
        
        // Using form.elements to access form fields
        for (const field of formElements) {
            if (field.name && (field.required || field.value.trim() !== '')) {
                // Debug: Add breakpoint here for inspection
                // debugger; // Uncomment this line to add a breakpoint
                
                const fieldIsValid = formHandler.validateField(field);
                console.log(`Field ${field.name}: ${fieldIsValid ? 'Valid ✅' : 'Invalid ❌'}`);
                isValid = isValid && fieldIsValid;
            }
        }
        console.groupEnd();
        
        if (!isValid) {
            // Show general error message
            const errorContainer = document.getElementById('form-errors');
            errorContainer.textContent = 'Please correct the errors in the form.';
            errorContainer.style.display = 'block';
            console.error('Form validation failed. Submission aborted.');
            return;
        }
        
        console.log('Form validation passed ✅');
        
        // Process form data
        const userData = {
            name: formData.get('name'),
            email: formData.get('email'),
            eventId: formData.get('eventId'),
            phone: formData.get('phone') || null,
            preferences: formData.getAll('preferences')
        };
        
        // Debug: Log processed user data
        console.log('Processed user data:', userData);
        
        // Register user for the event
        try {
            console.log('Attempting to register user...');
            
            // Generate a unique user ID based on email
            const userId = `user_${userData.email.replace(/[^a-zA-Z0-9]/g, '')}`;
            console.log(`Generated userId: ${userId}`);
            
            // Find the selected event
            const selectedEvent = eventManager.events.find(({ id }) => id === userData.eventId);
            console.log('Selected event:', selectedEvent);
            
            if (!selectedEvent) {
                console.error('Event not found:', userData.eventId);
                throw new Error('Selected event not found');
            }
            
            // Debug: Check event availability before registration
            const availability = selectedEvent.checkAvailability();
            console.log('Event availability before registration:', availability);
            
            // Debug: Check if user is already registered
            const isAlreadyRegistered = selectedEvent.registeredUsers.has(userId);
            console.log(`User already registered: ${isAlreadyRegistered}`);
            
            // Register the user
            console.time('Registration process');
            const registrationResult = selectedEvent.registerUser(userId);
            console.timeEnd('Registration process');
            console.log('Registration result:', registrationResult);
            
            // Update the UI
            domOperations.updateEventCard(userData.eventId);
            domOperations.renderEvents(); // Refresh all events
            
            // Debug: Check event availability after registration
            const newAvailability = selectedEvent.checkAvailability();
            console.log('Event availability after registration:', newAvailability);
            
            // Show success message
            alert(`Registration successful! Thank you, ${userData.name}. You are registered for ${selectedEvent.name}.`);
            console.log('%c Registration successful!', 'background: #27ae60; color: white; padding: 2px 5px; border-radius: 3px;');
            
            // Reset the form
            form.reset();
            console.log('Form reset');
            
        } catch (error) {
            // Show error message
            const errorContainer = document.getElementById('form-errors');
            errorContainer.textContent = `Registration failed: ${error.message}`;
            errorContainer.style.display = 'block';
            
            // Debug: Log detailed error information
            console.error('Registration failed:', error);
            console.error('Error stack:', error.stack);
        }
    },
    
    // Validate a single field with debugging
    validateField: (field) => {
        const { name, value } = field;
        const errorElement = document.querySelector(`.error-message[data-for="${name}"]`);
        
        // Debug: Check if error element exists
        if (!errorElement) {
            console.warn(`No error element found for field: ${name}`);  
            return true; // No error element found
        }
        
        const rule = formHandler.validationRules[name];
        if (!rule) {
            console.warn(`No validation rule defined for field: ${name}`);
            return true; // No validation rule for this field
        }
        
        // Debug: Log validation attempt
        console.group(`Validating field: ${name}`);
        console.log(`Value: "${value}"`); 
        console.log(`Rule:`, rule);
        
        // Skip validation for optional empty fields
        if (rule.optional && value.trim() === '') {
            console.log('Field is optional and empty - skipping validation');
            errorElement.style.display = 'none';
            field.dataset.hasError = 'false';
            console.groupEnd();
            return true;
        }
        
        let isValid = true;
        let validationMethod = 'none';
        
        if (rule.pattern) {
            validationMethod = 'pattern';
            isValid = rule.pattern.test(value);
            console.log(`Pattern validation: ${rule.pattern} => ${isValid ? 'Passed' : 'Failed'}`);
        } else if (rule.validate) {
            validationMethod = 'function';
            isValid = rule.validate(value);
            console.log(`Function validation => ${isValid ? 'Passed' : 'Failed'}`);
        }
        
        console.log(`Validation method: ${validationMethod}`);
        console.log(`Validation result: ${isValid ? 'Valid ✅' : 'Invalid ❌'}`);
        
        if (!isValid) {
            errorElement.textContent = rule.message;
            errorElement.style.display = 'block';
            field.dataset.hasError = 'true';
            field.style.borderColor = '#e74c3c';
        } else {
            errorElement.style.display = 'none';
            field.dataset.hasError = 'false';
            field.style.borderColor = '#2ecc71';
        }
        
        console.groupEnd();
        return isValid;
    },
    
    // Clear all error messages with jQuery
    clearErrors: () => {
        // Use jQuery to hide error container with fadeOut
        $('#form-errors').fadeOut(300);
        
        // Hide all error messages with jQuery
        $('.error-message').fadeOut(300);
        
        // Reset error state on inputs
        $('[data-has-error]').each(function() {
            $(this).data('hasError', 'false')
                   .css('borderColor', '#ddd');
        });
        
        console.log('Form errors cleared with jQuery animations');
    }
};

// Debug helper functions
const debugTools = {
    // Monitor network requests
    monitorNetworkRequests: () => {
        const originalFetch = window.fetch;
        window.fetch = function(...args) {
            console.group('Fetch Request');
            console.log('URL:', args[0]);
            if (args[1]) console.log('Options:', args[1]);
            console.groupEnd();
            
            return originalFetch.apply(this, args)
                .then(response => {
                    console.group('Fetch Response');
                    console.log('Status:', response.status);
                    console.log('Status Text:', response.statusText);
                    console.log('Headers:', response.headers);
                    console.groupEnd();
                    return response;
                })
                .catch(error => {
                    console.error('Fetch Error:', error);
                    throw error;
                });
        };
        console.log('%c Network monitoring enabled', 'background: #9b59b6; color: white; padding: 2px 5px; border-radius: 3px;');
    },
    
    // Add global error handler
    setupGlobalErrorHandler: () => {
        window.addEventListener('error', (event) => {
            console.error('Global error caught:', event.error);
            console.error('Error details:', {
                message: event.message,
                filename: event.filename,
                lineno: event.lineno,
                colno: event.colno
            });
        });
        
        window.addEventListener('unhandledrejection', (event) => {
            console.error('Unhandled Promise Rejection:', event.reason);
        });
        
        console.log('%c Global error handlers installed', 'background: #9b59b6; color: white; padding: 2px 5px; border-radius: 3px;');
    },
    
    // Inspect DOM elements
    inspectElement: (selector) => {
        const element = document.querySelector(selector);
        if (!element) {
            console.warn(`Element not found: ${selector}`);
            return null;
        }
        
        console.group(`Element: ${selector}`);
        console.log('Element:', element);
        console.log('Attributes:', element.attributes);
        console.log('Classes:', element.classList);
        console.log('Computed Style:', window.getComputedStyle(element));
        console.log('Bounding Rect:', element.getBoundingClientRect());
        console.groupEnd();
        
        return element;
    },
    
    // Test form submission with mock data
    testFormSubmission: (formId, mockData = {}) => {
        const form = document.getElementById(formId);
        if (!form) {
            console.error(`Form not found: ${formId}`);
            return;
        }
        
        // Fill form with mock data
        for (const [key, value] of Object.entries(mockData)) {
            const field = form.elements[key];
            if (field) {
                field.value = value;
            }
        }
        
        console.log('%c Test submission with mock data:', 'background: #f39c12; color: white; padding: 2px 5px; border-radius: 3px;');
        console.log('Mock data:', mockData);
        
        // Trigger form submission
        const submitEvent = new Event('submit', { cancelable: true });
        form.dispatchEvent(submitEvent);
    }
};

// Framework comparison note
/*
 * Benefits of moving to React or Vue:
 * 1. Component-Based Architecture: Better organization and reusability than jQuery
 * 2. Virtual DOM: More efficient updates than direct DOM manipulation
 * 3. State Management: Centralized state handling (Redux, Vuex) for complex applications
 * 4. Declarative UI: Define what the UI should look like based on state, not how to change it
 * 5. Developer Tools: Better debugging and development experience
 * 6. Testing: Easier to test components in isolation
 * 7. Community & Ecosystem: Large community and rich ecosystem of libraries
 */

// jQuery document ready function
$(function() {
    console.log('%c Application Initializing with jQuery', 'background: #2c3e50; color: white; padding: 5px; font-size: 14px; border-radius: 3px;');
    
    // Setup debugging tools
    debugTools.setupGlobalErrorHandler();
    debugTools.monitorNetworkRequests();
    
    // Use jQuery for button click events
    $('#register-button').click(function(e) {
        console.log('Register button clicked via jQuery handler');
        // The form submit handler will still process the submission
    });
    
    // Load events with retry mechanism
    console.time('Events loading');
    eventManager.loadEventsWithRetry()
        .then(() => {
            console.timeEnd('Events loading');
            console.log(`Loaded ${eventManager.events.length} events`);
            
            // Initialize the registration form after events are loaded
            formHandler.initForm();
            
            // Apply jQuery hover effects to cards
            domOperations.applyCardHoverEffects();
            
            // Debug: Inspect form element
            debugTools.inspectElement('#event-registration-form');
            
            // Debug: Log available events for registration
            const availableEvents = eventManager.events.filter(event => {
                const { available, isUpcoming } = event.checkAvailability();
                return available && isUpcoming;
            });
            console.log('Available events for registration:', availableEvents);
            
            // Add jQuery toggle effect for section headers
            $('.events-header h2').click(function() {
                $(this).next('div').slideToggle(300);
            });
        })
        .catch(error => {
            console.error('All retry attempts failed:', error);
            eventManager.showError('Failed to load events after multiple attempts. Please refresh the page.');
        });

        // Event listener for search input with debouncing
    let searchTimeout;
    const searchInput = document.querySelector('#event-search');
    if (searchInput) {
        searchInput.addEventListener('input', (e) => {
            clearTimeout(searchTimeout);
            searchTimeout = setTimeout(() => {
                domOperations.renderEvents();
            }, 300); // Debounce for 300ms
        });

        // Handle keyboard navigation
        searchInput.addEventListener('keydown', (e) => {
            if (e.key === 'Enter') {
                e.preventDefault();
                domOperations.renderEvents();
            }
        });
    }
    
    // Update event dropdown when events are filtered
    const eventSelect = document.getElementById('event-select');
    if (eventSelect) {
        // Initialize the dropdown with current events
        formHandler.populateEventOptions(eventSelect);
    }

    // Event listener for category filter
    const categorySelect = document.querySelector('#category-select');
    if (categorySelect) {
        categorySelect.addEventListener('change', () => {
            domOperations.renderEvents();
        });
    }

    // Event listener for availability filter
    const availabilitySelect = document.querySelector('#availability-select');
    if (availabilitySelect) {
        availabilitySelect.addEventListener('change', () => {
            domOperations.renderEvents();
        });
    }

    // Event listeners for view toggle buttons
    const gridViewBtn = document.querySelector('#grid-view');
    const listViewBtn = document.querySelector('#list-view');

    if (gridViewBtn && listViewBtn) {
        gridViewBtn.addEventListener('click', () => {
            if (domOperations.currentView !== 'grid') {
                domOperations.currentView = 'grid';
                gridViewBtn.classList.add('active');
                listViewBtn.classList.remove('active');
                domOperations.renderEvents();
            }
        });

        listViewBtn.addEventListener('click', () => {
            if (domOperations.currentView !== 'list') {
                domOperations.currentView = 'list';
                listViewBtn.classList.add('active');
                gridViewBtn.classList.remove('active');
                domOperations.renderEvents();
            }
        });
    }

    // Add hover effects to event cards
    document.addEventListener('mouseover', (e) => {
        const card = e.target.closest('.event-card, .event-list-item');
        if (card && card.classList.contains('active')) {
            card.style.transform = 'translateY(-5px)';
            card.style.boxShadow = '0 4px 8px rgba(0,0,0,0.2)';
        }
    }, true);

    document.addEventListener('mouseout', (e) => {
        const card = e.target.closest('.event-card, .event-list-item');
        if (card && card.classList.contains('active')) {
            card.style.transform = '';
            card.style.boxShadow = '';
        }
    }, true);
});

// Global function to handle event registration using ES6+ features
window.registerForEvent = (eventId) => {
    try {
        // Using template literals and modern string methods
        const userId = `user_${Math.random().toString(36).substring(2, 11)}`;
        
        // Using destructuring in the find callback
        const event = eventManager.events.find(({ id }) => id === eventId);
        
        // Using optional chaining and nullish coalescing
        if (!event) throw new Error('Event not found');
        
        // Destructuring the result of registerUser
        const { success, remainingSeats } = event.registerUser(userId);
        
        // Using optional chaining for safer access
        registrationTracker?.addRegistration(event.category);
        
        // Update the UI
        domOperations.updateEventCard(eventId);
        
        // Using template literals for string interpolation
        alert(`Successfully registered for ${event.name}! ${remainingSeats} seats remaining.`);
    } catch ({ message }) { // Destructuring the error object
        alert(`Registration failed: ${message}`);
    }
};
