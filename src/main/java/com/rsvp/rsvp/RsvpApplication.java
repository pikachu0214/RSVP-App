package com.rsvp.rsvp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.rsvp.rsvp.domain.Category;
import com.rsvp.rsvp.domain.CategoryRepository;
import com.rsvp.rsvp.domain.Event;
import com.rsvp.rsvp.domain.EventRepository;
import com.rsvp.rsvp.domain.User;
import com.rsvp.rsvp.domain.UserRepository;

@SpringBootApplication
public class RsvpApplication {
	@Autowired
	private static final Logger log = LoggerFactory.getLogger(RsvpApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RsvpApplication.class, args);
	}
		@Bean
		public CommandLineRunner eventDemo(EventRepository repository, CategoryRepository drepository, UserRepository urepository) {
			return (args) -> {
				log.info("save some events");
				//Event Category
				drepository.save(new Category("Party"));
				drepository.save(new Category("Wedding"));
				drepository.save(new Category("Birthday"));
				
				//Event demo
				repository.save(new Event("James Birthday Party", "John Smith", "02-02-2019", "12:00", "110 Washington Street", "New York", drepository.findByName("Birthday").get(0)));
				repository.save(new Event("House Warming", "Mary Poppin", "15-03-2019", "15:00", "22 Adam Avenue", "Chicago", drepository.findByName("Party").get(0)));
				repository.save(new Event("Mary's Engagement", "Mary Smith", "15-06-2019", "12:00", "12 Offspring Street", "Boston", drepository.findByName("Wedding").get(0)));
				
				// username/password: user/user/ Anne/anne James/james Mary/admin
				User user = new User("user", "$2a$04$mq0WjNPKmRRg73uE1ZXP7ubYPhkrKeBpykjCGR0vPBsRpl92nWsaK",   "USER");
				User anne = new User("Anne", "$2a$04$r1ht4Kj4It1EhlNWhzxhoum4r2V1BFoN116NRzJR1C03aHsKgRn.S", "ANNE");
				User james = new User("James", "$2a$05$YIXPwRhnXfjB0WdfcmQUNeC1mH3.P6WcRsBC0.uIPyONEf1x3zi0C", "ADMIN");
				User mary = new User("Mary", "$2a$04$RrExU59MHEnVbjw90dvk8.ePwDFAN5pcyd8X6rYQtgvYUF6kfEtni", "ADMIN");
				urepository.save(anne);
				urepository.save(james);
				urepository.save(mary);
				urepository.save(user);
				
				log.info("fetch all events");
				for (Event event : repository.findAll()) {
					log.info(event.toString());
				}

			};
		}
	}

