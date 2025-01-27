package com.airlines.app_wings.origin;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/origins")
public class OriginController {

    private final OriginService originService;

    public OriginController(OriginService originService) {
        this.originService = originService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Origin>> getAllOrigins() {
        return ResponseEntity.ok(originService.getAllOrigins());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Origin> getOriginyById(@PathVariable Long id) {
        Optional<Origin> origin = originService.getOriginById(id);
        return origin.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public ResponseEntity<Origin> createOrigin(@RequestBody Origin origin) {
        Origin createOrigin = originService.createOrigin(origin);
        return ResponseEntity.ok(createOrigin);
    }


}
