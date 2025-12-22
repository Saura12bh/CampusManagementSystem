package repo;
import model.*;
import java.util.*;
public interface EventRepo {
	public boolean isAddEvent(Event m);
	public List<Event> getAllEvents();
	public List<Event> getUpComingEvents();
	public boolean isDeleteEvent(int eid);
	public boolean isUpdateEvent(Event m);
	public Event getEventById(int eventId);
}
