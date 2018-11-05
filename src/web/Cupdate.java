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


@WebServlet("/doCupdate.do")
public class Cupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Cupdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//商品信息更新
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		ServletContext application = session.getServletContext();
		
	
		String cname = request.getParameter("cname");
		String cId = request.getParameter("cId");
		String cate = request.getParameter("cate");
		String writer = request.getParameter("writer");
		float price = Float.parseFloat(request.getParameter("price"));
		
		request.setAttribute("cId",cId);
		if(DBUtils.doCupdate(cId, cname, cate, price, writer))
		{
			 request.getRequestDispatcher("admincomm.jsp").forward(request, response); 
			System.out.println("成功!");
		}else{

			application.setAttribute("m", "修改失败!");
			application.setAttribute("URL", "admincomm.jsp");
			response.setHeader("refresh", "0;URL=alert.jsp");
		}
		
	}

}
