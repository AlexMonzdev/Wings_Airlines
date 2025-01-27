package com.airlines.app_wings.origin;

import com.airlines.app_wings.destiny.Destiny;
import com.airlines.app_wings.destiny.DestinyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OriginService {

    private final OriginRepository originRepository;

    public OriginService(OriginRepository originRepository) {
        this.originRepository = originRepository;
    }

    public List<Origin> getAllOrigins() {
        return originRepository.findAll();
    }

    public Optional<Origin> getOriginById(Long id) {
        return originRepository.findById(id);
    }

    public Origin createOrigin(Origin origin) { return originRepository.save(origin);
    }

}
