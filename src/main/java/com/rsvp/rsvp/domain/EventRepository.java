package com.rsvp.rsvp.domain;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Long> {

    List<Event> findByName(String name);
    List<Event> findById(long i);

}