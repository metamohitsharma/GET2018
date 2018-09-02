package GET2018.EAD.EADSession4.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import GET2018.EAD.EADSession4.Facade.Facade;
import GET2018.EAD.EADSession4.Model.FriendInfoPojo;

/**
 * This Servlet displays Friends of the User
 * 
 * @author Mohit Sharma
 *
 */
public class FriendsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Facade facade = Facade.getInstance();
		int id = (int) session.getAttribute("userId");
		List<FriendInfoPojo> friendsDetailsList = new ArrayList<FriendInfoPojo>();
		try {
			friendsDetailsList = facade.getFriends(id);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		generateHtml(response, friendsDetailsList, id);
	}

	private HttpServletResponse generateHtml(HttpServletResponse response, List<FriendInfoPojo> friendsDetailsList,
			int id) throws IOException {
		response.setContentType("text/html");
		PrintWriter fileWriter = response.getWriter();
		fileWriter.print("<table cellspacing='5px' cellpadding='5px'>");
		for (FriendInfoPojo friend : friendsDetailsList) {
			fileWriter.print("<tr><td>" + friend.getFirstName() + "</td><td>" + friend.getLastName()
					+ "</td><td><form action='FriendProfileServlet' method='post'>"
					+ "<input type='hidden' name='hiddenFriendId' value='" + friend.getId()
					+ "'/><input type='hidden' name='hiddenId' value='" + id
					+ "'/><input type='submit' name='visitFriend' value='Friend Details'/></form></td></tr>");
		}
		fileWriter.print("</table>");
		return response;
	}
}
