<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	if (window.opener){
		window.opener.document.getElementById('id').value = '${requestScope.id}';
	}
	else{
		window.alert('원래 페이지가 없음');
	}
	window.close();

</script>