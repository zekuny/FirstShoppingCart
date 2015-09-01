

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ShoppingReviewCommentDB;
import model.Shoppingreviewcomment;

/**
 * Servlet implementation class addCommentServlet
 */
@WebServlet("/addCommentServlet")
public class addCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int reid = Integer.parseInt(request.getParameter("reid"));
		int pid = Integer.parseInt(request.getParameter("pid"));
		String comment = request.getParameter("comments");
		Shoppingreviewcomment s = new Shoppingreviewcomment();
		s.setReviewid(reid);
		s.setReviewcomment(comment);
		ShoppingReviewCommentDB.insert(s);
		String url = "/commentReviewServlet?reid=" + reid;
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
