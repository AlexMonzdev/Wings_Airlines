package com.airlines.app_wings.Itinerary;

import com.airlines.app_wings.destiny.Destiny;
import com.airlines.app_wings.destiny.DestinyRepository;
import com.airlines.app_wings.origin.Origin;
import com.airlines.app_wings.origin.OriginRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ItineraryService {

    private final ItineraryRepository itineraryRepository;
    private final OriginRepository originRepository;
    private final DestinyRepository destinyRepository;

    public ItineraryService(ItineraryRepository itineraryRepository, OriginRepository originRepository, DestinyRepository destinyRepository) {
        this.itineraryRepository = itineraryRepository;
        this.originRepository = originRepository;
        this.destinyRepository = destinyRepository;
    }

    public List<Itinerary> getAllItineraries() {
        return itineraryRepository.findAll();
    }

    public Itinerary getItineraryById(Long id) {
        return itineraryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Itinerary not found with id: " + id));
    }

    public Itinerary createItinerary(Itinerary itinerary) {
        Optional<Origin> origin = originRepository.findById(itinerary.getOrigin().getId());
        Optional<Destiny> destiny = destinyRepository.findById(itinerary.getDestiny().getId());

        if (origin.isEmpty() || destiny.isEmpty()) {
            throw new RuntimeException("Origin or Destiny not found");
        }

        itinerary.setOrigin(origin.get());
        itinerary.setDestiny(destiny.get());

        return itineraryRepository.save(itinerary);
    }

    public Itinerary updateItinerary(Long id, Itinerary itineraryDetails) {
        Itinerary itinerary = itineraryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Itinerary not found"));

        itinerary.setLocalArrivalTime(itineraryDetails.getLocalArrivalTime());
        itinerary.setLocalArrivalDate(itineraryDetails.getLocalArrivalDate());
        itinerary.setOrigin(itineraryDetails.getOrigin());
        itinerary.setDestiny(itineraryDetails.getDestiny());

        return itineraryRepository.save(itinerary);
    }

    public void deleteItinerary(Long id) {
        if (!itineraryRepository.existsById(id)) {
            throw new RuntimeException("Itineray not found with id: " + id);
        }
        itineraryRepository.deleteById(id);
    }

}
