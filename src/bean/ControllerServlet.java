package bean;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		switch (request.getParameter("value")) {
		case "1":
			String email=request.getParameter("email");
			String name=request.getParameter("name");
			String password=request.getParameter("password");
			
			User bean=new User();
			bean.setName(name);
			bean.setEmail(email);
			bean.setPass(password);
			request.setAttribute("bean",bean);
			
			 boolean status=AddNewDao.insert(bean);
			if(status){
				RequestDispatcher rd=request.getRequestDispatcher("success.jsp");
				rd.forward(request, response);
			}
			else{
				RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
				rd.forward(request, response);
			}
			break;
		case "2":
			FetchDao.fetch();
			break;

		default:
			break;
		}
	
	
		
		
	}
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	
}
