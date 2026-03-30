

import org.apache.ibatis.annotations.*;
import org.chakriya.homework0003.Model.enity.Attendees;
import org.chakriya.homework0003.Model.enity.Events;
import org.chakriya.homework0003.Model.request.EventRequest;

import java.util.List;

@Mapper
public interface EventsRepository {
    @Results(id = "eventsMapper", value = {
            @Result(property = "eventId", column = "event_id"),
            @Result(property = "eventName", column = "event_name"),
            @Result(property = "eventDate", column = "event_date"),
            @Result(property = "venueId", column = "venue_id"),

    })

    @ResultMap("eventsMapper")
    @Select("""
        select * from events;
    """)
    List<Attendees> getAllEvents();


    @ResultMap("eventsMapper")
    @Select("""
        select * from events where eventsId = #{events_id};
    """)
    Events getAttendeesById(Integer eventsId);

    @ResultMap("eventsMapper")
    @Select("""
        insert into events (event_name,event_date ) 
        values #{req.event_name}
                #{req.event_date}
    """)
    Events saveEvents( @Param("req") EventRequest request);

    List<Events> eventsRepository();
}

//@ResultMap("venuesMapper")
//@Select("""
//        update attendees set attendees_name = #{attendeesName},
//                             email = #{req.email}
//
//    """)
//void updateAttendees(@Param("attendeesId") Integer attendeesId,
//                     @Param("req") AttendeesRequest request);
//
//@ResultMap("venuesMapper")
//@Select("""
//        delete from attendees where attendees_id = #{attendeesId}
//    """)



