package inz.data;


import org.springframework.data.repository.CrudRepository;

import inz.models.Seat;

public interface SeatRepository 
		extends CrudRepository<Seat, Long> {
	Seat findBySeat_RowAndSeat_Number(Long SeatRow, Long SeatNumber);
}


         


