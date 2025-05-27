# Java Modules Example

This project demonstrates the use of Java's module system with two modules:
- `com.utils`: A utility module that exports helper classes
- `com.greetings`: A module that requires and uses the utility module

## Project Structure

```
├── com.utils/
│   └── src/
│       ├── module-info.java
│       └── com/
│           └── utils/
│               └── StringUtils.java
└── com.greetings/
    └── src/
        ├── module-info.java
        └── com/
            └── greetings/
                └── Main.java
```

## Compilation Instructions

To compile the modules, you need to use the module path instead of the classpath. Follow these steps:

1. First, compile the `com.utils` module:

```
javac -d com.utils/mods/com.utils com.utils/src/module-info.java com.utils/src/com/utils/StringUtils.java
```

2. Then, compile the `com.greetings` module, using the compiled `com.utils` module:

```
javac --module-path com.utils/mods -d com.greetings/mods/com.greetings com.greetings/src/module-info.java com.greetings/src/com/greetings/Main.java
```

## Running the Application

To run the application, use the following command:

```
java --module-path com.utils/mods:com.greetings/mods -m com.greetings/com.greetings.Main
```

Note: On Windows, use semicolons (`;`) instead of colons (`:`) as path separators:

```
java --module-path com.utils/mods;com.greetings/mods -m com.greetings/com.greetings.Main
```

## Expected Output

```
Original message: hello from java modules
Capitalized message: Hello From Java Modules

Original greeting: Hello World
Reversed greeting: dlroW olleH

--- Module Information ---
Current module: com.greetings
StringUtils module: com.utils
```
