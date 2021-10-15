package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/NavigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationServlet() {
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
		String path = "/ViewAllStudentsServlet";
		
		StudentHelper dao = new StudentHelper();
		String act = request.getParameter("doThisToStudent");
		
		if (act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Student studentToDelete = dao.searchForEntryById(tempId);
				dao.deleteEntry(studentToDelete);
			}
			catch(NumberFormatException e){
				System.out.println("Must select a student to delete");
			}
		} 
		else if (act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Student studentToEdit = dao.searchForEntryById(tempId);
				request.setAttribute("studentToEdit", studentToEdit);
				path = "/edit-student.jsp";
			}
			catch(NumberFormatException e) {
				System.out.println("Must select a student to edit");
			}
		} 
		else if (act.equals("home")){
			path = "/index.html";
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
