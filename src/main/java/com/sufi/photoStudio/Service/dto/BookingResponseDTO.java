package com.sufi.photoStudio.Service.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class BookingResponseDTO {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String shootType;
    private LocalDate date;
    private LocalTime time;
    private String message;
    private String status;
}