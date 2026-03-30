package org.chakriya.homework0003.Controller;

import lombok.RequiredArgsConstructor;
import org.chakriya.homework0003.Impl.VenuesService;
import org.chakriya.homework0003.Model.enity.Venues;
import org.chakriya.homework0003.Model.request.VenuesRequest;
import org.chakriya.homework0003.Model.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.json.JsonMapper;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("api/v1/venues")
@RequiredArgsConstructor
public class VenuesController {
    public final VenuesService venuesService;
    private final JsonMapper.Builder builder;

    @GetMapping
    public List<Venues> getAllVenues(){
        return venuesService.getAllVenues();
    }

    @GetMapping("/{venue-id}")
    public Venues getVenuesById(@PathVariable("venue-id") Integer venueId){
        return venuesService.getVenuesById(venueId);
    }

    @PostMapping
    public Venues saveVenues(@RequestBody Venues venues){
        return venuesService.saveVenues(venues);
    }

    @PutMapping("/{venueId}")
    public ResponseEntity<ApiResponse<Venues>> updateVenues(@PathVariable Integer venueId,
                                                            @RequestBody VenuesRequest request)
    {
        venuesService.updateVenues(venueId, request);
        Venues payload = venuesService.getVenuesById(venueId);
        return ResponseEntity.ok(ApiResponse.<Venues>builder()
                .message("Update venue successfully")
                .payload(payload)
                .status("100 OK")
                .time(Instant.now())
                .build()
        );
    }

    @DeleteMapping("/{venueId}")
    public ResponseEntity<ApiResponse<Void>> deleteVenue(@PathVariable Integer venueId){
        venuesService.deleteVenue(venueId);
        return ResponseEntity.ok(ApiResponse.<Void>builder()
                .message("Delete Venue successfully")
                .status("100 OK")
                .time(Instant.now())
                .build()
        );
    }
}
