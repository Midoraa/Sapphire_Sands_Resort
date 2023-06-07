<%-- 
    Document   : chart_form
    Created on : Jun 7, 2023, 11:15:09 PM
    Author     : TRUNG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Chart Start -->
            <div class="container-fluid pt-4 px-4 pb-5">
                <div class="row g-4">
                    <div class="col-sm-12 col-xl-6">
                        <div class="bg-light rounded h-100 p-4">
                            <h6 class="mb-4">Khách Quốc Tế</h6>
                            <canvas id="line-chart"></canvas>
                        </div>
                    </div>
                    <div class="col-sm-12 col-xl-6">
                        <div class="bg-light rounded h-100 p-4">
                            <h6 class="mb-4">Doanh Số & Doanh Thu</h6>
                            <canvas id="salse-revenue"></canvas>
                        </div>
                    </div>
                    <div class="col-sm-12 col-xl-6">
                        <div class="bg-light rounded h-100 p-4">
                            <h6 class="mb-4">Đồ Ăn</h6>
                            <canvas id="bar-chart"></canvas>
                        </div>
                    </div>
                    <div class="col-sm-12 col-xl-6">
                        <div class="bg-light rounded h-100 p-4">
                            <h6 class="mb-4">Mức Độ Phát Triển</h6>
                            <canvas id="worldwide-sales"></canvas>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Chart End -->