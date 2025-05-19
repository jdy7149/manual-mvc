<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-SgOJa3DmI69IUzQ2PVdRZhwQ+dy64/BUtbMJw1MZ8t5HZApcHrRKUc4W0kG879m7" crossorigin="anonymous">
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/js/bootstrap.bundle.min.js" integrity="sha384-k6d4wzSIapyDyv1kpU366/PK5hCdSbCRGRCMv+eplOQJWyd1fbcAu9OCUj5zNLiq" crossorigin="anonymous"></script>
<c:set var="result" value="${ requestScope.result }"></c:set>
<table class="table table-info">
	<tr>
		<th>번호</th>
		<td>${ result.idx }</td>
		<th>작성날짜</th>
		<td>${ result.writeDate }</td>
		<th>조회수</th>
		<td>${ result.viewNum }</td>
	</tr>
	<tr>
		<th>제목</th>
		<td>${ result.title }</td>
		<th colspan="2">작성자</th>
		<td>${ result.writer }</td>
	</tr>
	<tr>
		<td colspan="3">
			<p>${ result.content }</p>
		</td>
	</tr>
</table>
</body>
</html>