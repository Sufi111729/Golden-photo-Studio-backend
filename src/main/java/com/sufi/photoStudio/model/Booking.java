package com.sufi.photoStudio.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "bookings")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String shootType;

    @Column(nullable = false)
    private LocalDate date;

    private LocalTime time;
    
    @Column(length = 1000)
    private String message;

    @Builder.Default
    @Column(nullable = false)
    private String status = "PENDING";

}