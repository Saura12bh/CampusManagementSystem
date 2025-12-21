package repo;

import java.util.List;

import model.Event;
import model.Student;

public interface EventRegRepo {
	public List<Student> getALlRegStudent(int eid);
	public List<Event>   getAllRegEvent(int sid);
	public Event getEventCapacityDetails(int eid);
}
