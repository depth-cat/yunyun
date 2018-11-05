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
 * Servlet implementation class AddtoCart
 */
@WebServlet("/doAddtocart.do")
public class Addcart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addcart() {
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
		
		//将商品加入购物车
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		ServletContext application = session.getServletContext();
		
		String uId= request.getParameter("uId");
		String cId = request.getParameter("cId");
		if(DBUtils.Addtocart(uId, cId)){
			request.getRequestDispatcher("index.jsp").forward(request, response); 
			System.out.println("成功!");
		}else{
			application.setAttribute("m", "添加失败!");
			application.setAttribute("URL", "login.html");
			response.setHeader("refresh", "0;URL=alert.html");
		}
		
	}

}

