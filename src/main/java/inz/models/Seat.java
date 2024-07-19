package inz.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "SEATS")
public class Seat {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long seat_id;
	private Long seat_Number;
	private Long seat_Row;
}

//@NoArgsConstructor(access=AccessLevel.PUBLIC, force=true)
//private String sector_seat;
