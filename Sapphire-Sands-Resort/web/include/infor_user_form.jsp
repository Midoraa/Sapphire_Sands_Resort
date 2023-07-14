<%-- 
    Document   : infor_user_form
    Created on : Jul 9, 2023, 10:20:52 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:if test="${sessionScope.customer==null}">
    <% response.sendRedirect("login");%>
</c:if>
<!DOCTYPE html>
<div class="container mt-5">
    <h1>Thông tin người dùng</h1>
    <form method="post" action="update_infor_user">
        <div class="row py-3" style="border: 1px solid black">
            <div class="col-md-6">
                <input name="cusID" type="text" class="form-control" id="id" value="${sessionScope.customer.cusID}" readonly hidden>
                <div class="form-group mb-3">
                    <label class="mx-3 mb-1" for="name">Tên khách hàng:</label>
                    <input name="cusName" type="text" class="form-control" id="name" value="${sessionScope.customer.cusName}" readonly>
                </div>
                <div class="form-group mb-3">
                    <label class="mx-3 mb-1" for="dob">Ngày sinh:</label>
                    <input name="cusDOB" type="date" class="form-control" id="dob" value="${sessionScope.customer.cusDOB}" readonly>
                </div>
                <div class="form-group mb-3">
                    <label class="mx-3 mb-1" for="phone">Số điện thoại:</label>
                    <input name="cusPhone" type="text" class="form-control" id="phone" value="${sessionScope.customer.cusPhone}" readonly>
                </div>
                <div class="form-group mb-3">
                    <label class="mx-3 mb-1" for="email">Email:</label>
                    <input name="cusEmail" type="email" class="form-control" id="email" value="${sessionScope.customer.cusEmail}" readonly>
                </div>
            </div>
            <div class="col-md-6">
                
                <div class="form-group mb-3">
                    <label class="mx-3 mb-1" for="cccd">Số căn cước:</label>
                    <input name="cusCCCD" type="text" class="form-control" id="cccd" value="${sessionScope.customer.cusCCCD}" readonly>
                </div>
                <div class="form-group mb-3">
                    <label class="mx-3 mb-1" for="type">Loại khách:</label>
                    <input name="cusType" type="text" class="form-control" id="type" value="${sessionScope.customer.cusType == 1 ? "Việt Nam" : "Nước Ngoài"}" readonly>
                </div>
                <div class="form-group mb-3">
                    <label class="mx-3 mb-1" for="username">Tên đăng nhập:</label>
                    <input name="username" type="text" class="form-control" id="username" value="${sessionScope.customer.username}" readonly>
                </div>
                <div class="form-group mb-3">
                    <label class="mx-3 mb-1" for="password">Mật khẩu:</label>
                    <input name="password" type="text" class="form-control" id="password" value="${sessionScope.customer.password}" readonly>
                </div>
            </div>
            <div class="mt-3">
                <button class="btn btn-primary" id="btnUpdate" onclick="enableEdit()">Cập nhật thông tin</button>
                <button class="btn btn-success" id="btnSave" onclick="submitForm()" type="submit" disabled>Lưu và đăng nhập lại</button>
            </div>
        </div>
    </form>
</div>

<script>
    function enableEdit() {
        document.getElementById("phone").readOnly = false;
        document.getElementById("email").readOnly = false;
        document.getElementById("username").readOnly = false;
        document.getElementById("password").readOnly = false;
        document.getElementById("btnUpdate").disabled = true;
        document.getElementById("btnSave").disabled = false;
    }
</script>