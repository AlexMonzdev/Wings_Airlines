package com.airlines.app_wings.Itinerary;

import com.airlines.app_wings.destiny.Destiny;
import com.airlines.app_wings.origin.Origin;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "itinerary")
public class Itinerary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalTime localDepartureTime;
    private LocalDate localDepartureDate;

    private LocalTime localArrivalTime;
    private LocalDate localArrivalDate;

    @ManyToOne
    @JoinColumn(name = "id_origin", nullable = false)
    private Origin origin;

    @ManyToOne
    @JoinColumn(name = "id_destini", nullable = false)
    private Destiny destiny;

}
