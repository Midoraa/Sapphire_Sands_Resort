<%@ page import="model.entity.Customer" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container-fluid">
    <div class="bg-white mt-5 container">
        <h1 class="mb-4">Chọn<span class="text-primary text-uppercase mx-2">Phòng</span>của bạn</h1>
    </div>
    <div class="container bg-primary text-white mt-5 align-items-center">
        <div class="d-flex">
            <div class="align-self-center mx-5 py-3">
                ${time_in} / ${time_out}
            </div>
            <div class="align-self-center mx-5">${people} người</div>
            <div class="align-self-center mx-5">
                ${room_type}
            </div>
        </div>
    </div>
    <c:forEach var="room" items="${listChoosenRoom}">
        <div class="container bg-body p-0">
            <div class="w-100 mt-5 d-flex justify-content-between">
                <div class="d-flex">
                    <div class="w-25">
                        <div id="${room.roomID}" class="carousel slide" data-bs-ride="carousel">
                            <div class="carousel-inner">
                                <div class="carousel-item active">
                                    <img src="img/room/${room.roomID}-2.jpg" class="d-block w-100" alt="...">
                                </div>
                                <div class="carousel-item">
                                    <img src="img/room/${room.roomID}-1.jpg" class="d-block w-100" alt="...">
                                </div>
                                <div class="carousel-item">
                                    <img src="img/room/${room.roomID}-3.jpg" class="d-block w-100" alt="...">
                                </div>
                            </div>
                            <button class="carousel-control-prev" type="button" data-bs-target="#${room.roomID}" data-bs-slide="prev">
                                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                <span class="visually-hidden">Previous</span>
                            </button>
                            <button class="carousel-control-next" type="button" data-bs-target="#${room.roomID}" data-bs-slide="next">
                                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                <span class="visually-hidden">Next</span>
                            </button>
                        </div>
                    </div>
                    <div class="mt-3 mx-4">
                        <h5 class="">${room.roomName}</h5>
                        <p class=""><i class="fa-solid fa-user px-2"></i>${room.maxPeople}</p>
                        <a href="room_detail?roomID=${room.roomID}" class="text-primary">Xem chi tiết phòng</a>
                    </div>
                </div>
                <div class="text-end p-3">
                    <div>
                        <h2>${room.roomPrice}</h2>
                    </div>
                    <div class="text-danger">USD/night</div>
                    <div class="mt-3">
                        <c:if test="${sessionScope.customer==null}">
                            <a class="btn btn-primary" href="login">Đặt phòng</a>
                        </c:if>
                        <c:if test="${sessionScope.customer != null}">
                                <a class="btn btn-primary" href="confirm_contract?roomID=${room.roomID}&time_in=${time_in}&time_out=${time_out}&people=${people}">Đặt phòng</a>
                        </c:if> 
                    </div>
                </div>
            </div>
        </div>
    </c:forEach>
</div>
