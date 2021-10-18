package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CourseDetails;

/**
 * Servlet implementation class ListNavigationServlet
 */
@WebServlet("/ListNavigationServlet")
public class ListNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListNavigationServlet() {
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
		CourseDetailsHelper dao = new CourseDetailsHelper();
		String act = request.getParameter("doThisToList");
		if (act == null) {
			// no button has been selected
			getServletContext().getRequestDispatcher("/ViewAllListsServlet").forward(request, response);
		}
		else if (act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				CourseDetails listToDelete = dao.searchForCourseDetailsById(tempId);
				dao.deleteList(listToDelete);
			}
			catch (NumberFormatException e) {
				System.out.println("Forgot to click a button");
			} 
			finally {
				getServletContext().getRequestDispatcher("/ViewAllListsServlet").forward(request, response);
			}
		}
		else if (act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				CourseDetails listToEdit = dao.searchForCourseDetailsById(tempId);
				request.setAttribute("listToEdit", listToEdit);
				request.setAttribute("month", listToEdit.getStartDate().getMonthValue());
				request.setAttribute("date", listToEdit.getStartDate().getDayOfMonth());
				request.setAttribute("year", listToEdit.getStartDate().getYear());
				CourseHelper daoForCourses = new CourseHelper();
				request.setAttribute("allCourses", daoForCourses.showAllEntries());
				
				if(daoForCourses.showAllEntries().isEmpty()){
					request.setAttribute("allCourses", " ");
				}
				getServletContext().getRequestDispatcher("/edit-list.jsp").forward(request, response);
			} 
			catch (NumberFormatException e) {
				getServletContext().getRequestDispatcher("/ViewAllListsServlet").forward(request, response);
			}
		}
		else if (act.equals("add")) {
			getServletContext().getRequestDispatcher("/new-list.jsp").forward(request, response);
		}
	
	}

}
