<%-- 
    Document   : header
    Created on : May 18, 2023, 4:57:43 PM
    Author     : TRUNG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <link rel="shortcut icon" href="img/sapphire-sands-website-favicon-color.png" type="image/x-icon">
        <title>Sapphire Sands</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="" name="keywords">
        <meta content="" name="description">

        <!-- Favicon -->
        <link href="img/favicon.ico" rel="icon">

        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600;700&family=Montserrat:wght@400;500;600;700&display=swap" rel="stylesheet">  

        <!-- Icon Font Stylesheet -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
              integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
              crossorigin="anonymous" referrerpolicy="no-referrer" />
        <!-- Libraries Stylesheet -->
        <link href="lib/animate/animate.min.css" rel="stylesheet">
        <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
        <link href="lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css" rel="stylesheet" />

        <!-- Customized Bootstrap Stylesheet -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Template Stylesheet -->
        <link href="css/style.css" rel="stylesheet">
    </head>

    <body>
        <div class="container-xxl bg-white p-0">
            <!-- Spinner Start -->
            <div id="spinner" class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
                <div class="spinner-border text-primary" style="width: 3rem; height: 3rem;" role="status">
                    <span class="sr-only">Loading...</span>
                </div>
            </div>
            <!-- Spinner End -->

            <!-- Header Start -->
            <div class="container-fluid bg-dark px-0">
                <div class="row gx-0">
                    <div class="col-lg-3 bg-dark d-none d-lg-block">
                        <a href="home.jsp" class="navbar-brand w-100 h-100 m-0 p-0 d-flex align-items-center justify-content-center">
                            <h2 class="m-0 text-primary text-uppercase">Sapphire Sands</h2>
                        </a>
                    </div>
                    <div class="col-lg-9">
                        <div class="row gx-0 bg-white d-none d-lg-flex">
                            <div class="col-lg-7 px-5 text-start">
                                <div class="h-100 d-inline-flex align-items-center py-2 me-4">
                                    <i class="fa fa-envelope text-primary me-2"></i>
                                    <p class="mb-0">info@fpt.edu.vn</p>
                                </div>
                                <div class="h-100 d-inline-flex align-items-center py-2">
                                    <i class="fa fa-phone-alt text-primary me-2"></i>
                                    <p class="mb-0">+012 345 6789</p>
                                </div>
                            </div>
                            <div class="col-lg-5 px-5 text-end">
                                <div class="d-inline-flex align-items-center py-2">
                                    <a class="me-3" href=""><i class="fab fa-facebook-f"></i></a>
                                    <a class="me-3" href=""><i class="fab fa-twitter"></i></a>
                                    <a class="me-3" href=""><i class="fab fa-linkedin-in"></i></a>
                                    <a class="me-3" href=""><i class="fab fa-instagram"></i></a>
                                    <a class="" href=""><i class="fab fa-youtube"></i></a>
                                </div>
                            </div>
                        </div>
                        <nav class="navbar navbar-expand-lg bg-dark navbar-dark p-3 p-lg-0">
                            <a href="home.jsp" class="navbar-brand d-block d-lg-none">
                                <h1 class="m-0 text-primary text-uppercase">Sapphire Sands Resort</h1>
                            </a>
                            <button type="button" class="navbar-toggler" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
                                <span class="navbar-toggler-icon"></span>
                            </button>
                            <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                                <div class="navbar-nav mr-auto py-0">
                                    <a href="home.jsp" class="nav-item nav-link active">Home</a>
                                    <a href="about.jsp" class="nav-item nav-link">About</a>
                                    <a href="service" class="nav-item nav-link">Services</a>
                                    <a href="room" class="nav-item nav-link">Rooms</a>
                                    <div class="nav-item dropdown">
                                        <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">Pages</a>
                                        <div class="dropdown-menu rounded-0 m-0">
                                            <a href="customer_register.jsp" class="dropdown-item">Become our customer</a>
                                            <a href="employee_login" class="dropdown-item">Đăng nhập nhân sự</a>
                                            <a href="testimonial.jsp" class="dropdown-item">Testimonial</a>
                                        </div>
                                    </div>
                                    <a href="food" class="nav-item nav-link">Foods</a>
                                </div>
                                <c:if test="${sessionScope.customer==null}">
                                    <a href="login" class="btn btn-primary rounded-0 py-4 px-md-5 d-none d-lg-block">Log in <i class="bi bi-arrow-right"></i></a>
                                    </c:if>
                                    <c:if test="${sessionScope.customer!=null}">
                                    <div class="nav-item dropdown">
                                        <a href="#" class="btn btn-primary rounded-0 py-4 px-md-5 d-none d-lg-block" data-bs-toggle="dropdown">${sessionScope.customer.username}</a>
                                        <div class="dropdown-menu m-0">
                                            <a href="infor_user.jsp" class="dropdown-item">Your information</a>
                                            <c:if test="${sessionScope.customer.role == 2}">
                                                <a href="admin.jsp" class="dropdown-item">Admin</a>
                                            </c:if>

                                            <a href="yourcart" class="dropdown-item">Your cart</a>
                                            <a href="logout" class="dropdown-item text-danger">Log out</a>
                                        </div>
                                    </div>
                                </c:if>    
                            </div>
                        </nav>
                    </div>
                </div>
            </div>
            <!-- Header End -->
