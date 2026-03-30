package org.chakriya.homework0003.Impl;


import org.chakriya.homework0003.Model.enity.Venues;
import org.chakriya.homework0003.Model.request.VenuesRequest;

import java.util.List;

public interface VenuesService {
    List<Venues> getAllVenues();

    Venues getVenuesById(Integer venueId);

    Venues saveVenues(Venues venues);

   void  updateVenues(Integer venueId, VenuesRequest request);

    void deleteVenue(Integer venueId);
}
