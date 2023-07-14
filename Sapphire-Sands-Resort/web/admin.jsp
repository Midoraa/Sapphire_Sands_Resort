<%-- 
    Document   : admin
    Created on : Jun 22, 2023, 5:44:03 AM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:if test="${sessionScope.employee.role!=2}">
    <% response.sendRedirect("employee_login");%>
</c:if>

<jsp:useBean class="model.repository.AdminRepository" scope="page" id="show"></jsp:useBean>
    <!DOCTYPE html>
    <html lang="en">

        <head>
            <meta charset="utf-8">
            <title>Admin-Resort</title>
            <meta content="width=device-width, initial-scale=1.0" name="viewport">
            <meta content="" name="keywords">
            <meta content="" name="description">

            <!-- Favicon -->
            <link href="img/favicon.ico" rel="icon">

            <!-- Google Web Fonts -->
            <link rel="preconnect" href="https://fonts.googleapis.com">
            <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
            <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600;700&display=swap" rel="stylesheet">

            <!-- Icon Font Stylesheet -->
            <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
            <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

            <!-- Libraries Stylesheet -->
            <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
            <link href="lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css" rel="stylesheet" />

            <!-- Customized Bootstrap Stylesheet -->
            <link href="css/bootstrap.min.css" rel="stylesheet">

            <!-- Template Stylesheet -->
            <link href="css/admin.css" rel="stylesheet">

        </head>

        <body>
            <div class="container-fluid position-relative bg-white d-flex p-0">
                <!-- Spinner Start -->
                <div id="spinner" class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
                    <div class="spinner-border text-primary" style="width: 3rem; height: 3rem;" role="status">
                        <span class="sr-only">Loading...</span>
                    </div>
                </div>
                <!-- Spinner End -->


                <!-- Sidebar Start -->
                <div class="sidebar pe-3 pb-3">
                    <nav class="navbar bg-light navbar-light">
                        <a href="index.html" class="navbar-brand mx-4 mb-3">
                            <h3 class="text-primary"><i class="fa fa-hashtag me-2"></i>ADMIN</h3>
                        </a>
                        <div class="d-flex align-items-center ms-4 mb-4">
                            <div class="position-relative">
                                <div class="bg-success rounded-circle border border-2 border-white position-absolute end-0 bottom-0 p-1"></div>
                            </div>
                            <div class="ms-3">
                                <h6 class="mb-0">${sessionScope.employee.empNames}</h6>
                            <span>Admin</span>
                        </div>
                    </div>
                    <div class="navbar-nav w-100">
                        <div class="nav-item dropdown">
                            <a href="#" class="nav-link"><i class="fa fa-home me-2"></i>Home</a>
                        </div>
                        <div class="nav-item dropdown">
                            <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown"><i class="fa fa-keyboard me-2"></i>Create</a>
                            <div class="dropdown-menu bg-transparent border-0">
                                <div class="d-flex align-items-center">
                                    <a href="#" class="dropdown-item" data-bs-toggle="modal" data-bs-target="#staticBackdrop"><i class="far fa-address-card me-2 mx-0"></i>Account Employee</a>
                                </div>
                                <div class="d-flex align-items-center">
                                    <a href="#" class="dropdown-item"  data-bs-toggle="modal" data-bs-target="#staticBackdrop1"><i class="far fa-address-card me-2 mx-0"></i>Account Manager</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </nav>
            </div>
            <!-- Sidebar End -->

            <!-- Popup create account Employee -->
            <form action="create_employee" method="post">
                <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabelEmployee" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header bg-danger ">
                                <div class="text-center">
                                    <h5 class="modal-title " id="staticBackdropLabelEmployee">Create Account Employee</h5>
                                </div>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <div class="">
                                    <div class="container-fluid">
                                        <div class="form-floating mb-3 ms-auto">
                                            <input name="username" type="text" class="form-control w-100" id="usernameEmployee" placeholder="jhondoe" autocomplete="off" onkeyup="checkUser(event)">
                                            <label for="usernameEmployee">Tên Đăng Nhập</label>
                                        </div>
                                        <div class="form-floating mb-3 ms-auto">
                                            <input name="empName" type="text" class="form-control w-100" id="fullName" placeholder="jhondoe" autocomplete="off" onkeyup="checkName(event)">
                                            <label for="fullName">Họ và tên</label>
                                        </div>
                                        <div class="col-md-12 d-flex pb-4">
                                            <label for="">Giới Tính:</label>
                                            <div class="form-check form-switch mx-3">
                                                <input class="form-check-input" type="radio" name="empGender" id="gioitinhNam" value="false" checked >
                                                <label class="form-check-label" for="gioitinhNam">Nam</label>
                                            </div>
                                            <div class="form-check form-switch">
                                                <input class="form-check-input" type="radio" name="empGender" id="gioitinhNu" value="true">
                                                <label class="form-check-label" for="gioitinhNu">Nữ</label>
                                            </div>
                                        </div>
                                        <div class="form-floating mb-3 ms-auto">
                                            <input name="empDOB" type="date" class="form-control w-100" id="DOBEmployee" placeholder="jhondoe" autocomplete="off" onchange="checkDate(event)" required>
                                            <label for="DOBEmployee">Ngày sinh</label>
                                        </div>
                                        <div class="form-floating mb-3 ms-auto">
                                            <input name="empAdress" type="text" class="form-control w-100" id="addressEmployee" placeholder="jhondoe" autocomplete="off" onkeyup="checkAddress(event)">
                                            <label for="addressEmployee">Địa chỉ</label>
                                        </div>
                                        <div class="form-floating mb-3 ms-auto">
                                            <input name="empPhone" type="text" class="form-control w-100" id="telEmployee" placeholder="jhondoe" autocomplete="off" onkeyup="checkTel(event)">
                                            <label for="telEmployee">Số điện thoại</label>
                                        </div>
                                        <div class="form-floating mb-3 ms-auto">
                                            <input name="empEmail" type="email" class="form-control w-100" id="emailEmployee" placeholder="jhondoe" autocomplete="off" onkeyup="checkEmail(event)">
                                            <label for="emailEmployee">Email</label>
                                        </div>
                                        <div class="form-floating mb-3 ms-auto">
                                            <input name="password" type="password" class="form-control w-100" id="passwordEmployee" placeholder="jhondoe" autocomplete="off" onkeyup="checkPass(event)">
                                            <label for="passwordEmployee">Password</label>
                                        </div>
                                        <div class="form-floating mb-3 ms-auto">
                                            <input type="password" class="form-control w-100" id="rePassEmployee" placeholder="jhondoe" autocomplete="off" onkeyup="checkRePass(event)">
                                            <label for="rePassEmployee">Confirm Password</label>
                                        </div>               
                                    </div>
                                </div>
                                <div id="errorText" class="error-text text-center text-warning"></div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                <button type="submit" class="btn btn-primary" id="loginButton" disabled>Create</button>

                            </div>
                        </div>
                    </div>
                </div>
            </form>
            <!-- End Popup create account -->

            <!-- popup create account Manager -->
            <form action="create_manager" method="post">
                <div class="modal fade" id="staticBackdrop1" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabelManager" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header bg-warning">
                                <h5 class="modal-title" id="staticBackdropLabelManager">Create Account Manager</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <div class="">
                                    <div class="container-fluid">
                                        <div class="form-floating mb-3 ms-auto">
                                            <input name="username" type="text" class="form-control w-100" id="usernameManager" placeholder="jhondoe" autocomplete="off" onkeyup="checkUserManager(event)">
                                            <label for="usernameManager">Tên Đăng Nhập</label>
                                        </div>
                                        <div class="form-floating mb-3 ms-auto">
                                            <input name="mngName" type="text" class="form-control w-100" id="fullName" placeholder="jhondoe" autocomplete="off" onkeyup="checkNameManager(event)">
                                            <label for="fullName">Họ và tên</label>
                                        </div>
                                        <div class="col-md-12 d-flex pb-4">
                                            <label for="">Giới Tính:</label>
                                            <div class="form-check form-switch mx-3">
                                                <input class="form-check-input" type="radio" name="mngGender" id="gioitinhNam" value="false" checked >
                                                <label class="form-check-label" for="gioitinhNam">Nam</label>
                                            </div>
                                            <div class="form-check form-switch">
                                                <input class="form-check-input" type="radio" name="mngGender" id="gioitinhNu" value="true">
                                                <label class="form-check-label" for="gioitinhNu">Nữ</label>
                                            </div>
                                        </div>
                                        <div class="form-floating mb-3 ms-auto">
                                            <input name="mngDOB" type="date" class="form-control w-100" id="DOBManager" placeholder="jhondoe" autocomplete="off" onchange="checkDateManager(event)" required>
                                            <label for="DOBManager">Ngày sinh</label>
                                        </div>
                                        <div class="form-floating mb-3 ms-auto">
                                            <input name="mngAdress" type="text" class="form-control w-100" id="address" placeholder="jhondoe" autocomplete="off" onkeyup="checkAddressManager(event)">
                                            <label for="address">Địa chỉ</label>
                                        </div>
                                        <div class="form-floating mb-3 ms-auto">
                                            <input name="mngPhone" type="text" class="form-control w-100" id="tel" placeholder="jhondoe" autocomplete="off" onkeyup="checkTelManager(event)">
                                            <label for="tel">Số điện thoại</label>
                                        </div>
                                        <div class="form-floating mb-3 ms-auto">
                                            <input name="mngEmail" type="email" class="form-control w-100" id="email" placeholder="jhondoe" autocomplete="off" onkeyup="checkEmailManager(event)">
                                            <label for="email">Email</label>
                                        </div>
                                        <div class="form-floating mb-3 ms-auto">
                                            <input name="password" type="password" class="form-control w-100" id="passwordManager" placeholder="jhondoe" autocomplete="off" onkeyup="checkPassManager(event)">
                                            <label for="passwordManager">Password</label>
                                        </div>
                                        <div class="form-floating mb-3 ms-auto">
                                            <input type="password" class="form-control w-100" id="rePassManager" placeholder="jhondoe" autocomplete="off" onkeyup="checkRePassManager(event)">
                                            <label for="rePassManager">Confirm Password</label>
                                        </div>               
                                    </div>
                                </div>
                                <div id="errorTextManager" class="error-text text-center text-warning"></div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                <button type="submit" class="btn btn-primary" id="loginButtonManager" disabled>Create</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
            <!-- end popup create account -->

            <!-- popup create account Employee -->
            <!--            <form action="">
                            <div class="modal fade" id="staticBackdrop2" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabelService" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header bg-light">
                                            <h5 class="modal-title" id="staticBackdropLabelService">Tạo dịch vụ</h5>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">                        
                                            <div class="">
                                                <div class="container-fluid">
                                                    <div class="form-floating mb-3  ms-auto">
                                                        <input type="text" class="form-control w-100" id="floatingText" placeholder="jhondoe" autocomplete="off" onkeyup="checkService(event)">
                                                        <label for="floatingText">Tên Dịch Vụ</label>
                                                    </div>
                                                    <div class="form-floating mb-3  ms-auto">
                                                        <input type="text" class="form-control w-100" id="floatingText" placeholder="jhondoe" autocomplete="off" onkeyup="checkPriceService(event)">
                                                        <label for="floatingText">Giá Dịch Vụ</label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div id="errorTextService" class="error-text text-center text-warning"></div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                            <button type="submit" class="btn btn-primary" id="createButtonService">Create</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form>-->
            <!-- end popup create account -->

            <!-- Content Start -->
            <div class="content">
                <!-- Navbar Start -->
                <nav class="navbar navbar-expand bg-light navbar-light sticky-top px-4 py-0">
                    <div class="navbar-nav align-items-center ms-auto">
                        <div class="nav-item dropdown">
                            <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">
                                <span class="d-none d-lg-inline-flex">${sessionScope.employee.empNames}</span>
                            </a>
                            <div class="dropdown-menu dropdown-menu-end bg-light border-0 rounded-0 rounded-bottom m-0">
                                <!--                                <a href="views-service.html" class="dropdown-item">My Profile</a>-->
                                <a href="home.jsp" class="dropdown-item">Home</a>
                                <a href="logout" class="dropdown-item">Log Out</a>
                            </div>
                        </div>
                    </div>
                </nav>
                <!-- Navbar End -->


                <!--                 List Service 
                                <div class="container-fluid pt-4 px-4 pb-3">
                                    <div class="bg-light text-center rounded p-4">
                                        <div class="d-flex align-items-center justify-content-between mb-4">
                                            <h6 class="mb-0">Danh sách dịch vụ</h6>
                                             <a href="">Show All</a> 
                                        </div>
                                        <div class="table-responsive">
                                            <table class="table text-start align-middle table-bordered table-hover mb-0">
                                                <thead>
                                                    <tr class="text-dark">
                                                        <th scope="col"><input class="form-check-input" type="checkbox"></th>
                                                        <th scope="col">Mã Dịch Vụ</th>
                                                        <th scope="col">Tên Dịch Vụ</th>
                                                        <th scope="col">Giá</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <td><input class="form-check-input" type="checkbox"></td>
                                                        <td>SV000001</td>
                                                        <td>Dịch vụ Karaoke</td>
                                                        <td>100000</td>
                                                        <td>
                                                            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                                                                Update
                                                            </button>
                                                            <button type="button" class="btn btn-primary">
                                                                Delete
                                                            </button>                  
                                                        </td>
                                                    </tr>                           
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                                 Popup update Service 
                                <form action="">
                                    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header bg-info">
                                                    <h5 class="modal-title" id="exampleModalLabel">Cập Nhập Dịch Vụ</h5>
                                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                </div>
                                                <div class="modal-body">
                
                                                    <div class="col-md">
                                                        <div class="container-fluid">
                                                            <div class="form-floating mb-3  ms-auto">
                                                                <input type="text" class="form-control w-100" id="nameService" placeholder="jhondoe" autocomplete="off" onkeyup="updateNameService(event)">
                                                                <label for="nameService">Tên Dịch Vụ</label>
                                                            </div>
                                                            <div class="form-floating mb-3  ms-auto">
                                                                <input type="text" class="form-control w-100" id="price" placeholder="jhondoe" autocomplete="off" onkeyup="priceServiceUpdate(event)">
                                                                <label for="price">Giá</label>
                                                            </div>
                                                        </div>
                                                    </div>
                
                                                </div>
                                                <div id="messageServiceUpdate" class="error-text text-center text-warning"></div>
                                                <div class="modal-footer">                            
                                                    <button type="submit" class="btn btn-primary" id="updateButtonService" disabled>Lưu Thay Đổi</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </form>  
                                 Recent Sales End -->

                <!-- List nhân sự, khách hàng -->


                <div class="container-fluid pt-4 px-4 pb-3">
                    <div class="bg-light text-center rounded p-4">
                        <div class="d-flex align-items-center justify-content-between mb-4">
                            <h6 class="mb-0">Danh sách Nhân viên</h6>
                            <!-- <a href="">Show All</a> -->
                        </div>
                        <div class="table-responsive">
                            <table class="table text-start align-middle table-bordered table-hover mb-0">
                                <thead>
                                    <tr class="text-dark">
                                        <th scope="col">Mã Nhân Viên</th>
                                        <th scope="col">Họ Tên</th>
                                        <th scope="col">Giới Tính</th>
                                        <th class="w-25" scope="col">Ngày Sinh</th>
                                        <th scope="col">Số Điện Thoại</th>
                                        <th scope="col">Email</th>
                                        <th scope="col">Username</th>
                                        <th scope="col">Password</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${show.getAllEmployee()}" var="i" >
                                        <tr id="row${i.empID}">
                                            <td>${i.empID}</td>
                                            <td>${i.empNames}</td>
                                            <td>${i.empGender}</td>
                                            <td>${i.empDOB}</td>
                                            <td>${i.empPhone}</td>
                                            <td>${i.empEmail}</td>
                                            <td>${i.username}</td>
                                            <td>${i.password}</td>
                                            <td class="d-flex flex-column">
                                                <button type="button" class="btn btn-primary m-1" data-empid="${i.empID}" data-bs-toggle="modal" data-bs-target="#exampleModal2">
                                                    Update
                                                </button>
                                                <button type="button" class="btn btn-danger m-1" onclick="deleteEmp('${i.empID}')">
                                                    Delete
                                                </button>                        
                                            </td>
                                        </tr>   
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <!-- Popup update Employee -->
                <form action="update_employee" method="post">
                    <div class="modal fade" id="exampleModal2" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header bg-primary">
                                    <h5 class="modal-title" id="exampleModalLabel">Cập Nhập Nhân Viên</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body">                             
                                    <div class="col-md">
                                        <div class="container-fluid">
                                            <input name="empID" type="text" class="form-control w-100" id="empIdInput" placeholder="jhondoe" autocomplete="off" hidden>
                                            <div class="form-floating mb-3  ms-auto">
                                                <input name="empName" type="text" class="form-control w-100" id="floatingText" placeholder="jhondoe" autocomplete="off" onkeyup="updateManagerName(event)">
                                                <label for="floatingText">Họ và tên</label>
                                            </div>
                                            <div class="col-md-12 d-flex pb-4">
                                                <label for="">Giới Tính:</label>
                                                <div class="form-check form-switch mx-3">
                                                    <input class="form-check-input" type="radio" name="empGender" id="gioitinhNam" value="true" v-model="gender" checked>
                                                    <label class="form-check-label" for="gioitinhNam">Nam</label>
                                                </div>
                                                <div class="form-check form-switch">
                                                    <input class="form-check-input" type="radio" name="empGender" id="gioitinhNu" v-model="gender" value="false">
                                                    <label class="form-check-label" for="gioitinhNu">Nữ</label>
                                                </div>
                                            </div>
                                            <div class="form-floating mb-3  ms-auto">
                                                <input name="empDOB" type="date" class="form-control w-100" id="floatingText" placeholder="jhondoe" autocomplete="off" onchange="checkUpdateDateManager(event)">
                                                <label for="floatingText">Ngày sinh</label>
                                            </div>
                                            <div class="form-floating mb-3 ms-auto">
                                                <input name="empAdress" type="text" class="form-control w-100" id="floatingText" placeholder="jhondoe" autocomplete="off" onkeyup="updateAddressManager(event)">
                                                <label for="floatingText">Địa chỉ</label>
                                            </div>
                                        </div>
                                        <div class="container-fluid">
                                            <div class="form-floating mb-3 ms-auto">
                                                <input name="empPhone" type="text" class="form-control w-100" id="floatingText" placeholder="jhondoe" autocomplete="off" onkeyup="updatePhoneManager(event)">
                                                <label for="floatingText">Số Điện Thoại</label>
                                            </div>
                                            <div class="form-floating mb-3 ms-auto">
                                                <input name="empEmail" type="text" class="form-control w-100" id="floatingText" placeholder="jhondoe" autocomplete="off" onkeyup="updateEmailManager(event)">
                                                <label for="floatingText">Email</label>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div id="messageManagerUpdate" class="error-text text-center text-warning"></div>
                                <div class="modal-footer">
                                    <button type="submit" class="btn btn-primary" id="updateButtonManager" disabled>Lưu Thay Đổi</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>

                <div class="container-fluid pt-4 px-4 pb-3">
                    <div class="bg-light text-center rounded p-4">
                        <div class="d-flex align-items-center justify-content-between mb-4">
                            <h6 class="mb-0">Danh sách Quản lý</h6>
                            <!-- <a href="">Show All</a> -->
                        </div>
                        <div class="table-responsive">
                            <table class="table text-start align-middle table-bordered table-hover mb-0">
                                <thead>
                                    <tr class="text-dark">
                                        <th scope="col">Mã Nhân Viên</th>
                                        <th scope="col">Họ Tên</th>
                                        <th scope="col">Giới Tính</th>
                                        <th scope="col">Ngày Sinh</th>
                                        <th scope="col">Số Điện Thoại</th>
                                        <th scope="col">Email</th>
                                        <th scope="col">Username</th>
                                        <th scope="col">Password</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${show.getAllManager()}" var="i" >
                                        <tr id="row${i.empID}">
                                            <td>${i.empID}</td>
                                            <td>${i.empNames}</td>
                                            <td>${i.empGender}</td>
                                            <td>${i.empDOB}</td>
                                            <td>${i.empPhone}</td>
                                            <td>${i.empEmail}</td>
                                            <td>${i.username}</td>
                                            <td>${i.password}</td>
                                            <td class="d-flex flex-column">
                                                <button type="button" class="btn btn-primary m-1" data-manager-id="${i.empID}" data-bs-toggle="modal" data-bs-target="#exampleModal3">
                                                    Update
                                                </button>
                                                <button type="button" class="btn btn-danger m-1" onclick="deleteEmp('${i.empID}')">
                                                    Delete
                                                </button>                        
                                            </td>
                                        </tr>    
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

                <!-- Popup cập nhật nhân viên -->
                <form action="update_employee" method="post">
                    <div class="modal fade" id="exampleModal3" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header bg-warning">
                                    <h5 class="modal-title" id="exampleModalLabel">Cập Nhật Quản Lý</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body">               
                                    <div class="container-fluid">
                                        <input name="empID" type="text" class="form-control w-100" id="managerIdInput" placeholder="jhondoe" autocomplete="off" hidden>
                                        <div class="form-floating mb-3 ms-auto">
                                            <input name="empName" type="text" class="form-control w-100" id="floatingText" placeholder="jhondoe" autocomplete="off" onkeyup="updateEmployeeName(event)">
                                            <label for="floatingText">Họ và tên</label>
                                        </div>
                                        <div class="col-md-12 d-flex pb-4">
                                            <label for="">Giới Tính:</label>
                                            <div class="form-check form-switch mx-3">
                                                <input class="form-check-input" type="radio" name="empGender" id="gioitinhNam" value="false" checked>
                                                <label class="form-check-label" for="gioitinhNam">Nam</label>
                                            </div>
                                            <div class="form-check form-switch">
                                                <input class="form-check-input" type="radio" name="empGender" id="gioitinhNu"  value="true">
                                                <label class="form-check-label" for="gioitinhNu">Nữ</label>
                                            </div>
                                        </div>
                                        <div class="form-floating mb-3 ms-auto">
                                            <input name="empDOB" type="date" class="form-control w-100" id="floatingText" placeholder="jhondoe" autocomplete="off" onchange="updateEmployeeDate(event)">
                                            <label for="floatingText">Ngày sinh</label>
                                        </div>
                                        <div class="form-floating mb-3 ms-auto">
                                            <input name="empAdress" type="text" class="form-control w-100" id="floatingText" placeholder="jhondoe" autocomplete="off" onkeyup="updateEmployeeAddress(event)">
                                            <label for="floatingText">Địa chỉ</label>
                                        </div>
                                    </div>
                                    <div class="container-fluid">
                                        <div class="form-floating mb-3 ms-auto">
                                            <input name="empPhone" type="text" class="form-control w-100" id="floatingText" placeholder="jhondoe" autocomplete="off" onkeyup="updateEmployeePhone(event)">
                                            <label for="floatingText">Số Điện Thoại</label>
                                        </div>
                                        <div class="form-floating mb-3 ms-auto">
                                            <input name="empEmail" type="text" class="form-control w-100" id="floatingText" placeholder="jhondoe" autocomplete="off" onkeyup="updateEmployeeEmail(event)">
                                            <label for="floatingText">Email</label>
                                        </div>
                                    </div>
                                </div>
                                <div id="messageEmployeeUpdate" class="error-text text-center text-warning"></div>
                                <div class="modal-footer">
                                    <button type="submit" class="btn btn-primary" id="updateEmployeeButton" disabled>Lưu Thay Đổi</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
                <!-- Kết thúc Cập nhật nhân viên -->


                <div class="container-fluid pt-4 px-4 pb-3">
                    <div class="bg-light text-center rounded p-4">
                        <div class="d-flex align-items-center justify-content-between mb-4">
                            <h6 class="mb-0">Danh sách Khách Hàng</h6>
                        </div>
                        <div class="table-responsive">
                            <table class="table text-start align-middle table-bordered table-hover mb-0">
                                <thead>
                                    <tr class="text-dark">
                                        <th scope="col">Mã Khách Hàng</th>
                                        <th scope="col">Tên Khách Hàng</th>
                                        <th scope="col">Ngày Sinh</th>
                                        <th scope="col">Số Điện Thoại</th>
                                        <th scope="col">Email</th>
                                        <th scope="col">CCCD</th>
                                        <th scope="col">Type</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${show.getAllCustomer()}" var="i" >
                                        <tr id="row${i.cusID}">
                                            <td>${i.cusID}</td>
                                            <td>${i.cusName} </td>
                                            <td>${i.cusDOB}</td>
                                            <td>${i.cusPhone}</td>
                                            <td>${i.cusEmail}</td>
                                            <td>${i.cusCCCD}</td>
                                            <td>${i.cusCCCD == 1 ? "Nước Ngoài" : "Việt Nam"}</td>
                                        </tr>   
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>

            <!-- JavaScript Libraries -->
            <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
            <script src="lib/chart/chart.min.js"></script>
            <script src="lib/easing/easing.min.js"></script>
            <script src="lib/waypoints/waypoints.min.js"></script>
            <script src="lib/owlcarousel/owl.carousel.min.js"></script>
            <script src="lib/tempusdominus/js/moment.min.js"></script>
            <script src="lib/tempusdominus/js/moment-timezone.min.js"></script>
            <script src="lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

            <!-- Template Javascript -->
            <script src="js/main.js"></script>
            <script src="js/check-all-input.js"></script> 
            <script>
                function deleteEmp(id) {
                    $.ajax({
                    url: '/sapphire_sands_resort/delete_emp',
                    type: 'GET',
                    data: {
                    id: id,
                    },
                    success: function (data) {
                    document.getElementById("row" + id).remove();
                    }
                    });
                    }

                            // Lấy thẻ modal trong DOM
                const modal = document.getElementById('exampleModal2');

                // Khi modal hiển thị, lấy giá trị empID từ button và thực hiện các thao tác cần thiết
                modal.addEventListener('show.bs.modal', function(event) {
                    const button = event.relatedTarget; // Button được nhấn để mở modal
                    const empId = button.getAttribute('data-empid'); // Lấy giá trị empID từ thuộc tính data-empid

                    // Thực hiện các thay đổi cần thiết với empId
                    // Ví dụ: gán giá trị empId vào một trường input trong modal
                    const empIdInput = document.getElementById('empIdInput');
                    empIdInput.value = empId;
                });    
                
                
                const modall = document.getElementById('exampleModal3');
                modall.addEventListener('show.bs.modal', function(event) {
                    const button = event.relatedTarget; // Button được nhấn để mở modal
                    const managerId = button.getAttribute('data-manager-id'); // Lấy giá trị empID từ thuộc tính data-empid

                    // Thực hiện các thay đổi cần thiết với empId
                    // Ví dụ: gán giá trị empId vào một trường input trong modal
                    const managerIdInput = document.getElementById('managerIdInput');
                    managerIdInput.value = managerId;
                });    
            </script>
    </body>
</html>