$(function() {

   $(".input input").focus(function() {

      $(this).parent(".input").each(function() {
         $("label", this).css({
            "line-height": "18px",
            "font-size": "18px",
            "font-weight": "100",
            "top": "0px"
         })
         $(".spin", this).css({
            "width": "100%"
         })
      });
   }).blur(function() {
      $(".spin").css({
         "width": "0px"
      })
      if ($(this).val() == "") {
         $(this).parent(".input").each(function() {
            $("label", this).css({
               "line-height": "60px",
               "font-size": "24px",
               "font-weight": "300",
               "top": "10px"
            })
         });

      }
   });

   $(".alt-2").click(function() {
      if (!$(this).hasClass('material-button')) {
         $(".shape").css({
            "width": "100%",
            "height": "100%",
            "transform": "rotate(0deg)"
         })

         setTimeout(function() {
            $(".overbox").css({
               "overflow": "initial"
            })
         }, 600)

         $(this).animate({
            "width": "140px",
            "height": "140px"
         }, 500, function() {
            $(".box").removeClass("back");

            $(this).removeClass('active')
         });

         $(".overbox .title").fadeOut(300);
         $(".overbox .input").fadeOut(300);
         $(".overbox .button").fadeOut(300);

         $(".alt-2").addClass('material-buton');
      }

   })

   $(".material-button").click(function() {

      if ($(this).hasClass('material-button')) {
         setTimeout(function() {
            $(".overbox").css({
               "overflow": "hidden"
            })
            $(".box").addClass("back");
         }, 200)
         $(this).addClass('active').animate({
            "width": "700px",
            "height": "700px"
         });

         setTimeout(function() {
            $(".shape").css({
               "width": "50%",
               "height": "50%",
               "transform": "rotate(45deg)"
            })

            $(".overbox .title").fadeIn(300);
            $(".overbox .input").fadeIn(300);
            $(".overbox .button").fadeIn(300);
         }, 700)

         $(this).removeClass('material-button');

      }

      if ($(".alt-2").hasClass('material-buton')) {
         $(".alt-2").removeClass('material-buton');
         $(".alt-2").addClass('material-button');
      }

   });
});
//check diều kiện ở đăng nhập ở JS 
function checkLogin() {
    const userLogin = document.getElementById('userLogin');
    const passwordLogin = document.getElementById('passwordLogin');
    const loginButton = document.getElementById('loginButton');
    const errorText = document.getElementById('errorText');
  
    const user = userLogin.value;
    const password = passwordLogin.value;
  
   
    if (user.length < 5) {
        loginButton.setAttribute("disabled", false);
        errorText.textContent = 'Vui lòng kiểm tra lại tên đăng nhập !';   
        return;
    } 
    if(password.length < 3){
        loginButton.setAttribute("disabled", false);
        errorText.textContent = 'Vui lòng nhập mật khẩu trên 3 kí tự !';   
        return;
    }
        loginButton.removeAttribute("disabled");
        errorText.textContent = '';
}

//Check DK ở Register

function checkRegister() {
    const regname = document.getElementById('regname');
    const regpass = document.getElementById('regpass');
    const reregpass = document.getElementById('reregpass');
    const registerButton = document.getElementById('registerButton');
    const errorTextRegister = document.getElementById('errorTextRegister');
  
    const nameRegister = regname.value;
    const passRegister = regpass.value;
    const rePassRegister = reregpass.value;
    
   
    if (nameRegister.length < 3) {
        registerButton.setAttribute("disabled", false);
        errorTextRegister.textContent = 'Vui lòng kiểm tra lại tên đăng nhập !';   
        return;
    } 
    if(passRegister.length < 3){
        registerButton.setAttribute("disabled", false);
        errorTextRegister.textContent = 'Vui lòng nhập mật khẩu trên 3 kí tự !';   
        return;
    }
    if(rePassRegister != passRegister){
        registerButton.setAttribute("disabled", false);
        errorTextRegister.textContent = 'Mật khẩu nhập không khớp !';   
        return;
    }
        registerButton.removeAttribute("disabled");
        errorTextRegister.textContent = '';
        
}
document.querySelector('#registerButton').addEventListener('click', function (event) {
    event.preventDefault(); // Ngăn chặn việc submit form

    // Hiển thị modal thôngáo đăng ký thành công
    const modal = new bootstrap.Modal(document.getElementById('exampleModal'));
    modal.show();

    setTimeout(function() {
        window.location.href = "login_register.jsp"; 
    }, 3000);
});