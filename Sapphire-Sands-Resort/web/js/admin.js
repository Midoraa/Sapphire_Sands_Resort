(function ($) {
    "use strict";

    // Spinner
    var spinner = function () {
        setTimeout(function () {
            if ($('#spinner').length > 0) {
                $('#spinner').removeClass('show');
            }
        }, 1);
    };
    spinner();
    
    
    // Back to top button
    $(window).scroll(function () {
        if ($(this).scrollTop() > 300) {
            $('.back-to-top').fadeIn('slow');
        } else {
            $('.back-to-top').fadeOut('slow');
        }
    });
    $('.back-to-top').click(function () {
        $('html, body').animate({scrollTop: 0}, 1500, 'easeInOutExpo');
        return false;
    });


    // Sidebar Toggler
    $('.sidebar-toggler').click(function () {
        $('.sidebar, .content').toggleClass("open");
        return false;
    });


    // Progress Bar
    $('.pg-bar').waypoint(function () {
        $('.progress .progress-bar').each(function () {
            $(this).css("width", $(this).attr("aria-valuenow") + '%');
        });
    }, {offset: '80%'});



    // Worldwide Sales Chart
    var ctx1 = $("#worldwide-sales").get(0).getContext("2d");
    var myChart1 = new Chart(ctx1, {
        type: "bar",
        data: {
            labels: ["2016", "2017", "2018", "2019", "2020", "2021", "2022","2023"],
            datasets: [{
                    label: "Hà Nội",
                    data: [15, 30, 55, 65, 50, 30, 55, 85],
                    backgroundColor: "rgba(0, 156, 255, .7)"
                },
                {
                    label: "Đà Nẵng",
                    data: [8, 35, 40, 50, 40, 65, 70, 75],
                    backgroundColor: "rgba(0, 156, 255, .5)"
                },
                {
                    label: "Hồ Chí Minh",
                    data: [12, 25, 45, 45, 55, 40, 60, 70],
                    backgroundColor: "rgba(0, 156, 255, .3)"
                }
            ]
            },
        options: {
            responsive: true
        }
    });


    // Salse & Revenue Chart
    var ctx2 = $("#salse-revenue").get(0).getContext("2d");
    var myChart2 = new Chart(ctx2, {
        type: "line",
        data: {
            labels: ["2016", "2017", "2018", "2019", "2020", "2021", "2022","2023"],
            datasets: [{
                    label: "Doanh Số",
                    data: [15, 30, 55, 45, 35, 40, 65, 85],
                    backgroundColor: "rgba(0, 156, 255, .5)",
                    fill: true
                },
                {
                    label: "Doanh Thu",
                    data: [99, 135, 170, 130, 110, 120, 180, 250],
                    backgroundColor: "rgba(0, 156, 255, .3)",
                    fill: true
                }
            ]
            },
        options: {
            responsive: true
        }
    });
    


    // Single Line Chart
    var ctx3 = $("#line-chart").get(0).getContext("2d");
    var myChart3 = new Chart(ctx3, {
        type: "line",
        data: {
            labels: ["2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023"],
            datasets: [{
                label: "Quốc Tế",
                fill: false,
                backgroundColor: "rgba(0, 156, 255, .3)",
                data: [7, 9, 10, 10, 8, 7.5, 9, 10, 14, 14]
            }]
        },
        options: {
            responsive: true
        }
    });


    // Single Bar Chart
    var ctx4 = $("#bar-chart").get(0).getContext("2d");
    var myChart4 = new Chart(ctx4, {
        type: "bar",
        data: {
            labels: ["Tôm Sú Cháy Tỏi", "Cá Phile Sốt Chanh Dây", "Gỏi Bò Bóp Thấu", "Mực Sữa Chiên Nước Mắm", "Lẩu Gà Tiềm Ớt Hiểm"],
            datasets: [{
                label: "Món Ăn Nổi Bật Trong Tháng",
                backgroundColor: [
                    "rgba(0, 156, 255, .7)",
                    "rgba(0, 156, 255, .6)",
                    "rgba(0, 156, 255, .5)",
                    "rgba(0, 156, 255, .4)",
                    "rgba(0, 156, 255, .3)"
                ],
                data: [55, 49, 44, 24, 15]
            }]
        },
        options: {
            responsive: true
        }
    });  
})(jQuery);

