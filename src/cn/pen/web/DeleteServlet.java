package cn.pen.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.pen.dao.UserDao;
import cn.pen.pojo.User;

public class DeleteServlet extends HttpServlet {

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
		int result=ud.deleteUserById(Integer.parseInt(id));
		
		if(result>0){
			ArrayList<User> userAll=ud.selectAll();
			request.setAttribute("userAll", userAll);
			request.getRequestDispatcher("List.jsp").forward(request, response);
		}
		
	}

}
