

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Shoppingreviewcomment;
import dao.ShoppingReviewCommentDB;
import dao.ShoppingReviewsDB;

/**
 * Servlet implementation class updateServlet
 */
@WebServlet("/commentReviewServlet")
public class commentReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public commentReviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pid = Integer.parseInt(request.getParameter("pid"));
		int reid = Integer.parseInt(request.getParameter("reid"));
		
		String table = "<table class=\"table table-striped\">";
		table += "<thead><tr><th>Comment</th></tr></thead>";
		List<Shoppingreviewcomment> tmp = ShoppingReviewCommentDB.getAllCommentByID(reid);
		if(tmp != null){
			ArrayList<Shoppingreviewcomment> list = new ArrayList<Shoppingreviewcomment>(tmp);
			for(Shoppingreviewcomment s : list){
				table += "<tr><td>" + s.getReviewcomment() + "</td></tr>\n";
			}
		}

		table += "</table><br><form class=\"form-horizontal\" role=\"form\" action=\"addCommentServlet\" method=\"post\">" +
			"<div class=\"form-group\">" +
				"<label class=\"control-label col-sm-5\" for=\"class\">Comments:</label>" +
				"<div class=\"col-sm-5\">" +
					"<input type=\"text\" class=\"form-control\" id=\"comments\" name=\"comments\">" +
					"<input type=\"hidden\" class=\"form-control\" id=\"reid\" name=\"reid\" value=\"" + reid + "\">" +
					"<input type=\"hidden\" class=\"form-control\" id=\"pid\" name=\"pid\" value=\"" + pid + "\">" +
				"</div>" +
			"</div>" +

			"<div class=\"form-group\">" +
				"<div class=\"col-sm-offset-2 col-sm-5\">" +
					"<center>" +
						"<button type=\"submit\" class=\"btn btn-primary btn-lg btn-block\" value=\"addView\">Comment on this one now!!!</button>" +
					"</center>" +
				"</div>" +
			"</div>" +
		"</form>";
		
		table += "<h2><a href = \"ProductDetailServlet?pid=" + pid + "\">Return</a></h2>";
		request.setAttribute("table", table); 
		getServletContext().getRequestDispatcher("/commentReview.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
