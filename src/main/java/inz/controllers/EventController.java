package inz.controllers;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import inz.models.Event;
import inz.data.EventRepository;
import lombok.extern.slf4j.Slf4j;




@Slf4j
@Controller
@RequestMapping("/calendarAdmin")
@SessionAttributes("event")
public class EventController {
	
	private EventRepository eventRepo;
	
	  @Autowired
	  public EventController(EventRepository eventRepo) {
		this.eventRepo = eventRepo;
	  }
	  
	  @ModelAttribute(name = "event")
	  public Event event() {
		return new Event();
	  }

	  @GetMapping
	  public String displayEvents(Model model) {
		model.addAttribute("events", eventRepo.findAll() );
		  
	    return "calendarAdmin";
	  }
	  
	  @PostMapping
	  public String addEvent(@Valid Event event, Errors errors, SessionStatus sessionStatus) {
	    if (errors.hasErrors()) {
	    	return "calendarAdmin";
	    }
	    
	    eventRepo.save(event);
	    sessionStatus.setComplete();
	    
	    return "calendarAdmin";
	  }
}
