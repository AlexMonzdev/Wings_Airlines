package com.airlines.app_wings.boardingPass;

import com.airlines.app_wings.flight.FlightRepository;
import com.airlines.app_wings.profiles.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardingPassService {

    private final BoardingPassRepository boardingPassRepository;
    private final ProfileRepository profileRepository;
    private final FlightRepository flightRepository;


    public BoardingPassService(BoardingPassRepository boardingPassRepository, ProfileRepository profileRepository, FlightRepository flightRepository) {
        this.boardingPassRepository = boardingPassRepository;
        this.profileRepository = profileRepository;
        this.flightRepository = flightRepository;
    }

    public List<BoardingPass> getAllBoardingPasses() {
        return boardingPassRepository.findAll();
    }


}
