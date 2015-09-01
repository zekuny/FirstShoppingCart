

import java.io.IOException;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductDB;
import model.Product;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ConfirmServlet")
public class ConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		ArrayList<Product> list;
		if(session.getAttribute("cart") != null){
			list = (ArrayList<Product>) session.getAttribute("cart");
		}else{
			list = new ArrayList<Product>();
			session.setAttribute("cart", list);
		}
		double total = 0.0;
		for(Product p : list){
			total += p.getPrice();
		}
	    session.removeAttribute("cart");	
		String table = "";
		table += "<div class=\"container\">"
				+ "<div class=\"jumbotron other-color\">"
				+ "<center>"
				 + "<h1>Thanks shopping on Tian Mao!!</h1>"
	      			+ "<p>Your total amount is: " + total + "</p>"
	      			+ "<p><a href=\"index.jsp\" class=\"btn btn-success btn-lg\">Back to home page>>></a></p>"
	      			+ "<img src=\"images/tianmao.jpg\" alt=\"Tian Mao\" >"
	      			+ "<img src=\"images/cat.jpg\" alt=\"Cat logo\" >"
	      			+ "</center>"
	      			+ "</div>"
	      			+ "</div>";
		request.setAttribute("table", table); 
		getServletContext().getRequestDispatcher("/confirm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
