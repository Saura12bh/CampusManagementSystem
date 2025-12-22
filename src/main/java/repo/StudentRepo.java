package repo;
import java.util.List;
import model.*;

public interface StudentRepo {
	public boolean addStudent(Student s);
	public List<Student> allStudent();
	public boolean deleteStudent(int sid);
	public boolean updateStudent(Student m);
	public List<Student> searchByEmail(String email);
	public List<Student> searchByDept(String dept);
	public Student getStudentById(int studentId);
}
