<%@page import="com.klef.jfsd.springboot.model.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
Employee e = (Employee)session.getAttribute("employee");
if(e==null)
{
	response.sendRedirect("empsessionfail");
	return;
}
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Home</title>
</head>
<body>
<%@include file="empnavbar.jsp" %>
ID:<%=e.getId()%><br>
Name:<%=e.getName() %><br>
Gender:<%=e.getGender() %><br>
DateofBirth:<%=e.getDateofbirth() %><br>
Department:<%=e.getDepartment() %><br>
Salary:<%=e.getSalary() %><br>
Email:<%=e.getEmail() %><br>
Location:<%=e.getLocation() %><br>
Contact:<%=e.getContact() %><br>
Status:<%=e.getStatus() %><br>

</body>
</html>