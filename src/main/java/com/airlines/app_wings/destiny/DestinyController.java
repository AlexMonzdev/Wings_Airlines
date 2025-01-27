package com.airlines.app_wings.destiny;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/destinies")
public class DestinyController {

    private final DestinyService destinyService;

    public DestinyController(DestinyService destinyService) {
        this.destinyService = destinyService;
    }

    @GetMapping
    public ResponseEntity<List<Destiny>> getAllDestinies() {
        return ResponseEntity.ok(destinyService.getAllDestinies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Destiny> getDestinyById(@PathVariable Long id) {
        Optional<Destiny> destiny = destinyService.getDestinyById(id);
        return destiny.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Destiny> createDestiny(@RequestBody Destiny destiny) {
        Destiny createdDestiny = destinyService.createDestiny(destiny);
        return ResponseEntity.ok(createdDestiny);
    }




}
