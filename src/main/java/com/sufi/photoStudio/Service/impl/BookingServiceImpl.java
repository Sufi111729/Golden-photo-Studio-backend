package com.sufi.photoStudio.Service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.sufi.photoStudio.Service.BookingService;
import com.sufi.photoStudio.Service.IMailService;
import com.sufi.photoStudio.Service.IWhatsAppService;
import com.sufi.photoStudio.Service.dto.BookingDTO;
import com.sufi.photoStudio.Service.dto.BookingResponseDTO;
import com.sufi.photoStudio.model.Booking;
import com.sufi.photoStudio.repository.BookingRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final IWhatsAppService whatsAppService;
    private final IMailService mailService;
    private final ModelMapper modelMapper;

    @Override
    public BookingResponseDTO createBooking(BookingDTO bookingDTO) {
        Booking booking = modelMapper.map(bookingDTO, Booking.class);
        booking.setStatus("CONFIRMED");
        Booking savedBooking = bookingRepository.save(booking);

        sendNotifications(savedBooking);

        return modelMapper.map(savedBooking, BookingResponseDTO.class);
    }

    @Override
    public List<BookingResponseDTO> getAllBookings() {
        return bookingRepository.findAll().stream()
                .map(booking -> modelMapper.map(booking, BookingResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public BookingResponseDTO getBookingById(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        return modelMapper.map(booking, BookingResponseDTO.class);
    }

    @Override
    public BookingResponseDTO updateBooking(Long id, BookingDTO bookingDTO) {
        Booking booking = bookingRepository.findById(id)
                .orElse(null);
        if (booking == null) {
            return null;
        }
        // Update fields
        modelMapper.map(bookingDTO, booking);
        Booking updatedBooking = bookingRepository.save(booking);
        return modelMapper.map(updatedBooking, BookingResponseDTO.class);
    }

    @Override
    public boolean deleteBooking(Long id) {
        if (!bookingRepository.existsById(id)) {
            return false;
        }
        bookingRepository.deleteById(id);
        return true;
    }

    private void sendNotifications(Booking booking) {
        // WhatsApp notification
        String whatsappMessage = String.format(
            "Hello %s, your %s booking on %s at %s is confirmed. Thank you!",
            booking.getName(), booking.getShootType(), booking.getDate(), booking.getTime()
        );
        whatsAppService.sendBookingConfirmation(booking.getPhone(), whatsappMessage);

        // Email notification
        String emailContent = String.format("""
            <h1>Booking Confirmation</h1>
            <p>Dear %s,</p>
            <p>Your %s photoshoot has been booked for:</p>
            <ul>
                <li>Date: %s</li>
                <li>Time: %s</li>
            </ul>
            <p>We'll contact you soon with more details.</p>
            <p>Thank you for choosing us!</p>
            """, booking.getName(), booking.getShootType(), booking.getDate(), booking.getTime());

        mailService.sendBookingConfirmation(
            booking.getEmail(),
            "Your Photo Shoot Booking Confirmation",
            emailContent
        );
    }
}
