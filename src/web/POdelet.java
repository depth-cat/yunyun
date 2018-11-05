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
 * Servlet implementation class POdelet
 */
@WebServlet("/doPOdelete.do")
public class POdelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public POdelet() {
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

		
		
		
		//个人订单信息删除成功跳转Odetail.jsp显示此时的订单详细信息
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		ServletContext application = session.getServletContext();
		
		String uId = request.getParameter("uId");
		String cId = request.getParameter("cId");
		request.setAttribute("uId",uId);
		if(DBUtils.doODelete(uId, cId))
		{
			request.getRequestDispatcher("Odetail.jsp").forward(request, response); 
			System.out.println("成功!");
		}else{
			application.setAttribute("m", "删除失败!");
			application.setAttribute("URL", "admanage.jsp");
			response.setHeader("refresh", "0;URL=alert.jsp");
		}
		
	}

}
