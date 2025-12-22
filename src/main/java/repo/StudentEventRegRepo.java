package repo;

import model.EventRegisterModel;

public interface StudentEventRegRepo {
	public boolean registerStudentForEvent(int sid,int eid);
	public boolean cancelEventRegistration(int studentId, int eventId);

}
