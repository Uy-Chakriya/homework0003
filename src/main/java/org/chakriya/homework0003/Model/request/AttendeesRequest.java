package org.chakriya.homework0003.Model.request;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttendeesRequest {
    private Integer attendeeId;
    private String attendeeName;
    private String email;
}

