package com.airlines.app_wings.boardingPass;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/boarding-passes")
public class BoardingPassController {

    private final BoardingPassService boardingPassService;

    public BoardingPassController(BoardingPassService boardingPassService) {
        this.boardingPassService = boardingPassService;
    }

    @PostMapping
    public BoardingPass createBoardingPass(@RequestParam Long profileId, @RequestParam Long flightId) {

        return boardingPassService.createBoardingPass(profileId, flightId);
    }

    @GetMapping("/{id}")
    public Optional<BoardingPass> getBoardingPassById(@PathVariable Long id) {
        return boardingPassService.getBoardingPassById(id);
    }

    @GetMapping("/profile/{profileId}")
    public List<BoardingPass> getBoardingPassesByProfile(@PathVariable Long profileId) {
        return boardingPassService.getBoardingPassesByProfile(profileId);
    }

    @DeleteMapping("/{id}")
    public void deleteBoardingPass(@PathVariable Long id) {
        boardingPassService.deleteBoardingPass(id);
    }

}
