<%-- 
    Document   : room_form
    Created on : May 18, 2023, 5:48:11 PM
    Author     : TRUNG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>--%>
<!-- Page Header Start -->
<div class="container-fluid page-header mb-5 p-0" style="background-image: url(img/carousel-1.jpg);">
    <div class="container-fluid page-header-inner py-5">
        <div class="container text-center pb-5">
            <h1 class="display-3 text-white mb-3 animated slideInDown">Rooms</h1>
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb justify-content-center text-uppercase">
                    <li class="breadcrumb-item"><a href="#">Home</a></li>
                    <li class="breadcrumb-item"><a href="#">Pages</a></li>
                    <li class="breadcrumb-item text-white active" aria-current="page">Rooms</li>
                </ol>
            </nav>
        </div>
    </div>
</div>
<!-- Page Header End -->
<!-- Room Start -->
<div class="container-xxl pt-5">
    <div class="container">
        <div class="text-center wow fadeInUp" data-wow-delay="0.1s">
            <h6 class="section-title text-center text-primary text-uppercase">Our Rooms</h6>
            <h2 class="mb-5"><span class="text-primary text-uppercase">Phòng, suite, penthouse và biệt thự sang
                    trọng</span></h2>
        </div>
        <div class="row g-4">

            <c:forEach var="room" items="${listRoom}">
                <div class="card col-lg-4 col-md-6 wow fadeInUp border-0">
                    <div class="room-item shadow rounded overflow-hidden">
                        <div class="position-relative mb-3">
                            <img class="img-fluid" src="img/room/${room.roomID}-3.jpg" alt="">
                            <small
                                class="position-absolute start-0 top-100 translate-middle-y bg-primary text-white rounded py-1 px-3 ms-4">${room.roomPrice}/Night</small>
                        </div>
                        <div class="card-body mb-3">
                            <div class="d-flex justify-content-between">
                                <h5 class="card-title">${room.roomType}</h5>
                                <div class="ps-2 ">
                                    <small class="fa fa-star text-primary"></small>
                                    <small class="fa fa-star text-primary"></small>
                                    <small class="fa fa-star text-primary"></small>
                                    <small class="fa fa-star text-primary"></small>
                                    <small class="fa fa-star text-primary"></small>
                                </div>
                            </div>
                            <p class="card-text" style="height: 48px;">${room.roomName}</p>
                            <a href="room_detail?roomID=${room.roomID}" class="btn btn-primary">Khám phá ngay</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>

