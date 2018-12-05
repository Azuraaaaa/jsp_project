package cn.pen.web;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.pen.dao.PenDao;
import cn.pen.dao.UserDao;
import cn.pen.pojo.Pen;
import cn.pen.pojo.User;

public class UserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String phone=request.getParameter("phone");
		String sex=request.getParameter("sex");
		String birthday=request.getParameter("birthday");
		String email=request.getParameter("email");

		UserDao ud=new UserDao();
		PenDao pd=new PenDao();
		
		User user=new User(0,name,password,phone,sex,birthday,email);
		int result=ud.saveUser(user);
		if(result>0){
			try {
				ArrayList<Pen> penAll=pd.selectPenAll();
				request.setAttribute("penAll", penAll);
				request.getSession().setAttribute("loginName",name);
				request.getRequestDispatcher("/List.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			request.setAttribute("regist","×¢²áÊ§°Ü");
			//Ìø×ª
			request.getRequestDispatcher("/Register.jsp").forward(request, response);
		}
	}
}
