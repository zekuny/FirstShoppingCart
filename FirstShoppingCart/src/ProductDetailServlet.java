import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductDB;
import dao.ShoppingReviewsDB;
import model.Product;
import model.Shoppingreview;

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
    	HttpSession session = request.getSession();
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
		
		if(session.getAttribute("username") != null){
			table += "<a href = \"addReview.jsp?pid=" + pid + "\"><button type=\"button\" class=\"btn pull-left btn-info btn-lg\">Add a review</button></a>";
		}else{
			table += "<a href = \"createProfile.jsp\"><button type=\"button\" class=\"btn pull-left btn-info btn-lg\">Login to wirte a review</button></a>";
		}
		
		table += "<table class=\"table table-striped\"><thead><tr><th>User</th><th>Review</th><th>Date</th><th>Comment on this review</th></tr></thead>";
		List<Shoppingreview> tmp = ShoppingReviewsDB.getAllReviewByID(pid);
		if(tmp != null){
			List<Shoppingreview> reviews = new ArrayList<Shoppingreview>(tmp);
			for(Shoppingreview s : reviews){
				table += "<tr><td>"+ s.getUsername() +"</td><td>"+ s.getReview() +"</td><td>"+ s.getReviewdate() + "</td>"
					  + "<td><a href = \"commentReviewServlet?reid=" + s.getReviewid() + "&pid=" + pid + "\">Comment</a></td></td></tr>\n";
			}
		}
		table += "</table>";
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
