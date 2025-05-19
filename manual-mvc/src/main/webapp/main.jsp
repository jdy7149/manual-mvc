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
<header>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="index.yong">Home</a>
        </li>
        <li class="nav-item">
          <button class="btn btn-secondary" onclick="location.href = '/exercise/register-view.yong'">Register</button>
        </li>
        <li class="nav-item">
          <c:choose>
          	<c:when test="${ empty sessionScope.userInfo }">
          		<button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#loginModal">Login</button>
          	</c:when>
          	<c:otherwise>
          		<button class="btn btn-primary" onclick="location.href = '/exercise/logout.yong'">Logout</button>
          	</c:otherwise>
          </c:choose>
          
          
          <div class="modal fade" id="loginModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  			<div class="modal-dialog">
    		  <div class="modal-content">
      			<div class="modal-header">
        		  <h1 class="modal-title fs-5" id="exampleModalLabel">로그인</h1>
        			<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      			</div>
      			<form action="/exercise/login.yong" method="post">
      			<div class="modal-body">
        		  
        			<div class="row mb-3">
        			  <label for="id" class="col-sm-3 col-form-label">아이디</label>
        			  <div class="col-sm-8">
        				<input type="text" class="form-control" name="id" id="id" placeholder="아이디" required>
        			  </div>
        			</div>
        			<div class="row mb-3">
        			  <label for="pwd" class="col-sm-3 col-form-label">비밀번호</label>
        			  <div class="col-sm-8">
        				<input type="password" class="form-control" name="pwd" id="pwd" placeholder="비밀번호" required>
        			  </div>
        			</div>
        			
        		 
      			</div>
      				<div class="modal-footer">
        				<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        				<button type="submit" class="btn btn-primary">login</button>
      				</div>
      			</form>
    			</div>
  			</div>
		</div>

        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Dropdown
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="#">Action</a></li>
            <li><a class="dropdown-item" href="#">Another action</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="#">Something else here</a></li>
          </ul>
        </li>
        <li class="nav-item">
          <a class="nav-link disabled" aria-disabled="true">Disabled</a>
        </li>
      </ul>
      <form class="d-flex" role="search">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
    </div>
  </div>
</nav>
</header>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/js/bootstrap.bundle.min.js" integrity="sha384-k6d4wzSIapyDyv1kpU366/PK5hCdSbCRGRCMv+eplOQJWyd1fbcAu9OCUj5zNLiq" crossorigin="anonymous"></script>
<div class="container-sm mb-3">
	<h1>모든회원 보기</h1>
	<a href="/exercise/member-list.yong">회원 보기</a>
</div>
<div class="container-sm mb-3">
	<h1>게시판글쓰기</h1>
	<a href="/exercise/post-form.yong">글쓰기</a>
</div>
<div class="container-sm mb-3">
	<h1>게시판 보기</h1>
	<c:url var="bbsList" value="bbs-list.yong">
		<c:param name="curpage">1</c:param>
	</c:url>
	<a href="${ bbsList }">게시글보기</a>
</div>
</body>
</html>