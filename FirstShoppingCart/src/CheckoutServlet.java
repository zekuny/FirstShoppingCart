

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
@WebServlet("/CheckoutServlet")
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		ArrayList<Product> list = (ArrayList<Product>) session.getAttribute("cart");

		String head = "<h1>You have " + list.size() + " item(s) in your shopping cart</h1>";
		head += "<a href = \"ConfirmServlet\"><button type=\"button\" class=\"btn pull-left btn-info btn-lg\">Continue</button></a>";

		String table = "";
		table += "<thead><tr><th>Product</th><th>Price</th><th>Description</th><th>Image</th></tr></thead>";
		for(Product p : list){
			table += "<tr><td><a href = \"ProductDetailServlet?pid=" + p.getPid() + "\">" + p.getPName() + "</a></td><td>" + p.getPrice() +"</td><td>" + p.getDescription()
					+ "</td><td><img src=\"" + p.getImageUrl() + "\" alt=\"Product image\" style=\"width: 48px; height: 72px;\"></td></tr>\n";
		}	
		table += "</tbody>" + "</table>" + "</div>";	
		request.setAttribute("head", head); 
		request.setAttribute("table", table); 
		getServletContext().getRequestDispatcher("/checkout.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
