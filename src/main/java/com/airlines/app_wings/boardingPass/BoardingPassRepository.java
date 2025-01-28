package com.airlines.app_wings.boardingPass;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardingPassRepository  extends JpaRepository<BoardingPass, Long> {
    List<BoardingPass> findByProfileId(Long profileId);
}
