package com.rsvp.rsvp;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rsvp.rsvp.domain.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@DataJpaTest
public class EventRepositoryTest {
	
	@Autowired
    private EventRepository repository;
	
	@Autowired
    private CategoryRepository drepository;
	
    @Test
    public void saveEvent() {
    	Category category = new Category("Happy New Year");
        Event event = new Event("New Year", "Mikey's", "31-12-2018", "18:00", "1 Helsinki Ave", "Helsinki", drepository.save(category));
        repository.save(event);
        
        assertThat(event.getId()).isNotNull();
    }
    @Test
    public void deleteEvent() {
    	List<Event> events = repository.findByCity("Boston");
    	Long Id = events.get(0).getId();
    	
    	repository.deleteById(Id);
    	assertThat(repository.findByCity("Boston")).isNotNull();
    }
}
