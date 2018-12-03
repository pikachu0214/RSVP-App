package com.rsvp.rsvp;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.rsvp.rsvp.domain.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EventRepositoryTest {
	
	@Autowired
    private EventRepository repository;
	@Autowired
    private CategoryRepository drepository;
	
    @Test
    public void findByIdShouldReturnEvent() {
        List<Event> events = repository.findByName("House Warming");
        
        assertThat(events).hasSize(1);
        assertThat(events.get(0).getHost()).isEqualTo("Mary Poppin");
    }
    
   
}
