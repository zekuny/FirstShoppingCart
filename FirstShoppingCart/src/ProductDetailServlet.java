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
@WebServlet("/ProductDetailServlet")
public class ProductDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
		int pid = Integer.parseInt(request.getParameter("pid"));
		Product c = ProductDB.getProductByID(pid);
		String table = "";
		table += "<form class=\"form-horizontal\">" + 
	    "<div class=\"form-group\">" +
	        "<label class=\"col-xs-3 control-label\">Product Name</label>" +
	        "<div class=\"col-xs-8\">" +
	            "<label class=\"col-xs-8 control-label\">" + c.getPName() + "</label>" + 
	        "</div>" + 
	    "</div>" + 

	    "<div class=\"form-group\">" + 
	        "<label class=\"col-xs-3 control-label\">Price</label>" + 
	        "<div class=\"col-xs-8\">" + 
	            "<label class=\"col-xs-8 control-label\">" + c.getPrice() + "</label>" + 
	        "</div>" + 
	    "</div>" + 

	    "<div class=\"form-group\">" + 
	        "<label class=\"col-xs-3 control-label\">Description</label>" + 
	        "<div class=\"col-xs-8\">" + 
	            "<label class=\"col-xs-8 control-label\">" + c.getDescription() + "</label>" + 
	        "</div>" + 
	    "</div>" + 

	    "<div class=\"form-group\">" + 
	        "<label class=\"col-xs-3 control-label\">Image</label>" + 
	        "<div class=\"col-xs-8\">" + 
	            "<label class=\"col-xs-8 control-label\"><img src=\"" + c.getImageUrl() + "\" alt=\"Product image\"></label>" + 
	        "</div>" + 
	    "</div>" + 
        "</form>";
		request.setAttribute("table", table);
		getServletContext().getRequestDispatcher("/detail.jsp").forward(request, response);
	} 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
