package web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.swing.text.AbstractDocument.Content;

import repository.DBUtils;

/**
 * Servlet implementation class Addcomm
 */
@WebServlet("/doAddcomm.do")
public class Addcomm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Addcomm() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//

		
		//管理员添加商品
		HttpSession session = request.getSession();
		ServletContext application = session.getServletContext();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String cId = request.getParameter("cId");
		System.out.println(cId);
		String cname = request.getParameter("cname");
		String cate = request.getParameter("cate");
		float price = Float.parseFloat(request.getParameter("price"));
		String writer = request.getParameter("writer");
		String image = request.getParameter("image");
		if (DBUtils.doAddcomm(cId, cname, cate, price, writer,image)) {
			application.setAttribute("m", "添加成功!");
			application.setAttribute("URL", "addcomm.jsp");
			response.setHeader("refresh", "0;URL=alert.jsp" );
		} else {
			application.setAttribute("m", "添加失败!");
			application.setAttribute("URL", "addcomm.jsp");
			response.setHeader("refresh", "0;URL=alert.jsp" );
		}
	}


}
