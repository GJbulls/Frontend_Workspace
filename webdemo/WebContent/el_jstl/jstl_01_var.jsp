<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- uri="http://java.sun.com/jsp/jstl/core"  == 모든문법이 들어가있음 --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl_01_var</title>
</head>
<body>
<!-- 
	커스텀 태그(Custom tag)
	1. jsp에서 사용할 수 있도록 사용자 정의 태그를 의미한다.
	2. jstl(JSP Standard Tag Libaray)은 jsp 페이지에서 많이 사용되는
	   논리적 판단, 반복문 처리, 데이터베이스 등의 처리를 위한 표준 커스텀 태그이다.
 -->
 <%
 	int data = 20;
 %>
 <!-- 변수 선언 -->
 <!-- int data = 10; 과 같은 의미로 사용 -->	
 <c:set var="data" value = "10"/>
 
 <p> ${data} </p>
 
 <p> <c:out value="${data }"></c:out> </p>
 	<!-- int data 의 출력값  -->
 <p> <c:out value="<%=data%>"></c:out> </p>
 
 <!-- 변수 제거 -->
 <c:remove var="data"/>
 <p> ${data } </p>
 
 
 <%
 	request.setAttribute("st", "request");
  %>
 
 <p>st:${requestScope.st} </p>
 <p>st:${request.requestAttribute("st")} </p> <!-- 출력안됨 -->
 <p>st: <c:out value='<%=request.getAttribute("st") %>'></c:out>
 
 
 
 
 
 
 
 
</body>
</html>















