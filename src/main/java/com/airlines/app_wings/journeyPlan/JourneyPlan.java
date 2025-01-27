package com.airlines.app_wings.journeyPlan;

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
@Table(name = "journey_plan")
public class JourneyPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalTime localDepartureTime;
    private LocalDate localDeparturelDate;

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

    public LocalTime getLocaldepartureTime() {
        return localDepartureTime;
    }

    public void setLocaldepartureTime(LocalTime localdepartureTime) {
        this.localDepartureTime = localdepartureTime;
    }

    public LocalDate getLocaldeparturelDate() {
        return localDeparturelDate;
    }

    public void setLocaldeparturelDate(LocalDate localdeparturelDate) {
        this.localDeparturelDate = localdeparturelDate;
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
