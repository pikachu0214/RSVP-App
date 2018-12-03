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
public class RSVPUserRepositoryTest {
	@Autowired
    private UserRepository urepository;
	
	@Autowired
    private EventRepository repository;
	
	@Autowired
    private CategoryRepository drepository;
	
    @Test
    public void findByUserNameShouldReturnName() {
User user = urepository.findByUsername("user");
        
        assertThat(user).isNotNull();
        assertThat(user.getRole()).isEqualTo("USER");        
    }
    @Test
    public void saveUser() {
    	User users = new User("Michael","user","USER");
    	urepository.save(users);
    	assertThat(urepository.findByUsername("Michael")).isNotNull();
    }
}
