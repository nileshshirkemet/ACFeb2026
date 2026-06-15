<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<jsp:useBean id="site" class="app.models.RealSiteModel" scope="application" />
<html>
    <head>
        <title>DemoApp</title>
    </head>
    <body>
        <h1>Welcome Visitor</h1>
        <h2>Our Visitors</h2>
        <table border="1">
            <tr>
                <th>Visitor Name</th>
                <th>Visit Count</th>
                <th>Last Visit</th>
                <th>Star Rating</th>
            </tr>
            <c:forEach var="entry" items="${site.visitors}">
                <tr>
                    <td>${entry.id}</td>
                    <td>${entry.visitCount}</td>
                    <td>${entry.lastVisit}</td>
                    <td>${entry.stars}</td>
                </tr>
            </c:forEach>
        </table>
        <p>
            <a href="register.jsp">Register Visit</a>
        </p>
    </body>
</html>