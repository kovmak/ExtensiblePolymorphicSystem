# PC Assembly System

## Overview
This project demonstrates an extensible polymorphic system for assembling personal computers. It leverages inheritance, interfaces, and the Builder pattern to create a flexible and maintainable codebase.

## Project Structure
The project follows a three-layer architecture:
1. **Data Layer**: Represents the warehouse of PC components.
2. **Business Logic Layer**: Handles the assembly process.
3. **Presentation Layer**: Interacts with the user.

## Key Concepts
- **Inheritance and Interfaces**: Used to define common behaviors and properties of PC components.
- **Builder Pattern**: Ensures that mandatory fields are provided before creating an object.
- **Association**: Connects components to form the final PC assembly.

## Components
### Mandatory Components
- **Motherboard**
- **Processor**
- **Memory**

### Optional Components
- **Graphics Card**
- **Sound Card**
- **Additional Storage**

### Enumerations
Enumerations are used for components with a known set of values, such as socket types and memory types.

## Usage
### Builder Pattern
The builder pattern is used to construct PC components, ensuring all mandatory fields are set.

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

