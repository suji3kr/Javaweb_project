<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    request.setCharacterEncoding("utf-8");
    request.setAttribute("id", "hong");
    request.setAttribute("pwd", "1234");
    request.setAttribute("name", "홍길동");
    application.setAttribute("email", "hong@hong.com");
	request.setAttribute("address", "경기도 시흥시");  /* request가 다음session보다 우선순위로 뜸 */
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forward4</title>
</head>
<body>
	<jsp:forward page ="member4.jsp"/>
</body>
</html>

<!--  데이터가 없을 때 확인용 -->