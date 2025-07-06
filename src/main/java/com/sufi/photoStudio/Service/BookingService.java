// BookingService.java
package com.sufi.photoStudio.Service;

import com.sufi.photoStudio.Service.dto.BookingDTO;
import com.sufi.photoStudio.Service.dto.BookingResponseDTO;
import java.util.List;

public interface BookingService {
    BookingResponseDTO createBooking(BookingDTO bookingDTO);
    List<BookingResponseDTO> getAllBookings();
    BookingResponseDTO getBookingById(Long id);
    BookingResponseDTO updateBooking(Long id, BookingDTO bookingDTO); // Add this
    boolean deleteBooking(Long id); // Add this
}
