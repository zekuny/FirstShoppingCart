

import java.util.List;
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

import model.Product;
import model.Shoppinguser;
import model.Usershoppingcart;
import dao.ProductDB;
import dao.UserDB;
import dao.UserShoppingCartDB;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet") 
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(UserDB.checkLogin(username, password) != null){
			//Shoppinguser user = UserDB.checkLogin(username, password);
			session.setAttribute("username", username);
			
			List<Usershoppingcart> lists = UserShoppingCartDB.getProductsByUsername(username);
			ArrayList<Product> cart = new ArrayList<Product>();
			if(lists != null){
				ArrayList<Usershoppingcart> usershoppingcart = new ArrayList<Usershoppingcart>(lists);			
				for(Usershoppingcart u : usershoppingcart){
					Product p = ProductDB.getProductByID(u.getPid());
					cart.add(p);
				}
			}
			session.setAttribute("cart", cart);
		}
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
