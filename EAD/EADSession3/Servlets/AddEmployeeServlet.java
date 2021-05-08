package GET2018.EAD.EADSession3.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import GET2018.EAD.EADSession3.DAO.ConnectionToDB;
import GET2018.EAD.EADSession3.DAO.EmployeeQueries;

/**
 * This Servlet adds Employee to database
 * 
 * @author Mohit Sharma
 *
 */
public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connectionToDB;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			connectionToDB = ConnectionToDB.getConnection();
			response.setContentType("text/html");
			PrintWriter fileWriter = response.getWriter();
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String email = request.getParameter("email");
			String age = request.getParameter("age");
			if (firstName == "" || lastName == "" || email == "") {
				fileWriter.print("Fields Can't be Empty...");
				fileWriter.print("<a href='Welcome.html'>Back</a>");
			} else {
				try {
					PreparedStatement statement = connectionToDB
							.prepareStatement(EmployeeQueries.getQueryOne());
					statement.setString(1, firstName);
					statement.setString(2, lastName);
					statement.setString(3, email);
					statement.setString(4, age);
					int i = statement.executeUpdate();
					if (i > 0) {
						fileWriter.print("You are successfully registered...");
						fileWriter.print("<a href='Welcome.html'>Back</a>");
					}
				} catch (SQLException ex) {
					fileWriter.print("Email Id Already Registered...");
					fileWriter.print("<a href='Welcome.html'>Back</a>");
				} finally {
					fileWriter.close();
				}
			}
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
	}
}
