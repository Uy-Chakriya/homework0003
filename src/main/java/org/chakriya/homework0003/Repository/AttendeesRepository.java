package org.chakriya.homework0003.Repository;

import org.apache.ibatis.annotations.*;
import org.chakriya.homework0003.Model.enity.Attendees;
import org.chakriya.homework0003.Model.request.AttendeesRequest;


import java.util.List;

@Mapper
public interface AttendeesRepository {
    @Results(id = "attendeesMapper", value = {
            @Result(property = "attendeeId", column = "attendee_id"),
            @Result(property = "attendeeName", column = "attendee_name")
    })

    @ResultMap("venuesMapper")
    @Select("""
       select * from attendees;
       """)
    List<Attendees> getAllAttendees();

    @ResultMap("venuesMapper")
    @Select("""
        select * from attendees where attendees_id = #{attendeesId};
    """)
    Attendees getAttendeesById(Integer attendeesId);


    @ResultMap("venuesMapper")
    @Select("""
        insert into Attendees (venue_name,location)
        values #{reg.venueName}, #{reg.location}
    """)
    Attendees saveAttendees(@Param("req") AttendeesRequest request);

    @ResultMap("venuesMapper")
    @Select("""
        update attendees set attendees_name = #{attendeesName},
                             email = #{req.email}
                             
    """)
    void updateAttendees(@Param("attendeesId") Integer attendeesId,
                         @Param("req") AttendeesRequest request);

    @ResultMap("venuesMapper")
    @Select("""
        delete from attendees where attendees_id = #{attendeesId}
    """)
    void deleteAttendees(Integer attendeesId);
}


