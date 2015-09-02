

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ShoppingReviewsDB;
import model.Shoppingreview;

/** 
 * Servlet implementation class createReviewServlet
 */
@WebServlet("/createReviewServlet")
public class createReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createReviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int rating = Integer.parseInt(request.getParameter("rating"));
		int pid = Integer.parseInt(request.getParameter("pid"));
		String review = request.getParameter("review");
		String reviewdate = request.getParameter("reviewdate");
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		
		// insert into database
		Shoppingreview s = new Shoppingreview();
		s.setPid(pid);
		s.setReview(review);
		s.setReviewdate(reviewdate);
		s.setUsername(username);
		s.setRating(rating);
		ShoppingReviewsDB.insert(s);
		
		// redirect
		String url = "/ProductDetailServlet?pid=" + pid;
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
