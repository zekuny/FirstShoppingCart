

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Shoppinguser;
import dao.UserDB;

/**
 * Servlet implementation class UpdateCreditServlet
 */
@WebServlet("/UpdateCreditServlet")
public class UpdateCreditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCreditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String tmp = request.getParameter("userid1");
		System.out.println(tmp);
		int uid = Integer.parseInt(tmp);
		tmp = request.getParameter("credit1");
		System.out.println(tmp);
		double credit = Double.parseDouble(tmp);
		Shoppinguser u = UserDB.getUserByID(uid);
		u.setCredit(credit);
		UserDB.update(u);
		getServletContext().getRequestDispatcher("/CreditServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
