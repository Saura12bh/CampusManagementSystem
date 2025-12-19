package repo;
import java.util.*;

import database.DbConfig;

import java.sql.*;
import java.sql.Date;

import model.*;
public class EventRepoImpl extends DbConfig implements EventRepo{
	List<Event> list;
	@Override
	public boolean isAddEvent(Event m) {
		try {
			ps=con.prepareStatement("insert into event (name , edate , venue , capacity) values(?,?,?,?)");
			ps.setString(1, m.getName());
			ps.setDate(2, (Date) m.getEdate());
			ps.setString(3, m.getVenue());
			ps.setInt(4, m.getCapacity());
			
			int value = ps.executeUpdate();
			if(value>0) {
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
	public List<Event> getAllEvents() {
		try {
			list=new ArrayList<Event>();
			
			ps=con.prepareStatement("Select * from event");
			rs=ps.executeQuery();
			
			while(rs.next()) {
				Event m = new Event();
				m.setEid(rs.getInt(1));
				m.setName(rs.getString(2));
				m.setEdate(rs.getDate(3));
				m.setVenue(rs.getString(4));
				m.setCapacity(rs.getInt(5));
				list.add(m);
			}
		}
		catch(Exception e) {
			System.out.println("Error is : "+e);
		}
		// here we return list which holds the DB data 
		return list;
	}

	@Override
	public List<Event> getUpComingEvents() {
		try {
			list = new ArrayList<Event>();
			ps=con.prepareStatement("select * from event where edate > curdate()");
			
			rs=ps.executeQuery();
			
			while(rs.next()) {
				Event m = new Event();
				m.setEid(rs.getInt(1));
				m.setName(rs.getString(2));
				m.setEdate(rs.getDate(3));
				m.setVenue(rs.getString(4));
				m.setCapacity(rs.getInt(5));
				
				list.add(m);
			}
		}
		catch(Exception e) {
			System.out.println("Error is : "+e);
		}
		return list;
	}

	@Override
	public boolean isDeleteEvent(int eid) {
		try {
			ps=con.prepareStatement("delete from event where eid=?");
			ps.setInt(1, eid);
			
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
	public boolean isUpdateEvent(Event m) {
		try {
			System.out.println(m);
			ps=con.prepareStatement("update event set name=? , edate=? , venue=? , capacity=? where name=?");
			ps.setString(1, m.getName());
			ps.setDate(2, (Date) m.getEdate());
			ps.setString(3, m.getVenue());
			ps.setInt(4, m.getCapacity());
			ps.setString(5, m.getName());
			
			int val = ps.executeUpdate();
			System.out.println("Value is : "+val);
			if(val>0)
			{
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
}
