<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action='memInsert' method='post'>
	<tabale>
	<tr>
		<th>이름</th>
		<td><input type="text" name="name" /></td>
	</tr>

	<tr>
		<th>나이</th>
		<td><input type="text" name="age" /></td>
	</tr>

	<tr>
		<th>지역</th>
		<td><input type="text" name="loc" /></td>
	</tr>

	<tr>
		<td colspan='2'><input type="submit" value="commit" /></td>
		<!-- submit 클릭하면 action을 호출해준다-->
	</tr>
	</tabale>
</form>
</body>
</html>