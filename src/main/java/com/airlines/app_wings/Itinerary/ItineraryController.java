package com.airlines.app_wings.Itinerary;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/itineraries")
public class ItineraryController {

    private final ItineraryService itineraryService;

    public ItineraryController(ItineraryService itineraryService) {
        this.itineraryService = itineraryService;
    }

    @GetMapping
    public ResponseEntity<List<Itinerary>> getAllItinerarys() {
        return ResponseEntity.ok(itineraryService.getAllItineraries());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Itinerary> getItineraryById(@PathVariable Long id) {
        return ResponseEntity.ok(itineraryService.getItineraryById(id));
    }

    @PostMapping
    public ResponseEntity<Itinerary> createItinerary(@RequestBody Itinerary itinerary) {
        return ResponseEntity.ok(itineraryService.createItinerary(itinerary));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Itinerary> updateItinerary(@PathVariable Long id, @RequestBody Itinerary itinerary) {
        return ResponseEntity.ok(itineraryService.updateItinerary(id, itinerary));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItinerary(@PathVariable Long id) {
        itineraryService.deleteItinerary(id);
        return ResponseEntity.noContent().build();
    }


}
