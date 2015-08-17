<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List Page</title>
<!--  
	SpringMVC 处理静态资源:
	1. 为什么会有这样的问题:
	优雅的 REST 风格的资源URL 不希望带 .html 或 .do 等后缀
	若将 DispatcherServlet 请求映射配置为 /, 
	则 Spring MVC 将捕获 WEB 容器的所有请求, 包括静态资源的请求, SpringMVC 会将他们当成一个普通请求处理, 
	因找不到对应处理器将导致错误。
	2. 解决: 在 SpringMVC 的配置文件中配置 <mvc:default-servlet-handler/>
-->
<script type="text/javascript" src="scripts/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$(".delete").click(function(){
			var href = $(this).attr("href");
			$("form").attr("action", href).submit();			
			return false;
		});
	})
</script>
</head>
<body>
	<form action="" method="POST">
		<input type="hidden" name="_method" value="DELETE"/>
	</form>
	
	<c:if test="${empty requestScope.tradeInfos}">
		没有任何交易信息.
	</c:if>
	<c:if test="${!empty requestScope.tradeInfos}">
		<table border="1" cellpadding="10" cellspacing="0">
			<tr>
				<th>ID</th>
				<th>Time</th>
				<th>Status</th>
				<th>Type</th>
				<th>Amount</th>
				<th>CashType</th>
				<th>CustomerName</th>
				<th><font color="red">Edit</font></th>
				<th><font color="red">Delete</font></th>
			</tr>
			
			<c:forEach items="${requestScope.tradeInfos}" var="tradeInfo">
				<tr>
					<td>${tradeInfo.id }</td>
					<td>${tradeInfo.time}</td>
					<td>${tradeInfo.status}</td>
					<td>${tradeInfo.type}</td>
					<td>${tradeInfo.amount}</td>
					<td><a href="updateTradeInfo/${tradeInfo.id}"><font color="blue">Edit</font></a></td>
					<td><a class="delete" href="deleteTradeInfo/${tradeInfo.id}"><font color="blue">Delete</font></a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	
	<br><br>
	
	<a href="${pageContext.request.contextPath }/input.jsp">Create New TradeInfo</a>
	
</body>
</html>