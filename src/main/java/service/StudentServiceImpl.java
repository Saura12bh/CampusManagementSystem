package service;
import java.util.List;
import model.*;
import repo.*;
public class StudentServiceImpl implements StudentService{
	StudentRepo sr=new StudentRepoImpl();
	@Override
	public boolean addStudent(Student s) {
		return sr.addStudent(s);
	}

	@Override
	public List<Student> allStudent() {
		// TODO Auto-generated method stub
		return sr.allStudent();
	}

	@Override
	public boolean deleteStudent(int sid) {
		// TODO Auto-generated method stub
		return sr.deleteStudent(sid);
	}

	@Override
	public boolean updateStudent(Student s) {
		// TODO Auto-generated method stub
		return sr.updateStudent(s);
	}

	@Override
	public List<Student> searchByEmail(String email) {
		// TODO Auto-generated method stub
		return sr.searchByEmail(email);
	}

	@Override
	public List<Student> searchByDept(String dept) {
		// TODO Auto-generated method stub
		return sr.searchByDept(dept);
	}

	@Override
	public Student getStudentById(int studentId) {
		// TODO Auto-generated method stub
		return sr.getStudentById(studentId);
	}

}
