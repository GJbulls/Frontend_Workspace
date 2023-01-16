package servletdemo.part03;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//doPost 방식
// loginForm.jsp에서 <form method='post' action = 'loginPro'>   ==> Post 방식으로 넘겨줬기때문에 Post방식사용

@WebServlet("/loginPro")
public class LoginProController extends HttpServlet {
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String fid = req.getParameter("fid");
		String fpass = req.getParameter("fpass");
		
		//System.out.printf("%s %s\n",fid, fpass); //console에 입력한 id , password 출력
		
		MemberDTO dto = new MemberDTO();
		dto.setFid(fid);
		dto.setFpass(fpass);
		
		req.setAttribute("dto", dto); 
		
		String path = "/servletview/part03/loginResult.jsp";
		RequestDispatcher dis = req.getRequestDispatcher(path);
		dis.forward(req, resp);
		
		
		}
}
