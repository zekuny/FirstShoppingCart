

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Shoppinghistory;
import dao.ShoppingHistoryDB;

/**
 * Servlet implementation class PastOrderServlet
 */
@WebServlet("/PastOrderServlet")
public class PastOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PastOrderServlet() {
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
		String table = "";
		List<Shoppinghistory> tmp = ShoppingHistoryDB.getAllHistoryByName(username);
		if(tmp == null){
			table += "<h3>You haven't bought anything before.</h3>";
		}else{
			table += "<h3>You have bought: </h3>";
			table += "<thead><tr><th>Product ID</th><th>Product Name</th></tr></thead>";
			ArrayList<Shoppinghistory> lists = new ArrayList<Shoppinghistory>(tmp);
			for(Shoppinghistory s : lists){
				table += "<tr><td>" + s.getPid() +"</td><td>" + s.getProductname()
						+ "</td></tr>\n";
			}	
		}
		table += "</tbody>" + "</table>" + "</div>";	
		request.setAttribute("table", table); 
		getServletContext().getRequestDispatcher("/pastorder.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
