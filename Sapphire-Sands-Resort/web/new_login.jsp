<%-- 
    Document   : new_login
    Created on : Jun 8, 2023, 5:22:21 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Đăng nhập</title>
        <link rel="stylesheet" href="css/login.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body>
        <section>
            <div class="login-box">
                <form action="login" method="post">
                    <h2>Đăng nhập</h2>
                    <div class="input-box">
                        <span class="icon"><ion-icon name="person"></ion-icon></span>
                        <input type="text" name="username" required autocomplete="off" onkeyup="userName(event)"> 
                        <label>Tên đăng nhập</label>
                    </div>
                    <div class="input-box">
                        <span class="icon"><ion-icon name="lock-closed"></ion-icon></span>
                        <input type="password" name="password" required autocomplete="off" onkeyup="Pass(event)"> 
                        <label>Mật khẩu</label>
                    </div>
                    <div class="remember-forgot d-flex justify-content-between">
                        <label><input type="checkbox" name>Remember me</label>
                        <a href="#">Forgot password</a>
                    </div>
                    <div class="text-warning text-center" id="messText" >${thongbao}</div>
                    <button type="submit" class="btn btn-light" id="loginButton" disabled>Đăng nhập</button>
                    <div class="register-link">
                        <p>Chưa có tài khoản? <a href="customer_register">Đăng ký</a></p>
                    </div>
                </form>
            </div>

        </section>
        <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
        <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    </body>
</html>
<script>
    const loginButton = document.getElementById("loginButton");
    const messText = document.getElementById("messText");
    let usernameLogin = "", passLogin = " ";
    
    function userName(event){
        usernameLogin = event.target.value;
        if(usernameLogin.length === 0){
            messText.textContent = "Vui lòng không để trống !"
        }else if (usernameLogin.length < 3){
            messText.textContent = "Vui lòng nhập tên đăng trên 3 kí tự !"
        }else{
            messText.innerHTML = ""
        }
        checkLogin();
    }
    function Pass(event){
        passLogin = event.target.value;
        
        if(passLogin.length === 0){
            messText.textContent = "Vui lòng không để trống !"
        }else if(passLogin.length < 3){
             messText.textContent = "Vui lòng nhập mật khẩu trên 3 kí tự !"
        }else{
             messText.textContent = ""
        }
        checkLogin();
    }
    function checkLogin(){
        if(usernameLogin.length >= 3 && passLogin.length >= 3){
            loginButton.disabled = false
        }else{
            loginButton.disabled = true;
        }
    }
    
</script>