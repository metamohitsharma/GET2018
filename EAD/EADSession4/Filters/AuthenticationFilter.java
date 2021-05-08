package GET2018.EAD.EADSession4.Filters;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import GET2018.EAD.EADSession4.Facade.Facade;

/**
 * This filter Authenticates a user
 * 
 * @author Mohit Sharma
 *
 */
public class AuthenticationFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Facade facade = Facade.getInstance();
		try {
			int id = facade.authenticateUser(email, password);
			if (id != 0) {
				HttpServletRequest httpRequest = (HttpServletRequest) request;
				HttpSession session = httpRequest.getSession();
				session.setAttribute("userId", id);
				chain.doFilter(request, response);
			} else {
				HttpServletResponse httpsResponse = (HttpServletResponse) response;
				httpsResponse.sendRedirect(request.getServletContext().getInitParameter("errorPage"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}
}
