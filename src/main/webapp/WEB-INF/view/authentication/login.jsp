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
        <title>Login Page</title>
        <style>
            /* Made with love by Mutiullah Samim*/

            @import url('https://fonts.googleapis.com/css?family=Numans');

            html,body{
                background-image: url('images/fashion_login_picture.jpg');
                background-size: cover;
                background-repeat: no-repeat;
                height: 100%;
                font-family: 'Numans', sans-serif;
            }

            .container{
                height: 100%;
                align-content: center;
            }

            .card{
                height: 370px;
                margin-top: auto;
                margin-bottom: auto;
                width: 400px;
                background-color: rgba(0,0,0,0.5) !important;
            }

            .social_icon span{
                font-size: 60px;
                margin-left: 10px;
                color: #FFC312;
            }

            .social_icon span:hover{
                color: white;
                cursor: pointer;
            }

            .card-header h3{
                color: white;
            }

            .social_icon{
                position: absolute;
                right: 20px;
                top: -45px;
            }

            .input-group-prepend span{
                width: 50px;
                background-color: #ffffff;
                color: black;
                border:0 !important;
            }

            input:focus{
                outline: 0 0 0 0  !important;
                box-shadow: 0 0 0 0 !important;

            }

            .remember{
                color: white;
            }

            .remember input
            {
                width: 20px;
                height: 20px;
                margin-left: 15px;
                margin-right: 5px;
            }


            .links{
                color: white;
            }

            .links a{
                margin-left: 4px;
            }

            .glow-on-hover {
                color: white;
                background-color: #ffffff;
                width: 100px;
                border: none;
                outline: none;
                cursor: pointer;
                position: relative;
                bottom: 30px;
                z-index: 0;
                border-radius: 10px;
            }

            .glow-on-hover:before {
                content: '';
                background: linear-gradient(45deg, #ff0000, #ff7300, #fffb00, #48ff00, #00ffd5, #002bff, #7a00ff, #ff00c8, #ff0000);
                position: absolute;
                top: -2px;
                left:-2px;
                background-size: 400%;
                z-index: -1;
                filter: blur(5px);
                width: calc(100% + 4px);
                height: calc(100% + 4px);
                animation: glowing 20s linear infinite;
                opacity: 0;
                transition: opacity .3s ease-in-out;
                border-radius: 10px;
            }

            .glow-on-hover:active {
                color: #000
            }

            .glow-on-hover:active:after {
                background: transparent;
            }

            .glow-on-hover:hover:before {
                opacity: 1;
            }

            .glow-on-hover:after {
                z-index: -1;
                content: '';
                position: absolute;
                width: 100%;
                height: 100%;
                background: #111;
                left: 0;
                top: 0;
                border-radius: 10px;
            }

            @keyframes glowing {
                0% { background-position: 0 0; }
                50% { background-position: 400% 0; }
                100% { background-position: 0 0; }
            }

        </style>
    </head>
    <body>
        <!--        <div align="center">
                    <h3>Please Login</h3>
        <c:if test="${param.error != null}">
            <p>
                <strong>Credentrials are not correct</strong>
            </p>
        </c:if>
        <form:form action="${pageContext.request.contextPath}/authenticate" method="POST" >
            <P>
                USERNAME: 
            </P>
            <P>
                PASSWORD: 
            </P>
            <p>
                <button type="submit">Submit</button>

            </p>
        </form:form>
    </div>-->
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
