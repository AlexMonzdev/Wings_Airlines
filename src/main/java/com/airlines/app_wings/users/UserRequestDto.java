package com.airlines.app_wings.users;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record UserRequestDto(

        @NotNull(message = "Date cannot be null")
        @FutureOrPresent(message = "Date must be in the present or future")
        String user,
        @NotNull(message = "Date cannot be null")
        @FutureOrPresent(message = "Date must be in the present or future")
        String password

){
}
