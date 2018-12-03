package com.rsvp.rsvp.RsvpController.web;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rsvp.rsvp.domain.CategoryRepository;
import com.rsvp.rsvp.domain.Event;
import com.rsvp.rsvp.domain.EventRepository;

@Controller
public class EventController {
	@Autowired
	private EventRepository repository; 
	@Autowired
	private CategoryRepository drepository; 
	
			
		//login Page
		@RequestMapping(value="/login")
			public String login() {	
				return "login";
		}	
			
		// Home Page
		@RequestMapping(value="/eventlist")
    		public String bookList(Model model) {	
				model.addAttribute("events", repository.findAll());
					return "eventlist";
    	}
		// Add an event
		@RequestMapping(value = "/add")
	    	public String addEvent(Model model){
	    		model.addAttribute("event", new Event());
				model.addAttribute("category", drepository.findAll());
	    			return "addevent";
		}  	
        
		// Save an event
	    @RequestMapping(value = "/save", method = RequestMethod.POST)
	    	public String save(Event event){
	        	repository.save(event);
	        		return "redirect:eventlist";	
	    }
	    // delete an event
	    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	    @PreAuthorize("hasRole('ADMIN')")
	    	public String deleteEvent(@PathVariable("id") Long eventId, Model model) {
	    		repository.deleteById(eventId);
	    			return "redirect:../eventlist";
	    }
		// edit an event
	    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    		public String editBook(@PathVariable("id") Long eventId,  Model model) {
	    		model.addAttribute("event", repository.findById(eventId));
	    		model.addAttribute("category", drepository.findAll());
    				return "editevent";
	    }
	    // Restful api for all events
		@RequestMapping(value = "/events", method = RequestMethod.GET)
			public @ResponseBody List<Event> eventListRest() {
				return (List<Event>) repository.findAll();
		}

		//Restful API to get an event
	    @RequestMapping(value = "/events/{id}", method = RequestMethod.GET)
    		public @ResponseBody Optional<Event> findBookRest(@PathVariable("id") Long eventId) {
	    		return repository.findById(eventId);
    }    
}