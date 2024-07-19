package inz.data;

import org.springframework.data.repository.CrudRepository;

import inz.models.Reservation;
import inz.models.User;

public interface ReservationRepository 
		extends CrudRepository<Reservation, Long> {
	Reservation findAllByUser_id(String user_id);
}


