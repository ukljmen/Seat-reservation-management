//package inz.controllers;
//
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.Errors;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.SessionAttributes;
//import org.springframework.web.bind.support.SessionStatus;
//
//
//import inz.data.UserRepository;
//import inz.models.User;
//import lombok.extern.slf4j.Slf4j;
//
//
//
//
//@Slf4j
//@Controller
//@RequestMapping("/login")
//@SessionAttributes({ "userUser"})
//public class UserController {
//	
//	private UserRepository userRepo;
//	
//	
//	  @Autowired
//	  public UserController(UserRepository userRepo) {
//	    this.userRepo = userRepo;
//	  }
//	  
//	  @ModelAttribute(name = "user")
//	  public User user() {
//	    return new User();
//	  }
//	  
//	
//
//	  
////	  @GetMapping
////	  public String logging(Model model) {
////		  
////	    return "login";
////	  }
//
//	  @PostMapping
//	  public String logging(@Valid User user , Errors errors ) {
//	    if (errors.hasErrors()) {
//	      return "login";
//	    }
//	  
//	    try {
//	    	Optional<User> requestedUser = userRepo.findById(user.getUser_username());
//	    }catch ( Exception e ) {
//	    	log.info("błąd");
//	    }
//	    
//	    
//	    
//	    
//	    log.info("zalogowano jako :" + user);
//	   // log.info("rezerwacja zrobiona : " + reservation);
//	    return "redirect:/";
//	   // return "seats";
//	  }
//
//}
