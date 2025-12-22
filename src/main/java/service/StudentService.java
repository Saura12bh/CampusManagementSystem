package service;
import model.*;
import java.util.*;
public interface StudentService {
	public boolean addStudent(Student s);
	public List<Student> allStudent();
	public boolean deleteStudent(int sid);
	public boolean updateStudent(Student m);
	public List<Student> searchByEmail(String email);
	public List<Student> searchByDept(String dept);
	public Student getStudentById(int studentId);
}
