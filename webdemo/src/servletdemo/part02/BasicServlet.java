package servletdemo.part02;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

////http://localhost:8090/webdemo/basic02
/*
 * get방식 doGet
 * super.doGet(req, resp); 삭제
 * JSP로 응답하게 처리해주는방법
 */
@WebServlet("/basic02")
public class BasicServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "/servletview/part02/view.jsp";
		
		RequestDispatcher dis = req.getRequestDispatcher(path);
		dis.forward(req, resp); // 상속받은 파라미터 값을 인자값으로 넣어줌
		
	}
	

}
