<%-- 
    Document   : food_form
    Created on : Jun 5, 2023, 5:14:23 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container-fluid page-header mb-5 p-0" style="background-image: url(img/carousel-1.jpg);">
    <div class="container-fluid page-header-inner py-5">
        <div class="container text-center pb-5">
            <h1 class="display-3 text-white mb-3 animated slideInDown">Food & Restaurant</h1>
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb justify-content-center text-uppercase">
                    <li class="breadcrumb-item"><a href="#">Home</a></li>
                    <li class="breadcrumb-item"><a href="#">Pages</a></li>
                    <li class="breadcrumb-item"><a href="#">Services</a></li>
                    <li class="breadcrumb-item text-white active" aria-current="page">Food & Restaurant</li>
                </ol>
            </nav>
        </div>
    </div>
</div>
<!-- Page Header End -->
<!-- Food Start -->
<div class="container-xxl py-5">
    <div class="container">
        <div class="text-center wow fadeInUp" data-wow-delay="0.1s">
            <h6 class="section-title text-center text-primary text-uppercase">Our Food & Restaurant</h6>
            <h1 class="mb-5">Explore Our <span class="text-primary text-uppercase">Food & Restaurant</span></h1>
            <c:if test="${sessionScope.customer == null}">
                <a class="btn btn-outline-dark mt-auto" href="login"><i class="bi bi-cart"></i></a>
                </c:if>
                <c:if test="${sessionScope.customer != null}">
                <a class="btn btn-outline-dark mt-auto" href="foodcart"><i class="bi bi-cart"></i></a>
                </c:if> 

        </div>
        <div class="row g-4">
            <section class="py-5">
                <div class="container px-4 px-lg-5 mt-5">
                    <div id="content" class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                        <c:forEach items="${listFood}" var="f" begin="${begin}" end="${end}">
                            <div class="col mb-5">
                                <div class="card h-100" style="box-shadow: 2px 2px 15px 0 rgba(0, 0, 0, 0.19)">
                                    <!-- Product image-->
                                    <img class="card-img-top" src="img/${f.foodID}.jpg" alt="img/${f.foodID}.jpg" style="height: 85%;"/>
                                    <!-- Product details-->

                                    <!--<form action="food" method="post">-->
                                    <div class="card-body p-4">
                                        <div class="text-center">
                                            <!-- Product name-->
                                            <a href="#" style="text-decoration: none; color: black" >
                                                <h5 class="fw-bolder">${f.foodName}</h5>
                                            </a>
                                            <!-- Product price-->
                                            <div class="price" style="padding: 10%">
                                                <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${f.foodPrice}"/> VND
                                            </div>
                                        </div>
                                    </div>
                                    <!-- Product actions-->
                                    <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                        <div class="text-center">
                                            <c:if test="${sessionScope.customer == null}">
                                                <a class="btn btn-primary" href="login">Gọi Món</a>
                                            </c:if>
                                            <c:if test="${sessionScope.customer != null}">
                                                <a class="btn btn-outline-dark mt-auto" id="input" href="food?foodID=${f.foodID}&quantity=1">Gọi Món</a>
                                            </c:if> 

                                            <!--<button class="btn btn-outline-dark mt-auto" id="input" type="summit"> Gọi Món </button>-->

                                        </div>
                                    </div>

                                </div>
                            </div>
                        </c:forEach>

                        <div class="row justify-content-center">
                            <div class="col-12">

                                <a class="btn btn-primary" href="food"> << </a>

                                <a class="btn btn-primary" href="food?page=${(page != 1) ? page-1 : 1}"> < </a>

                                <a class="btn btn-primary" href="food?page=${page}"> ${page} </a>

                                <a class="btn btn-primary" href="food?page=${(page != maxPage) ? page+1 : maxPage}"> > </a>

                                <a class="btn btn-primary" href="food?page=${maxPage}"> >> </a>

                            </div>
                        </div>
                    </div>
                </div>

            </section>
        </div>
    </div>
</div><!--
<!-- Food End -->


<!-- Testimonial Start -->
<div class="container-xxl testimonial mt-5 py-5 bg-dark wow zoomIn" data-wow-delay="0.1s" style="margin-bottom: 90px;">
    <div class="container">
        <div class="owl-carousel testimonial-carousel py-5">
            <div class="testimonial-item position-relative bg-white rounded overflow-hidden">
                <p>Tempor stet labore dolor clita stet diam amet ipsum dolor duo ipsum rebum stet dolor amet diam stet. Est stet ea lorem amet est kasd kasd et erat magna eos</p>
                <div class="d-flex align-items-center">
                    <img class="img-fluid flex-shrink-0 rounded" src="img/testimonial-1.jpg" style="width: 45px; height: 45px;">
                    <div class="ps-3">
                        <h6 class="fw-bold mb-1">Client Name</h6>
                        <small>Profession</small>
                    </div>
                </div>
                <i class="fa fa-quote-right fa-3x text-primary position-absolute end-0 bottom-0 me-4 mb-n1"></i>
            </div>
            <div class="testimonial-item position-relative bg-white rounded overflow-hidden">
                <p>Tempor stet labore dolor clita stet diam amet ipsum dolor duo ipsum rebum stet dolor amet diam stet. Est stet ea lorem amet est kasd kasd et erat magna eos</p>
                <div class="d-flex align-items-center">
                    <img class="img-fluid flex-shrink-0 rounded" src="img/testimonial-2.jpg" style="width: 45px; height: 45px;">
                    <div class="ps-3">
                        <h6 class="fw-bold mb-1">Client Name</h6>
                        <small>Profession</small>
                    </div>
                </div>
                <i class="fa fa-quote-right fa-3x text-primary position-absolute end-0 bottom-0 me-4 mb-n1"></i>
            </div>
            <div class="testimonial-item position-relative bg-white rounded overflow-hidden">
                <p>Tempor stet labore dolor clita stet diam amet ipsum dolor duo ipsum rebum stet dolor amet diam stet. Est stet ea lorem amet est kasd kasd et erat magna eos</p>
                <div class="d-flex align-items-center">
                    <img class="img-fluid flex-shrink-0 rounded" src="img/testimonial-3.jpg" style="width: 45px; height: 45px;">
                    <div class="ps-3">
                        <h6 class="fw-bold mb-1">Client Name</h6>
                        <small>Profession</small>
                    </div>
                </div>
                <i class="fa fa-quote-right fa-3x text-primary position-absolute end-0 bottom-0 me-4 mb-n1"></i>
            </div>
        </div>
    </div>
</div>  