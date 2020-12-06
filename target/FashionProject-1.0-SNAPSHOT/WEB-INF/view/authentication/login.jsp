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

        <link rel='stylesheet' href='webjars/bootstrap/4.5.3/css/bootstrap.min.css''>
       
        <!--Fontawesome CDN-->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" 
              integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" 
              crossorigin="anonymous">
         <link rel='stylesheet' type="text/css" href='css/style.css''>
        <title>Login Page</title>
    </head>
    <body>
        <div class="container">
            <div class="d-flex justify-content-center h-100">
                <div class="card">
                    <div class="card-header">
                        <h3 class="text-center">Log In</h3>
                    </div>
                    <div class="card-body">
                        <c:if test="${param.error != null}" >
                            <div class="alert alert-danger" role="alert">
                                Login failed wrong user credentials!
                            </div>
                        </c:if>
                        <c:if test="${param.logout != null}" >
                            <div class="alert alert-danger" role="alert">
                                You've been logged out
                            </div>
                        </c:if>
                        <form:form action="${pageContext.request.contextPath}/authenticate" method="POST" >
                            <div class="input-group form-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="fas fa-user"></i></span>
                                </div>
                                <input class="form-control" type="text" name="username" placeholder="username"/>
                            </div>
                            <div class="input-group form-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="fas fa-key"></i></span>
                                </div>
                                <input class="form-control" placeholder="password" type="password" name="password"/>
                            </div>
                            <div class="row align-items-center remember">
                                <input type="checkbox">Remember Me
                            </div>
                            <div class="form-group">
                                <button class="btn float-right glow-on-hover" type="submit">Login</button>
                            </div>
                        </form:form>
                    </div>
                    <div class="card-footer">
                        <div class="d-flex justify-content-center links">
                            Don't have an account?<a class="text-warning" href="${pageContext.request.contextPath}/signup">Sign Up</a>
                        </div>
                        <div class="d-flex justify-content-center links">
                            <a class="text-warning" href="#">Forgot your password?</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script type="text/javascript" src="webjars/jquery/3.5.1/jquery.min.js"></script>
        <script type="text/javascript" src="webjars/popper.js/1.16.0/umd/popper.min.js"></script>
        <script type="text/javascript" src="webjars/bootstrap/4.5.3/js/bootstrap.min.js"></script>
    </body>
</html>
