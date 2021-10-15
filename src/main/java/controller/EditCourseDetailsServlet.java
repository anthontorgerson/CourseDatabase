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
 * Servlet implementation class EditCourseDetailsServlet
 */
@WebServlet("/EditCourseDetailsServlet")
public class EditCourseDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCourseDetailsServlet() {
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
		// TODO Auto-generated method stub
		CourseDetailsHelper dao = new CourseDetailsHelper();
		
		CourseHelper ch = new CourseHelper();
		StudentHelper sh = new StudentHelper();
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		CourseDetails listToUpdate = dao.searchForCourseDetailsById(tempId);
		String newListName = request.getParameter("listName");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String studentName = request.getParameter("studentName");

		Student newStudent = sh.findStudent(studentName);
		
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year),
					Integer.parseInt(month), Integer.parseInt(day));
		} 
		catch (NumberFormatException ex) {
			ld = LocalDate.now();
		}
		
		try {
		//items are selected in list to add
			String[] selectedItems = request.getParameterValues("allCoursesToAdd");
			List<Course> selectedItemsInList = new ArrayList<Course>();
			for (int i = 0; i < selectedItems.length; i++) {
				System.out.println(selectedItems[i]);
				Course c = ch.searchForEntryById(Integer.parseInt(selectedItems[i]));
				selectedItemsInList.add(c);
			}
			listToUpdate.setListOfCourses(selectedItemsInList);
		}
		catch (NullPointerException ex) {
			// no items selected in list - set to an empty list
			List<Course> selectedItemsInList = new ArrayList<Course>();
			listToUpdate.setListOfCourses(selectedItemsInList);
		}
		
		listToUpdate.setListName(newListName);
		listToUpdate.setStartDate(ld);
		listToUpdate.setStudent(newStudent);
		dao.updateList(listToUpdate);
		getServletContext().getRequestDispatcher("/ViewAllListsServlet").forward(request, response);
	}

}
