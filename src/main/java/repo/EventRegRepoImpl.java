package repo;

import java.util.*;

import database.DbConfig;
import model.Event;
import model.Student;
import java.sql.*;
public class EventRegRepoImpl extends DbConfig implements EventRegRepo {

	List<Student> list;
	List<Event> list1;
	@Override
	public List<Student> getALlRegStudent(int eid) {
		try {
			list = new ArrayList<>();
			ps = con.prepareStatement(
					"select s.sid,s.name,s.email,s.department from student s join registration r on s.sid=r.sid join event e on r.eid=e.eid where e.eid=?");
			ps.setInt(1, eid);
			rs=ps.executeQuery();
			while(rs.next())
			{
				Student s=new Student();
				s.setSid(rs.getInt(1));
				s.setSname(rs.getString(2));
				s.setEmail(rs.getString(3));
				s.setDepartment(rs.getString(4));
				list.add(s);
			}
		} catch (Exception e) {
			System.out.println(e);

		}
		return list;
	}
	@Override
	public List<Event> getAllRegEvent(int sid) {
		try {
			list1=new ArrayList<>();
			ps=con.prepareStatement("select e.eid,e.name,e.date,e.venue,e.capacity from event join registration r on e.eid=r.eid join student s on r.sid=s.sid where sid=?");
			ps.setInt(1, sid);
			rs=ps.executeQuery();
			while(rs.next())
			{
				Event e=new Event();
				e.setEid(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setEdate(rs.getDate(3));
				e.setVenue(rs.getString(4));
				e.setCapacity(rs.getInt(5));
				list1.add(e);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;

		}
		return list1;
	}
	@Override
	public Event getEventCapacityDetails(int eid) {
		try {
			Event model=new Event();
	        // event name + capacity
	        PreparedStatement ps1 = con.prepareStatement(
	            "select  name, capacity from event where eid = ?"
	        );
	        ps1.setInt(1, eid);
	        ResultSet rs1 = ps1.executeQuery();

	        if (!rs1.next()) {
	            return null; // event not found
	        }

	        model.setEid(eid);
	        model.setName(rs1.getString("name"));
	        model.setCapacity(rs1.getInt("capacity"));

	        // count registrations
	        PreparedStatement ps2 = con.prepareStatement(
	            "SELECT COUNT(*) FROM registration WHERE eid = ?"
	        );
	        ps2.setInt(1, eid);
	        ResultSet rs2 = ps2.executeQuery();
	        rs2.next();

	        model.setRegistered(rs2.getInt(1));
	        model.setAvailable(model.getCapacity() - model.getRegistered());

	        return model;

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	

}
