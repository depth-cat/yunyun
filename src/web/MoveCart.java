package web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import repository.DBUtils;

/**
 * Servlet implementation class DelCart
 */
@WebServlet("/doMoveCart.do")
public class MoveCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MoveCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		ServletContext application = session.getServletContext();
		
		String uId= request.getParameter("uId");
		String cId =request.getParameter("cId");
		request.setAttribute("uId", uId);
		System.out.println(uId);
		System.out.println(cId);
		if(DBUtils.doMoveCart(uId,cId))
		{
			DBUtils.doCart(uId, cId);
			 request.getRequestDispatcher("checkout.jsp").forward(request, response); 
			System.out.println("成功!");
		}else{

			application.setAttribute("m", "修改失败!");
			application.setAttribute("URL", "admanage.jsp");
			response.setHeader("refresh", "0;URL=alert.jsp");
		}
		
	}
}
