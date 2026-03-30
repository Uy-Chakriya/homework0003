CREATE TABLE IF NOT EXISTS venues(
                                     venue_id serial primary key,
                                     venue_name varchar(100) not null,
                                     location varchar(100) not null
);

CREATE TABLE IF NOT EXISTS attendees(
                                        attendee_id serial primary key ,
                                        attendee_name varchar(100) not null ,
                                        email VARCHAR(150) UNIQUE NOT NULL
);


CREATE TABLE IF NOT EXISTS events(
                                     event_id serial primary key ,
                                     event_name varchar(100) not null ,
                                     event_date date not null ,
                                     venue_id serial,
    constraint fk_event_venue foreign key (venue_id) references venues(venue_id) on delete cascade
);

CREATE TABLE IF NOT EXISTS event_attendee(
    event_id serial,
    attendee_id serial,
    primary key (event_id, attendee_id),
    constraint fk_eventt_event foreign key (event_id) references events(event_id) on delete cascade ,
    constraint fk_eventt_attendee foreign key (attendee_id) references attendees(attendee_id) on delete cascade
);


