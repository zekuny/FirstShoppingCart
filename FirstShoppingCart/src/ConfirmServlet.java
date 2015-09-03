

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

import dao.PaymentDB;
import dao.ProductDB;
import dao.ShoppingHistoryDB;
import dao.UserDB;
import dao.UserShoppingCartDB;
import model.Payment;
import model.Product;
import model.Shoppinghistory;
import model.Shoppinguser;
import model.Usershoppingcart;

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
		String username = (String) session.getAttribute("username");
		// Insert Payment
		String cardnumber = request.getParameter("cardnumber");
		String shippingaddress = request.getParameter("shippingaddress");
		String billingaddress = request.getParameter("billingaddress");
		Payment payment = new Payment();
		payment.setCardnumber(cardnumber);
		payment.setBillingaddress(billingaddress);
		payment.setShippingaddress(shippingaddress);
		payment.setUsername(username);
		PaymentDB.insert(payment);
		
		ArrayList<Product> list = (ArrayList<Product>) session.getAttribute("cart");
		double total = 0.0;
		for(Product p : list){
			total += p.getPrice();
	    	Shoppinghistory sh = new Shoppinghistory();
	    	sh.setPid(p.getPid());
	    	sh.setProductname(p.getPName());
	    	sh.setUsername(username);
	    	ShoppingHistoryDB.insert(sh);
		}
		total = total * 1.06;
		
		// the magic credit
		Shoppinguser su = UserDB.getUserByName(username);
		double credit = su.getCredit();
		if(credit > 0){
			if(credit >= total){
				total = 0;
				su.setCredit(credit - total);
			}else{
				total = total - credit;
				su.setCredit(0);
			}
		}
		UserDB.update(su);
		
	    session.removeAttribute("cart");	    
	    List<Usershoppingcart> tmp = UserShoppingCartDB.getProductsByUsername(username);
		if(tmp != null){
			ArrayList<Usershoppingcart> lists = new ArrayList<Usershoppingcart>(tmp);
		    for(Usershoppingcart u : lists){
		    	UserShoppingCartDB.delete(u);
		    }
		}
	    ArrayList<Product> cart = new ArrayList<Product>();
	    session.setAttribute("cart", cart);
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
