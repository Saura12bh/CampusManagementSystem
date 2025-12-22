package service;
import model.*;
public interface StudentEventRegService {
	public boolean registerStudentForEvent(int sid,int eid);
	public boolean cancelEventRegistration(int studentId, int eventId);
}
