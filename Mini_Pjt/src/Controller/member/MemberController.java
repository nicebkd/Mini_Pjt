package Controller.member;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.member.DAO.MemberDAO;
import Model.member.DAO.MemberDAOImpl;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/MemberController")
public class MemberController extends HttpServlet {
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	private void process(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		MemberDAO dao = new MemberDAOImpl();
		String command = request.getRequestURI();
		
		if(command.indexOf(request.getContextPath())==0){
			command = command.substring(request.getContextPath().length());
		}
		System.out.println("들어옴?"+command);
		String viewPage = null;
		try{
			if(command.equals("/test.do")){
				List<String> list = new ArrayList<>();
				list = dao.insert();
				request.setAttribute("list",list);
				viewPage = "/WEB-INF/test2.jsp";
			}

		}catch (Throwable e) {
			throw new ServletException(e);
		}
		if(viewPage !=null){
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
	}

}
