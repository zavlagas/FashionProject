<%-- 
    Document   : login
    Created on : 13 Νοε 2020, 3:39:26 μμ
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div align="center">
            <h3>Please Login</h3>
            <c:if test="${param.error != null}">
                <p>
                    <strong>Credentrials are not correct</strong>
                </p>
            </c:if>

            <form:form action="${pageContext.request.contextPath}/authenticate" method="POST" >
                <P>
                    USERNAME: <input type="text" name="username"/>
                </P>
                <P>
                    PASSWORD: <input type="password" name="password"/>
                </P>
                <p>
                    <button type="submit">Submit</button>

                </p>
            </form:form>
        </div>

    </body>
</html>
