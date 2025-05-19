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
<div class="container-sm">
  <table class="table table-info table-striped table-hover">
  	<thead>
  		<tr>
  			<th>회원번호</th>
  			<th>아이디</th>
  			<th>이름</th>
  			<th>Email</th>
  			<th>tel</th>
  			<th>addr</th>
  		</tr>
    </thead>
    <tbody>
    	<c:set var="res" value="${ requestScope.result }"></c:set>
    	<c:choose>
    		<c:when test="${ empty res }">
    			<tr>
    				<td colspan="6" align="center">목록 없음</td>
    			</tr>
    		</c:when>
    		<c:otherwise>
    			<c:forEach var="memberInfo" items="${ res }">
    				<tr>
    					<td>${ memberInfo.idx }</td>
    					<td>${ memberInfo.id }</td>
    					<td>${ memberInfo.name }</td>
    					<td>${ memberInfo.email }</td>
    					<td>${ memberInfo.tel }</td>
    					<td>${ memberInfo.addr }</td>
    				</tr>
    			</c:forEach>
    		</c:otherwise>
    	</c:choose>
    </tbody>
  </table>
</div>
</body>
</html>