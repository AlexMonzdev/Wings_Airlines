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
    private String planeModel;
    private String flightNum;

    @ManyToOne
    @JoinColumn(name = "id_journey", nullable = false)
    private JourneyPlan journeyPlan;

}
