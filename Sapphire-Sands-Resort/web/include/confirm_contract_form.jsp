<%-- 
    Document   : contract_accept_form
    Created on : Jun 14, 2023, 3:32:03 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="container-fluid">
    <div class="m-5">
        <ul class="list-group">
            <li class="list-group-item active">Thông tin hợp đồng</li>
            <li class="list-group-item">${customer.cusName}</li>
            <li class="list-group-item">${accept_room.roomType}</li>
            <li class="list-group-item">${accept_room.roomName}</li>
            <li class="list-group-item">${time_in}</li>
            <li class="list-group-item">${time_out}</li>
            <li class="list-group-item">${people} người</li>
        </ul>
    </div>
    <div class="m-5">
        <a href="home.jsp" class="btn btn-info">Quay lại trang chủ</a>
        <a href="makeorder" type="submit" class="btn btn-warning">Xác nhận thuê phòng</a>
    </div>
</div>