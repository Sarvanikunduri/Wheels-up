package com.rentalsystem.vehiclerental.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//
    private Long id;

    @ManyToOne
    private Vehicle vehicle;

    @ManyToOne
    private User renter;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private double totalCost;
}
