<%-- 
    Document   : payments_form
    Created on : Jun 25, 2023, 9:29:23 AM
    Author     : TRUNG
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.util.Date" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Checkout Start -->
<div class="checkout mt-5">
    <div class="px-5"> 
        <div class="row">
            <div class="col-md-10">
                <div class="billing-address">
                    <h2>Cần Thanh Toán</h2>
                    <div class="row">
                        <div class="table-container">
                            <table class="table table-hover">
                                <thead>
                                    <tr>
                                        <th scope="col">Mã hóa đơn</th>
                                        <th scope="col">Mã Phòng</th>
                                        <th scope="col">Tên Phòng </th>
                                        <th scope="col">Ngày thuê</th>
                                        <th scope="col">Ngày trả</th>
                                        <th scope="col">Số người</th>
                                        <th scope="col">Giá tiền</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${listRoom}" var="r">
                                        <tr>
                                            <td>${r.orderID}</td>
                                            <td>${r.roomID}</td>
                                            <td>${r.roomName}</td>
                                            <td>${r.timeIn}</td>
                                            <td>${r.timeOut}</td>
                                            <td>${r.people}</td>
                                            <td><fmt:formatNumber value="${r.roomPrice*r.dayStay}" pattern="#,##0.###"/></td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>                         
                    </div>
                </div>

                <div class="shipping-address">
                    <div class="row">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th scope="col">Tên Dịch Vụ</th>
                                    <th scope="col">Số Người</th>
                                    <th scope="col">Giá</th>
                                    <th scope="col">Thời gian</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${listService}" var="s">
                                    <tr>
                                        <td class="text-start">${s.serviceName}</td>
                                        <td>${s.amount}</td>
                                        <td><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${s.servicePrice*s.amount}"/></td>
                                        <td>${s.serviceTime}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="row">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th scope="col">Tên Món Ăn</th>
                                    <th scope="col">Số Lượng</th>
                                    <th scope="col">Giá</th>
                                    <th scope="col">Thời gian</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${listFood}" var="f">
                                    <tr>
                                        <td class="text-start">${f.foodName}</td>
                                        <td>${f.amount}</td>
                                        <td><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${f.foodPrice*f.amount}"/></td>
                                        <td>${f.orTime}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="checkout-btn mt-3">
                        <a href="paid_customer?orderID=${orderID}" class="btn btn-primary">Xác Nhận Thanh Toán</a>
                </div>
            </div>
            <div class="col-md-2 bg-light pt-5 ">
                <div class="checkout-summary text-center">
                    <h4>Tổng cộng: <span><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${totalPrice}"/>đ</span></h4>
                </div>
                <div class="mt-5">
                    <h6>Ngân hàng quân đội MBBank</h6>
                    <h6>STK : 0702347748</h6>
                    <h6>NGUYEN QUANG BAO</h6>
                    <h6>Nội dung tin nhắn: [Tên của bạn] thanh toán [Mã hóa đơn]</h6>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Checkout End -->
