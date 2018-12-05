package cn.pen.web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class WordFilter
 */
@WebFilter("/WordFilter")
public class WordFilter implements Filter {

    /**
     * Default constructor. 
     */
    public WordFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		
		request.setCharacterEncoding("utf-8");
		
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		int flag=0;
		System.out.println("123");
		//¹ýÂË×Ö·û
		String str[] = {"!","#","$","%","^",";","\\","//","/",",",":","<",">","?","+"};
		if(name==""||password=="") {
			HttpServletResponse httpServletResponse =(HttpServletResponse)response;
			httpServletResponse.sendRedirect("UserError.jsp");
			return;
		}
		else if(!(name.equals(""))) {
			for(int i=0;i<name.length();i++) {
				String username=String.valueOf(name.charAt(i));
				for(int j=0;j<str.length;j++) {
					if(username.equals(str[j])){
						HttpServletResponse httpServletResponse =(HttpServletResponse)response;
						httpServletResponse.sendRedirect("UserError.jsp");
						return;
					}
				}
			}
			flag=1;
		}
		if(flag==1){
			chain.doFilter(request, response);
			return;
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
