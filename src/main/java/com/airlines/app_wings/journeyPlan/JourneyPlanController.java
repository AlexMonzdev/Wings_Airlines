package com.airlines.app_wings.journeyPlan;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/journeys")
public class JourneyPlanController {

    private final JourneyPlanService journeyPlanService;

    public JourneyPlanController(JourneyPlanService journeyPlanService) {
        this.journeyPlanService = journeyPlanService;
    }

    @GetMapping
    public ResponseEntity<List<JourneyPlan>> getAllJourneyPlans() {
        return ResponseEntity.ok(journeyPlanService.getAllJourneyPlans());
    }

    @GetMapping("/{id}")
    public ResponseEntity<JourneyPlan> getJourneyPlanById(@PathVariable Long id) {
        return ResponseEntity.ok(journeyPlanService.getJourneyPlanById(id));
    }

    @PostMapping
    public ResponseEntity<JourneyPlan> createJourneyPlan(@RequestBody JourneyPlan journeyPlan) {
        return ResponseEntity.ok(journeyPlanService.createJourneyPlan(journeyPlan));
    }

    @PutMapping("/{id}")
    public ResponseEntity<JourneyPlan> updateJourneyPlan(@PathVariable Long id, @RequestBody JourneyPlan journeyPlan) {
        return ResponseEntity.ok(journeyPlanService.updateJourneyPlan(id, journeyPlan));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJourneyPlan(@PathVariable Long id) {
        journeyPlanService.deleteJourneyPlan(id);
        return ResponseEntity.noContent().build();
    }


}
