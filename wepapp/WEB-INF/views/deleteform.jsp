<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
	<form action="${pageContext.servletContext.contextPath}/delete" method="post">
		<table>
		<input type='hidden' name="no" value="${param.no}" />
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="password"></td>
				<td><input type="submit" value="확인"></td>
			</tr>
		</table>
	</form>
	<a href="${pageContext.servletContext.contextPath} ">메인으로 돌아가기</a>
</body>
</html>