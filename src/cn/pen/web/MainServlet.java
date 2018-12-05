package cn.pen.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.pen.dao.PenDao;
import cn.pen.dao.UserDao;
import cn.pen.pojo.Pen;
import cn.pen.pojo.User;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		String penId=request.getParameter("penId");
		System.out.println(penId);
		PenDao pd=new PenDao();
		
		ArrayList<Pen> pens=pd.selectPenById(Integer.parseInt(penId));

		request.setAttribute("pen", pens.get(0));
		request.getRequestDispatcher("/Main.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*String penId=request.getParameter("penId");
		String penName=request.getParameter("penName");
		String penImg=request.getParameter("penImg");
		String penInfo=request.getParameter("penInfo");

		PenDao pd=new PenDao();
		Pen pen=new Pen(Integer.parseInt(penId),penName,penImg,penInfo);

			ArrayList<Pen> penAll=pd.selectPenAll();
			request.setAttribute("penAll", penAll);
			
			request.setAttribute("pen", pen);
			request.getRequestDispatcher("/Main.jsp").forward(request, response);
*/
	}
}
