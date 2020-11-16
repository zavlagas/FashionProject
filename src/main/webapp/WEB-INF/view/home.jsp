

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h1>Welcome Home</h1>
        User:<security:authentication property="principal.username"/><br>
        Roles: <security:authentication property="principal.authorities" />
        <hr>
        <p>
            <a href="${pageContext.request.contextPath}/books">List Of Books</a> 
        </p>

        <form:form action="${pageContext.request.contextPath}/logout" method="POST">
            <input type="submit" value="logout"/>
        </form:form>

    </body>
</html>
