

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

import dao.ShoppingHistoryDB;
import model.Shoppinghistory;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/AllOrderServlet")
public class AllOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String table = "";
		List<Shoppinghistory> tmp = ShoppingHistoryDB.getAllHistory();

		table += "<thead><tr><th>User</th><th>Product ID</th><th>Product Name</th></tr></thead>";
		if(tmp != null){
			ArrayList<Shoppinghistory> lists = new ArrayList<Shoppinghistory>(tmp);
			for(Shoppinghistory s : lists){
				table += "<tr><td>" + s.getUsername() +"</td><td>" + s.getPid() +"</td><td>" + s.getProductname()
						+ "</td></tr>\n";
			}	
		}
		table += "</tbody>" + "</table>" + "</div>";	

		request.setAttribute("table", table); 
		getServletContext().getRequestDispatcher("/allorder.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
