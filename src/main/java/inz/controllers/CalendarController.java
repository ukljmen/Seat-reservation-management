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
import inz.models.Reservation;
import inz.data.EventRepository;
import inz.data.ReservationRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/calendar")
@SessionAttributes({ "reservation" })
public class CalendarController {

	private EventRepository eventRepo;

	@Autowired
	public CalendarController(EventRepository eventRepo) {
		this.eventRepo = eventRepo;

	}

	@ModelAttribute(name = "event")
	public Event chosen() {
		return new Event();
	}

	@ModelAttribute(name = "reservation")
	public Reservation reservation() {
		return new Reservation();
	}

	@GetMapping
	public String eventDisplay(Model model) {

		model.addAttribute("events", eventRepo.findAll());

		return "calendar";
	}

	@PostMapping
	public String chooseEvent(@Valid Event event, Errors errors, @ModelAttribute Reservation reservation) {
		if (errors.hasErrors()) {
			return "calendar";
		}

		reservation.setEvent(event);

		return "redirect:/seats";
	}
}
