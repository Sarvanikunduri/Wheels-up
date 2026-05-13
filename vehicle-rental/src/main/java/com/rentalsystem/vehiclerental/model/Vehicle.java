package com.rentalsystem.vehiclerental.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type; // car, bike, scooty
    private String model;
    private double pricePerHour;
    private boolean available = true;

    @ManyToOne
    private User owner;
}
