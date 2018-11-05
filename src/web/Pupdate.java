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


@WebServlet("/doPupdate.do")
public class Pupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pupdate() {
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
		
		
		
		//用户信息更新(用户个人信息修改处理页面)
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		ServletContext application = session.getServletContext();
		
		String uId= request.getParameter("uId");
		String uaddr = request.getParameter("uaddr");
		String ucon = request.getParameter("ucon");
		String uname = request.getParameter("uname");
		String usex = request.getParameter("usex");
		String upwd = request.getParameter("upwd");
		
		request.setAttribute("uId",uId);
		if(DBUtils.doUupdate(uId, uname,uaddr, ucon, usex, upwd))
		{
			 request.getRequestDispatcher("personal.jsp").forward(request, response); 
			System.out.println("成功!");
		}else{

			application.setAttribute("m", "修改失败!");
			application.setAttribute("URL","admanage.jsp" );
			response.setHeader("refresh", "0;URL=alert.jsp");
		}
		
	}

}
