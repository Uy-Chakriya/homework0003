package org.chakriya.homework0003.Impl.Impl;

import lombok.RequiredArgsConstructor;
import org.chakriya.homework0003.Impl.VenuesService;
import org.chakriya.homework0003.Model.enity.Venues;
import org.chakriya.homework0003.Model.request.VenuesRequest;
import org.chakriya.homework0003.Repository.VenuesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VenuesServiceImpl implements VenuesService {
    public final VenuesRepository venuesRepository;

    @Override
    public List<Venues> getAllVenues() {
        return venuesRepository.getAllVenues();
    }

    @Override
    public Venues getVenuesById(Integer venueId) {
        return venuesRepository.getVenuesById(venueId);
    }

    @Override
    public Venues saveVenues(Venues venues) {
        return venuesRepository.saveVenues(venues);
    }

    @Override
    public void updateVenues(Integer venueId, VenuesRequest request) {
        venuesRepository.updateVenues(venueId, request);
    }

    @Override
    public void deleteVenue(Integer venueId) {
        venuesRepository.deleteVenue(venueId);
    }
}
