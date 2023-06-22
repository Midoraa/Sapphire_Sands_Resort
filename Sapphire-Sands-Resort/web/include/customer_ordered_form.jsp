<%-- 
    Document   : customer_ordered_form
    Created on : Jun 21, 2023, 6:44:26 PM
    Author     : DELL
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.util.Date" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- List product -->
<div
    class="container-fluid d-flex wow fadeIn py-5 flex-column"
    data-wow-delay="0.1s">
    <!--Danh sách Phòng-->
    <div class="col-lg-12">
        <div class="bg-light text-center rounded p-4">
            <div
                class="d-flex align-items-center justify-content-between mb-4">
                <h6 class="mb-0">Phòng đã đặt</h6>
            </div>
            <div class="table-responsive">
                <table
                    class="table text-start align-middle table-bordered table-hover mb-0">
                    <thead>
                        <tr class="text-dark">
                            <th scope="col">Loại Phòng</th>
                            <th scope="col">Tên Phòng</th>
                            <th scope="col">Ngày Đăng Ký</th>
                            <th scope="col">Ngày Nhận Phòng</th>
                            <th scope="col">Ngày Trả Phòng</th>
                            <th scope="col">Số Lượng Người</th>
                            <th scope="col">Giá</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listRoom}" var="r">
                            <tr>
                                <td>${r.roomType}</td>
                                <td>${r.roomName}</td>
                                <td>${r.timeRegister}</td>
                                <td>${r.timeIn}</td>
                                <td>${r.timeOut}</td>
                                <td>${r.people}</td>
                                <td><fmt:formatNumber value="${r.roomPrice*r.dayStay}" pattern="#,##0.###"/></td>

                                <td>
                                    <button type="button"
                                            class="btn btn-primary">
                                        HUỶ PHÒNG
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <!--Kết Thúc Danh Sách Phòng-->

    <div class="d-flex py-3">
        <div class="col-lg-7 d-flex flex-column">
            <!--Bắt Đầu Danh Sách Dịch Vụ-->
            <div class=" mx-2">
                <div class="bg-light text-center rounded p-4">
                    <div
                        class="d-flex align-items-center justify-content-between mb-4">
                        <h6 class="mb-0">Danh sách dịch vụ</h6>
                    </div>
                    <div class="table-responsive">
                        <table
                            class="table text-start align-middle table-bordered table-hover mb-0">
                            <thead>
                                <tr class="text-dark text-center">
                                    <th scope="col">Tên Dịch Vụ</th>
                                    <th scope="col">Số Người</th>
                                    <th scope="col">Giá</th>
                                    <th scope="col">Thời gian</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${listService}" var="s">
                                    <tr class="text-center">
                                        <td class="text-start">${s.serviceName}</td>
                                        <td>${s.amount}</td>
                                        <td><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${s.servicePrice*s.amount}"/></td>
                                        <td>${s.serviceTime}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <!--Kết Thúc Danh Sách Dịch Vụ-->

            <!--Bắt Đầu Danh Sách Thức Ăn-->
            <div class="mx-2">       
                <div class="bg-light text-center rounded p-4">
                    <div
                        class="d-flex align-items-center justify-content-between mb-4">
                        <h6 class="mb-0">Danh sách thức ăn</h6>
                    </div>
                    <div class="table-responsive">
                        <table
                            class="table text-start align-middle table-bordered table-hover mb-0">
                            <thead>
                                <tr class="text-dark text-center">

                                    <th scope="col">Tên Món Ăn</th>
                                    <th scope="col">Số Lượng</th>
                                    <th scope="col">Giá</th>
                                    <th scope="col">Thời gian</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${listFood}" var="f">
                                    <tr class="text-center">
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
            </div>
            <!--Kết Thúc Danh Sách Dịch Vụ-->
        </div>
        <div class="col-lg-5 bg-light mx-2">
            sds

            <!-- khúc này để trống cho t degins -->
        </div>
    </div>
</div>
<!-- Product end -->
