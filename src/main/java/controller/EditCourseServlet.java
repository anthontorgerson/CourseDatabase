package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Course;

/**
 * Servlet implementation class EditCourseServlet
 */
@WebServlet("/EditCourseServlet")
public class EditCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CourseHelper dao = new CourseHelper();
		String courseName = request.getParameter("courseName");
		String courseTeacher = request.getParameter("courseTeacher");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		Course courseToUpdate = dao.searchForEntryById(tempId);
		
		courseToUpdate.setCourseName(courseName);
		courseToUpdate.setCourseTeacher(courseTeacher);
		
		dao.updateEntry(courseToUpdate);
		getServletContext().getRequestDispatcher("/ViewAllCoursesServlet").forward(request, response);
	}

}
