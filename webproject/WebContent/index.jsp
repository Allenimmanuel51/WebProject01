<%@ page language="java" contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@include file="CommonHeader.jsp" %>
<h3>DeclarationScriptlet</h3>
<%!
	java.sql.Connection conn=null;
%>
<h3>Scriptlet</h3>
<%
	java.util.Date today=new java.util.Date();
	out.println("Today:"+today);
%>
<h3>ExpressionScriptlet</h3>
101+201 = <%=(101+201)%>
</body>
</html>																			