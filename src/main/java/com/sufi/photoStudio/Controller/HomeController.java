// src/main/java/com/sufi/photoStudio/Controller/HomeController.java
package com.sufi.photoStudio.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "index"; // Looks for index.html in src/main/resources/templates/
    }
}
