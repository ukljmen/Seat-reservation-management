package inz.data;

import org.springframework.data.repository.CrudRepository;

import inz.models.User;

public interface UserRepository 
		extends CrudRepository<User, Long> {
	User findByUsername(String username);
}


