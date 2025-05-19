<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<h1>글쓰기</h1>
<form action="/exercise/post.yong" method="post">
	<div class="row mb-3">
		<label for="title" class="form-label col-3">제목</label>
		<input class="form-control col-9" id="title" name="title" type="text">
	</div>
	<div class="mb-3">
		<textarea class="textarea" name="content" rows="8" cols="55"></textarea>
	</div>
	<div class="d-flex justify-content-end gap-2">
		<input type="submit" value="작성">
	</div>
</form>
</body>
</html>