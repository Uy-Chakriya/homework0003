package org.chakriya.homework0003.Impl.Impl;
import lombok.RequiredArgsConstructor;
import org.chakriya.homework0003.Impl.AttendeesService;
import org.chakriya.homework0003.Model.enity.Attendees;
import org.chakriya.homework0003.Model.request.AttendeesRequest;
import org.chakriya.homework0003.Repository.AttendeesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendeesServiceImpl implements AttendeesService {
    public final AttendeesRepository attendeesRepository;

    @Override
    public List<Attendees> getAllAttendees() {
        return attendeesRepository.getAllAttendees();
    }

    @Override
    public Attendees getAttendeesById(Integer attendeesId) {
        return attendeesRepository.getAttendeesById(attendeesId);
    }

    @Override
    public void updateAttendees(Integer attendeesId, AttendeesRequest request) {
        attendeesRepository.updateAttendees(attendeesId,request);
    }

    @Override
    public Attendees saveAttendees(AttendeesRequest request) {
        return attendeesRepository.saveAttendees(request);
    }

    @Override
    public void deleteAttendees(Integer attendeesId) {
        attendeesRepository.deleteAttendees(attendeesId);
    }
}
