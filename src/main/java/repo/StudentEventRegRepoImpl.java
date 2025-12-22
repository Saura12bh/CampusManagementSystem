package repo;

import database.DbConfig;
import model.EventRegisterModel;

public class StudentEventRegRepoImpl extends DbConfig implements StudentEventRegRepo {

	@Override
	public boolean registerStudentForEvent(int sid ,int eid) {
		try {
			// get event capacity
						ps=con.prepareStatement("select  capacity from event where eid = ?");
						ps.setInt(1,eid);
						rs = ps.executeQuery();
						
						int capacity=0;
						if(rs.next()) {
							capacity=rs.getInt(1);
						}
						else {
							System.out.println("Event Not Found");
							return false;
						}
			// count already register student
						ps=con.prepareStatement("select count(*) from registration where eid=?");
						ps.setInt(1, eid);
						rs=ps.executeQuery();
						
						int regStudentCount=0;
						if(rs.next()) {
							regStudentCount=rs.getInt(1);
						}
			// check the capacity of the event
						if(regStudentCount >= capacity) {
							System.out.println("Event is Full No more students Register for this event...");
							return false;
						}
			// insert registration 
						ps=con.prepareStatement("insert into registration (eid , sid , regdate) values(?,?,curdate())");
						
						ps.setInt(1,eid);
						ps.setInt(2, sid);
						//psmt.setDate(3, model.getRegdate());
						
						int val = ps.executeUpdate();
						
						if(val > 0) {
							return true;
						}
						else {
							return false;
						}
		}
		catch(Exception e) {
			System.out.println("Error is : "+e);
			return false;
		}
	}

	@Override
	public boolean cancelEventRegistration(int studentId, int eventId) {
		try {
			ps = con.prepareStatement("delete from registration where sid=? and eid=?");

			ps.setInt(1, studentId);
			ps.setInt(2, eventId);

			int result = ps.executeUpdate();

			return result > 0; // delete zala tar true

		} catch (Exception e) {
			System.out.println("Cancel Event Error : " + e);
			return false;
		}
	}

	
}
