package Com.arch.mvc.view;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Com.arch.mvc.model.Student;
import Com.arch.mvc.model.StudentService;

public class Service implements StudentService
{
	
	private Connection getConnection() throws SQLException
	{
		Connection con = null;
        try
        {
        	Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","shivam107");
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return con;
	}
	
    public void AddStudent(Student student)
    {
        try {
        	Connection con = getConnection();
            String query = "insert into Student(id,name,age,mobile,email)values(?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, student.getId());
            ps.setString(2, student.getName());
            ps.setString(3, student.getAge());
            ps.setString(4, student.getMobile());
            ps.setString(5, student.getEmail());
            ps.executeUpdate();
            System.out.println("insert sucessfully");
     
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    public void UpdateStudent(Student student) 
    {
        try {
        	Connection con = getConnection();
            String query = "update Student set name=?, age=?, mobile=?,email=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setString(5, student.getId());
            ps.setString(1, student.getName());
            ps.setString(2, student.getAge());
            ps.setString(3, student.getMobile());
            ps.setString(4, student.getEmail());
           
            int updaterow = ps.executeUpdate();
            if(updaterow > 0)
            {
              System.out.println("row update sucessfully");
            }
            else
            {
            	System.out.println("NO row updated ");
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    public void DeleteStudent(String id)
    {
        try {
        	Connection con = getConnection();
            String query = "delete from Student where id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,id);
            int deleterow = ps.executeUpdate();
            if(deleterow > 0)
            {
              System.out.println("row delete sucessfully");
            }
            else
            {
            	System.out.println("NO row deleted ");
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public List<Student> getAllStudents()
    {
        List<Student> students = new ArrayList<>();
        try {
        	Connection con = getConnection();
            String query = "select * from Student";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String age = rs.getString("age");
                String mobile = rs.getString("mobile");
                String email = rs.getString("email");
                students.add(new Student(id, name, age, mobile,email));
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return students;
    }
}