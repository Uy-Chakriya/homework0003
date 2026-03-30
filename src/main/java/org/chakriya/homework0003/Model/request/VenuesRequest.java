package org.chakriya.homework0003.Model.request;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VenuesRequest {
    private Long venueId;
    private String venueName;
    private String location;
}

