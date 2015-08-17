<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> Detail Page</title>
<script type="text/javascript" src="scripts/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$(".delete").click(function(){
			var href = $(this).attr("href");
			$("form").attr("action", href).submit();			
			return false;
		});
	})
	
	function updateTradeInfo(){  
		$("form")[0].attr("action", "updatetTradeInfo").submit();
		return false;
    } 
</script>
</head>
<body>

	<form action="updatetTradeInfo" method="POST">
	    <c:if test="${!empty requestScope.tradeInfo}">
	    <input type="hidden" name="_method" value="PUT"/>
		TradeInfoDetail:<br> <br>
		Time:<input type="text" name="time" value="${tradeInfo.time}"/> <br>
		status:<input type="text" name="status" value="${tradeInfo.status}"/> <br>
		type:<input type="text" name="type" value="${tradeInfo.type}"/> <br>
		amount:<input type="text" name="amount" value="${tradeInfo.amount}"/> <br>
		cashType:<input type="text" name="cashType" value="${tradeInfo.cashType}"/> <br>
		CustomerName:<input type="text" name="customerInfo.name" value="${tradeInfo.customerInfo.name}"/> <br><br>
		<input type="submit" value="Submit" /> <br>
		</c:if>
	</form>
	<br><br>
	
</body>
</html>