package org.chakriya.homework0003.Impl;

import org.chakriya.homework0003.Model.enity.Attendees;
import org.chakriya.homework0003.Model.request.AttendeesRequest;

import java.util.List;

public interface AttendeesService {
    List<Attendees> getAllAttendees();

    Attendees getAttendeesById(Integer attendeesId);

    void updateAttendees(Integer attendeesId, AttendeesRequest request);

    Attendees saveAttendees(AttendeesRequest request);

    void deleteAttendees(Integer attendeesId);
}
