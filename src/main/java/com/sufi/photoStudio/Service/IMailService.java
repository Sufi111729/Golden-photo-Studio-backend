// IMailService.java
package com.sufi.photoStudio.Service;

public interface IMailService {
    void sendBookingConfirmation(String to, String subject, String content);
}
