<%-- 
    Document   : room_details_form
    Created on : May 30, 2023, 6:05:59 PM
    Author     : TRUNG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="room-detail">
    <div class="content text-center">
        <div class="pt-5 text-white">
            <p class="room-type">${room.roomType}</p>
        </div>
        <div class=" py-4 text-white">
            <p class="room-name">${room.roomName}</p>
        </div>
    </div>
    <div class="booking wow fadeIn w-100" data-wow-delay="0.1s">
        <div class="booking-detail">
            <form action="list_choose_room" class="row col-md-12">
                <div class="col-md-10">
                    <div class="row g-2">
                        <div class="col-md-3 px-2">
                            <div class="date" id="date1" data-target-input="nearest">
                                <input name="time_in" type="date" class="form-control"
                                       placeholder="Nhận phòng" onchange="checkIn(event)"/>
                            </div>
                            <div id="messCheckIn" class="error-text text-center text-warning"></div>
                        </div>
                        
                        <div class="col-md-3 px-2">
                            <div class="date" id="date2" data-target-input="nearest">
                                <input name="time_out" type="date" class="form-control"
                                       placeholder="Trả phòng" onchange="checkOut(event)"/>
                            </div>
                            <div id="messCheckOut" class="error-text text-center text-warning"></div>
                        </div>
                        
                        <div class="col-md-3 px-2">
                            <select class="form-select" name="max_people">
                                <option selected>Số người</option>
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>
                                <option value="7">7</option>
                                <option value="8">8</option>
                                <option value="9">9</option>
                                <option value="10">10</option>
                                <option value="11">11</option>
                                <option value="12">12</option>
                            </select>
                        </div>
                        <div class="col-md-3 px-2">
                            <select class="form-select" name="room_type">
                                <option selected>Loại phòng</option>
                                <option value="Phòng nghỉ dưỡng">Phòng nghỉ dưỡng</option>
                                <option value="Suite">Suite</option>
                                <option value="PENTHOUSES & VILLAS">PENTHOUSES & VILLAS</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-md-2">
                    <button type="submit" class="btn btn-primary w-100" id="searchRoom" disabled>Tìm phòng</button>
                </div>
            </form>
        </div>
    </div>
</div>



<div class="container-xxl room-information">
    <div class="container">
        <p class="room-descript">${room.roomDescript}</p>
        <hr>
    </div>

    <div class="container py-4 d-flex justify-content-around">
        <div class="room-number py-5 ">
            <section class="mb-4">
                <div class="d-flex">
                    <div class="resort-icon">
                        <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"
                             id="Layer_1" x="0px" y="0px" viewBox="0 0 40 40"
                             style="enable-background:new 0 0 40 40;" xml:space="preserve">
                        <style type="text/css">
                            .st0 {
                                fill: none;
                                stroke: #666565;
                                stroke-linecap: round;
                                stroke-miterlimit: 10;
                            }
                        </style>
                        <polyline class="st0"
                                  points="11.7,30.1 8.8,30.1 8.8,8.3 30.6,8.3 30.6,30.1 19.7,30.1 ">
                        </polyline>
                        <line class="st0" x1="19.7" y1="8.3" x2="19.7" y2="17.4">
                        </line>
                        <line class="st0" x1="8.8" y1="23.3" x2="19.7" y2="23.3">
                        </line>
                        </svg>
                    </div>
                    <strong class="align-self-center strong">Diện tích</strong>
                    <div class="w-50 align-self-center">
                        <p class="align-self-center p-0 m-0"> ${room.roomArea} sqm </p>
                    </div>
                </div>
            </section>
            <section>
                <div class="d-flex">
                    <div class="resort-icon">
                        <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"
                             id="Layer_1" x="0px" y="0px" viewBox="0 0 40 40"
                             style="enable-background:new 0 0 40 40;" xml:space="preserve">
                        <style type="text/css">
                            .st0 {
                                fill: none;
                                stroke: #D3B5A3;
                                stroke-linecap: round;
                                stroke-linejoin: round;
                                stroke-miterlimit: 10;
                            }
                        </style>
                        <g id="single_bed">
                        <path class="st0"
                              d="M36.9,28.1H3.5v-7c0-0.5,0.4-1,1-1H36c0.5,0,1,0.4,1,1V28.1z"></path>
                        <path class="st0"
                              d="M33.7,20.1H6.6v-9.3c0-1,0.8-1.9,1.9-1.9h23.3c1,0,1.9,0.8,1.9,1.9V20.1z">
                        </path>
                        <path class="st0"
                              d="M27.4,20.1H13v-5c0-0.7,0.6-1.3,1.3-1.3H26c0.7,0,1.3,0.6,1.3,1.3V20.1z">
                        </path>
                        <line class="st0" x1="3.5" y1="28.1" x2="3.5" y2="31.3"></line>
                        <line class="st0" x1="36.9" y1="28.1" x2="36.9" y2="31.3"></line>
                        </g>
                        </svg>
                    </div>
                    <strong class="align-self-center strong">Giường</strong>
                    <div class="align-self-center w-50">
                        <p class="align-self-center p-0 m-0"> ${room.bedRoom}</p>
                    </div>
                </div>
            </section>
        </div>
        <div class="room-number py-5">
            <section class="mb-4">
                <div class="d-flex">
                    <div class="resort-icon">
                        <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"
                             id="Layer_1" x="0px" y="0px" viewBox="0 0 40 40"
                             style="enable-background:new 0 0 40 40;" xml:space="preserve">
                        <style type="text/css">
                            .st0 {
                                fill: none;
                                stroke: #D3B5A3;
                                stroke-linecap: round;
                                stroke-linejoin: round;
                                stroke-miterlimit: 10;
                            }
                        </style>
                        <g>
                        <line class="st0" x1="5.3" y1="20.8" x2="33.7" y2="20.8"></line>
                        <path class="st0" d="M4.3,10.9c0,0,0.5-1.3,2.1,0c0,0,1.1-1.3,2.4,0"></path>
                        <path class="st0"
                              d="M7,14.1c0,0,0.8-0.9,1.7-0.9s1.5,0.9,1.5,0.9s0.3-0.9,1.5-0.9s1.8,0.9,1.8,0.9">
                        </path>
                        <polyline class="st0"
                                  points="22.1,20.8 28.3,14.5 30.4,15.9 34,12.2 36.4,14.1  "></polyline>
                        <path class="st0" d="M11.1,20.8c0,0,1.7-4.9,6.7-4.9s6.2,3,6.2,3"></path>
                        <path class="st0" d="M27.5,20.8c0,0,2.3,0.5,1.8,2.8c-0.4,1.9-6.7,5.3-18.2,6">
                        </path>
                        <line class="st0" x1="14.2" y1="22.9" x2="16.5" y2="22.9"></line>
                        <line class="st0" x1="18.5" y1="22.3" x2="20.8" y2="22.3"></line>
                        <line class="st0" x1="16.5" y1="24.7" x2="19.5" y2="24.7"></line>
                        <line class="st0" x1="15.1" y1="26.7" x2="16.8" y2="26.7"></line>
                        </g>
                        </svg>
                    </div>
                    <strong class="align-self-center strong">Hướng</strong>
                    <div class="w-50 align-self-center">
                        <p class="align-self-center p-0 m-0"> ${room.roomDirection} </p>
                    </div>
                </div>
            </section>
            <section>
                <div class="d-flex">
                    <div class="resort-icon">
                        <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"
                             id="Layer_1" x="0px" y="0px" viewBox="0 0 40 40"
                             style="enable-background:new 0 0 40 40;" xml:space="preserve">
                        <style type="text/css">
                            .st0 {
                                fill: none;
                                stroke: #D3B5A3;
                                stroke-miterlimit: 10;
                            }
                        </style>
                        <g>
                        <path class="st0"
                              d="M26.9,18h5.6v1.1c0,0-1.7,0.5-1.7,1.7V23c0,2.5-2,4.4-4.4,4.4h-6.7h-6.7c-2.5,0-4.4-2-4.4-4.4v-2.2   c0-1.2-1.7-1.7-1.7-1.7V18h14.4">
                        </path>
                        <polyline class="st0" points="26.9,27.4 27.5,29.1 27.5,29.6  "></polyline>
                        <polyline class="st0" points="12.5,27.4 12,29.1 12,29.6  "></polyline>
                        <polyline class="st0" points="14.2,10.8 15.3,10.8 16.4,10.8  "></polyline>
                        <path class="st0"
                              d="M15.3,10.8V9.7c0-1.2-1-2.2-2.2-2.2h-0.6c-1.2,0-2.2,1-2.2,2.2V18"></path>
                        <path class="st0"
                              d="M26.9,22.4h-5.6v-4.6c0-0.6,0.4-1,1-1h3.6c0.6,0,1,0.4,1,1V22.4z"></path>
                        <line class="st0" x1="14.2" y1="12.4" x2="14.2" y2="13.5"></line>
                        <line class="st0" x1="16.4" y1="12.4" x2="16.4" y2="13.5"></line>
                        <line class="st0" x1="15.3" y1="14.7" x2="15.3" y2="15.8"></line>
                        <line class="st0" x1="13.1" y1="14.7" x2="13.1" y2="15.8"></line>
                        <line class="st0" x1="17.5" y1="14.7" x2="17.5" y2="15.8"></line>
                        </g>
                        </svg>
                    </div>
                    <strong class="align-self-center strong">Phòng tắm</strong>
                    <div class="align-self-center w-50">
                        <p class="align-self-center p-0 m-0">${room.bathRoom}</p>
                    </div>
                </div>
            </section>
        </div>
    </div>
    <hr>
</div>

<!-- Testimonial Start -->
<div class="testimonial bg-dark wow zoomIn" data-wow-delay="0.1s" style="margin-bottom: 90px;">
    <div class="container">
        <div class="owl-carousel testimonial-carousel py-5">
            <div class="testimonial-item position-relative bg-white rounded overflow-hidden">
                <img src="img/room/${room.roomID}-1.jpg"
                     alt="">
            </div>
            <div class="testimonial-item position-relative bg-white rounded overflow-hidden">
                <img src="img/room/${room.roomID}-2.jpg"
                     alt="">
            </div>
            <div class="testimonial-item position-relative bg-white rounded overflow-hidden">
                <img src="img/room/${room.roomID}-3.jpg"
                     alt="">
            </div>
        </div>
    </div>
</div>
<!-- Testimonial End -->


<div class="mb-5 container last-descript">
    <div>
        <h3 class="text-center mb-5"> TIỆN NGHI TRONG PHÒNG </h3>
    </div>
    <div class="my-5">
        <ul class="list-unstyled">
            <li>${room.bedRoom}</li>
            <li>${room.bathRoom}</li>
            <li>Không gian ngoài trời rộng rãi để thư giãn và thưởng thức ẩm thực.</li>
            <li>Hệ thống âm thanh Bose</li>
        </ul>
    </div>
</div>


<div class="container text-center pb-5 ">
    <a class="btn btn-primary" href="">
        <div class="d-flex align-items-center">
            <svg class="me-3" xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 320 512">
            <path style="fill: white;"
                  d="M9.4 233.4c-12.5 12.5-12.5 32.8 0 45.3l192 192c12.5 12.5 32.8 12.5 45.3 0s12.5-32.8 0-45.3L77.3 256 246.6 86.6c12.5-12.5 12.5-32.8 0-45.3s-32.8-12.5-45.3 0l-192 192z" />
            </svg>
            <p class="m-0 p-0">TRỞ VỀ DANH MỤC PHÒNG NGHỈ</p>
        </div>
    </a> 
</div>

<style>
    .room-detail{
        background: -moz-linear-gradient(rgba(0,0,0,.7),rgba(0,0,0,.7));
        background: -webkit-linear-gradient(rgba(0,0,0,.7),rgba(0,0,0,.7));
        background: linear-gradient(rgba(0,0,0,.7),rgba(0,0,0,.7));
        filter: unquote("progid:DXImageTransform.Microsoft.gradient( startColorstr='#b3000000', endColorstr='#b3000000',GradientType=0 )");
        background-image: url("img/room/${room.roomID}-2.jpg");
        background-size: cover;
        background-repeat: no-repeat;
        background-position: center;
        font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
        font-weight: 100;
    }
    .room-detail .content{
        padding: 200px 0px;
    }

    .room-detail .room-type{
        font-size: x-large;
        font-weight: 400;
    }
    .room-detail .room-name{
        font-size: 45px;
    }

    .booking-detail{
        background-color: rgba(0, 0, 0, 0.4);  /* Màu nền trong suốt (ở đây là màu trắng) với độ trong suốt 0.5 */
        padding: 35px;
    }
    .booking-detail .inside{
        background-color: transparent; /* Màu nền trong suốt cho phần tử bg-white */
        box-shadow: none;
    }
    .room-information{
        margin-bottom: 100px;
    }

    .room-descript{
        padding: 80px 0px;
    }
    .resort-icon{
        width: 15%;
    }
    .resort-icon svg{
        width: 80px;
    }
    .room-bed{
        width: 10%;
    }
    .room-number .strong{
        width: 100px;
        text-align: center;
    }

    .last-descript li{
        padding: 4% 0;
        border-bottom: 1px solid rgba(0, 0, 0, 0.233);
    }
</style>