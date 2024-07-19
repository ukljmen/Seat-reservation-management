package inz.models;

import javax.validation.constraints.Size;

import org.springframework.security.crypto.password.PasswordEncoder;
import lombok.Data;
import inz.models.User;

@Data
public class RegistrationUser {

	@Size(min = 5, message = "Musi zawierać przynajmniej 5 znaków")
	private String username;
	@Size(min = 8, message = "Musi składać się przynajmniej z 8 znaków")
	private String password;
  
  public User toUser(PasswordEncoder passwordEncoder) {
    return new User(
        username, passwordEncoder.encode(password));
  }
  
}