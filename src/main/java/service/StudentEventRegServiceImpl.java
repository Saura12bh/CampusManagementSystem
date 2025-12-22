package service;

import model.EventRegisterModel;
import repo.*;

public class StudentEventRegServiceImpl implements StudentEventRegService{
	StudentEventRegRepo ser=new StudentEventRegRepoImpl();
	@Override
	public boolean registerStudentForEvent(int sid ,int eid) {
		// TODO Auto-generated method stub
		return ser.registerStudentForEvent(sid, eid);
	}
	@Override
	public boolean cancelEventRegistration(int studentId, int eventId) {
		// TODO Auto-generated method stub
		return ser.cancelEventRegistration(studentId, eventId);
	}

}
