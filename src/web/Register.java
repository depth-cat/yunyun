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

@WebServlet("/doRegister.do")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		ServletContext application = session.getServletContext();
		
		Users user = new Users();
		user.setuId(request.getParameter("uId"));
		user.setUname(request.getParameter("uname"));
		user.setUpwd(request.getParameter("upwd"));
		user.setUsex(request.getParameter("usex"));
		user.setUaddr(request.getParameter("uaddr"));
		user.setUcon(request.getParameter("ucon"));
		
		
		if(UserDAO.doRegiser(user))
		{
			application.setAttribute("m", "注册成功,请登录!");
			application.setAttribute("URL", "login.jsp");
			response.setHeader("refresh", "0;URL=alert.jsp");
		}else{
			application.setAttribute("m", "该ID已被占用,请重新输入ID!");
			application.setAttribute("URL", "register.jsp");
			response.setHeader("refresh", "0;URL=alert.jsp");
		}
		
	}


}
