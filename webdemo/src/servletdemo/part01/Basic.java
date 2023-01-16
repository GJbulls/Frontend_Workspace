package servletdemo.part01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//http://localhost:8090/webdemo/basic01

//HttpServlet 상속을 해줘야한다. HttpServlet 상속이 안되면,
//Properties -> Targets Runtimes -> Apache Tomcat9.01 check -> apply 후 상속해준다.

/*
 * get방식 doget Override 해줌
 */
@WebServlet("/basic01")
public class Basic extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset = UTF-8"); //현재 페이지 환경설정값
		
		
		PrintWriter out  = resp.getWriter();
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head><title>home page</title></head>");
		out.write("<body>");
		out.write("<p> servlet page </p>");
		out.write("<p>홈 페이지</p>");
		out.write("</body>");
		out.write("</html>");
		
		
	}//end doGet()

}// end class
















