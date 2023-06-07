<%-- Document : booking_form Created on : May 18, 2023, 5:34:16 PM Author :
TRUNG --%> <%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- Page Header Start -->
<div
    class="container-fluid page-header mb-5 p-0"
    style="background-image: url(img/carousel-1.jpg)"
    >
    <div class="container-fluid page-header-inner py-5">
        <div class="container text-center pb-5">
            <h1 class="display-3 text-white mb-3 animated slideInDown">Booking</h1>
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb justify-content-center text-uppercase">
                    <li class="breadcrumb-item"><a href="#">Home</a></li>
                    <li class="breadcrumb-item"><a href="#">Pages</a></li>
                    <li class="breadcrumb-item text-white active" aria-current="page">
                        Booking
                    </li>
                </ol>
            </nav>
        </div>
    </div>
</div>
<!-- Booking Start -->
<div class="container-xxl py-5">
    <div class="container">
        <div class="text-center wow fadeInUp" data-wow-delay="0.1s">
            <h6 class="section-title text-center text-primary text-uppercase">
                Room Booking
            </h6>
            <h1 class="mb-5">
                Book A <span class="text-primary text-uppercase">Luxury Room</span>
            </h1>
        </div>
        <div class="row g-5">
            <div class="col-lg-6">
                <div class="row g-3">
                    <div class="col-6 text-end">
                        <img
                            class="img-fluid rounded w-75 wow zoomIn"
                            data-wow-delay="0.1s"
                            src="img/about-1.jpg"
                            style="margin-top: 25%"
                            />
                    </div>
                    <div class="col-6 text-start">
                        <img
                            class="img-fluid rounded w-100 wow zoomIn"
                            data-wow-delay="0.3s"
                            src="img/about-2.jpg"
                            />
                    </div>
                    <div class="col-6 text-end">
                        <img
                            class="img-fluid rounded w-50 wow zoomIn"
                            data-wow-delay="0.5s"
                            src="img/about-3.jpg"
                            />
                    </div>
                    <div class="col-6 text-start">
                        <img
                            class="img-fluid rounded w-75 wow zoomIn"
                            data-wow-delay="0.7s"
                            src="img/about-4.jpg"
                            />
                    </div>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="wow fadeInUp" data-wow-delay="0.2s">
                    <form>
                        <div class="row g-3">
                            <div class="col-md-12">
                                <div class="form-floating">
                                    <input
                                        type="text"
                                        class="form-control"
                                        id="name"
                                        placeholder="Fullname"
                                        />
                                    <label for="name"> Họ Và Tên</label>
                                </div>
                            </div>

                            <div class="col-md-6">
                                <div class="form-floating">
                                    <input
                                        type="date"
                                        class="form-control"
                                        id="dob"
                                        placeholder="DOB"
                                        />
                                    <label for="dob"> Ngày Sinh </label>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-floating">
                                    <input
                                        type="tel"
                                        class="form-control"
                                        id="phone"
                                        placeholder="Phone"
                                        />
                                    <label for="phone">Số Điện Thoại</label>
                                </div>
                            </div>
                            <div class="col-md-12">
                                <div class="form-floating">
                                    <input
                                        type="email"
                                        class="form-control"
                                        id="email"
                                        placeholder="Email"
                                        />
                                    <label for="email">Email</label>
                                </div>
                            </div>

                            <div class="col-md-12">
                                <div class="form-floating">
                                    <input
                                        type="text"
                                        class="form-control"
                                        id="cccd"
                                        placeholder="CCCD"
                                        />
                                    <label for="cccd"> CCCD </label>
                                </div>
                            </div>
                            <div class="col-md-12">
                                <div class="form-floating">
                                    <select class="form-select" id="select1">
                                        <option value="1" selected>Việt Nam</option>
                                        <option value="2">Ngoại Quốc</option>
                                    </select>
                                    <label for="select1">Quốc Tịch</label>
                                </div>
                            </div>

                            <div class="col-12">
                                <button class="btn btn-primary w-100 py-3" type="submit">
                                    Book Now
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Booking End -->
