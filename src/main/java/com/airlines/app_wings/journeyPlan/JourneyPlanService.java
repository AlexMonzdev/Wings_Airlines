package com.airlines.app_wings.journeyPlan;

import com.airlines.app_wings.destiny.Destiny;
import com.airlines.app_wings.destiny.DestinyRepository;
import com.airlines.app_wings.origin.Origin;
import com.airlines.app_wings.origin.OriginRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class JourneyPlanService {

    private final JourneyPlanRepository journeyPlanRepository;
    private final OriginRepository originRepository;
    private final DestinyRepository destinyRepository;

    public JourneyPlanService(JourneyPlanRepository journeyPlanRepository, OriginRepository originRepository, DestinyRepository destinyRepository) {
        this.journeyPlanRepository = journeyPlanRepository;
        this.originRepository = originRepository;
        this.destinyRepository = destinyRepository;
    }

    public List<JourneyPlan> getAllJourneyPlans() {
        return journeyPlanRepository.findAll();
    }

    public JourneyPlan getJourneyPlanById(Long id) {
        return journeyPlanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Journey plan not found with id: " + id));
    }

    public JourneyPlan createJourneyPlan(JourneyPlan journeyPlan) {
        Optional<Origin> origin = originRepository.findById(journeyPlan.getOrigin().getId());
        Optional<Destiny> destiny = destinyRepository.findById(journeyPlan.getDestiny().getId());

        if (origin.isEmpty() || destiny.isEmpty()) {
            throw new RuntimeException("Origin or Destiny not found");
        }

        journeyPlan.setOrigin(origin.get());
        journeyPlan.setDestiny(destiny.get());

        return journeyPlanRepository.save(journeyPlan);
    }

    public JourneyPlan updateJourneyPlan(Long id, JourneyPlan journeyPlanDetails) {
        JourneyPlan journeyPlan = journeyPlanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Journey plan not found"));

        journeyPlan.setLocalArrivalTime(journeyPlanDetails.getLocalArrivalTime());
        journeyPlan.setLocalArrivalDate(journeyPlanDetails.getLocalArrivalDate());
        journeyPlan.setOrigin(journeyPlanDetails.getOrigin());
        journeyPlan.setDestiny(journeyPlanDetails.getDestiny());

        return journeyPlanRepository.save(journeyPlan);
    }

    public void deleteJourneyPlan(Long id) {
        if (!journeyPlanRepository.existsById(id)) {
            throw new RuntimeException("Journey plan not found with id: " + id);
        }
        journeyPlanRepository.deleteById(id);
    }

}
