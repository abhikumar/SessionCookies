
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final String userID = "Abhi";
	private final String password = "pass";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String user = request.getParameter("user");
		String passwordV = request.getParameter("pass");

		if (userID.equals(user) && password.equals(passwordV)) {
			Cookie cookie = new Cookie("user", user);
			cookie.setMaxAge(30);
			response.addCookie(cookie);
			response.sendRedirect("LoginSucess.jsp");
		}

		else {
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}

	}

}
