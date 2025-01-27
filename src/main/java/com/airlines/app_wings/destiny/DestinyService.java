package com.airlines.app_wings.destiny;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DestinyService {

    private final DestinyRepository destinyRepository;

    public DestinyService(DestinyRepository destinyRepository) {
        this.destinyRepository = destinyRepository;
    }

    public List<Destiny> getAllDestinies() {
        return destinyRepository.findAll();
    }

    public Optional<Destiny> getDestinyById(Long id) {
        return destinyRepository.findById(id);
    }

    public Destiny createDestiny(Destiny destiny) {
        return destinyRepository.save(destiny);
    }

}
