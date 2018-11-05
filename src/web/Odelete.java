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
 * Servlet implementation class DeleteOrder
 */
@WebServlet("/doOdelete.do")
public class Odelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Odelete() {
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
		
		
		
		//删除订单
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		ServletContext application = session.getServletContext();
		
		String uId = request.getParameter("uId");
		String cId = request.getParameter("cId");
		if(DBUtils.doODelete(uId, cId))
		{
			application.setAttribute("m", "删除成功!");
			application.setAttribute("URL", "admanage.jsp");
			response.setHeader("refresh", "0;URL=alert.jsp");
		}else{
			application.setAttribute("m", "删除失败!");
			application.setAttribute("URL", "admanage.jsp");
			response.setHeader("refresh", "0;URL=alert.jsp");
		}
		
	}

}

