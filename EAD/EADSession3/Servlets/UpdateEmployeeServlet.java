package GET2018.EAD.EADSession3.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import GET2018.EAD.EADSession3.DAO.ConnectionToDB;
import GET2018.EAD.EADSession3.DAO.EmployeeQueries;

/**
 * This Servlet takes Updated Details for Employee
 * 
 * @author Mohit Sharma
 *
 */
public class UpdateEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connectionToDB;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			connectionToDB = ConnectionToDB.getConnection();
			response.setContentType("text/html");
			PrintWriter fileWriter = response.getWriter();
			String email = request.getParameter("hiddenId");
			try {
				PreparedStatement statement = connectionToDB
						.prepareStatement(EmployeeQueries.getQueryFour(email));
				fileWriter
						.print("<form action = 'SetEmployee' method='get'><table width=50% border=1>");
				ResultSet result = statement.executeQuery();
				while (result.next()) {
					fileWriter
							.print("<tr><td>First Name</td><td><input type='text' name='firstName' value='"
									+ result.getString(1)
									+ "'/>"
									+ "</td></tr><tr><td>Last Name</td><td><input type='text' name='lastName' value='"
									+ result.getString(2)
									+ "'/>"
									+ "</td></tr><tr><td>Email</td><td><input name='email' value='"
									+ result.getString(3)
									+ "' readonly/></td></tr><tr><td>Age</td><td><input type='number' name='age' value='"
									+ result.getString(4)
									+ "'/>"
									+ "</td></tr><tr><td><input type='submit' value='submit'/></td></tr>");
				}
				fileWriter.print("</table></form>");
				fileWriter.println("<a href='Welcome.html'>Back</a>");
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			} finally {
				fileWriter.close();
				try {
					connectionToDB.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
	}
}
