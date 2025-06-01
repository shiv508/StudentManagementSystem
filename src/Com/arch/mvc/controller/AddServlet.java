package Com.arch.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Com.arch.mvc.model.Student;
import Com.arch.mvc.view.Service;


@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet
{
	public Service service = new Service();
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		Student newStudent = new Student(
                req.getParameter("id"),
                req.getParameter("name"),
                req.getParameter("age"),
                req.getParameter("mobile"),
                req.getParameter("email")
                );
        service.AddStudent(newStudent);
        RequestDispatcher rd = req.getRequestDispatcher("/index1.jsp");
		rd.forward(req,res);
	}

}
