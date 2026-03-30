package org.chakriya.homework0003.Model.enity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventAttendee {
    private Integer attendeeId;
    private String attendeeName;
    private String email;
}
