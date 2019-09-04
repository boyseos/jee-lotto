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
   <h2>구입</h2>
   <form id="join_form" action="<%=request.getContextPath()%>/lotto.do">
   	money<input type="text" name="money"/>
   	<input type="hidden" name="action" value="buy"/>
   	<input type="submit" value="전소옹"/>
   </form> 
</div>
<script>
$('#join_form').submit(function(){
   
});

</script>
</body>
   
</html>