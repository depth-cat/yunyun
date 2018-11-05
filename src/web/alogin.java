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
import domain.admin;

@WebServlet("/doadLogin.do")
public class alogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public alogin() {
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

		
		//管理员登录验证
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		ServletContext application = session.getServletContext();
		admin admin = new admin();
		admin.setaId(request.getParameter("aId"));
		admin.setApwd(request.getParameter("apwd"));
		if(DBUtils.adLogin(admin))
		{
			application.setAttribute("m", "登录成功!");
			application.setAttribute("URL", "Orders.jsp");
			response.setHeader("refresh", "0;URL=alert.jsp");	
			
		}else{
			application.setAttribute("m", "ID或密码输入有误,请重新登录!");
			application.setAttribute("URL","adminlogin.jsp" );
			response.setHeader("refresh", "0;URL=alert.jsp");
		}
	}
	
}
