package GET2018.EAD.EADSession4.Servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import GET2018.EAD.EADSession4.Facade.Facade;

/**
 * This Servlet dispatches Updated data of user to Database
 * 
 * @author Mohit Sharma
 *
 */
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Facade facade = Facade.getInstance();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				facade.updateUserInfo(request.getParameter("firstName"), request.getParameter("lastName"),
						new java.sql.Date(sdf.parse(request.getParameter("dateOfBirth")).getTime()),
						request.getParameter("contact"), Integer.parseInt(request.getParameter("hiddenId")));
				RequestDispatcher rd = request.getRequestDispatcher("ProfileServlet");
				rd.forward(request, response);
			} catch (NumberFormatException e) {
				response.sendRedirect(request.getServletContext().getInitParameter("errorPage"));
			} catch (ParseException e) {
				response.sendRedirect(request.getServletContext().getInitParameter("errorPage"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			response.sendRedirect(request.getServletContext().getInitParameter("errorPage"));
		}
	}
}
