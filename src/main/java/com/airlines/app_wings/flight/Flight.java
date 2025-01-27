package com.airlines.app_wings.flight;

import com.airlines.app_wings.journeyPlan.JourneyPlan;
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

    private int capacity;
    private int bookedSeats;
    private String planeModel;
    private String flightNum;

    @ManyToOne
    @JoinColumn(name = "id_journey", nullable = false)
    private JourneyPlan journeyPlan;

    public boolean isFull() {
        return bookedSeats >= capacity;
    }

    public void bookSeat() {
        if (!isFull()) {
            this.bookedSeats++;
        } else {
            throw new IllegalStateException("El vuelo está lleno.");
        }
    }

}
