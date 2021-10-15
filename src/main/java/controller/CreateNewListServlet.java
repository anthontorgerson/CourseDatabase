package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CourseDetails;
import model.Course;
import model.Student;


/**
 * Servlet implementation class CreateNewListServlet
 */
@WebServlet("/CreateNewListServlet")
public class CreateNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateNewListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CourseHelper ch = new CourseHelper();
		String listName = request.getParameter("listName");
		System.out.println("List Name: " + listName);
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String studentName = request.getParameter("studentName");
		
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
			ld = LocalDate.now();
		}
		
		String[] selectedCourses = request.getParameterValues("allCoursesToAdd");
		List<Course> selectedCoursesInList = new
		ArrayList<Course>();
		//make sure something was selected – otherwise we get a null pointer exception
		if (selectedCourses != null && selectedCourses.length > 0){
			for(int i = 0; i< selectedCourses.length; i++) {
				System.out.println(selectedCourses[i]);
				Course c = ch.searchForEntryById(Integer.parseInt(selectedCourses[i]));
				selectedCoursesInList.add(c);
			}
		}
		Student student = new Student(studentName);
		CourseDetails cds = new CourseDetails(listName, ld, student);
		
		cds.setListOfCourses(selectedCoursesInList);
		CourseDetailsHelper cdh = new CourseDetailsHelper();
		cdh.insertNewCourseDetails(cds);
		System.out.println("Success!");
		getServletContext().getRequestDispatcher("/ViewAllListsServlet").forward(request, response);
		
	}

	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
