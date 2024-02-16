

package za.co.protogen;

import za.co.protogen.core.CarService;
import za.co.protogen.core.impl.CarServiceImpl;
import za.co.protogen.domain.Car;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        
        CarService carService = new CarServiceImpl();

        // Adding cars
        Car car1 = new Car("Toyota", "Corolla", 2021, "White", "1.8L", "Automatic",
                "Gasoline", 10000, "ABC123", 25000, 123, new ArrayList<>());
        Car car2 = new Car("Honda", "Civic", 2020, "Red", "1.5L", "CVT",
                "Gasoline", 15000, "XYZ789", 22000, 456, new ArrayList<>());

        carService.addCar(car1);
        carService.addCar(car2);

        // Retrieving cars
        System.out.println("All Cars:");
        List<Car> allCars = carService.getAllCars();
        displayCarInformation(allCars);

        // Get car by VIN
        System.out.println("\nCar with VIN ABC123:");
        Car carByVin = carService.getCarById("ABC123");
        if (carByVin != null) {
            displayCarInformation(carByVin);
        } else {
            System.out.println("Car not found.");
        }

        // Removing a car
        carService.removeCar("XYZ789");

        // Retrieving cars after removal
        System.out.println("\nAll Cars after removal:");
        allCars = carService.getAllCars();
        displayCarInformation(allCars);
    }

    // method to display car information
    public static void displayCarInformation(List<Car> cars) {
        for (Car car : cars) {
            System.out.println("Make: " + car.getMake());
            System.out.println("Model: " + car.getModel());
            System.out.println("Year: " + car.getYear());
            System.out.println("Color: " + car.getColor());
            System.out.println("Engine: " + car.getEngine());
            System.out.println("Transmission: " + car.getTransmission());
            System.out.println("Fuel Type: " + car.getFuelType());
            System.out.println("Mileage: " + car.getMileage());
            System.out.println("VIN: " + car.getVin());
            System.out.println("Price: " + car.getPrice());
            System.out.println("Owner ID: " + car.getOwnerId());
            System.out.println("Features: " + car.getFeatures());
            System.out.println();
        }
    }
}
