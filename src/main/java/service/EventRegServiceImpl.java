package service;

import java.util.List;

import model.Event;
import model.Student;
import repo.*;

public class EventRegServiceImpl implements EventRegService{
EventRegRepo err=new EventRegRepoImpl();
	@Override
	public List<Student> getALlRegStudent(int eid) {
		// TODO Auto-generated method stub
		return err.getALlRegStudent(eid);
	}
	@Override
	public List<Event> getAllRegEvent(int sid) {
		// TODO Auto-generated method stub
		return err.getAllRegEvent(sid);
	}
	@Override
	public Event getEventCapacityDetails(int eid) {
		// TODO Auto-generated method stub
		return err.getEventCapacityDetails(eid);
	}

}
