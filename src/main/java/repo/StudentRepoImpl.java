package repo;
import java.util.ArrayList;
import database.*;
import java.util.List;
import model.*;
public class StudentRepoImpl extends DbConfig implements StudentRepo{
	List<Student> list;
	@Override
	public boolean addStudent(Student s) {	
		try {
			ps=con.prepareStatement("insert into student  values('0',?,?,?,?,?)");
			ps.setString(1,s.getSname());
			ps.setString(2, s.getEmail());
			ps.setString(3, s.getDepartment());
			ps.setString(4,s.getMobile());
			ps.setString(5, s.getPassword());
			int v=ps.executeUpdate();
			if(v>0)
			{
				return true;
			}
			else {
				return false;
			}
		}catch(Exception e)
		{
			return false;
		}
	}
	public List<Student> allStudent() {
		try {
			list=new ArrayList<Student>();
			ps=con.prepareStatement("Select * from Student");
			rs=ps.executeQuery();
			while(rs.next())
			{
				Student s=new Student();
				s.setSid(rs.getInt(1));
				s.setSname(rs.getString(2));
				s.setEmail(rs.getString(3));
				s.setDepartment(rs.getString(4));
				s.setMobile(rs.getString(5));
				s.setPassword(rs.getString(6));
				list.add(s);
			}		
		}catch(Exception e)
		{
		}
		return list;
	}
	public boolean deleteStudent(int sid) {
		try {
			ps=con.prepareStatement("delete from student where sid=?");
			ps.setInt(1,sid);
			int v=ps.executeUpdate();
			if(v>0)
			{
				return true;
			}
			else {
				return false;
			}
		}
		catch(Exception e)
		{
		}
		return false;
	}
	public boolean updateStudent(Student s) {
	  try {
		  String sql = "UPDATE student SET sname=?, email=?, password=?, department=?, mobile=? WHERE sid=?";
		   ps = con.prepareStatement(sql);
		   ps.setString(1, s.getSname());
		   ps.setString(2, s.getEmail());
		   ps.setString(3, s.getPassword());
		   ps.setString(4, s.getDepartment());
		   ps.setString(5, s.getMobile());   // ✅ MUST
		   ps.setInt(6, s.getSid());

		  int v=ps.executeUpdate();
		  if(v>0)
		  {
			  return true;
		  }
		  else {
			  return false;
		  }
	  }
		catch(Exception e)
	  {
			System.out.println(e);
			return false;
	  }
	}
	public List<Student> searchByEmail(String email) {
		try {
			list=new ArrayList<>();
			ps=con.prepareStatement("Select * from student where email=?");
			ps.setString(1, email);
			rs=ps.executeQuery();
			while(rs.next())
			{
				Student s=new Student();
				s.setSid(rs.getInt(1));
				s.setSname(rs.getString(2));
				s.setEmail(rs.getString(3));
				s.setDepartment(rs.getString(4));
				s.setMobile(rs.getString(5));
				s.setPassword(rs.getString(6));
				list.add(s);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
		return list;
	}
	public List<Student> searchByDept(String dept) {
		try {
			list=new ArrayList<>();
			ps=con.prepareStatement("Select * from student where department=?");
			ps.setString(1, dept);
			rs=ps.executeQuery();
			while(rs.next())
			{
				Student s=new Student();
				s.setSid(rs.getInt(1));
				s.setSname(rs.getString(2));
				s.setEmail(rs.getString(3));
				s.setDepartment(rs.getString(4));
				s.setMobile(rs.getString(5));
				s.setPassword(rs.getString(6));
				list.add(s);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
		return list;
	}
	public Student getStudentById(int studentId) {
		 Student s = null;
	        try {
	            String sql = "SELECT * FROM student WHERE sid = ?";
	             ps = con.prepareStatement(sql);
	            ps.setInt(1, studentId);
	             rs = ps.executeQuery();
	            if (rs.next()) {
	                s = new Student(
	                    rs.getInt("sid"),
	                    rs.getString("sname"),
	                    rs.getString("email"),
	                    rs.getString("password"),
	                    rs.getString("department"),
	                    rs.getString("mobile")
	                );
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return s;
	}
}
