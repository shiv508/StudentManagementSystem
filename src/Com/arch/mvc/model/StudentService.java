package Com.arch.mvc.model;

import java.sql.Connection;
import java.util.List;

public interface StudentService
{
		public void AddStudent(Student student);

	    public void UpdateStudent(Student student);

	    public void DeleteStudent(String id);

	    public  List<Student> getAllStudents();
}

