
insert into venues(venue_name, location) values
                                             ('chakya', 'Building A'),
                                             ('kim kim', 'Building B'),
                                             ('dara', 'Building A'),
                                            ('Theara', 'Building B');

insert into attendees(attendee_name, email) values
                                                ('chakya','chakya@gmail.com'),
                                                ('kim kim', 'kim@gmail.com'),
                                                ('dara','dara@gmail.com'),
                                                ('Theara', 'theara@gmail.com');

insert into events(event_name, event_date, venue_id) values
                                                         ('AI Hackathon', '2026-03-20','1'),
                                                         ('Women in tech', '2026-03-20','2'),
                                                         ('AI Hackathon', '2026-03-20','3'),
                                                         ('Women in tech', '2026-03-20','4');

insert into event_attendee(event_id,attendee_id) values
                                                     ('1', '2'),
                                                     ('1' , '3'),
                                                     ('2', '1'),
                                                     ('3','3');



