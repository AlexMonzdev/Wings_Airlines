package com.airlines.app_wings.boardingPass;

import com.airlines.app_wings.flight.Flight;
import com.airlines.app_wings.flight.FlightRepository;
import com.airlines.app_wings.profiles.Profile;
import com.airlines.app_wings.profiles.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoardingPassService {

    private final BoardingPassRepository boardingPassRepository;
    private final FlightRepository flightRepository;
    private final ProfileRepository profileRepository;


    public BoardingPassService(BoardingPassRepository boardingPassRepository, FlightRepository flightRepository, ProfileRepository profileRepository) {
        this.boardingPassRepository = boardingPassRepository;
        this.flightRepository = flightRepository;
        this.profileRepository = profileRepository;
    }

    public List<BoardingPass> getBoardingPassesByProfile(Long profileId) {
        return boardingPassRepository.findByProfileId(profileId);
    }

    public Optional<BoardingPass> getBoardingPassById(Long id) {
        return boardingPassRepository.findById(id);
    }

    public BoardingPass createBoardingPass(Long profileId, Long flightId) {
        Profile profile = profileRepository.findById(profileId)
                .orElseThrow(() -> new RuntimeException("Perfil no encontrado"));

        Flight flight = flightRepository.findById(flightId)
                .orElseThrow(() -> new RuntimeException("Vuelo no encontrado"));

        if (flight.isFull()) {
            throw new IllegalStateException("El vuelo está lleno. No se pueden vender más pasajes.");
        }

        // Asignar asiento automáticamente
        String assignedSeat = assignSeat(flight);

        // Calcular precio dinámico
        double price = calculateDynamicPrice(flight);

        BoardingPass boardingPass = new BoardingPass();
        boardingPass.setProfile(profile);
        boardingPass.setFlight(flight);
        boardingPass.setSeat(assignedSeat);
        boardingPass.setFlightClass("Turista"); // Se asigna automáticamente la clase Economy
        boardingPass.setPrice(price); // Precio dinámico

        // Reservar el asiento en el vuelo
        flight.bookSeat();
        flightRepository.save(flight);

        return boardingPassRepository.save(boardingPass);
    }

    private String assignSeat(Flight flight) {
        int nextSeatNumber = flight.getBookedSeats() + 1;
        return "Seat-" + nextSeatNumber; // Ejemplo: Seat-1, Seat-2, ...
    }

    private double calculateDynamicPrice(Flight flight) {
        int totalSeats = flight.getCapacitySeats();
        int bookedSeats = flight.getBookedSeats();

        // Factor dinámico: incrementa el precio dependiendo del porcentaje de asientos ocupados
        double basePrice = 100.00; // Precio inicial
        double dynamicFactor = 1.0 + (double) bookedSeats / totalSeats; // Incremento proporcional al porcentaje de ocupación
        return Math.round(basePrice * dynamicFactor * 100.0) / 100.0; // Redondear a 2 decimales
    }


    public void deleteBoardingPass(Long id) {
        if (!boardingPassRepository.existsById(id)) {
            throw new RuntimeException("Pasaje no encontrado");
        }
        boardingPassRepository.deleteById(id);
    }

}
