<%@ page language="java"   contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비트 로또</title>
<script   src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
<div>
   <h2>로그인</h2>
   <form id="join_form" action="<%=request.getContextPath()%>/consumer.do">
   	cid<input type="text" name="cid"/>
   	pass<input type="text" name="pass"/>
   	<input type="hidden" name="action" value="login"/>
   	<input type="submit" value="전소옹"/>
   </form> 
</div>
<script>
$('#join_form').submit(function(){
   
});

</script>
</body>
   
</html>