package com.sufi.photoStudio.Service.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class BookingDTO {
    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^[0-9]{10,15}$", message = "Invalid phone number")
    private String phone;

    @NotBlank(message = "Shoot type is required")
    private String shootType;

    @FutureOrPresent(message = "Date must be today or in the future")
    private LocalDate date;

    private LocalTime time;

    @Size(max = 1000, message = "Message too long")
    private String message;
}
