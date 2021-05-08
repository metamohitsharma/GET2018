package GET2018.EAD.EADSession4.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import GET2018.EAD.EADSession4.Facade.Facade;
import GET2018.EAD.EADSession4.Model.UserInfoPojo;

/**
 * This Servlet edits User Information
 * 
 * @author Mohit Sharma
 *
 */
public class EditInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("userId");
		Facade facade = Facade.getInstance();
		UserInfoPojo userDetailsList = new UserInfoPojo();
		try {
			userDetailsList = facade.getUserInfo(id);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		generateHtml(response, userDetailsList, id);
	}

	public void generateHtml(HttpServletResponse response, UserInfoPojo userInfoList, int id) throws IOException {
		response.setContentType("text/html");
		PrintWriter fileWriter = response.getWriter();
		fileWriter.print(
				"<img name = 'imageOfUser'src=''><form action='FriendsServlet' method='post'><input type='hidden' name='hiddenId' value='"
						+ id + "'/><input type='submit' value='Friends'></form><a href='LogoutServlet'>Logout</a> ");
		fileWriter.print("<form action='UpdateUserServlet' method='post'>" + "<h1 align=''center>Profile</h1><br />"
				+ "<table cellpadding='5'><tr>" + "<th align='left'>First Name :</th>"
				+ "<td><input type='text' name = 'firstName' value= '" + userInfoList.getFirstName() + "'/></td></tr>"
				+ "<th align='left'>Last Name :</th>" + "<td><input type='text' name = 'lastName' value= '"
				+ userInfoList.getLastName() + "'/></td></tr>" + "<tr><th align='left'>Date of Birth :</th>"
				+ "<td><input type='date' name='dateOfBirth' value='" + userInfoList.getDateOfBirth() + "'/></td></tr>"
				+ "<tr><th align='left'>Contact No. :</th>" + "<td><input type='number' name='contact' value='"
				+ userInfoList.getContactNo() + "'/></td></tr>" + "<tr><th align='left'>Email :</th>"
				+ "<td><input type='email' name='email' value='" + userInfoList.getEmail() + "' readonly/></td></tr>"
				+ "<tr><th align='left'>Company/Institute :</th>"
				+ "<td><input type='text' name = 'organization' value='" + userInfoList.getOrganization()
				+ "' readonly /></td>" + "</tr><tr><td><input type='submit' value='Edit Details'></td></tr></table>"
				+ "<input type='hidden' name='hiddenId' value='" + id + "'/></form>");
	}
}
