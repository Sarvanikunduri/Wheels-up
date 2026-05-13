package com.rentalsystem.vehiclerental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rentalsystem.vehiclerental.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    // You can add custom queries here if needed
}
