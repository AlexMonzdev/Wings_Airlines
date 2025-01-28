package com.airlines.app_wings.flight;

import com.airlines.app_wings.Itinerary.Itinerary;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "flight")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int capacitySeats;
    private int bookedSeats;
    private String airplaneModel;
    private String flightNumber;

    @ManyToOne
    @JoinColumn(name = "id_itinerary", nullable = false)
    private Itinerary itinerary;

    public boolean isFull() {
        return bookedSeats >= capacitySeats;
    }

    public void bookSeat() {
        if (!isFull()) {
            this.bookedSeats++;
        } else {
            throw new IllegalStateException("El vuelo está lleno.");
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCapacitySeats() {
        return capacitySeats;
    }

    public void setCapacitySeats(int capacitySeats) {
        this.capacitySeats = capacitySeats;
    }

    public int getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(int bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

    public String getAirplaneModel() {
        return airplaneModel;
    }

    public void setAirplaneModel(String airplaneModel) {
        this.airplaneModel = airplaneModel;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Itinerary getItinerary() {
        return itinerary;
    }

    public void setItinerary(Itinerary itinerary) {
        this.itinerary = itinerary;
    }
}
