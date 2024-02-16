
package za.co.protogen.core;

import za.co.protogen.domain.Car;

import java.util.List;

public interface CarService {
    void addCar(Car car);
    void removeCar(String vin);
    Car getCarById(String vin);
    List<Car> getAllCars();
    List<Car> getCarsByMake(String make);
    List<Car> getCarsByYear(int year);
    List<Car> getCarsByColor(String color);
    void updateCar(String vin, Car updatedCar);
    double calculateAverageMileage();
    Car findCheapestCar();
    Car findMostExpensiveCar();
    Car findNewestCar();
    Car findOldestCar();
    List<Car> searchCars(String make, String model, double minPrice, double maxPrice, int minYear, int maxYear);
}
