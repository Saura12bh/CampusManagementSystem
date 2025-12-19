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
			System.out.println(e);
			return false;
		}
	}

	@Override
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
				s.setPassword(rs.getString(4));
				s.setDepartment(rs.getString(5));
				list.add(s);
			}
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		return list;
	}

	@Override
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
			System.out.println(e);

		}
		return false;
	}

	@Override
	public boolean updateStudent(Student s) {
	  try {
		  ps=con.prepareStatement("update student set name=?,email=?,password=?,department=? where sid=?");
		  ps.setString(1, s.getSname());
		  ps.setString(2, s.getEmail());
		  ps.setString(3,s.getPassword());
		  ps.setString(4, s.getDepartment());
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

	@Override
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
				s.setPassword(rs.getString(4));
				s.setDepartment(rs.getString(5));
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

	@Override
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
				s.setPassword(rs.getString(4));
				s.setDepartment(rs.getString(5));
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

}
