package org.chakriya.homework0003.Controller;

import lombok.RequiredArgsConstructor;
import org.chakriya.homework0003.Impl.AttendeesService;
import org.chakriya.homework0003.Model.enity.Attendees;
import org.chakriya.homework0003.Model.request.AttendeesRequest;
import org.chakriya.homework0003.Model.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("api/v1/attendees")
@RequiredArgsConstructor
public class AttendeesController {
    public final AttendeesService attendeesService;

    @GetMapping
    public ResponseEntity<ApiResponse<Attendees>> getAllAttendees(){
        List<Attendees> payload = attendeesService.getAllAttendees();
        return ResponseEntity.ok(ApiResponse.<Attendees>builder()
                .message("Get all Attendees Successfully!")
                .payload((Attendees) payload)
                .status("100 OK")
                .time(Instant.now())
                .build()
        );
    }

    @GetMapping("/{attendeesId}")
    public ResponseEntity<ApiResponse<Attendees>> getAttendeesById(@PathVariable Integer attendeesId )
    {
        Attendees payload = attendeesService.getAttendeesById(attendeesId);
        return ResponseEntity.ok(ApiResponse.<Attendees>builder()
                .message("Get attendee Successfully!")
                .payload(payload)
                .status("100 OK")
                .time(Instant.now())
                .build()
        );
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Attendees>> saveAttendees(@RequestBody AttendeesRequest request)
    {
        Attendees payload = attendeesService.saveAttendees(request);
        return ResponseEntity.ok(ApiResponse.<Attendees>builder()
                .message("Post Attendees Successfully!")
                .payload(payload)
                .status("100 OK")
                .time(Instant.now())
                .build()
        );
    }

    @PutMapping("/{attendeesId}")
    public  ResponseEntity<ApiResponse<Attendees>> updateAttendees(@PathVariable Integer attendeesId,
            @RequestBody AttendeesRequest request)
    {
        attendeesService.updateAttendees(attendeesId, request);
        Attendees payload = attendeesService.getAttendeesById(attendeesId);
        return ResponseEntity.ok(ApiResponse.<Attendees>builder()
                .message("Update Attendees Successfully!")
                .payload(payload)
                .status("100 OK")
                .time(Instant.now())
                .build()
        );
    }

    @DeleteMapping("/{attendeesId}")
    public ResponseEntity<ApiResponse<Void>> deleteAttendees(@PathVariable Integer attendeesId)
    {
        attendeesService.deleteAttendees(attendeesId);
        return ResponseEntity.ok(ApiResponse.<Void>builder()
                .message("Delete Attendees Successfully ")
                .status("100 OK")
                .time(Instant.now())
                .build()
        );
    }

}
