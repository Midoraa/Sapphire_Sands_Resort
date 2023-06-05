<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" >
    <head>
        <meta charset="UTF-8">
        <title>Login</title>
        <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
        <link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900&amp;subset=latin,latin-ext'>
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <!-- partial:index.partial.html -->
        <form action="login" method="post">
            <div class="materialContainer">


                <div class="box">

                    <h1 class="text-primary">LOGIN</h1>
                    <c:if test="${sessionScope.account == null}">
                        <h3 style="color: red">${requestScope.ms}</h3>
                    </c:if>
                    <c:if test="${sessionScope.account != null}">
                        <h3 style="color: FEA116 ">${requestScope.error}</h3>
                    </c:if>

                    <div class="input">
                        <label class="text-white" for="name">Username</label>
                        <input class="text-white" type="text" name="username" id="name">
                        <span class="spin"></span>
                    </div>

                    <div class="input">
                        <label class="text-white" for="pass">Password</label>
                        <input class="text-white" type="password" name="password" id="pass">
                        <span class="spin"></span>
                    </div>

                    <div class="button login">
                        <button type="submit" class="text-white"><span>LOGIN</span> <i class="fa fa-check"></i></button>
                    </div>

                    <a href="" class="pass-forgot">Forgot your password?</a>

                </div>
        </form>

        <form action="register" method="post">
            <div class="overbox">
                <div class="material-button alt-2"><span class="shape"></span></div>

                <div class="title">REGISTER</div>

                <div class="input">
                    <label for="regname">Username</label>
                    <input type="text" name="username" id="regname">
                    <span class="spin"></span>
                </div>

                <div class="input">
                    <label for="regpass">Password</label>
                    <input type="password" name="password" id="regpass">
                    <span class="spin"></span>
                </div>

                <div class="input">
                    <label for="reregpass">Repeat Password</label>
                    <input type="password" name="repass" id="reregpass">
                    <span class="spin"></span>
                </div>

                <div class="button">
                    <button type="submit"><span>NEXT</span></button>
                </div>


            </div>

        </div>
    </form>
    <!-- partial -->
    <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
    <script  src="js/loginJS.js"></script>
    </<script src="./js/loginJS.js"></script>
</body>
</html>