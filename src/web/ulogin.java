package web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import repository.UserDAO;
import domain.Users;

@WebServlet("/doLogin.do")
public class ulogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ulogin() {
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
		
	
		//用户登录
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		ServletContext application = session.getServletContext();
		Users user = new Users();
		user.setuId(request.getParameter("uId"));
		user.setUpwd(request.getParameter("upwd"));
		String uId = request.getParameter("uId");
		System.out.println(user.getuId()+"00000000111");
		request.setAttribute("uId",uId);
		
		if(UserDAO.doLogin(user))
		{
			request.setAttribute("uId",uId);
			request.getRequestDispatcher("index.jsp").forward(request, response); //登录成功跳转到personal.jsp页面处理
		}else{
			application.setAttribute("m", "请您检查下ID和密码,重新登录!");
			application.setAttribute("URL","login.jsp" );
			response.setHeader("refresh", "0;URL=alert.jsp");
		}
		
	}
	
}
