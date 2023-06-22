<%-- 
    Document   : service_cart_form
    Created on : Jun 18, 2023, 11:20:13 AM
    Author     : DELL
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="cart-page">
    <style>
        .cart-page {
            position: relative;
            margin-top: 30px;
        }

        .cart-page .cart-page-inner {
            padding: 30px;
            margin-bottom: 30px;
            background: #ffffff;
        }

        .table-responsive {
            display: block;
            width: 100%;
            overflow-x: auto;
            -webkit-overflow-scrolling: touch;
        }

        .cart-page .table {
            width: 100%;
            text-align: center;
            margin-bottom: 0;
        }

        .table-responsive>.table-bordered {
            border: 0;
        }

        .table-bordered {
            border: 1px solid #dee2e6;
        }

        .cart-page .table td {
            font-size: 16px;
            vertical-align: middle;
        }
        .table-bordered td, .table-bordered th {
            border: 1px solid #dee2e6;
        }
        .table td, .table th {
            padding: 0.75rem;
            vertical-align: top;
            border-top: 1px solid #dee2e6;
        }

        .cart a {
            color: #7AB730;
        }

        .cart-page .table .img {
            display: flex;
            align-items: center;
        }
        .cart-page .table .img img {
            max-width: 60px;
            max-height: 60px;
            margin-right: 15px;
        }
        img {
            vertical-align: middle;
            border-style: none;
        }

        .cart-page .table .qty {
            display: inline-block;
            width: 100px;
            font-size: 0;
        }
        .cart-page .table button.btn-minus {
            border-radius: 4px 0 0 4px;
        }
        .cart-page .table button.btn-plus {
            border-radius: 0 4px 4px 0;
        }
        .cart-page .table button {
            width: 30px;
            height: 30px;
            font-size: 14px;
            text-align: center;
            color: #ffffff;
            background: #7AB730;
            border: none;
            border-radius: 4px;
        }
        .cart-page .table input {
            width: 50px;
            height: 30px;
            font-size: 16px;
            color: #ffffff;
            text-align: center;
            background: #333333;
            border: none;
        }

        .cart-page .cart-page-inner {
            padding: 30px;
            margin-bottom: 30px;
            background: #ffffff;
        }
        .row {
            display: -ms-flexbox;
            display: flex;
            -ms-flex-wrap: wrap;
            flex-wrap: wrap;
            margin-right: -15px;
            margin-left: -15px;
        }
        .cart-page .coupon {
            display: flex;
            position: relative;
            width: 100%;
            margin-bottom: 15px;
            font-size: 0;
        }
        .cart-page .coupon input {
            width: calc(100% - 135px);
            height: 40px;
            padding: 0 15px;
            font-size: 16px;
            color: #999999;
            background: #ffffff;
            border: 1px solid #dddddd;
            border-radius: 4px;
            margin-right: 15px;
            transition: all .3s;
        }
        .cart-page .coupon .button {
            width: 120px;
            height: 40px;
            padding: 2px 0;
            font-size: 16px;
            text-align: center;
            color: #7AB730;
            background: #ffffff;
            border: 1px solid #7AB730;
            border-radius: 4px;
        }
        .cart-page .coupon .button:hover{
            background-color: #7AB730;
            color: white;
        }
        .cart-page .cart-summary {
            position: relative;
            width: 100%;
        }
        .cart-page .cart-summary .cart-content {
            padding: 30px;
            background: #f3f6ff;
        }
        .cart-page .cart-summary .cart-content h1 {
            font-size: 22px;
            margin-bottom: 20px;
        }
        .cart-page .cart-summary .cart-content h2 {
            font-size: 20px;
            font-weight: 600;
            padding-top: 12px;
            border-top: 1px solid #dddddd;
            margin: 0;
        }
        .cart-page .cart-summary .cart-btn button:first-child {
            margin-right: 20px;
            color: #7AB730;
            background: #ffffff;
            border: 1px solid #7AB730;
            transition: 200ms;
        }
        .cart-page .cart-summary .cart-btn button:first-child:hover{
            background-color: #7AB730;
            color: white;
        }
        .cart-page .cart-summary .cart-btn button {
            margin-top: 15px;
            width: calc(50% - 15px);
            height: 50px;
            padding: 2px 10px;
            text-align: center;
            color: #ffffff;
            background: #7AB730;
            border: none;
            border-radius: 4px;
            transition: 200ms;
        }
        .cart-page .cart-summary .cart-btn button:hover{
            color: #7AB730;
            background-color: white;
            border: 1px solid #7AB730;
        }

    </style>
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-8">
                <div class="cart-page-inner">
                    <div class="table-responsive">
                        <table class="table table-bordered"> 
                            <thead class="thead-dark">
                                <tr>
                                    <th>Dịch Vụ</th>
                                    <th>Giá</th>
                                    <th>Số Người</th>
                                    <th>Tổng Tiền</th>
                                    <th>Hủy Dịch Vụ</th>
                                </tr>
                            </thead>
                            <tbody class="align-middle">
                            <c:set var="totalItem" value="0"></c:set>
                            <c:set var="totalPrice" value="0"></c:set>

                            <c:forEach items="${listServiceCart}" var="so">

                                <c:set var="totalItem"> ${totalItem+1}</c:set>
                                <tr>
                                    <td>
                                        <div class="img">   
                                            <img src="img/Service/${so.serviceID}.jpg" alt="Image">
                                            <p>${so.serviceName}</p>
                                        </div>
                                    </td>
                                    <td><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${so.servicePrice}"/> VND</td>
                                <td>
                                    <form action="processServiceCart" method="post">
                                        <input name="statusWeb" value="quantity" hidden=""/>
                                        <div class="d-flex justify-content-center">

                                            <button class="btn btn-primary px-2 me-1"
                                                    onclick="this.parentNode.querySelector('input[type=number]').stepDown()" name="num" value="-1">
                                                <i class="fas fa-minus"></i>
                                            </button>

                                            <div class="form-outline">
                                                <input class="form-control text-center" id="quantity" min="1" value="${so.amount}" name="quantity" type="number" 
                                                       onchange="const quantity = document.getElementById('quantity').value;" readonly=""/>

                                            </div>

                                            <button  class="btn btn-primary px-2 ms-2"
                                                     onclick="this.parentNode.querySelector('input[type=number]').stepUp()" name="num" value="1">
                                                <i class="fas fa-plus"></i>
                                            </button>
                                            <input name="serviceID" value="${so.serviceID}" type="text" hidden="" >
                                        </div>                      
                                    </form>   
                                </td>
                                <td><fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${so.servicePrice*so.amount}"/> VND</td>
                                <c:set var="totalPrice">${totalPrice + so.servicePrice*so.amount}</c:set>
                                <td>
                                    <form action = "processServiceCart" method="post">
                                        <input name="statusWeb" value="delete" hidden="">
                                        <input name ="serviceID" value = "${so.serviceID}" type = "hidden">
                                        <button type = "submit"><i class="fa fa-trash"></i></button>
                                    </form>
                                </td>
                                </tr>                                                                    
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="cart-page-inner">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="cart-summary">
                                <div class="cart-content">
                                    <h1>Dịch Vụ Đã Chọn</h1>
                                    <p class="text-danger">Sau khi đặt dịch vụ sẽ không thể hủy vì nhân viên sẽ setup ngay lập tức. Vui lòng xác nhận lại trước khi đặt dịch vụ</p>
                                    <p>Số Lượng Dịch Vụ: <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${totalItem}"/></p>
                                    <p>Tổng Tiền: <fmt:formatNumber type = "number" maxFractionDigits = "3" value = "${totalPrice}"/> VND</p>
                                </div>
                                <!--                                <div class="cart-btn">
                                                                    <div class="container-fluid">
                                                                        <div class="a" style="display: inline-block;">
                                                                            <div class="col-md-5 w-100">
                                                                                <form action="processServiceCart" method="post">
                                                                                    <button type = "submit" name="statusWeb" value="order">Đặt Dịch Vụ</button>
                                                                                </form>
                                                                            </div>
                                                                            <div class="col-md-5 w-100">
                                                                                <form action="service" method="post">
                                                                                    <button type = "submit" name="statusWeb" value="viewService">Xem Dịch Vụ</button>
                                                                                </form>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>-->
                                <div class="cart-btn">

                                    <button type="submit" name="statusWeb" value="order" onclick="window.location.href = 'processServiceCart?statusWeb=order'">Đặt Dịch Vụ</button>

                                    <button type="submit" name="statusWeb" value="viewService" onclick="window.location.href = 'service'">Xem Dịch Vụ</button>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>