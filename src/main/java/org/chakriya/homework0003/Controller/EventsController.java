package org.chakriya.homework0003.Controller;
import com.sun.jdi.request.EventRequest;
import lombok.RequiredArgsConstructor;
import org.chakriya.homework0003.Impl.EventsService;
import org.chakriya.homework0003.Model.enity.Attendees;
import org.chakriya.homework0003.Model.enity.Events;
import org.chakriya.homework0003.Model.request.AttendeesRequest;
import org.chakriya.homework0003.Model.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("api/v1/events")
@RequiredArgsConstructor
public class EventsController {
    public final EventsService eventsService;
    @GetMapping
    public ResponseEntity<ApiResponse<Events>> getAllEvents(){
        List<Events> payload = eventsService.getAllEvents();
        return ResponseEntity.ok(ApiResponse.<Events>builder()
                .status("100 OK")
                .message("Get All Events successfully")
                .time(Instant.now())
                .build()
        );
    }

    @GetMapping("/{eventsId}")
    public ResponseEntity<ApiResponse<Events>> getEventsById(@PathVariable Integer eventsId )
    {
        Events payload = eventsService.getEventsById(eventsId);
        return ResponseEntity.ok(ApiResponse.<Events>builder()
                .message("Get events by id  Successfully!")
                .payload(payload)
                .status("100 OK")
                .time(Instant.now())
                .build()
        );
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Events>> saveEvents(@RequestBody EventRequest request)
    {
        Events payload = eventsService.saveEvents(request);
        return ResponseEntity.ok(ApiResponse.<Events>builder()
                .message("Post Attendees Successfully!")
                .payload(payload)
                .status("100 OK")
                .time(Instant.now())
                .build()
        );
    }

    @PutMapping("/{eventsId}")
    public ResponseEntity<ApiResponse<Attendees>> updateEvents(@PathVariable Integer eventsId,
                                                               @RequestBody AttendeesRequest request)
    {
        eventsService.updateEvents(eventsId, request);
        Events payload = eventsService.getEventsById(eventsId);
        return ResponseEntity.ok(ApiResponse.<Attendees>builder()
                .message("Update Attendees Successfully!")
                .status("100 OK")
                .time(Instant.now())
                .build()
        );
    }
//
//    @DeleteMapping("/{attendeesId}")
//    public ResponseEntity<ApiResponse<Void>> deleteAttendees(@PathVariable Integer attendeesId)
//    {
//        eventsService.deleteAttendees(attendeesId);
//        return ResponseEntity.ok(ApiResponse.<Void>builder()
//                .message("Delete Attendees Successfully ")
//                .status("100 OK")
//                .time(Instant.now())
//                .build()
//        );
//    }


}
