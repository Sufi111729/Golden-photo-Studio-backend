// WhatsAppService.java
package com.sufi.photoStudio.Service.impl;


import org.springframework.stereotype.Service;

import com.sufi.photoStudio.Service.IWhatsAppService;

@Service
public class WhatsAppService implements IWhatsAppService {

    @Override
    public void sendBookingConfirmation(String phoneNumber, String message) {
        // TODO: Integrate actual WhatsApp API (e.g., Twilio or Gupshup)

        // Simulate sending for now
        System.out.println("WhatsApp message sent to " + phoneNumber + ": " + message);
    }
}
