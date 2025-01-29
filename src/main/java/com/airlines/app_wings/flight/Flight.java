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

}
