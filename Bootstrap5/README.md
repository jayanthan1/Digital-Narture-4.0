# Bootstrap 5 Exercises

This project contains exercises demonstrating different aspects of Bootstrap 5.

## Exercise 1: Setting Up Bootstrap 5

### Exercise 1.1: Bootstrap 5 via CDN

Located in the `exercise1.1` directory, this exercise demonstrates how to include Bootstrap 5 in your HTML page using Content Delivery Network (CDN) links.

#### Features:
- No download required
- Quick setup
- Always uses the latest version (or specified version) of Bootstrap
- Relies on internet connection

#### How to Use:
Simply open the `exercise1.1/index.html` file in your browser to see Bootstrap 5 in action.

### Exercise 1.2: Bootstrap 5 via Local Files

Located in the `exercise1.2` directory, this exercise demonstrates how to include Bootstrap 5 in your HTML page using locally stored files.

#### Features:
- Works offline once downloaded
- Can be customized
- No dependency on external services
- Better for production environments

#### How to Use:
1. In a real project, you would download Bootstrap files or install via npm
2. For this exercise, placeholder files have been created to demonstrate the structure
3. Open the `exercise1.2/index.html` file in your browser

#### Note:
The CSS and JS files in this exercise are just placeholders. In a real project, you would:

1. Download Bootstrap files from the official website, OR
2. Install Bootstrap via npm with `npm install bootstrap`
3. Copy the files to your project's css and js directories

## Exercise 2: Bootstrap Structure and Files

### Exercise 2.1: Bootstrap Directory Structure

Located in the `exercise2.1` directory, this exercise explores the structure of the Bootstrap framework and explains the purpose of its main directories.

#### Files:
- `bootstrap_structure.md`: Detailed explanation of Bootstrap's directory structure
- `bootstrap_structure_diagram.html`: Visual representation of Bootstrap's directory structure

#### How to Use:
1. Read `bootstrap_structure.md` to understand the purpose of each directory
2. Open `bootstrap_structure_diagram.html` in your browser for a visual representation

### Exercise 2.2: Bootstrap JavaScript Plugins

Located in the `exercise2.2` directory, this exercise demonstrates how to use Bootstrap's JavaScript components via bootstrap.bundle.min.js.

#### Features:
- Demonstrates multiple interactive components (modals, tooltips, dropdowns, etc.)
- Shows how to properly include bootstrap.bundle.min.js
- Includes code examples for each component

#### How to Use:
Open `exercise2.2/index.html` in your browser to see the JavaScript components in action.

## Exercise 3: Fundamentals of Responsive Grid Layout

### Exercise 3.1: Responsive Columns

Located in the `exercise3.1` directory, this exercise demonstrates how to create a responsive grid layout with columns that stack vertically on mobile, display two per row on tablets, and three per row on desktops.

#### Features:
- Uses Bootstrap's grid system with responsive breakpoints
- Demonstrates mobile-first responsive design
- Includes visual indicators for different screen sizes
- Shows how columns reflow based on viewport width

#### How to Use:
1. Open `exercise3.1/index.html` in your browser
2. Resize your browser window to see how the columns respond to different screen sizes
3. Notice how columns stack vertically on mobile, show two per row on tablets, and three per row on desktops

### Exercise 3.2: Container, Row, and Column Classes

Located in the `exercise3.2` directory, this exercise demonstrates the proper use of `.container`, `.row`, and `.col-*` classes for responsive design.

#### Features:
- Explains different container types (fixed-width, fluid, breakpoint-specific)
- Shows how rows work with and without gutters
- Demonstrates various column configurations and responsive behavior
- Includes best practices and common mistakes to avoid

#### How to Use:
Open `exercise3.2/index.html` in your browser to explore the different container, row, and column configurations.

## Exercise 4: Column Layouts and Grid Classes

### Exercise 4.1: Two-Column Layout with Sidebar

Located in the `exercise4.1` directory, this exercise demonstrates how to create a two-column layout with a sidebar (col-md-3) and content area (col-md-9).

#### Features:
- Responsive layout that stacks on mobile and displays side-by-side on medium screens and larger
- Sidebar with navigation and information widgets
- Main content area with sample content and explanations
- Sticky sidebar that remains visible while scrolling (on larger screens)

#### How to Use:
1. Open `exercise4.1/index.html` in your browser
2. Resize your browser window to see how the layout responds to different screen sizes
3. Notice how the sidebar and content area stack vertically on mobile and display side-by-side on medium screens and larger

### Exercise 4.2: Four-Column Equal Width Layout

Located in the `exercise4.2` directory, this exercise demonstrates how to create a four-column layout with equal widths using the col-sm-3 class.

#### Features:
- Four equal-width columns that stack on mobile and display side-by-side on small screens and larger
- Visual demonstration of how the Bootstrap grid system works with equal columns
- Examples of alternative column layouts (two-column, three-column, six-column, and mixed)
- Detailed explanations of the grid system calculations

#### How to Use:
Open `exercise4.2/index.html` in your browser to explore the four-column layout and alternative column configurations.

## Exercise 5: Alignment and Reordering in Grid

### Exercise 5.1: Content Alignment

Located in the `exercise5.1` directory, this exercise demonstrates how to use `justify-content-center` and `align-items-center` to center content inside a row.

#### Features:
- Horizontal alignment with `justify-content-*` classes
- Vertical alignment with `align-items-*` classes
- Individual column alignment with `align-self-*` classes
- Centering content both horizontally and vertically
- Practical examples including hero sections, login forms, and feature cards

#### How to Use:
Open `exercise5.1/index.html` in your browser to explore the different alignment options and see how they affect the layout of content within rows and columns.

### Exercise 5.2: Column Reordering

Located in the `exercise5.2` directory, this exercise demonstrates how to reorder columns on different screen sizes using `order-md-2`, `order-md-1`, and other order classes.

#### Features:
- Basic column reordering with `order-*` classes
- Responsive reordering with breakpoint-specific order classes
- Practical use cases including alternating image-text layouts
- First-last reordering for optimizing mobile and desktop experiences
- Visual indicators showing how the order changes at different breakpoints

#### How to Use:
1. Open `exercise5.2/index.html` in your browser
2. Resize your browser window to see how the column order changes at different screen sizes
3. Explore the practical examples to understand common use cases for column reordering

## Exercise 6: Responsive Flexbox Utilities

### Exercise 6.1: Responsive Navbar with Flexbox

Located in the `exercise6.1` directory, this exercise demonstrates how to create a responsive navbar using Bootstrap's flexbox utilities like `d-flex`, `flex-column`, and `flex-md-row`.

#### Features:
- Basic responsive navbar that stacks vertically on mobile and horizontally on larger screens
- Navbar with justified content using `justify-content-between`
- Navbar with search functionality
- Navbar with dropdown menu
- Complete responsive navbar example with toggle button
- Detailed explanation of key flexbox utilities in Bootstrap

#### How to Use:
1. Open `exercise6.1/index.html` in your browser
2. Resize your browser window to see how the navbar responds to different screen sizes
3. Explore the different navbar examples and their implementations

### Exercise 6.2: Card Layout with Flexbox

Located in the `exercise6.2` directory, this exercise demonstrates how to use `justify-content-between` and `align-items-center` in card layouts.

#### Features:
- Card headers with content justified between left and right
- Product cards with price and action buttons aligned
- Card footers with multiple elements
- Product grid with consistent card layouts
- User profile cards with avatar and details
- Dashboard cards with statistics and icons

#### How to Use:
Open `exercise6.2/index.html` in your browser to explore the different card layouts and see how flexbox utilities help create well-structured content.

## Exercise 7: Typography

### Exercise 7.1: Typography Utilities

Located in the `exercise7.1` directory, this exercise demonstrates various Bootstrap typography utilities including display headings, text utilities, font weight, and more.

#### Features:
- Display headings (`display-1` through `display-6`)
- Regular headings (h1-h6)
- Lead text with the `lead` class
- Text colors including `text-muted`
- Font weight utilities like `fw-bold`, `fw-light`, etc.
- Text alignment utilities
- Text wrapping and overflow control
- Text decoration utilities
- Font size utilities
- Line height utilities
- Monospace text
- Text selection utilities
- Combined typography examples

#### How to Use:
Open `exercise7.1/index.html` in your browser to explore the different typography utilities available in Bootstrap 5.

### Exercise 7.2: Text Transformation

Located in the `exercise7.2` directory, this exercise focuses on Bootstrap's text transformation utilities: `text-uppercase`, `text-lowercase`, and `text-capitalize`.

#### Features:
- Basic text transformations with examples and explanations
- Comparison table showing the effect of each transformation
- Practical examples in navigation menus, buttons, and cards
- Form elements with text transformations
- Badges and alerts with transformed text
- Combining text transformations with other typography utilities
- Best practices and accessibility considerations

#### How to Use:
Open `exercise7.2/index.html` in your browser to explore how text transformation utilities can be used to enhance the visual hierarchy and styling of your content.

## Exercise 8: Forms

### Exercise 8.1: Registration Form

Located in the `exercise8.1` directory, this exercise demonstrates how to create a comprehensive registration form using Bootstrap form components like form-control, form-check, and input-group.

#### Features:
- Personal information section with responsive grid layout
- Account information section with password strength indicator
- Preferences section with checkboxes and radio buttons
- Terms and conditions section with required checkbox
- Input validation with feedback messages
- Input groups with icons and buttons
- Form sections with clear visual hierarchy
- Password visibility toggle
- Responsive design for all screen sizes

#### Form Components Used:
- `form-control` for text inputs and textareas
- `form-check` for checkboxes and radio buttons
- `input-group` for inputs with addons like icons
- `form-select` for dropdown menus
- `form-label` for input labels
- `invalid-feedback` for validation messages
- Bootstrap grid system for form layout

#### How to Use:
Open `exercise8.1/index.html` in your browser to explore the registration form and see how different Bootstrap form components work together to create a comprehensive and user-friendly form.

### Exercise 8.2: Floating Label Login Form

Located in the `exercise8.2` directory, this exercise demonstrates how to style a login form using Bootstrap's form-floating component.

#### Features:
- Email and password inputs with floating labels
- Remember me checkbox with forgot password link
- Social login options with icons
- Clean, modern design with proper spacing
- Detailed explanation of how form-floating works
- Live examples of different form-floating implementations
- Accessibility considerations and best practices

#### Form Components Used:
- `form-floating` for the floating label effect
- Proper input and label ordering for floating labels
- Required placeholder text for floating labels to work
- Support for various input types, select menus, and textareas

#### How to Use:
Open `exercise8.2/index.html` in your browser to see the floating label login form in action and learn how to implement this modern form style in your own projects.

## Exercise 9: Buttons

### Exercise 9.1: Contextual Button Classes

Located in the `exercise9.1` directory, this exercise demonstrates all the contextual button classes available in Bootstrap 5.

#### Features:
- Standard contextual buttons (primary, secondary, success, danger, etc.)
- Outline buttons for all contextual classes (btn-outline-*)
- Button sizes (large, default, small)
- Block buttons using the d-grid class
- Active and disabled button states

#### How to Use:
Open `exercise9.1/index.html` in your browser to explore the different button styles and see how contextual classes affect the appearance of buttons.

### Exercise 9.2: Button Groups and Toggle Buttons

Located in the `exercise9.2` directory, this exercise demonstrates how to create button groups and toggle buttons with checkboxes.

#### Features:
- Basic button groups with the btn-group class
- Button toolbars with multiple button groups
- Button group sizing options (large, default, small)
- Vertical button groups using btn-group-vertical
- Toggle buttons with checkboxes using btn-check
- Toggle buttons with radio buttons for exclusive selection

#### How to Use:
Open `exercise9.2/index.html` in your browser to explore button groups and toggle buttons, and see how they can be used to create interactive UI components.

## Exercise 10: Navbars and Navigation

### Exercise 10.1: Responsive Navbar

Located in the `exercise10.1` directory, this exercise demonstrates how to create a responsive navbar with a logo, navigation links, and a search form.

#### Features:
- Responsive navbar that collapses on mobile devices
- Brand logo in the navbar
- Navigation links with dropdown menu
- Integrated search form
- Different navbar color variations (light, dark, colorful)
- Mobile-friendly toggle button
- Proper accessibility attributes

#### How to Use:
Open `exercise10.1/index.html` in your browser to explore the responsive navbar. Resize your browser window to see how the navbar adapts to different screen sizes.

### Exercise 10.2: Tabbed Navigation

Located in the `exercise10.2` directory, this exercise demonstrates how to create tabbed navigation using Bootstrap's nav, nav-tabs, and nav-pills components.

#### Features:
- Basic nav component demonstration
- Horizontal tabs with nav-tabs class
- Pill-style navigation with nav-pills class
- Vertical pills for sidebar-style navigation
- Fill and justified navigation options
- Dynamic content switching with JavaScript
- Practical examples with sample content

#### How to Use:
Open `exercise10.2/index.html` in your browser to explore the different types of tabbed navigation. Click on different tabs to see the content change dynamically.

## Exercise 11: Cards and Media Objects

### Exercise 11.1: Profile Card

Located in the `exercise11.1` directory, this exercise demonstrates how to create a profile card using Bootstrap's card components.

#### Features:
- Main card container with the `card` class
- Card image with the `card-img-top` class
- Card content area with the `card-body` class
- Card title with the `card-title` class
- Card subtitle with the `card-subtitle` class
- Interactive hover effects with CSS transitions
- Responsive design that looks good on all screen sizes
- Action buttons with contextual styling

#### How to Use:
Open `exercise11.1/index.html` in your browser to see the profile card in action. The card includes a profile image, name, job title, description, and action buttons.

### Exercise 11.2: Media Object Layout

Located in the `exercise11.2` directory, this exercise demonstrates how to create a media object layout using Bootstrap's flexbox utilities.

#### Features:
- Media objects created using the `d-flex` class
- Images aligned to the left of the content
- Multiple media objects stacked vertically
- Proper spacing and alignment between image and text
- Responsive design that works on all screen sizes
- Card-like styling with shadows and rounded corners
- Sample content for each media object

#### How to Use:
Open `exercise11.2/index.html` in your browser to explore the media object layout. The page displays multiple profile entries with circular images aligned to the left of the text content.

## Exercise 12: Spacing Utilities

### Exercise 12.1: Margin and Padding Utilities

Located in the `exercise12.1` directory, this exercise demonstrates how to apply Bootstrap margin and padding utilities to improve layout spacing.

#### Features:
- Margin utilities demonstration (m-3, mt-4, etc.)
- Padding utilities demonstration (p-2, py-5, etc.)
- Visual indicators showing the effect of each spacing utility
- Practical examples showing how spacing improves UI design
- Interactive examples with code snippets
- Comprehensive coverage of all spacing utility variants

#### How to Use:
Open `exercise12.1/index.html` in your browser to see visual demonstrations of Bootstrap's spacing utilities. The page includes highlighted examples showing how different margin and padding values affect layout elements.

### Exercise 12.2: Pricing Section with Spacing

Located in the `exercise12.2` directory, this exercise demonstrates a real-world pricing section where Bootstrap spacing utilities are used to improve the layout and visual hierarchy.

#### Features:
- Professional pricing cards with tiered options
- Strategic use of margin and padding to improve readability
- Consistent spacing between related elements
- Visual separation between different sections
- Responsive design with appropriate spacing at all breakpoints
- Practical implementation of spacing best practices
- Additional sections including features, FAQ, and call-to-action

#### How to Use:
Open `exercise12.2/index.html` in your browser to see a complete pricing section layout. Pay attention to how spacing utilities (margins and paddings) create visual hierarchy and improve the overall user experience.

## Exercise 13: Colors and Backgrounds

### Exercise 13.1: Dashboard with Contextual Colors

Located in the `exercise13.1` directory, this exercise demonstrates how to create a dashboard page using Bootstrap's contextual background classes and text colors.

#### Features:
- Dark sidebar with white text for navigation
- Stat cards using `bg-primary`, `bg-success`, `bg-warning`, and `bg-danger` backgrounds
- Text colors that complement each background color
- Progress bars with contextual colors
- Activity timeline with color-coded indicators
- Status badges with appropriate background colors
- Tables with contextual styling
- Responsive layout that works on all screen sizes

#### How to Use:
Open `exercise13.1/index.html` in your browser to see a complete dashboard interface that demonstrates how contextual colors can be used to create visual hierarchy and convey meaning in a data-rich interface.

### Exercise 13.2: Gradient Backgrounds

Located in the `exercise13.2` directory, this exercise demonstrates how to use Bootstrap's `bg-gradient` utility with `bg-dark` and white text to create visually appealing sections.

#### Features:
- Navigation bar with dark gradient background
- Hero section with dark gradient and white text
- Feature cards showcasing different gradient variations
- Examples of all Bootstrap contextual gradients
- Custom gradient variations for more visual interest
- Testimonial section with dark gradient background
- Call-to-action section with custom gradient
- Footer with dark gradient background

#### How to Use:
Open `exercise13.2/index.html` in your browser to see how gradient backgrounds can enhance the visual appeal of a website. The page demonstrates both Bootstrap's built-in gradient utility and custom gradient variations.

## Exercise 14: Display and Visibility

### Exercise 14.1: Responsive Display Utilities

Located in the `exercise14.1` directory, this exercise demonstrates how to use Bootstrap's display utilities like `d-none`, `d-md-block`, and `d-lg-flex` to hide and show content based on screen size.

#### Features:
- Examples of basic display utilities (`d-none`, `d-block`, `d-inline`, `d-inline-block`)
- Mobile-only content using `d-block d-md-none`
- Tablet-only content using `d-none d-md-block d-lg-none`
- Desktop-only content using `d-none d-lg-block`
- Content that's hidden on mobile but visible on larger screens using `d-none d-md-block`
- Flex layout that changes from stacked to horizontal using `d-block d-lg-flex`
- Practical example of a responsive news website layout
- Device size indicator that shows the current viewport size

#### How to Use:
Open `exercise14.1/index.html` in your browser and resize the window to see how different sections appear and disappear based on screen size. The page includes a device size indicator in the top-right corner to help identify the current viewport size.

### Exercise 14.2: Responsive Sidebar

Located in the `exercise14.2` directory, this exercise demonstrates how to create a responsive sidebar that only shows on tablets and above, with an alternative mobile navigation.

#### Features:
- Sidebar that's hidden on mobile (xs, sm) but visible on tablet and above (md, lg, xl, xxl)
- Uses `d-none d-md-block` to control sidebar visibility
- Mobile dropdown menu that appears only on small screens using `d-block d-md-none`
- Main content area that adjusts its width based on sidebar visibility
- Sticky sidebar that remains visible while scrolling
- Organized navigation with icons and section headings
- Detailed explanation of the implementation approach
- Device size indicator to show the current viewport size

#### How to Use:
Open `exercise14.2/index.html` in your browser and resize the window to see how the sidebar appears and disappears based on screen size. On mobile devices, the sidebar is replaced with a dropdown menu in the header.

## Exercise 15: Borders, Shadows, and Rounded Corners

### Exercise 15.1: Border Utilities with Images

Located in the `exercise15.1` directory, this exercise demonstrates how to use Bootstrap's border utilities to enhance images.

#### Features:
- Basic borders with `border` utility class
- Contextual border colors like `border-primary`, `border-success`, etc.
- Border width variations with `border-1`, `border-3`, and `border-5`
- Directional borders with `border-top`, `border-end`, `border-bottom`, and `border-start`
- Rounded corners with `rounded`, `rounded-circle`, `rounded-pill`, and more
- Combined utilities for complex styling (e.g., `border-3 border-primary rounded-circle`)
- Interactive demo that allows experimenting with different border combinations
- Comprehensive examples with code snippets and explanations

#### How to Use:
Open `exercise15.1/index.html` in your browser to explore different border utilities applied to images. The page includes an interactive demo where you can experiment with different border styles, colors, widths, and rounded corners.

### Exercise 15.2: Shadows and Rounded Pills

Located in the `exercise15.2` directory, this exercise demonstrates how to use Bootstrap's shadow utilities and rounded-pill class with cards.

#### Features:
- Different shadow sizes with `shadow-sm`, `shadow`, and `shadow-lg`
- Pill-shaped elements with `rounded-pill`
- Cards with various shadow effects
- Buttons and badges with rounded-pill styling
- Creative examples combining shadows and rounded corners
- Profile cards with circular images and shadows
- Pricing cards with shadow and rounded corners
- Floating card effect using shadows and CSS transitions
- Comprehensive examples with code snippets and explanations

#### How to Use:
Open `exercise15.2/index.html` in your browser to see how shadow and rounded-pill utilities enhance the visual appeal of cards and other elements. The page includes various examples and creative combinations of these utilities.

## Exercise 16: Positioning Utilities

### Exercise 16.1: Fixed Footer

Located in the `exercise16.1` directory, this exercise demonstrates how to create a fixed footer using Bootstrap's positioning utilities.

#### Features:
- Fixed footer that stays at the bottom of the viewport using `position-fixed` and `bottom-0`
- Multiple footer style variations (basic, dark, primary)
- Explanation of how fixed positioning works
- Best practices for implementing fixed footers
- Common use cases including cookie consent banners and mobile app-like navigation
- Consideration of body padding to prevent content from being hidden
- Interactive footer style toggle
- Comprehensive examples with code snippets and explanations

#### How to Use:
Open `exercise16.1/index.html` in your browser to see a fixed footer that remains at the bottom of the viewport even when scrolling. Use the buttons in the bottom-right corner to toggle between different footer styles.

### Exercise 16.2: Badge Overlay on Images

Located in the `exercise16.2` directory, this exercise demonstrates how to use `position-relative` and `position-absolute` to overlay badges on images.

#### Features:
- Parent containers with `position-relative`
- Badges with `position-absolute` and positioning utilities
- Badge placement at different corners (top-left, top-right, bottom-left, bottom-right)
- Centered badges using `translate-middle` utilities
- Practical examples including product cards with sale badges
- Real estate listings with multiple badges
- Event promotions with overlay text
- Interactive demo that allows experimenting with different badge positions
- Comprehensive examples with code snippets and explanations

#### How to Use:
Open `exercise16.2/index.html` in your browser to explore different ways to overlay badges on images. The page includes an interactive demo where you can experiment with different badge positions, translations, and styles.

## Exercise 17: Bootstrap Icons

### Exercise 17.1: Social Media Icons in Footer

Located in the `exercise17.1` directory, this exercise demonstrates how to install and use Bootstrap Icons to create social media icons in a footer.

#### Features:
- Installation methods for Bootstrap Icons (CDN, npm, download)
- Basic usage of Bootstrap Icons
- Social media icon implementation
- Different footer layouts with icons
- Circular background icons
- Animated hover effects
- Brand color implementation
- Accessibility best practices
- Mobile-responsive layouts
- Comprehensive examples with code snippets

#### How to Use:
Open `exercise17.1/index.html` in your browser to see different implementations of social media icons in footers. The page includes multiple examples and detailed explanations of each approach.

### Exercise 17.2: Icon-Only Buttons

Located in the `exercise17.2` directory, this exercise demonstrates how to replace text buttons with icon-only buttons using Bootstrap Icons.

#### Features:
- Converting text buttons to icon-only buttons
- Button sizes (small, regular, large)
- Button variants (solid, outline, floating)
- Circular icon buttons
- Button groups with icons
- Floating action buttons
- Tooltip integration
- Accessibility considerations
- Hover animations
- Best practices for icon buttons

#### How to Use:
Open `exercise17.2/index.html` in your browser to explore different types of icon-only buttons. The page includes interactive examples and demonstrates proper accessibility implementation.

## Exercise 18: Bootstrap JavaScript Plugins

### Exercise 18.1: Modal Popup

Located in the `exercise18.1` directory, this exercise demonstrates how to create and use Bootstrap's modal component with various configurations.

#### Features:
- Basic modal implementation
- Different modal sizes (small, large, extra large)
- Scrollable modals
- Vertically centered modals
- Modal with forms
- Static backdrop modals
- Custom styling and animations
- Accessibility considerations
- Comprehensive examples with code snippets

#### How to Use:
Open `exercise18.1/index.html` in your browser to explore different types of modal popups. The page includes interactive examples and demonstrates proper implementation techniques.

### Exercise 18.2: Collapsible Accordion

Located in the `exercise18.2` directory, this exercise demonstrates how to create and customize Bootstrap's accordion component.

#### Features:
- Basic accordion implementation
- Always-open accordion variant
- Flush styling without borders
- Custom styled accordions
- Nested accordions
- Icon integration
- Accessibility features
- Interactive examples
- Best practices and usage guidelines

#### How to Use:
Open `exercise18.2/index.html` in your browser to explore different types of accordions. The page includes various examples and demonstrates proper implementation.

## Exercise 19: Customization with Sass

### Exercise 19.1: Bootstrap with Sass Setup

Located in the `exercise19.1` directory, this exercise demonstrates how to set up a Bootstrap 5 project with Sass using npm.

#### Features:
- npm project setup
- Sass compilation configuration
- Custom variable overrides
- Custom component styles
- Custom utility classes
- Gradient and shadow utilities
- Button variants
- Card customization
- Live compilation with watch mode

#### How to Use:
1. Navigate to `exercise19.1` directory
2. Run `npm install` to install dependencies
3. Run `npm run sass` to start Sass compilation in watch mode
4. Open `index.html` to see the customized Bootstrap components

### Exercise 19.2: Custom Colors and Border Radius

Located in the `exercise19.2` directory, this exercise demonstrates how to customize Bootstrap's theme colors and border radius using Sass variables.

#### Features:
- Custom color palette
- Theme color customization
- Custom border radius utilities
- Extended border radius values
- Component examples with custom colors
- Interactive demonstrations
- Sass variable overrides
- Utility class generation

#### How to Use:
1. Navigate to `exercise19.2` directory
2. Run `npm install` to install dependencies
3. Run `npm run sass` to start Sass compilation in watch mode
4. Open `index.html` to see the customized theme colors and border radius



## Project Structure:
```
cts_module5/
├── exercise1.1/
│   └── index.html (Bootstrap via CDN)
├── exercise1.2/
│   ├── css/
│   │   └── bootstrap.min.css (placeholder)
│   ├── js/
│   │   └── bootstrap.bundle.min.js (placeholder)
│   ├── package.json
│   └── index.html (Bootstrap via local files)
├── exercise2.1/
│   ├── bootstrap_structure.md
│   └── bootstrap_structure_diagram.html
├── exercise2.2/
│   └── index.html (JavaScript plugins demo)
├── exercise3.1/
│   └── index.html (Responsive columns demo)
├── exercise3.2/
│   └── index.html (Container, row, and column classes demo)
├── exercise4.1/
│   └── index.html (Two-column layout with sidebar)
├── exercise4.2/
│   └── index.html (Four-column equal width layout)
├── exercise5.1/
│   └── index.html (Content alignment demo)
├── exercise5.2/
│   └── index.html (Column reordering demo)
├── exercise6.1/
│   └── index.html (Responsive navbar with flexbox)
├── exercise6.2/
│   └── index.html (Card layout with flexbox)
├── exercise7.1/
│   └── index.html (Typography utilities demo)
├── exercise7.2/
│   └── index.html (Text transformation demo)
├── exercise8.1/
│   └── index.html (Registration form demo)
├── exercise8.2/
│   └── index.html (Floating label login form)
├── exercise9.1/
│   └── index.html (Contextual button classes demo)
├── exercise9.2/
│   └── index.html (Button groups and toggle buttons demo)
├── exercise10.1/
│   └── index.html (Responsive navbar demo)
├── exercise10.2/
│   └── index.html (Tabbed navigation demo)
├── exercise11.1/
│   └── index.html (Profile card demo)
├── exercise11.2/
│   └── index.html (Media object layout demo)
├── exercise12.1/
│   └── index.html (Margin and padding utilities demo)
├── exercise12.2/
│   └── index.html (Pricing section with spacing demo)
├── exercise13.1/
│   └── index.html (Dashboard with contextual colors demo)
├── exercise13.2/
│   └── index.html (Gradient backgrounds demo)
├── exercise14.1/
│   └── index.html (Responsive display utilities demo)
├── exercise14.2/
│   └── index.html (Responsive sidebar demo)
├── exercise15.1/
│   └── index.html (Border utilities with images demo)
├── exercise15.2/
│   └── index.html (Shadows and rounded pills demo)
├── exercise16.1/
│   └── index.html (Fixed footer demo)
├── exercise16.2/
│   └── index.html (Badge overlay on images demo)
├── exercise17.1/
│   └── index.html (Social media icons in footer demo)
├── exercise17.2/
│   └── index.html (Icon-only buttons demo)
├── exercise18.1/
│   └── index.html (Modal popup demo)
├── exercise18.2/
│   └── index.html (Collapsible accordion demo)
├── exercise19.1/
│   ├── css/
│   │   └── styles.css (Compiled from Sass)
│   ├── scss/
│   │   └── custom.scss (Custom Bootstrap Sass)
│   ├── package.json
│   └── index.html (Bootstrap with Sass demo)
├── exercise19.2/
│   ├── css/
│   │   └── styles.css (Compiled from Sass)
│   ├── scss/
│   │   ├── _variables.scss (Custom variables)
│   │   └── custom.scss (Theme customization)
│   ├── package.json
│   └── index.html (Custom colors and border radius demo)
└── README.md
```
