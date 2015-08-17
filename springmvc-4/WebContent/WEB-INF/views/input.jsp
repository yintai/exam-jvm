<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> Input Page</title>
</head>
<body>

	<form action="createTradeInfo" method="POST">
		TradeInfo:<br> <br>
		Time:<input type="text" name="time"/> <br>
		status:<input type="text" name="status"/> <br>
		type:<input type="text" name="type"/> <br>
		amount:<input type="text" name="amount"/> <br>
		cashType:<input type="text" name="cashType"/> <br>
		CustomerName:<input type="text" name="customerInfo.name"/> <br><br>
		<input type="submit" value="Submit"/> <br>
	</form>
	<br><br>
	<a href="listTradeInfo">linajie</a>
</body>
</html>