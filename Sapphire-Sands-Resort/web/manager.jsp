<%-- 
    Document   : manager
    Created on : Jun 15, 2023, 8:12:09 PM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:if test="${sessionScope.employee.role!=3}">
    <% response.sendRedirect("employee_login");%>
</c:if>

<jsp:useBean class="model.repository.ManagerRepository" scope="page" id="show"></jsp:useBean>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>Manager management</title>
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
        <link href="css/manager.css" rel="stylesheet">
    </head>

    <body>
        <div class="container-fluid position-relative bg-white d-flex p-0">

            <!-- Content Start -->
            <div class="content">
                <!-- Navbar Start -->
                <nav class="navbar navbar-expand bg-light navbar-light sticky-top px-4 py-0">
                    <a href="index.html" class="navbar-brand d-flex d-lg-none me-4">
                        <h2 class="text-primary mb-0"><i class="fa fa-hashtag"></i></h2>
                    </a>
                    <div class="navbar-nav align-items-center ms-auto py-2">
                        <div class="nav-item dropdown">
                            <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">
                                <span class="d-none d-lg-inline-flex">Manager</span>
                            </a>
                            <div class="dropdown-menu dropdown-menu-end bg-light border-0 rounded-0 rounded-bottom m-0">
                                <a href="home.jsp" class="dropdown-item"><i class="fa fa-home me-2"></i>Home</a>
                                <a href="#chart" class="dropdown-item"><i class="fa fa-chart-bar me-2"></i>Charts</a>
                                <a href="#contractManager" class="dropdown-item"><i class="fas fa-tasks me-2"></i>Contract Manager</a>
                                <a href="#managerService" class="dropdown-item"><i class="fas fa-tasks me-2"></i>Service Manager</a>
                                <a href="logout" class="dropdown-item"><i class="fas fa-arrow-circle-right me-2"></i>Log Out</a>
                            </div>
                        </div>
                    </div>
                </nav>
                <!-- Navbar End -->


                <!-- Sale & Revenue Start -->
                <div class="container-fluid pt-4 px-4" id="chart">
                    <div class="row g-4">
                        <div class="col-sm-6 col-xl-3">
                            <div class="bg-light rounded d-flex align-items-center justify-content-between p-4">
                                <i class="fa fa-chart-line fa-3x text-primary"></i>
                                <div class="ms-3">
                                    <p class="mb-2">Today Sale</p>
                                    <h6 class="mb-0">$1234</h6>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6 col-xl-3">
                            <div class="bg-light rounded d-flex align-items-center justify-content-between p-4">
                                <i class="fa fa-chart-bar fa-3x text-primary"></i>
                                <div class="ms-3">
                                    <p class="mb-2">Total Sale</p>
                                    <h6 class="mb-0">$1234</h6>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6 col-xl-3">
                            <div class="bg-light rounded d-flex align-items-center justify-content-between p-4">
                                <i class="fa fa-chart-area fa-3x text-primary"></i>
                                <div class="ms-3">
                                    <p class="mb-2">Today Revenue</p>
                                    <h6 class="mb-0">$1234</h6>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6 col-xl-3">
                            <div class="bg-light rounded d-flex align-items-center justify-content-between p-4">
                                <i class="fa fa-chart-pie fa-3x text-primary"></i>
                                <div class="ms-3">
                                    <p class="mb-2">Total Revenue</p>
                                    <h6 class="mb-0">$1234</h6>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Sale & Revenue End -->


                <!-- Chart Start -->
                <div class="container-fluid pt-2 px-4 pb-5">

                    <div class="row g-4">
                        <div class="col-sm-12 col-xl-6">
                            <div class="bg-light rounded h-100 p-4">
                                <h6 class="mb-4">Khách Quốc Tế</h6>
                                <canvas id="line-chart"></canvas>
                            </div>
                        </div>
                        <div class="col-sm-12 col-xl-6">
                            <div class="bg-light rounded h-100 p-4">
                                <h6 class="mb-4">Doanh Số & Doanh Thu</h6>
                                <canvas id="salse-revenue"></canvas>
                            </div>
                        </div>
                        <div class="col-sm-12 col-xl-6">
                            <div class="bg-light rounded h-100 p-4">
                                <h6 class="mb-4">Đồ Ăn</h6>
                                <canvas id="bar-chart"></canvas>
                            </div>
                        </div>
                        <div class="col-sm-12 col-xl-6">
                            <div class="bg-light rounded h-100 p-4">
                                <h6 class="mb-4">Mức Độ Phát Triển</h6>
                                <canvas id="worldwide-sales"></canvas>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Chart End -->


                <!-- Recent Sales Start -->
                <div class="container-fluid pt-4 px-4 pb-5" id="contractManager">
                    <div class="bg-light text-center rounded p-4">
                        <div class="d-flex align-items-center justify-content-between mb-4">
                            <h6 class="mb-0">Hợp đồng thuê phòng đang chờ xử lý</h6>
                            <!-- <a href="">Show All</a> -->
                        </div>
                        <div class="table-responsive">
                            <table class="table text-start align-middle table-bordered table-hover mb-0">
                                <thead>
                                    <tr class="text-dark">
                                        <th scope="col">ID Khách Hàng</th>
                                        <th scope="col">Thời gian đặt</th>
                                        <th scope="col">Tên Khách Hàng</th>
                                        <th scope="col">ID Phòng </th>
                                        <th scope="col">Ngày thuê</th>
                                        <th scope="col">Ngày trả</th>
                                        <th scope="col">Số người</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${show.getAllPendingContract()}" var="i" >
                                    <tr id="row${i.orderID}">
                                        <td>${i.cusID}</td>
                                        <td>${i.timeRegister}</td>
                                        <td>${i.cusName}</td>
                                        <td>${i.roomID}</td>
                                        <td>${i.timeIn}</td>
                                        <td>${i.timeOut}</td>
                                        <td>${i.people}</td>
                                        <td>
                                            <a class="btn btn-sm btn-primary" href="accept_contract?orderID=${i.orderID}&cusID=${i.cusID}&roomID=${i.roomID}">Chấp nhận</a>
                                            <a class="btn btn-sm btn-danger" href="remove_order?orderID=${i.orderID}&cusID=${i.cusID}">Không chấp nhận</a>                        
                                        </td>
                                    </tr>   
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="container-fluid pt-4 px-4 pb-5" id="contractManager">
                    <div class="bg-light text-center rounded p-4">
                        <div class="d-flex align-items-center justify-content-between mb-4">
                            <h6 class="mb-0">Hợp đồng thuê phòng đã được chấp nhận</h6>
                            <!-- <a href="">Show All</a> -->
                        </div>
                        <div class="table-responsive">
                            <table class="table text-start align-middle table-bordered table-hover mb-0">
                                <thead>
                                    <tr class="text-dark">
                                        <th scope="col">Mã Hóa Đơn</th>
                                        <th scope="col">ID Khách Hàng</th>
                                        <th scope="col">Thời gian đặt</th>
                                        <th scope="col">Tên Khách Hàng</th>
                                        <th scope="col">ID Phòng </th>
                                        <th scope="col">Ngày thuê</th>
                                        <th scope="col">Ngày trả</th>
                                        <th scope="col">Số người</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${show.getAllAcceptedContract()}" var="i" >
                                    <tr id="row${i.orderID}">
                                        <td>${i.orderID}</td>
                                        <td>${i.cusID}</td>
                                        <td>${i.timeRegister}</td>
                                        <td>${i.cusName}</td>
                                        <td>${i.roomID}</td>
                                        <td>${i.timeIn}</td>
                                        <td>${i.timeOut}</td>
                                        <td>${i.people}</td>
                                        <td>
                                            <a class="btn btn-sm btn-primary" href="pay?orderID=${i.orderID}">Thanh toán</a>  
                                        </td>
                                    </tr>   
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="container-fluid pt-4 px-4 pb-5" id="contractManager">
                    <div class="bg-light text-center rounded p-4">
                        <div class="d-flex align-items-center justify-content-between mb-4">
                            <h6 class="mb-0">Hóa đơn đã được thanh toán</h6>
                            <!-- <a href="">Show All</a> -->
                        </div>
                        <div class="table-responsive">
                            <table class="table text-start align-middle table-bordered table-hover mb-0">
                                <thead>
                                    <tr class="text-dark">
                                        <th scope="col">Mã Hóa Đơn</th>
                                        <th scope="col">ID Khách Hàng</th>
                                        <th scope="col">Thời gian đặt</th>
                                        <th scope="col">Tên Khách Hàng</th>
                                        <th scope="col">ID Phòng </th>
                                        <th scope="col">Ngày thuê</th>
                                        <th scope="col">Ngày trả</th>
                                        <th scope="col">Số người</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${show.getAllPaidContract()}" var="i" >
                                    <tr id="row${i.orderID}">
                                        <td>${i.orderID}</td>
                                        <td>${i.cusID}</td>
                                        <td>${i.timeRegister}</td>
                                        <td>${i.cusName}</td>
                                        <td>${i.roomID}</td>
                                        <td>${i.timeIn}</td>
                                        <td>${i.timeOut}</td>
                                        <td>${i.people}</td>
                                    </tr>   
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

                <div class="container-fluid pt-4 px-4 pb-5" id="managerService">
                    <div class="bg-light text-center rounded p-4">
                        <div class="d-flex align-items-center justify-content-between mb-4">
                            <h6 class="mb-0">Quản lý dịch vụ</h6>
                        </div>
                        <div class="table-responsive">
                            <table class="table text-start align-middle table-bordered table-hover mb-0">
                                <thead>
                                    <tr class="text-dark">
                                        <th scope="col"><input class="form-check-input" type="checkbox"></th>
                                        <th scope="col">Mã hoá đơn</th>
                                        <th scope="col">ID Khách Hàng</th>
                                        <th scope="col">Mã dịch vụ</th>
                                        <th scope="col">Tên dịch vụ</th>
                                        <th scope="col">Số lượng</th>
                                        <th scope="col">Thành tiền</th>
                                        <th scope="col"></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td><input class="form-check-input" type="checkbox"></td>
                                        <td>DE12NDa</td>
                                        <td>INV-0123</td>
                                        <td>INV-0123</td>
                                        <td>Cá kho</td>
                                        <td>3</td>
                                        <td>$123</td>
                                        <td>
                                            <a class="btn btn-sm btn-primary" href="">Accept</a>
                                            <a class="btn btn-sm btn-primary" href="">UnAccept</a>                        
                                        </td>
                                    </tr>                           
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <!-- Recent Sales End -->

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
        <script src="js/admin.js"></script>
    </body>

</html>