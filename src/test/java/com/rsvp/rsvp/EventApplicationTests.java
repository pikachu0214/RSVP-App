package com.rsvp.rsvp;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rsvp.rsvp.RsvpController.web.EventController;;

/**
 * Testing that the context is creating your controller
 * 
 * 
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EventApplicationTests {
	
	@Autowired
    private EventController controller;
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}
}