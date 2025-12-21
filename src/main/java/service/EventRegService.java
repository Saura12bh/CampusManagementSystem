package service;
import java.util.*;
import model.*;
public interface EventRegService {
public List<Student> getALlRegStudent(int eid);
public List<Event>   getAllRegEvent(int sid);
public Event getEventCapacityDetails(int eid);
}
