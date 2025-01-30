package com.airlines.app_wings.config;

import com.airlines.app_wings.users.User;
import com.airlines.app_wings.users.UserRequestDto;
import com.airlines.app_wings.users.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/home")
public class AuthController {

    @GetMapping
    public String home() {
        return "Bienvenido a la API de AppWings";
    }


}
