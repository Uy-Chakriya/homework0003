package org.chakriya.homework0003.Model.enity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Venues {
    private Long venueId;
    private String venueName;
    private String location;
}
