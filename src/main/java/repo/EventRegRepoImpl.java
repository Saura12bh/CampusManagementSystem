package repo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import database.DbConfig;
import model.Event;
import model.Student;

public class EventRegRepoImpl extends DbConfig implements EventRegRepo {

    List<Student> studentList;
    List<Event> eventList;

    // 1️⃣ Get all students registered for a specific event
    @Override
    public List<Student> getALlRegStudent(int eid) {

        studentList = new ArrayList<>();

        try {
            ps = con.prepareStatement(
                "SELECT s.sid, s.sname, s.email, s.department " +
                "FROM student s " +
                "JOIN registration r ON s.sid = r.sid " +
                "JOIN event e ON r.eid = e.eid " +
                "WHERE e.eid = ?"
            );

            ps.setInt(1, eid);
            rs = ps.executeQuery();

            while (rs.next()) {
                Student s = new Student();
                s.setSid(rs.getInt("sid"));
                s.setSname(rs.getString("sname"));
                s.setEmail(rs.getString("email"));
                s.setDepartment(rs.getString("department"));
                studentList.add(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return studentList;
    }

    // 2️⃣ Get all events registered by a specific student
    @Override
    public List<Event> getAllRegEvent(int sid) {

        eventList = new ArrayList<>();

        try {
            ps = con.prepareStatement(
                "SELECT e.eid, e.name, e.edate, e.venue, e.capacity " +
                "FROM event e " +
                "JOIN registration r ON e.eid = r.eid " +
                "JOIN student s ON r.sid = s.sid " +
                "WHERE s.sid = ?"
            );

            ps.setInt(1, sid);
            rs = ps.executeQuery();

            while (rs.next()) {
                Event e = new Event();
                e.setEid(rs.getInt("eid"));
                e.setName(rs.getString("name"));
                e.setEdate(rs.getDate("edate"));
                e.setVenue(rs.getString("venue"));
                e.setCapacity(rs.getInt("capacity"));
                eventList.add(e);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return eventList;
    }

    // 3️⃣ Get event capacity, registered count & available seats
    @Override
    public Event getEventCapacityDetails(int eid) {

        try {
            Event event = new Event();

            // get event capacity
            PreparedStatement ps1 = con.prepareStatement(
                "SELECT name, capacity FROM event WHERE eid = ?"
            );
            ps1.setInt(1, eid);
            ResultSet rs1 = ps1.executeQuery();

            if (!rs1.next()) {
                return null;
            }

            event.setEid(eid);
            event.setName(rs1.getString("name"));
            event.setCapacity(rs1.getInt("capacity"));

            // count registered students
            PreparedStatement ps2 = con.prepareStatement(
                "SELECT COUNT(*) FROM registration WHERE eid = ?"
            );
            ps2.setInt(1, eid);
            ResultSet rs2 = ps2.executeQuery();
            rs2.next();

            event.setRegistered(rs2.getInt(1));
            event.setAvailable(
                event.getCapacity() - event.getRegistered()
            );

            return event;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
