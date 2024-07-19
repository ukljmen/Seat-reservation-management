package inz.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
import inz.models.Seat;
import inz.data.EventRepository;
import inz.data.ReservationRepository;
import inz.data.SeatRepository;
import inz.data.UserRepository;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/reservationBrowse")
public class ReservationController {

	private ReservationRepository reservationRepo;

	@Autowired
	public ReservationController(ReservationRepository reservationRepo) {
		this.reservationRepo = reservationRepo;
	}

	@GetMapping
	public String displayReservations(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("reservations", reservationRepo.findAllByUser_id(auth.getName()));

		return "reservationBrowse";
	}
}