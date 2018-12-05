package cn.pen.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.pen.dao.PenDao;
import cn.pen.pojo.Pen;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String penName=request.getParameter("search");
		System.out.println(penName);
		PenDao pd=new PenDao();
		
		ArrayList<Pen> pens=pd.selectPenByName(penName);

		if(pens.size()>0){
			request.setAttribute("pen", pens.get(0));
			request.getRequestDispatcher("/Main.jsp").forward(request, response);
		} else {
			request.setAttribute("searchInfo","无搜索物品！");
			//跳转
			request.getRequestDispatcher("/Main.jsp").forward(request, response);
		}
		
	}
}