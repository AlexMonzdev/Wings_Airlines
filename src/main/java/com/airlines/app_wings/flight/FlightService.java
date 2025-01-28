package com.airlines.app_wings.flight;

import com.airlines.app_wings.Itinerary.Itinerary;
import com.airlines.app_wings.Itinerary.ItineraryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    private final FlightRepository flightRepository;
    private final ItineraryRepository itineraryRepository;

    public FlightService(FlightRepository flightRepository, ItineraryRepository itineraryRepository) {
        this.flightRepository = flightRepository;
        this.itineraryRepository = itineraryRepository;
    }

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Optional<Flight> getFlightById(Long id) {
        return flightRepository.findById(id);
    }

    public Flight createFlight(Flight flight, Long itineraryId) {
        Itinerary itinerary = itineraryRepository.findById(itineraryId)
                .orElseThrow(() -> new RuntimeException("Itinerary not found with id: " + itineraryId));
        flight.setItinerary(itinerary);
        return flightRepository.save(flight);
    }

    public Flight updateFlight(Long id, Flight flightDetails) {
        Flight flight = flightRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Flight not found"));
        flight.setCapacitySeats(flightDetails.getCapacitySeats());
        flight.setBookedSeats(flightDetails.getBookedSeats());
        flight.setAirplaneModel(flightDetails.getAirplaneModel());
        flight.setFlightNumber(flightDetails.getFlightNumber());
        return flightRepository.save(flight);
    }

    public void deleteFlight(Long id) {
        flightRepository.deleteById(id);
    }

    public void bookSeat(Long id) {
        Flight flight = flightRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Flight not found"));
        flight.bookSeat();
        flightRepository.save(flight);
    }

}
