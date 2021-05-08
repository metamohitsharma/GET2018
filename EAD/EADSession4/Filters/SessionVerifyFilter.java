package GET2018.EAD.EADSession4.Filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * It Verifies the Session of the current user
 * 
 * @author Mohit Sharma
 *
 */
public class SessionVerifyFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession();
		if ((int) session.getAttribute("userId") == Integer.parseInt(request.getParameter("hiddenId"))) {
			chain.doFilter(request, response);
		} else {
			HttpServletResponse httpsResponse = (HttpServletResponse) response;
			httpsResponse.sendRedirect(request.getServletContext().getInitParameter("errorPage"));
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}
}
