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
import cn.pen.dao.PenDao;
import cn.pen.pojo.Pen;


public class LoginServlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		String name=request.getParameter("name");
		String password=request.getParameter("password");

		UserDao ud=new UserDao();
		PenDao pd=new PenDao();

		ArrayList<User> users=ud.login(name, password);

		if(users.size()>0){

			User user=users.get(0);
			ArrayList<Pen> penAll=pd.selectPenAll();
			request.setAttribute("penAll", penAll);

			request.getSession().setAttribute("loginName",name);
			request.getSession().setAttribute("loginId",user.getId());
			request.getRequestDispatcher("/List.jsp").forward(request, response);
		} else {
			request.setAttribute("loginErrorMessage","用户名或密码错误");
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
		}
	}
		
}
