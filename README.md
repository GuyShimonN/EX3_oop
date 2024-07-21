# Airline Management System

This project is a simple airline management system implemented in Java. It uses several design patterns to improve encapsulation and separate interfaces from implementation.

## Design Patterns Used

1. **Observer Pattern**: The `Passenger` and `Employed` classes act as observers, listening for changes in the `AirlineGlobal` class, which is observable.

2. **Strategy Pattern**: Different search strategies (`PriceSearchStrategy`, `TimeSearchStrategy`, `SerchByDistans`) are used to search for flights. These strategies can be selected at runtime.

3. **Composite Pattern**: The `Flight` class and the `AirlineGlobal` class (along with its subclasses) are treated uniformly, simplifying the handling of tree structures.

4. **Abstract Factory Pattern**: The `AirlineGlobal` class acts as an abstract factory, creating `Employed` and `Flight` objects.

## Classes

- `Observable`: An interface for observable objects.
- `Observer`: An interface for observer objects.
- `Employed`: A class representing an employee. It extends the `Passenger` class and implements the `Observer` interface.
- `SerchByDistans`: A class implementing the `SearchStrategy` interface. It searches for flights based on distance.

## How to Run

This project is a standard Java project. You can compile and run it using any Java IDE or from the command line using the `javac` and `java` commands.

## Contributing

Contributions are welcome. Please open an issue to discuss your ideas before making changes.

## License

This project is licensed under the MIT License. See the `LICENSE` file for details.
