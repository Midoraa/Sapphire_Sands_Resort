<%-- 
    Document   : InformationE_form
    Created on : Jun 7, 2023, 11:15:24 PM
    Author     : TRUNG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Table Start -->
            <div class="container-fluid pt-4 px-4 pb-5">
                <div class="row g-4">
                    <div class="col-12 style-fs">
                        <div class="bg-light rounded h-100 p-4">
                            <h6 class="mb-4">Information Employee</h6>
                            <div class="table-responsive">
                                <table class="table table-hover">
                                    <thead>
                                        <tr>
                                            <th scope="col">ID</th>
                                            <th scope="col">Họ Tên</th>
                                            <th scope="col">Giới Tính</th>
                                            <th scope="col">DOB</th>
                                            <th scope="col">Địa Chỉ</th>
                                            <th scope="col">SDT</th>
                                            <th scope="col">Email</th>
                                            <th scope="col">Role</th>
                                            <th scope="col">Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <th scope="row">EMP000001</th>
                                            <td>Nguyễn Bảo Trung</td>
                                            <td>True</td>
                                            <td>08/04/2002</td>
                                            <td>680 Trần Hưng Đạo, TP Quy Nhơn, Bình Định</td>
                                            <td>0386751108</td>
                                            <td>thinhntde160164@fpt.edu.vn</td>
                                            <td>5</td>
                                            <td>
                                                <a class="btn btn-sm btn-primary" href="">Update</a>
                                                <a class="btn btn-sm btn-primary" href="">Delete</a>                        
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Table End -->
