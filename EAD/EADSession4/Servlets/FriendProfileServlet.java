package GET2018.EAD.EADSession4.Servlets;

import java.io.File;
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
 * This Servlet Displays the Profile of selected friend
 * 
 * @author Mohit Sharma
 *
 */
public class FriendProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("userId");
		int friendId = Integer.parseInt(request.getParameter("hiddenFriendId"));
		Facade facade = Facade.getInstance();
		UserInfoPojo userDetailsList = new UserInfoPojo();
		try {
			userDetailsList = facade.getUserInfo(Integer.parseInt(request.getParameter("hiddenFriendId")));
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		response = generateHtml(response, userDetailsList, id, friendId);
	}

	public HttpServletResponse generateHtml(HttpServletResponse response, UserInfoPojo userInfoList, int id,
			int friendId) throws IOException {
		response.setContentType("text/html");
		PrintWriter fileWriter = response.getWriter();
		String filePath = getServletContext().getInitParameter("profileImage");
		File profileImage = new File(filePath + "\\" + friendId + ".jpg");
		fileWriter.print(
				"<img name = 'imageOfUser'src=''><form action='FriendsServlet' method='post'><input type='hidden' name='hiddenId' value='"
						+ id
						+ "'/><input type='submit' value='Friends'></form><a href='LogoutServlet'>Logout</a><br/><br/> ");
		if (profileImage.exists()) {
			fileWriter.print("<img src='" + profileImage + "' height = '30%'/><br>");
		} else {
			fileWriter.print("<img src='" + filePath + "\\default.png' height = '30%'/><br>");
		}
		fileWriter.print("<form action='ReturnProfileServlet' method='post'>" + "<h1 align=''center>Profile</h1><br />"
				+ "<table cellpadding='5'><tr>" + "<th align='left'>First Name :</th>"
				+ "<td><input type='text' name = 'firstName' value= '" + userInfoList.getFirstName()
				+ "' readonly/></td></tr>" + "<th align='left'>Last Name :</th>"
				+ "<td><input type='text' name = 'lastName' value= '" + userInfoList.getLastName()
				+ "' readonly/></td></tr>" + "<tr><th align='left'>Age :</th>"
				+ "<td><input type='' name = 'dateOfBirth' value='" + userInfoList.getDateOfBirth()
				+ "' readonly/></td></tr>" + "<tr><th align='left'>Contact No. :</th>"
				+ "<td><input type='number' name='contact' value='" + userInfoList.getContactNo()
				+ "' readonly/></td></tr>" + "<tr><th align='left'>Email :</th>"
				+ "<td><input type='email' name='email' value='" + userInfoList.getEmail() + "' readonly/></td></tr>"
				+ "<tr><th align='left'>Company/Institute :</th>"
				+ "<td><input type='text' name = 'organization' value='" + userInfoList.getOrganization()
				+ "' readonly /></td>" + "</tr><tr><td><input type='submit' value='Back'></td></tr></table>"
				+ "<input type='hidden' name='hiddenId' value='" + id + "'/></form>");
		return response;
	}
}
