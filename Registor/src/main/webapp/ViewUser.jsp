<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.blbz.login.model.UserModel"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.addHeader("Cache-Control", "post-check=0, pre-check=0");
response.setHeader("Pragma", "no-cache");
String uname ="";
if(session !=null){ 
	if (session.getAttribute("user") == null) {
		response.sendRedirect("index.jsp");
	} else {
uname = (String)session.getAttribute("user");


%>
<h1>All Users List</h1>
<a href="index.jsp">Add New User </a>
<p><%=uname %></p>
<table border='1' width="100%")>
	<tr style="background-color:yellowgreen;color:white;">
		<th>Id</th>
		<th>FirstName</th>
		<th>LastName</th>
		<th>UserName</th>
		<th>Email</th>
		<th>Edit</th>
		<th>Delete</th>
	</tr>
	<%  List<UserModel> userlist = (List<UserModel>)request.getAttribute("list");
    if(!userlist.isEmpty()){
    	
    for(UserModel user : userlist){
%>
	<tr style="background-color:"";color:white;">
	
		<td><%=user.getId()%></td>
		<td><%=user.getFirstName() %></td>
		<td><%=user.getLastName() %></td>
		<td><%=user.getUserName() %></td>
		<td><%=user.getEmail() %></td>
		<%String EditUser ="EditUser?id="+user.getId();%>
		<td><a href= <%=EditUser%>>edit</a></td>
		<%String DeleteUser="DeleteUser?id="+ user.getId();%>
		<td><a href= <%=DeleteUser%>>delete</a></td>
		</tr>
		<%
		}
    } %>
		</table>
		<form action="Logout" method="post">
		<button type="submit">Logout</button></form>
<%}
	} %>
</body>
</html>