package com.rentalsystem.vehiclerental.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import lombok.RequiredArgsConstructor;
import com.rentalsystem.vehiclerental.model.Vehicle;
import com.rentalsystem.vehiclerental.repository.VehicleRepository;

@RestController
@RequestMapping("/api/vehicles")
@CrossOrigin("*")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleRepository vehicleRepo;

    @GetMapping
    public List<Vehicle> getAllVehicles() {
        return vehicleRepo.findAll();
    }

    @PostMapping
    public Vehicle addVehicle(@RequestBody Vehicle v) {
        return vehicleRepo.save(v);
    }

    @DeleteMapping("/{id}")
    public void deleteVehicle(@PathVariable Long id) {
        vehicleRepo.deleteById(id);
    }
}
