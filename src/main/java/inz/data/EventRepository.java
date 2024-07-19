package inz.data;


import org.springframework.data.repository.CrudRepository;

import inz.models.Event;

public interface EventRepository 
		extends CrudRepository<Event, Long> {
}


         


