package daaw.examen_app.services;

import java.util.List;
import java.util.Optional;

import javax.smartcardio.CardPermission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import daaw.examen_app.persistence.model.Car;
import daaw.examen_app.persistence.model.Maintenance;
import daaw.examen_app.persistence.repository.*;;

@Service
public class CarService{

    @Autowired
    private CarRepository repository;

    public List<Car> getAllCars() {
        return repository.findAll();
    }

    public Car saveCar(Car car) {
        car.setId(null);
        return repository.save(car);
    }

    public Optional<Car> findById(Long id) {
        Optional<Car> result = repository.findById(id);
        System.out.println(result);
        return result;
    }

    public Car addMaintenance(Long id, Maintenance m) {
        Optional<Car> result = repository.findById(id);
        if (result.isPresent()) {
            Car car = result.get();
            car.addMaintenance(m);
            System.err.println(car);
            repository.save(car);
            return car;
        } else {
            return null;
        }
    }
    

        


}
