<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-SgOJa3DmI69IUzQ2PVdRZhwQ+dy64/BUtbMJw1MZ8t5HZApcHrRKUc4W0kG879m7" crossorigin="anonymous">
<script type="text/javascript">
document.addEventListener('DOMContentLoaded', function(){
	
	document.getElementById('register').addEventListener('submit', function(event){
		if (!document.getElementById('id').value){
			window.alert('아이디를 입력해주세요');
			event.preventDefault();
		}
	});
	
});
</script>
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/js/bootstrap.bundle.min.js" integrity="sha384-k6d4wzSIapyDyv1kpU366/PK5hCdSbCRGRCMv+eplOQJWyd1fbcAu9OCUj5zNLiq" crossorigin="anonymous"></script>
<h1>회원가입</h1>
<div class="container mx-auto w-25">
	<form action="/exercise/register.yong" id="register" method="post">
		<div class="mb-3">
			<label class="form-label" for="id">아이디</label>
			<input class="form-control" type="text" placeholder="아이디" name="id" id="id" readonly>
			<div class="d-flex justify-content-end">
				<button class="btn btn-info mt-3" type="button" onclick="window.open('/exercise/idcheck-popup.yong', 'idcheck', 'width=550, height=400')">중복체크</button>
			</div>
		</div>
		<div class="form-floating mb-3">
			<input class="form-control" type="password" placeholder="비밀번호" name="pwd" id="pwd" required>
			<label class="form-label" for="pwd">비밀번호</label>
		</div>
		<div class="form-floating mb-3">
			<input class="form-control" type="text" placeholder="이름" name="name" id="name" required>
			<label class="form-label" for="name">이름</label>
		</div>
		<div class="form-floating mb-3">
			<input class="form-control" type="email" placeholder="Email" name="email" id="email" required>
			<label class="form-label" for="email">Email</label>
		</div>
		<div class="form-floating mb-3">
			<input class="form-control" type="tel" placeholder="전화번호" name="tel" id="tel" required>
			<label class="form-label" for="tel">전화번호</label>
		</div>
		<div class="form-floating mb-3">
			<input class="form-control" type="text" placeholder="주소" name="addr" id="addr" required>
			<label class="form-label" for="addr">주소</label>
		</div>
		<div class="d-flex justify-content-end gap-2">
			<input class="btn btn-success" type="submit" value="제출">
			<input class="btn btn-secondary" type="reset" value="다시작성">
		</div>
	</form>
</div>
</body>
</html>