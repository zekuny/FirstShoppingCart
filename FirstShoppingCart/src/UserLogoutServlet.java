

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Product;
import model.Usershoppingcart;
import dao.UserShoppingCartDB;
 
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/UserLogoutServlet")
public class UserLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		List<Usershoppingcart> tmp = UserShoppingCartDB.getProductsByUsername(username);
		if(tmp != null){
			ArrayList<Usershoppingcart> lists = new ArrayList<Usershoppingcart>(tmp);
		    for(Usershoppingcart u : lists){
		    	UserShoppingCartDB.delete(u);
		    }
		}
		ArrayList<Product> products = (ArrayList<Product>) session.getAttribute("cart");
		for(Product p : products){
			Usershoppingcart usc = new Usershoppingcart();
			usc.setPid(p.getPid());
			usc.setUsername(username);
			UserShoppingCartDB.insert(usc);
		}
	    session.removeAttribute("username");
	    session.removeAttribute("cart");
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
