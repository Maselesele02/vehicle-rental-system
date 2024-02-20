package za.co.protogen.core.impl;

import za.co.protogen.core.CarService;
import za.co.protogen.domain.Car;
import za.co.protogen.utility.Constant;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;

public class CarServiceImpl implements CarService {

    @Override
    public void addCar(Car car) {
        Constant.cars.add(car);
    }

    @Override
    public void removeCar(String vin) {
        Constant.cars.removeIf(car -> car.getVin().equals(vin));
    }

    @Override
    public Car getCarById(String vin) {
        return Constant.cars.stream()
                .filter(car -> car.getVin().equals(vin))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Car> getAllCars() {
        return new ArrayList<>(Constant.cars);
    }

    @Override
    public List<Car> getCarsByMake(String make) {
        return Constant.cars.stream()
                .filter(car -> car.getMake().equalsIgnoreCase(make))
                .collect(Collectors.toList());
    }

    @Override
    public List<Car> getCarsByYear(int year) {
        return Constant.cars.stream()
                .filter(car -> car.getYear() == year)
                .collect(Collectors.toList());
    }

    @Override
    public List<Car> getCarsByColor(String color) {
        return Constant.cars.stream()
                .filter(car -> car.getColor().equalsIgnoreCase(color))
                .collect(Collectors.toList());
    }

    @Override
    public void updateCar(String vin, Car updatedCar) {
        for (int i = 0; i < Constant.cars.size(); i++) {
            Car car = Constant.cars.get(i);
            if (car.getVin().equals(vin)) {
                Constant.cars.set(i, updatedCar);
                return;
            }
        }
    }

    @Override
    public double calculateAverageMileage() {
        double totalMileage = Constant.cars.stream()
                .mapToDouble(Car::getMileage)
                .sum();
        return totalMileage / Constant.cars.size();
    }

    @Override
    public Car findCheapestCar() {
        return Constant.cars.stream()
                .min(Comparator.comparingDouble(Car::getPrice))
                .orElse(null);
    }

    @Override
    public Car findMostExpensiveCar() {
        return Constant.cars.stream()
                .max(Comparator.comparingDouble(Car::getPrice))
                .orElse(null);
    }

    @Override
    public Car findNewestCar() {
        return Constant.cars.stream()
                .max(Comparator.comparingInt(Car::getYear))
                .orElse(null);
    }

    @Override
    public Car findOldestCar() {
        return Constant.cars.stream()
                .min(Comparator.comparingInt(Car::getYear))
                .orElse(null);
    }

    @Override
    public List<Car> searchCars(String make, String model, double minPrice, double maxPrice, int minYear, int maxYear) {
        return Constant.cars.stream()
            .filter(car -> car.getMake().contains(make) &&
                           car.getModel().contains(model) &&
                           car.getPrice() >= minPrice &&
                           car.getPrice() <= maxPrice &&
                           car.getYear() >= minYear &&
                           car.getYear() <= maxYear)
            .collect(Collectors.toList());
}

}
