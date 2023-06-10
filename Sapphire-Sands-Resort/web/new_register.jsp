<%-- 
    Document   : new-register
    Created on : Jun 8, 2023, 6:05:52 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Đăng ký</title>
        <link rel="stylesheet" href="css/register.css">
    </head>
    <body>
        <section class="register-section">
            <div class="login-box">
                <form action="register" method="post">
                    <h2>Đăng Ký</h2>
                    <div class="input-box">
                        <span class="icon"><ion-icon name="person"></ion-icon></span>
                        <input type="text" name="username" required> 
                        <label>Tên đăng nhập</label>
                    </div>
                    <div class="input-box">
                        <span class="icon"><ion-icon name="lock-closed"></ion-icon></span>
                        <input type="password" name="password" required> 
                        <label>Mật khẩu</label>
                    </div>
                    <div class="input-box">
                        <span class="icon"><ion-icon name="lock-closed"></ion-icon></span>
                        <input type="password" required> 
                        <label>Xác nhận mật khẩu</label>
                    </div>
                    <div class="remember-forgot">
                        <a href="#">Quên mật khẩu</a>
                    </div>
                    <button type="submit">Đăng ký</button>
                    <div class="register-link">
                        <p>Đã có tài khoản? <a href="login">Đăng nhập</a></p>
                    </div>
                    <div class="message" style="text-align: center; color: red;">
                        <p>${message}</p>
                    </div>
                </form>
            </div>


        </section>
        <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
        <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
    </body>
</html>