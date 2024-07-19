package inz.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
import inz.models.User;
import inz.data.EventRepository;
import inz.data.ReservationRepository;
import inz.data.SeatRepository;
import inz.data.UserRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/seats")
@SessionAttributes({ "reservation" })
public class SeatController {

	private ReservationRepository reservationRepo;
	private SeatRepository seatRepo;
	private UserRepository userRepo;

	@Autowired
	public SeatController(ReservationRepository reservationRepo, SeatRepository seatRepo, UserRepository userRepo) {
		this.seatRepo = seatRepo;
		this.reservationRepo = reservationRepo;
		this.userRepo = userRepo;
	}

	@ModelAttribute(name = "seatchosen")
	public Seat seat() {
		return new Seat();
	}

//	  @ModelAttribute(name = "reservation")
//	  public Reservation reservation() {
//	    return new Reservation();
//	  }

	@GetMapping
	public String seat(Model model) {
		model.addAttribute("seatsSeats", seatRepo.findAll());
		return "seats";
	}

	@PostMapping
	public String chooseSeat(Seat seatchosen, @ModelAttribute Reservation reservation, Errors errors,
			SessionStatus sessionStatus) {
		if (errors.hasErrors()) {
			return "seats";
		}
		reservation.setSeat(seatRepo.findBySeat_RowAndSeat_Number(seatchosen.getSeat_Row(), seatchosen.getSeat_Number()));
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		reservation.setUser(userRepo.findByUsername(auth.getName()));

		reservationRepo.save(reservation);
		sessionStatus.setComplete();

		return "redirect:/home";
	}
}
