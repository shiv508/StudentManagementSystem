package Com.arch.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Com.arch.mvc.model.Student;
import Com.arch.mvc.view.Service;


@WebServlet("/DeleteStudent")
public class DeleteStudent extends HttpServlet
{
	public Service service = new Service();
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		String deleteStudent = req.getParameter("id");
		service.DeleteStudent(deleteStudent);
		RequestDispatcher rd = req.getRequestDispatcher("/index1.jsp");
		rd.forward(req,res);
	}

}
