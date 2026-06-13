<%
	String person = request.getParameter("name");
	if(person == null)
		person = "";
%>
<html>
	<head>
		<title>DemoApp</title>
	</head>
	<body>
		<h1>Welcome Visitor <%=person%></h1>
		<b>Current Time: </b><%=new java.util.Date()%>
	</body>
</html>

