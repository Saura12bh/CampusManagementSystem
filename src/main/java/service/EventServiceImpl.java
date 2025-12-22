package service;
import java.util.*;
import model.*;
import repo.*;
public class EventServiceImpl implements EventService{
EventRepo er=new EventRepoImpl();
	@Override
	public boolean isAddEvent(Event m) {
		return er.isAddEvent(m);
	}

	@Override
	public List<Event> getAllEvents() {
		// TODO Auto-generated method stub
		return er.getAllEvents();
	}

	@Override
	public List<Event> getUpComingEvents() {
		// TODO Auto-generated method stub
		return er.getUpComingEvents();
	}

	@Override
	public boolean isDeleteEvent(int eid) {
		// TODO Auto-generated method stub
		return er.isDeleteEvent(eid);
	}

	@Override
	public boolean isUpdateEvent(Event m) {
		// TODO Auto-generated method stub
		return er.isUpdateEvent(m);
	}

	@Override
	public Event getEventById(int eventId) {
		// TODO Auto-generated method stub
		return er.getEventById(eventId);
	}

}
