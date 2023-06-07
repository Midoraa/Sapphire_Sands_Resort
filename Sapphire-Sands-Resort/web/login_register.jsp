<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" >
    <head>
        <meta charset="UTF-8">
        <title>Login</title>
        <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
        <link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900&amp;subset=latin,latin-ext'>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

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
                        <label class="text-white" for="userLogin">Username</label>
                        <input class="text-white" type="text" name="username" id="userLogin" onkeyup="checkLogin()">
                        <span class="spin"></span>
                    </div>

                    <div class="input">
                        <label class="text-white" for="passwordLogin">Password</label>
                        <input class="text-white" type="password" name="password" id="passwordLogin" onkeyup="checkLogin()">
                        <span class="spin"></span>
                    </div>
                    <div id="errorText" class="error-text text-center text-warning"></div> 
                    <div class="button login">
                        <button type="submit" class="text-white btn btn-primary" id="loginButton" disabled><span>LOGIN</span> <i class="fa fa-check"></i></button>
                    </div>

                    <a href="" class="pass-forgot">Forgot your password?</a>

                </div>
        </form>
        
        <form action="register" method="post" >
            
            <div class="overbox">
                <div class="material-button alt-2"><span class="shape"></span></div>

                <div class="title">REGISTER</div>
                    

                <div class="input">
                    <label for="regname">Username</label>
                    <input type="text" name="username" id="regname" onkeyup="checkRegister()">
                    <span class="spin"></span>
                </div>

                <div class="input">
                    <label for="regpass">Password</label>
                    <input type="password" name="password" id="regpass" onkeyup="checkRegister()">
                    <span class="spin"></span>
                </div>

                <div class="input">
                    <label for="reregpass">Repeat Password</label>
                    <input type="password" name="repass" id="reregpass" onkeyup="checkRegister()">
                    <span class="spin"></span>
                </div>
                <div class="button">
                    <button type="submit" class="btn btn-primary bg-white" id="registerButton" data-bs-toggle="modal" data-bs-target="#exampleModal" disabled><span>NEXT</span></button>
                </div>
            </div>
             
        </div>
           <!--<div id="errorTextRegister" class="error-text text-center text-dark mt-5-"></div>--> 
    </form>
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Đăng ký thành công</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <p>Vui lòng đăng nhập</p>
                    <div class="spinner-grow text-danger" role="status">
                        <span class="visually-hidden">Loading...</span>
                    </div>
                    <div class="spinner-grow text-warning" role="status">
                        <span class="visually-hidden">Loading...</span>
                    </div>
                    <div class="spinner-grow text-info" role="status">
                        <span class="visually-hidden">Loading...</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- partial -->
    <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.min.js"></script>

    <script  src="js/loginJS.js"></script>
</body>
</html>