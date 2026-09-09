package com.vehicleservice.service;

import com.vehicleservice.dto.CreateVehicleRequest;
import com.vehicleservice.dto.UpdateVehicleRequest;
import com.vehicleservice.exception.MissingAttributeException;
import com.vehicleservice.exception.VehicleAlreadyExistsException;
import com.vehicleservice.exception.VehicleNotFoundException;
import com.vehicleservice.model.Vehicle;
import com.vehicleservice.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    private final VehicleRepository repository;

    public VehicleService(VehicleRepository repository) {
        this.repository = repository;
    }

    public List<Vehicle> getAll() {
        return repository.findAll();
    }

    public Vehicle getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new VehicleNotFoundException("Vehicle with id: " + id + " not found."));
    }

    public Vehicle create(CreateVehicleRequest request) {
        if (request.getVin() == null || request.getVin().isBlank()) {
            throw new MissingAttributeException("Request body missing required attribute: vin");
        }

        Optional<Vehicle> existing = repository.findByVin(request.getVin());
        if (existing.isPresent()) {
            throw new VehicleAlreadyExistsException(
                    "Vehicle with VIN " + request.getVin()
                            + " already exists. Existing vehicle ID: " + existing.get().getId());
        }

        Vehicle vehicle = new Vehicle();
        vehicle.setNickName(request.getNickName());
        vehicle.setVin(request.getVin());
        vehicle.setMake(request.getMake());
        vehicle.setModel(request.getModel());
        vehicle.setYear(request.getYear());
        vehicle.setMiles(request.getMiles());

        return repository.save(vehicle);
    }

    public Vehicle update(Long id, UpdateVehicleRequest request) {
        Vehicle vehicle = repository.findById(id)
                .orElseThrow(() -> new VehicleNotFoundException("Vehicle with id: " + id + " not found."));

        if (request.getNickName() != null) {
            vehicle.setNickName(request.getNickName());
        }
        if (request.getVin() != null) {
            vehicle.setVin(request.getVin());
        }
        if (request.getMake() != null) {
            vehicle.setMake(request.getMake());
        }
        if (request.getModel() != null) {
            vehicle.setModel(request.getModel());
        }
        if (request.getYear() != null) {
            vehicle.setYear(request.getYear());
        }
        if (request.getMiles() != null) {
            vehicle.setMiles(request.getMiles());
        }

        return repository.save(vehicle);
    }

    public void delete(Long id) {
        boolean existed = repository.deleteById(id);
        if (!existed) {
            throw new VehicleNotFoundException("Vehicle with id: " + id + " not found.");
        }
    }
}
