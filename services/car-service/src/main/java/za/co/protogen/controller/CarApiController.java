package za.co.protogen.controller;

import org.springframework.web.bind.annotation.*;
import za.co.protogen.domain.Car;
import za.co.protogen.utility.Constant;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarApiController {

    // Retrieving all cars
    @GetMapping
    public List<Car> getAllCars() {
        return Constant.cars; 
    }

    // Retrieving a car by VIN
    @GetMapping("/{vin}")
    public Car getCarByVin(@PathVariable String vin) {
        return Constant.cars.stream()
                .filter(car -> car.getVin().equals(vin))
                .findFirst()
                .orElse(null);
    }

    // Adding a new car
    @PostMapping
    public void addCar(@RequestBody Car car) {
        Constant.cars.add(car); 
    }

    // Updating an existing car
    @PutMapping("/{vin}")
    public void updateCar(@PathVariable String vin, @RequestBody Car updatedCar) {
        List<Car> cars = Constant.cars; 
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            if (car.getVin().equals(vin)) {
                cars.set(i, updatedCar);
                return;
            }
        }
    }

    // Deleting a car by VIN
    @DeleteMapping("/{vin}")
    public void deleteCar(@PathVariable String vin) {
        Constant.cars.removeIf(car -> car.getVin().equals(vin)); 
    }
}
