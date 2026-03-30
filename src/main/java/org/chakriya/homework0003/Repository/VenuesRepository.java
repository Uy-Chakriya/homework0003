package org.chakriya.homework0003.Repository;
import org.apache.ibatis.annotations.*;
import org.chakriya.homework0003.Model.enity.Venues;
import org.chakriya.homework0003.Model.request.VenuesRequest;

import java.util.List;

@Mapper
public interface VenuesRepository {
    @Results(id = "venuesMapper", value = {
        @Result(property = "venueId", column = "venue_id"),
        @Result(property = "venueName", column = "venue_name"),
    })

    @ResultMap("venuesMapper")
    @Select("""
        select * from venues;
""")
    List<Venues> getAllVenues();

    @ResultMap("venuesMapper")
    @Select("""
        select * from venues where venue_id = #{venueId};  
""")
    Venues getVenuesById(Integer id);

    @ResultMap("venuesMapper")
    @Select("""
        insert into venues (venue_name,location) 
        values (#{reg.venueName}, #{req.location})
       """)
    Venues saveVenues(@Param("req") Venues venues);


    @ResultMap("venuesMapper")
    @Select("""
        update venues set venue_name = #{req.venueName},
                          location = #{req.location}
    """)
    void updateVenues(@Param("venueId" ) Integer venueId,
                      @Param("req") VenuesRequest request);


    @ResultMap("venuesMapper")
    @Select("""
        delete from venues where venue_id = #{venueId}
    """)
    void deleteVenue(Integer venueId);
}


//@Delete("DELETE FROM instructors WHERE instructor_id = #{id}")
//void deleteInstructor(Integer id);
