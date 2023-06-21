<%-- 
    Document   : customer_ordered_form
    Created on : Jun 20, 2023, 3:15:31 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- List product -->
<div
    class="container-fluid d-flex wow fadeIn py-5 flex-column"
    data-wow-delay="0.1s">
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
                            <th scope="col">Ngày Nhận Phòng</th>
                            <th scope="col">Ngày Trả Phòng</th>
                            <th scope="col">Số Lượng Người</th>
                            <th scope="col">Giá</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Penthouses & Villas</td>
                            <td>Biệt Thự Hai Phòng Ngủ Sun Peninsula
                                Residence Cạnh Biển</td>
                            <td>2023-05-28</td>
                            <td>2023-05-30</td>
                            <td>3</td>
                            <td>100000</td>
                            <td>
                                <button type="button"
                                        class="btn btn-primary">
                                    HUỶ PHÒNG
                                </button>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <div class="d-flex py-3">
        <div class="col-lg-7 d-flex flex-column">
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
                                <tr class="text-dark">
                                    <th scope="col">Tên Dịch Vụ</th>
                                    <th scope="col">Số Người</th>
                                    <th scope="col">Giá</th>
                                    <th scope="col">Thời gian</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>Dịch vụ Karaoke</td>
                                    <td>3</td>
                                    <td>100000</td>
                                    <td>16/6/2006 12:12:12</td>
                                    <td>
                                        <button type="button"
                                                class="btn btn-primary">
                                            HUỶ DỊCH VỤ
                                        </button>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
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
                                <tr class="text-dark">

                                    <th scope="col">Tên Món Ăn</th>
                                    <th scope="col">Số Lượng</th>
                                    <th scope="col">Giá</th>
                                    <th scope="col">Thời gian</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>

                                    <td>Xúc xích kẹp thịt</td>
                                    <td>3</td>
                                    <td>100000</td>
                                    <td>16/6/2006 12:12:12</td>
                                    <td>
                                        <button type="button"
                                                class="btn btn-primary">
                                            HUỶ DỊCH VỤ
                                        </button>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-lg-5 bg-light mx-2">
            sds

            <!-- khúc này để trống cho t degins -->
        </div>
    </div>
</div>
<!-- Product end -->