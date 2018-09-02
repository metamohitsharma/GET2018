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
 * This Servlet is used to display Profile of User
 * 
 * @author Mohit Sharma
 *
 */
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("userId");
		Facade facade = Facade.getInstance();
		UserInfoPojo userDetails = new UserInfoPojo();
		try {
			userDetails = facade.getUserInfo(id);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		generateHtml(response, userDetails, id);
	}

	public void generateHtml(HttpServletResponse response, UserInfoPojo userInfoList, int id) throws IOException {
		response.setContentType("text/html");
		PrintWriter fileWriter = response.getWriter();
		String filePath = getServletContext().getInitParameter("profileImage");
		File profileImage = new File(filePath + "\\" + id + ".jpg");
		fileWriter.print("<form action='FriendsServlet' method='post'><input type='hidden' name='hiddenId' value='" + id
				+ "'/><input type='submit' value='Friends' align='right'></form><a href='LogoutServlet'>Logout</a> ");
		fileWriter.print("<h1 align='center'>!! Welcome " + userInfoList.getFirstName() + "!!</h1><br />"
				+ "<form action = 'ImageUploadServlet' method='post' enctype = 'multipart/form-data'>"
				+ "<input type='hidden' name='hiddenId' value='" + id + "'/>");
		if (profileImage.exists()) {
			fileWriter.print("<img src='" + profileImage + "' height = '30%'/><br>");
		} else {
			fileWriter.print("<img src='" + filePath + "\\default.png' height = '30%'/><br>");
		}
		fileWriter.println(
				"<input type = 'file' name = 'file' size = '20' /><br /><input type = 'submit' value = 'Upload File' /></form>");
		fileWriter.print("<form action='EditInfoServlet' method='post'>" + "<h1 align=''center>Profile</h1><br />"
				+ "<table cellpadding='5'><tr>" + "<th align='left'>First Name :</th>"
				+ "<td><input type='text' name = 'firstName' value= '" + userInfoList.getFirstName()
				+ "' readonly/></td></tr>" + "<th align='left'>Last Name :</th>"
				+ "<td><input type='text' name = 'lastName' value= '" + userInfoList.getLastName()
				+ "' readonly/></td></tr>" + "<tr><th align='left'>Date of Birth :</th>"
				+ "<td><input type='date' name = 'dateOfBirth' value='" + userInfoList.getDateOfBirth()
				+ "' readonly/></td></tr>" + "<tr><th align='left'>Contact No. :</th>"
				+ "<td><input type='number' name='contact' value='" + userInfoList.getContactNo()
				+ "' readonly/></td></tr>" + "<tr><th align='left'>Email :</th>"
				+ "<td><input type='email' name='email' value='" + userInfoList.getEmail() + "' readonly/></td></tr>"
				+ "<tr><th align='left'>Company/Institute :</th>"
				+ "<td><input type='text' name = 'organization' value='" + userInfoList.getOrganization()
				+ "' readonly /></td>" + "</tr><tr><td><input type='submit' value='Edit Details'></td></tr></table>"
				+ "<input type='hidden' name='hiddenId' value='" + id + "'/></form>");
	}
}
