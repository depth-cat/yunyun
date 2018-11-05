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
 * Servlet implementation class delete
 */
@WebServlet("/doCDelete.do")
public class Cdelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cdelete() {
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


		//管理员删除商品
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		ServletContext application = session.getServletContext();
		
		String cId = request.getParameter("cId");
		if(DBUtils.doCDelete(cId))
		{
			application.setAttribute("m", "删除成功!");
			application.setAttribute("URL", "admincomm.jsp");
			response.setHeader("refresh", "0;URL=alert.jsp");
		}else{
			application.setAttribute("m", "删除失败!");
			application.setAttribute("URL", "admincomm.jsp");
			response.setHeader("refresh", "0;URL=alert.jsp");
		}
		
			
			
		
	}

}
