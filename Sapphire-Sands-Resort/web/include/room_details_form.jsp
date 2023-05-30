<%-- 
    Document   : room_details_form
    Created on : May 30, 2023, 6:05:59 PM
    Author     : TRUNG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- Page Header Start -->
        <div class="container-fluid page-header mb-4 p-0" style="background-image: url(img/carousel-1.jpg);">
            <div class="container-fluid page-header-inner py-5">
                <div class="container text-center pb-5">
                    <h1 class="display-3 text-white mb-3 animated slideInDown">Room Details</h1>
                </div>
            </div>
        </div>
        <!-- Page Header End -->

        <!-- Modal -->
        <div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
            <div class="carousel-inner">
              <div class="carousel-item active">
                <img src="./assets/img/Images/Img-Bedroom/1.png" class="d-block" width="100%" height="900px" alt="...">
              </div>
              <div class="carousel-item">
                <img src="./assets/img/Images/Img-Kitchen/1.png" class="d-block" width="100%" height="900px" alt="...">
              </div>
              <div class="carousel-item">
                <img src="./assets/img/Images/Img-swimmingpool/Swimingpool-1.jpg" class="d-block" width="100%" height="900px" alt="...">
              </div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
              <span class="carousel-control-prev-icon" aria-hidden="true"></span>
              <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
              <span class="carousel-control-next-icon" aria-hidden="true"></span>
              <span class="visually-hidden">Next</span>
            </button>
          </div>
        <!-- end modal -->

         <!-- Job Detail Start -->
     <div class="container-xxl py-5 wow fadeInUp " data-wow-delay="0.1s">
        <div class="container">
            <div class="row gy-5 gx-4">
                <div class="col-lg-6">
                    <div class="d-flex align-items-center mb-3">
                        <!-- <img class="flex-shrink-0 img-fluid border rounded" src="img/com-logo-2.jpg" alt="" style="width: 80px; height: 80px;"> -->
                        <div class="text-start">
                            <h3 class="mb-3">Junior Suite</h3>
                            <span class="text-truncate me-3"><i class="fa fa-map-marker-alt text-primary me-2"></i>New York, USA</span>
                            <span class="text-truncate me-3"><i class="fa-thin fa-battery-bolt"></i>Còn Phòng</span>
                            <span class="text-truncate me-0"><i class="far fa-money-bill-alt text-primary me-2"></i>$123 - $456</span>
                        </div>
                    </div>

                    <div class="mb-5">
                        <p>Căn phòng <strong>Junior Suite</strong> là một lựa chọn tuyệt vời cho kỳ nghỉ của bạn. Với diện tích X mét vuông rộng rãi, căn phòng này mang đến không gian thoải mái và tiện nghi. Với 1 phòng ngủ đẹp, bạn sẽ có thể thư giãn và nghỉ ngơi trong không gian riêng tư. Đảm bảo rằng bạn sẽ có một trải nghiệm nghỉ dưỡng tuyệt vời tại căn phòng Resort Deluxe này.</p>
                        
                        <h4 class="mb-3">Tiện nghi phòng ngủ</h4> 
                        <ul class="list-unstyled">
                            <li><i class="fa fa-angle-right text-primary me-2"></i>Giường King-size với chăn ga cao cấp.</li>
                            <li><i class="fa fa-angle-right text-primary me-2"></i>Tủ quần áo rộng rãi và két an toàn</li>
                            <li><i class="fa fa-angle-right text-primary me-2"></i>Bàn làm việc và ghế thoải mái.</li>
                            <li><i class="fa fa-angle-right text-primary me-2"></i>Máy điều hòa nhiệt độ.</li>
                            <li><i class="fa fa-angle-right text-primary me-2"></i>TV màn hình phẳng với các kênh truyền hình cáp</li>
                            <li><i class="fa fa-angle-right text-primary me-2"></i>Két nước mini và máy pha cà phê/ấm đun nước.</li>
                            <li><i class="fa fa-angle-right text-primary me-2"></i>Truy cập Internet không dây miễn phí</li>
                        </ul>
                        <h4 class="mb-3">Nhà bếp</h4>
                        <ul class="list-unstyled">
                            <li><i class="fa fa-angle-right text-primary me-2"></i>Bếp đầy đủ với bếp gas, lò vi sóng, tủ lạnh và lò nướng</li>
                            <li><i class="fa fa-angle-right text-primary me-2"></i>Bộ nồi chảo và dụng cụ nấu ăn cơ bản</li>
                            <li><i class="fa fa-angle-right text-primary me-2"></i>Bàn ăn và ghế cho các bữa ăn thoải mái</li>
                        </ul>
                        <h4 class="mb-3">Phòng Tắm</h4>
                        <ul class="list-unstyled">
                            <li><i class="fa fa-angle-right text-primary me-2"></i>Phòng tắm riêng với vòi sen và bồn tắm</li>
                            <li><i class="fa fa-angle-right text-primary me-2"></i>Bộ đồ vệ sinh cá nhân miễn phí.</li>
                            <li><i class="fa fa-angle-right text-primary me-2"></i>Máy sấy tóc và gương trang điểm.</li>
                        </ul>
                        <h4 class="mb-3">Hồ Bơi</h4>
                        <ul class="list-unstyled">
                            <li><i class="fa fa-angle-right text-primary me-2"></i>Hồ bơi riêng có diện tích lớn</li>
                            <li><i class="fa fa-angle-right text-primary me-2"></i>Ghế nằm thoải mái và dù nắng.</li>
                            <li><i class="fa fa-angle-right text-primary me-2"></i>Không gian xung quanh hồ bơi để thư giãn và tắm nắng</li>
                        </ul>
                    </div>
                </div>
            <div class="col-lg-6">
                <div class="bg-light rounded p-5 mb-4 wow slideInUp" data-wow-delay="0.1s">
                    <h4 class="mb-4">Dịch Vụ Của Resort</h4>
                    <p><i class="fa fa-angle-right text-primary me-2"></i>Nhà hàng và quầy bar phục vụ các món ăn và đồ uống đa dạng.</p>
                    <p><i class="fa fa-angle-right text-primary me-2"></i>Dịch vụ phòng 24/7</p>
                    <p><i class="fa fa-angle-right text-primary me-2"></i>Phòng tập gym và khu vực spa</p>
                    <p><i class="fa fa-angle-right text-primary me-2"></i>Khu vui chơi trẻ em</p>
                    <p class="m-0"><i class="fa fa-angle-right text-primary me-2"></i>Truy cập miễn phí vào khu vực Wi-Fi công cộng</p>
                    <button class="btn btn-primary w-100 py-3 mt-4" type="submit">Book Now</button>
                </div>
            </div>
        </div>
        </div>
    </div>
    <!-- Job Detail End -->