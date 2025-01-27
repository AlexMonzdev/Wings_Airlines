package com.airlines.app_wings.boardingPass;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BoardingPassController {

    private final BoardingPassService boardingPassService;

    public BoardingPassController(BoardingPassService boardingPassService) {
        this.boardingPassService = boardingPassService;
    }

    @GetMapping("/pass")
    public ResponseEntity<List<BoardingPass>> getAllBoardingPasses() {
        return ResponseEntity.ok(boardingPassService.getAllBoardingPasses());
    }




}
