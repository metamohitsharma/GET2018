package GET2018.EAD.EADSession3.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import GET2018.EAD.EADSession3.DAO.ConnectionToDB;
import GET2018.EAD.EADSession3.DAO.EmployeeQueries;

/**
 * This Servlet Searches Employee using given FirstName and LastName
 * 
 * @author Mohit Sharma
 *
 */
public class SearchEmployeeServlet extends HttpServlet {
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
			try {
				PreparedStatement statement = connectionToDB
						.prepareStatement(EmployeeQueries.getQueryThree(
								firstName, lastName));
				ResultSet result = statement.executeQuery();
				ResultSetMetaData columnNames = result.getMetaData();
				int totalColumns = columnNames.getColumnCount();
				fileWriter.print("<table width=50% border=1><tr>");
				for (int i = 1; i <= totalColumns; i++) {
					fileWriter.print("<th>" + columnNames.getColumnName(i)
							+ "</th>");
				}
				fileWriter.print("</tr>");
				while (result.next()) {
					fileWriter.print("<tr><td>" + result.getString(1)
							+ "</td><td>" + result.getString(2) + "</td><td>"
							+ result.getString(3) + "</td><td>"
							+ result.getString(4) + "</td></tr>");
				}
				fileWriter.print("</table>");
				fileWriter.print("<a href='Welcome.html'>Back</a>");
			} catch (SQLException ex) {
				ex.printStackTrace();
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
