 

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDB;
import model.Product;
import model.Shoppinguser;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/CreateAccountServlet")
public class CreateAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Shoppinguser u = new Shoppinguser();
		u.setEmail(email);
		u.setPassword(password);
		u.setUsername(username);
		UserDB.insert(u);
		//session.setAttribute("userID", userID);
		session.setAttribute("username", username);
		ArrayList<Product> cart = new ArrayList<Product>();
	    session.setAttribute("cart", cart);
		//request.setAttribute("extra", "<h1>extra</h1>"); 
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
