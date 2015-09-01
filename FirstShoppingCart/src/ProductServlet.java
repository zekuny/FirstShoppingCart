

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
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String head = "";
		if(session.getAttribute("username") != null){		
			ArrayList<Product> list = (ArrayList<Product>) session.getAttribute("cart");
			head = "<h1>You have " + list.size() + " item(s) in your shopping cart</h1>";
			head += "<a href = \"CheckoutServlet\"><button type=\"button\" class=\"btn pull-left btn-info btn-lg\">Check out now</button></a>";
			head += "<a href = \"LogoutServlet\"><button type=\"button\" class=\"btn pull-left btn-info btn-lg\">Clean Shopping Cart</button></a>";
		}

		
		String table = "";
		ArrayList<Product> lists = new ArrayList<Product>(ProductDB.getAllProduct());
		table += "<thead><tr><th>Product</th><th>Price</th><th>Description</th><th>Image</th><th>Add to Cart</th></tr></thead>";
		for(Product p : lists){
			table += "<tr><td><a href = \"ProductDetailServlet?pid=" + p.getPid() + "\">" + p.getPName() + "</a></td><td>" + p.getPrice() +"</td><td>" + p.getDescription()
					+ "</td><td><img src=\"" + p.getImageUrl() + "\" alt=\"Product image\" style=\"width: 48px; height: 72px;\"></td><td><a href = \"AddCartServlet?pid=" + p.getPid() + "\"><button type=\"button\" class=\"btn pull-left btn-info btn-lg\">Add</button></a></td></tr>\n";
		}	
		table += "</tbody>" + "</table>" + "</div>";	

		request.setAttribute("head", head); 
		request.setAttribute("table", table); 
		getServletContext().getRequestDispatcher("/product.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
