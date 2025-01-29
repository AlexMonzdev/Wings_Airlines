package com.airlines.app_wings.boardingPass;

import com.airlines.app_wings.flight.Flight;
import com.airlines.app_wings.profiles.Profile;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "boarding_pass")
public class BoardingPass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String flightClass;
    private String seat;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "id_profile", nullable = false)
    @JsonBackReference
    private Profile profile;

    @ManyToOne
    @JoinColumn(name = "id_flight", nullable = false)
    @JsonBackReference
    private Flight flight;

}
