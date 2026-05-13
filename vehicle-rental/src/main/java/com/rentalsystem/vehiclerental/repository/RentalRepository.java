package com.rentalsystem.vehiclerental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rentalsystem.vehiclerental.model.Rental;

public interface RentalRepository extends JpaRepository<Rental, Long> {
    // You can add custom queries here if needed
}
