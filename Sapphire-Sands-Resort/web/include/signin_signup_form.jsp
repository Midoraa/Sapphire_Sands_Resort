<%-- 
    Document   : signin_signup
    Created on : Jun 3, 2023, 9:19:19 AM
    Author     : Dinh Hieu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/loginStyle.css" />
        <link rel="stylesheet" href="font-5.8.1/css/all.css"/>
        <title>Login Page</title>
    </head>
    <body>
        <div class="container" id="container">
            <div class="form-container sign-up-container">
                <form action="#">
                    <h1>Create Account</h1>
<!--                    <div class="social-container">
                        <a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
                        <a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
                        <a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
                    </div>-->
                    <!--<span>or use your email for registration</span>-->
                    <input type="text" placeholder="Username" />
                    <input type="email" placeholder="Email" />
                    <input type="password" placeholder="Password" />
                    <button>Sign Up</button>
                </form>
            </div>
            <div class="form-container sign-in-container">
                <form action="#">
                    <h1>Sign in</h1>
<!--                    <div class="social-container">
                        <a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
                        <a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
                        <a href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
                    </div>-->
                    <!--<span>or use your account</span>-->
                    <input type="text" placeholder="Username" />
                    <input type="password" placeholder="Password" />
                    <a href="#">Forgot your password?</a>
                    <button>Sign In</button>
                </form>
            </div>
            <div class="overlay-container">
                <div class="overlay">
                    <div class="overlay-panel overlay-left">
                        <h1>Welcome Back to Sapphire-Sands Resort!</h1>
                        <p>
                            To keep connected with us please login with your personal info
                        </p>
                        <button class="sera" id="signIn">Sign In</button>
                    </div>
                    <div class="overlay-panel overlay-right">
                        <h1>Hello Ladies & Gentlemen!</h1>
                        <p>Enter your personal details and start look for a luxury room</p>
                        <button class="sera" id="signUp">Sign Up</button>
                    </div>
                </div>
            </div>
        </div>

        <script>
            const signUpButton = document.getElementById('signUp');
            const signInButton = document.getElementById('signIn');
            const container = document.getElementById('container');

            signUpButton.addEventListener('click', () =>
                container.classList.add('right-panel-active'));
            signInButton.addEventListener('click', () =>
                container.classList.remove('right-panel-active'));
        </script>
    </body>
</html>

