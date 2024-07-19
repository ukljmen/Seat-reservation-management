package inz.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@Entity
@Table(name = "Reservations")
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ID_reservation;
	private Date placedAt;
	
	@OneToOne(targetEntity = User.class, cascade = { CascadeType.MERGE })
	private User user;

//	public void addUser(User user) {
//		this.user = user;
//	}

	@OneToOne(targetEntity = Event.class, cascade = { CascadeType.MERGE })
	private Event event;

//	public void addEvent(Event event) {
//		this.event = event;
//	}

	@OneToOne(targetEntity = Seat.class, cascade = { CascadeType.MERGE })
	private Seat seat;

//	public void addSeat(Seat seat) {
//		this.seat = seat;
//	}

	@PrePersist
	void placedAt() {
		this.placedAt = new Date();
	}
}