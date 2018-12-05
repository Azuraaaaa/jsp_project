package cn.pen.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.pen.dao.PenDao;
import cn.pen.dao.UserDao;
import cn.pen.pojo.Pen;
import cn.pen.pojo.User;

public class UpdateUserServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");

		String id=request.getParameter("id");

		UserDao ud=new UserDao();
		ArrayList<User> users=ud.selectUserById(Integer.parseInt(id));
		request.setAttribute("user", users.get(0));
		request.getRequestDispatcher("/updateUser.jsp").forward(request, response);
		
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String phone=request.getParameter("phone");
		String sex=request.getParameter("sex");
		String birthday=request.getParameter("birthday");
		String email=request.getParameter("email");

		PenDao pd=new PenDao();
		UserDao ud=new UserDao();
		User user=new User(Integer.parseInt(id),name,password,phone,sex,birthday,email);
		int result=ud.updateUser(user);
		
		if(result>0){
			ArrayList<Pen> penAll=pd.selectPenAll();
			request.setAttribute("penAll", penAll);
			ArrayList<User> userAll=ud.selectAll();
			request.setAttribute("userAll", userAll);
			request.getSession().setAttribute("loginName",name);
			request.getRequestDispatcher("/List.jsp").forward(request, response);
			
		}
		
		
		
	}

}
