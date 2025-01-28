package com.airlines.app_wings.flight;

public record FlightRequestDto(
        int capacitySeats,
        int bookedSeats,
        String airplaneModel,
        String flightNumber,
        Long itineraryId
) {
}
