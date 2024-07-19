package inz.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "EVENTS")
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long event_id;
	@Size(min = 4, message = "Musi składać się z conajmniej 4 znaków")
	private String name;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date event_date;
}

//@NoArgsConstructor(access=AccessLevel.PUBLIC, force=true)

//private Type type;

//public static enum Type {
//MECZ, KONCERT, INNY
//}