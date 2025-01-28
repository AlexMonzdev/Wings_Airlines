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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalTime getLocalDepartureTime() {
        return localDepartureTime;
    }

    public void setLocalDepartureTime(LocalTime localDepartureTime) {
        this.localDepartureTime = localDepartureTime;
    }

    public LocalDate getLocalDepartureDate() {
        return localDepartureDate;
    }

    public void setLocalDepartureDate(LocalDate localDepartureDate) {
        this.localDepartureDate = localDepartureDate;
    }

    public LocalTime getLocalArrivalTime() {
        return localArrivalTime;
    }

    public void setLocalArrivalTime(LocalTime localArrivalTime) {
        this.localArrivalTime = localArrivalTime;
    }

    public LocalDate getLocalArrivalDate() {
        return localArrivalDate;
    }

    public void setLocalArrivalDate(LocalDate localArrivalDate) {
        this.localArrivalDate = localArrivalDate;
    }

    public Origin getOrigin() {
        return origin;
    }

    public void setOrigin(Origin origin) {
        this.origin = origin;
    }

    public Destiny getDestiny() {
        return destiny;
    }

    public void setDestiny(Destiny destiny) {
        this.destiny = destiny;
    }
}
