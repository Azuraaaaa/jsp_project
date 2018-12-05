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
 * Servlet implementation class DeletePenServlet
 */
@WebServlet("/DeletePenServlet")
public class DeletePenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePenServlet() {
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
		
		PenDao pd=new PenDao();
		int result=pd.deletePenById(Integer.parseInt(penId));
		
		if(result>0){
			ArrayList<Pen> penAll=pd.selectPenAll();
			request.setAttribute("penAll", penAll);
			
			request.getRequestDispatcher("/List.jsp").forward(request, response);
		}
	}
}
