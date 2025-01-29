package com.airlines.app_wings.users;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record UserRequestDto(

//        @NotBlank(message = "El email no puede estar vacío")
//        @Email(message = "El email debe tener un formato válido")
        String user,
//        @NotBlank(message = "La contraseña no puede estar vacía")
//        @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
//        @Pattern(
//                regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=]).{8,}$",
//                message = "La contraseña debe contener al menos una mayúscula, una minúscula, un número y un carácter especial"
//        )
        String password

){
}
