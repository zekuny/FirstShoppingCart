

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Shoppinguser;
import dao.UserDB;

/**
 * Servlet implementation class CreditServlet
 */
@WebServlet("/CreditServlet")
public class CreditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreditServlet() {
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
		List<Shoppinguser> tmp = UserDB.getAllUser();

		table += "<thead><tr><th>User</th><th>Credit</th></tr></thead>";
		if(tmp != null){
			ArrayList<Shoppinguser> lists = new ArrayList<Shoppinguser>(tmp);
			for(Shoppinguser s : lists){
				table += "<tr><td>" + s.getUsername() +"</td><td><form method = \"post\" action = \"UpdateCreditServlet\"><input type = \"text\" name=\"credit1\" value = \"" + s.getCredit() +"\"><input type = \"hidden\" name=\"userid1\" value = \"" + s.getUserid() +"\"><button type=\"submit\">Update</button></form></td></tr>";
			}	
		}
		table += "</tbody>" + "</table>" + "</div>";	

		request.setAttribute("table", table); 
		getServletContext().getRequestDispatcher("/credit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
