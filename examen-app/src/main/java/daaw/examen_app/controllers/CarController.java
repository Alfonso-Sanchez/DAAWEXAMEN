package daaw.examen_app.controllers;

import java.net.URI;
import java.util.List;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import daaw.examen_app.exceptions.exception.CarIdMismatchException;
import daaw.examen_app.exceptions.exception.CarNotFoundException;
import daaw.examen_app.persistence.model.Car;
import daaw.examen_app.persistence.model.Maintenance;
import daaw.examen_app.persistence.repository.CarRepository;
import daaw.examen_app.services.CarService;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService CarService;

    @GetMapping()
    public List<Car> getCars() {
        return CarService.getAllCars();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> findOne(@PathVariable Long id) {
        Optional<Car> result = CarService.findById(id);
        if (result.isEmpty()) {
            throw new CarNotFoundException();
        } else {

        }
        return ResponseEntity.ok(result.get());
    }

    @PostMapping
    public ResponseEntity<Car> createCar(@Valid @RequestBody Car car) {
        Car savedCar = CarService.saveCar(car);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedCar.getId()).toUri();

        return ResponseEntity.created(location).body(savedCar);
    }
    
    @PostMapping("/{id}/maintenances") 
    public ResponseEntity<Car> addMaintenance(@PathVariable Long id, @RequestBody Maintenance m) {
        Car result = CarService.addMaintenance(id, m);
        if (result != null) {
            return ResponseEntity.ok(result);
        } else {
            throw new CarIdMismatchException();
        }
        
    }
    
}
