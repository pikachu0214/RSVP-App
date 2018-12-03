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
public class CategoryRepositoryTest2 {
	
	@Autowired
    private EventRepository repository;
	
	@Autowired
    private CategoryRepository drepository;
	
    @Test
    public void findByNameShouldReturnName() {
    	Category cat = new Category("Wedding");
        drepository.save(cat);
        
        assertThat(cat.getName()).isEqualTo("Wedding");
        assertThat(cat.getCategoryid()).isNotNull();
    }
    @Test
    public void deleteEvent() {
    	Category cats = new Category("Meetings");
    	assertThat(repository.findByName("Meeting")).isNotNull();
    }
}
