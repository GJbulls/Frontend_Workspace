
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>el_02_res</title>
</head>
<body>
	<%
		//scriptlet
		String data = request.getParameter("data");
		//out이라는 객체를 이용해서 출력해줄수있음
		out.print("<p>" + data + "</p>");
		
	%>
	<p> <%= data %> </p>
	
	
	<%--표현언어 사용 
		param = parameter--%>
	<p>${param.data }</p>
	
	<%
		//여러개 받을대는 String []
		String[] chk = request.getParameterValues("chk");
		if(chk != null){
			for(String sn : chk)
				out.print("<p>" + sn + "</p>");
		}
	
	%>
	
	<p> ${paramValues.chk[0]} </p>
	<p> ${paramValues.chk[1]} </p>
	<p> ${paramValues.chk[2]} </p>
	
	
	</body>
</html>










