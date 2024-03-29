package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class about_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(3);
    _jspx_dependants.add("/include/header.jsp");
    _jspx_dependants.add("/include/about_form.jsp");
    _jspx_dependants.add("/include/footer.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <title>Hotelier - Hotel HTML Template</title>\n");
      out.write("    <meta content=\"width=device-width, initial-scale=1.0\" name=\"viewport\">\n");
      out.write("    <meta content=\"\" name=\"keywords\">\n");
      out.write("    <meta content=\"\" name=\"description\">\n");
      out.write("\n");
      out.write("    <!-- Favicon -->\n");
      out.write("    <link href=\"img/favicon.ico\" rel=\"icon\">\n");
      out.write("\n");
      out.write("    <!-- Google Web Fonts -->\n");
      out.write("    <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\n");
      out.write("    <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600;700&family=Montserrat:wght@400;500;600;700&display=swap\" rel=\"stylesheet\">  \n");
      out.write("\n");
      out.write("    <!-- Icon Font Stylesheet -->\n");
      out.write("    <link href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css\" rel=\"stylesheet\">\n");
      out.write("    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("    <!-- Libraries Stylesheet -->\n");
      out.write("    <link href=\"lib/animate/animate.min.css\" rel=\"stylesheet\">\n");
      out.write("    <link href=\"lib/owlcarousel/assets/owl.carousel.min.css\" rel=\"stylesheet\">\n");
      out.write("    <link href=\"lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css\" rel=\"stylesheet\" />\n");
      out.write("\n");
      out.write("    <!-- Customized Bootstrap Stylesheet -->\n");
      out.write("    <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("    <!-- Template Stylesheet -->\n");
      out.write("    <link href=\"css/style.css\" rel=\"stylesheet\">\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("    <div class=\"container-xxl bg-white p-0\">\n");
      out.write("        <!-- Spinner Start -->\n");
      out.write("        <div id=\"spinner\" class=\"show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center\">\n");
      out.write("            <div class=\"spinner-border text-primary\" style=\"width: 3rem; height: 3rem;\" role=\"status\">\n");
      out.write("                <span class=\"sr-only\">Loading...</span>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!-- Spinner End -->\n");
      out.write("\n");
      out.write("        <!-- Header Start -->\n");
      out.write("        <div class=\"container-fluid bg-dark px-0\">\n");
      out.write("            <div class=\"row gx-0\">\n");
      out.write("                <div class=\"col-lg-3 bg-dark d-none d-lg-block\">\n");
      out.write("                    <a href=\"index.html\" class=\"navbar-brand w-100 h-100 m-0 p-0 d-flex align-items-center justify-content-center\">\n");
      out.write("                        <h2 class=\"m-0 text-primary text-uppercase\">Sapphire Sands</h2>\n");
      out.write("                    </a>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-lg-9\">\n");
      out.write("                    <div class=\"row gx-0 bg-white d-none d-lg-flex\">\n");
      out.write("                        <div class=\"col-lg-7 px-5 text-start\">\n");
      out.write("                            <div class=\"h-100 d-inline-flex align-items-center py-2 me-4\">\n");
      out.write("                                <i class=\"fa fa-envelope text-primary me-2\"></i>\n");
      out.write("                                <p class=\"mb-0\">info@fpt.edu.vn</p>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"h-100 d-inline-flex align-items-center py-2\">\n");
      out.write("                                <i class=\"fa fa-phone-alt text-primary me-2\"></i>\n");
      out.write("                                <p class=\"mb-0\">+012 345 6789</p>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-lg-5 px-5 text-end\">\n");
      out.write("                            <div class=\"d-inline-flex align-items-center py-2\">\n");
      out.write("                                <a class=\"me-3\" href=\"\"><i class=\"fab fa-facebook-f\"></i></a>\n");
      out.write("                                <a class=\"me-3\" href=\"\"><i class=\"fab fa-twitter\"></i></a>\n");
      out.write("                                <a class=\"me-3\" href=\"\"><i class=\"fab fa-linkedin-in\"></i></a>\n");
      out.write("                                <a class=\"me-3\" href=\"\"><i class=\"fab fa-instagram\"></i></a>\n");
      out.write("                                <a class=\"\" href=\"\"><i class=\"fab fa-youtube\"></i></a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <nav class=\"navbar navbar-expand-lg bg-dark navbar-dark p-3 p-lg-0\">\n");
      out.write("                        <a href=\"index.html\" class=\"navbar-brand d-block d-lg-none\">\n");
      out.write("                            <h1 class=\"m-0 text-primary text-uppercase\">Sapphire Sands Resort</h1>\n");
      out.write("                        </a>\n");
      out.write("                        <button type=\"button\" class=\"navbar-toggler\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarCollapse\">\n");
      out.write("                            <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("                        </button>\n");
      out.write("                        <div class=\"collapse navbar-collapse justify-content-between\" id=\"navbarCollapse\">\n");
      out.write("                            <div class=\"navbar-nav mr-auto py-0\">\n");
      out.write("                                <a href=\"index.html\" class=\"nav-item nav-link active\">Home</a>\n");
      out.write("                                <a href=\"about.html\" class=\"nav-item nav-link\">About</a>\n");
      out.write("                                <a href=\"service.html\" class=\"nav-item nav-link\">Services</a>\n");
      out.write("                                <a href=\"room.html\" class=\"nav-item nav-link\">Rooms</a>\n");
      out.write("                                <div class=\"nav-item dropdown\">\n");
      out.write("                                    <a href=\"#\" class=\"nav-link dropdown-toggle\" data-bs-toggle=\"dropdown\">Pages</a>\n");
      out.write("                                    <div class=\"dropdown-menu rounded-0 m-0\">\n");
      out.write("                                        <a href=\"booking.html\" class=\"dropdown-item\">Booking</a>\n");
      out.write("                                        <a href=\"team.html\" class=\"dropdown-item\">Our Team</a>\n");
      out.write("                                        <a href=\"testimonial.html\" class=\"dropdown-item\">Testimonial</a>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <a href=\"contact.html\" class=\"nav-item nav-link\">Contact</a>\n");
      out.write("                            </div>\n");
      out.write("                            <a href=\"https://htmlcodex.com/hotel-html-template-pro\" class=\"btn btn-primary rounded-0 py-4 px-md-5 d-none d-lg-block\">Login<i class=\"fa fa-arrow-right ms-3\"></i></a>\n");
      out.write("                        </div>\n");
      out.write("                    </nav>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!-- Header End -->\n");
      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!-- Page Header Start -->\n");
      out.write("        <div class=\"container-fluid page-header mb-5 p-0\" style=\"background-image: url(img/carousel-1.jpg);\">\n");
      out.write("            <div class=\"container-fluid page-header-inner py-5\">\n");
      out.write("                <div class=\"container text-center pb-5\">\n");
      out.write("                    <h1 class=\"display-3 text-white mb-3 animated slideInDown\">About Us</h1>\n");
      out.write("                    <nav aria-label=\"breadcrumb\">\n");
      out.write("                        <ol class=\"breadcrumb justify-content-center text-uppercase\">\n");
      out.write("                            <li class=\"breadcrumb-item\"><a href=\"#\">Home</a></li>\n");
      out.write("                            <li class=\"breadcrumb-item\"><a href=\"#\">Pages</a></li>\n");
      out.write("                            <li class=\"breadcrumb-item text-white active\" aria-current=\"page\">About</li>\n");
      out.write("                        </ol>\n");
      out.write("                    </nav>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!-- Page Header End -->\n");
      out.write("        \n");
      out.write("        <!-- About Start -->\n");
      out.write("        <div class=\"container-xxl py-5\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row g-5 align-items-center\">\n");
      out.write("                    <div class=\"col-lg-6\">\n");
      out.write("                        <h6 class=\"section-title text-start text-primary text-uppercase\">About Us</h6>\n");
      out.write("                        <h1 class=\"mb-4\">Welcome to <span class=\"text-primary text-uppercase\">Hotelier</span></h1>\n");
      out.write("                        <p class=\"mb-4\">Tempor erat elitr rebum at clita. Diam dolor diam ipsum sit. Aliqu diam amet diam et eos. Clita erat ipsum et lorem et sit, sed stet lorem sit clita duo justo magna dolore erat amet</p>\n");
      out.write("                        <div class=\"row g-3 pb-4\">\n");
      out.write("                            <div class=\"col-sm-4 wow fadeIn\" data-wow-delay=\"0.1s\">\n");
      out.write("                                <div class=\"border rounded p-1\">\n");
      out.write("                                    <div class=\"border rounded text-center p-4\">\n");
      out.write("                                        <i class=\"fa fa-hotel fa-2x text-primary mb-2\"></i>\n");
      out.write("                                        <h2 class=\"mb-1\" data-toggle=\"counter-up\">1234</h2>\n");
      out.write("                                        <p class=\"mb-0\">Rooms</p>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-sm-4 wow fadeIn\" data-wow-delay=\"0.3s\">\n");
      out.write("                                <div class=\"border rounded p-1\">\n");
      out.write("                                    <div class=\"border rounded text-center p-4\">\n");
      out.write("                                        <i class=\"fa fa-users-cog fa-2x text-primary mb-2\"></i>\n");
      out.write("                                        <h2 class=\"mb-1\" data-toggle=\"counter-up\">1234</h2>\n");
      out.write("                                        <p class=\"mb-0\">Staffs</p>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-sm-4 wow fadeIn\" data-wow-delay=\"0.5s\">\n");
      out.write("                                <div class=\"border rounded p-1\">\n");
      out.write("                                    <div class=\"border rounded text-center p-4\">\n");
      out.write("                                        <i class=\"fa fa-users fa-2x text-primary mb-2\"></i>\n");
      out.write("                                        <h2 class=\"mb-1\" data-toggle=\"counter-up\">1234</h2>\n");
      out.write("                                        <p class=\"mb-0\">Clients</p>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <a class=\"btn btn-primary py-3 px-5 mt-2\" href=\"\">Explore More</a>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-lg-6\">\n");
      out.write("                        <div class=\"row g-3\">\n");
      out.write("                            <div class=\"col-6 text-end\">\n");
      out.write("                                <img class=\"img-fluid rounded w-75 wow zoomIn\" data-wow-delay=\"0.1s\" src=\"img/about-1.jpg\" style=\"margin-top: 25%;\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-6 text-start\">\n");
      out.write("                                <img class=\"img-fluid rounded w-100 wow zoomIn\" data-wow-delay=\"0.3s\" src=\"img/about-2.jpg\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-6 text-end\">\n");
      out.write("                                <img class=\"img-fluid rounded w-50 wow zoomIn\" data-wow-delay=\"0.5s\" src=\"img/about-3.jpg\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-6 text-start\">\n");
      out.write("                                <img class=\"img-fluid rounded w-75 wow zoomIn\" data-wow-delay=\"0.7s\" src=\"img/about-4.jpg\">\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!-- About End -->\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- Team Start -->\n");
      out.write("        <div class=\"container-xxl py-5\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"text-center wow fadeInUp\" data-wow-delay=\"0.1s\">\n");
      out.write("                    <h6 class=\"section-title text-center text-primary text-uppercase\">Our Team</h6>\n");
      out.write("                    <h1 class=\"mb-5\">Explore Our <span class=\"text-primary text-uppercase\">Staffs</span></h1>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"row g-4 all\">\n");
      out.write("                    <div class=\"col-lg-2 col-md-4 wow fadeInUp\" data-wow-delay=\"0.1s\">\n");
      out.write("                        <div class=\"rounded shadow overflow-hidden\">\n");
      out.write("                            <div class=\"position-relative\">\n");
      out.write("                                <img class=\"img-fluid\" src=\"img/Trung.jpg\" alt=\"\">\n");
      out.write("                                <div class=\"position-absolute start-50 top-100 translate-middle d-flex align-items-center\">\n");
      out.write("                                    <a class=\"btn btn-square btn-primary mx-1\" href=\"\"><i class=\"fab fa-facebook-f\"></i></a>\n");
      out.write("                                    <a class=\"btn btn-square btn-primary mx-1\" href=\"\"><i class=\"fab fa-twitter\"></i></a>\n");
      out.write("                                    <a class=\"btn btn-square btn-primary mx-1\" href=\"\"><i class=\"fab fa-instagram\"></i></a>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"text-center p-4 mt-3\">\n");
      out.write("                                <h5 class=\"fw-bold mb-0\">Nguyễn Bảo Trung</h5>\n");
      out.write("                                <small>FE-BE</small>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-lg-2 col-md-4 wow fadeInUp\" data-wow-delay=\"0.3s\">\n");
      out.write("                        <div class=\"rounded shadow overflow-hidden\">\n");
      out.write("                            <div class=\"position-relative\">\n");
      out.write("                                <img class=\"img-fluid\" src=\"img/Bảo.jpg\" alt=\"\">\n");
      out.write("                                <div class=\"position-absolute start-50 top-100 translate-middle d-flex align-items-center\">\n");
      out.write("                                    <a class=\"btn btn-square btn-primary mx-1\" href=\"\"><i class=\"fab fa-facebook-f\"></i></a>\n");
      out.write("                                    <a class=\"btn btn-square btn-primary mx-1\" href=\"\"><i class=\"fab fa-twitter\"></i></a>\n");
      out.write("                                    <a class=\"btn btn-square btn-primary mx-1\" href=\"\"><i class=\"fab fa-instagram\"></i></a>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"text-center p-4 mt-3\">\n");
      out.write("                                <h5 class=\"fw-bold mb-0\">Nguyễn Quang Bảo</h5>\n");
      out.write("                                <small>BE-SQL</small>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-lg-2 col-md-4 wow fadeInUp\" data-wow-delay=\"0.3s\">\n");
      out.write("                        <div class=\"rounded shadow overflow-hidden\">\n");
      out.write("                            <div class=\"position-relative\">\n");
      out.write("                                <img class=\"img-fluid\" width=\"100%\" height=\"auto\" src=\"img/Thành Công.png\" alt=\"\">\n");
      out.write("                                <div class=\"position-absolute start-50 top-100 translate-middle d-flex align-items-center\">\n");
      out.write("                                    <a class=\"btn btn-square btn-primary mx-1\" href=\"\"><i class=\"fab fa-facebook-f\"></i></a>\n");
      out.write("                                    <a class=\"btn btn-square btn-primary mx-1\" href=\"\"><i class=\"fab fa-twitter\"></i></a>\n");
      out.write("                                    <a class=\"btn btn-square btn-primary mx-1\" href=\"\"><i class=\"fab fa-instagram\"></i></a>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"text-center p-4 mt-3\">\n");
      out.write("                                <h5 class=\"fw-bold mb-0\">Nguyễn Công Thành</h5>\n");
      out.write("                                <small>SQL Designer</small>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-lg-2 col-md-4 wow fadeInUp\" data-wow-delay=\"0.5s\">\n");
      out.write("                        <div class=\"rounded shadow overflow-hidden\">\n");
      out.write("                            <div class=\"position-relative\">\n");
      out.write("                                <img class=\"img-fluid\" src=\"img/Quân.jpg\" alt=\"\">\n");
      out.write("                                <div class=\"position-absolute start-50 top-100 translate-middle d-flex align-items-center\">\n");
      out.write("                                    <a class=\"btn btn-square btn-primary mx-1\" href=\"\"><i class=\"fab fa-facebook-f\"></i></a>\n");
      out.write("                                    <a class=\"btn btn-square btn-primary mx-1\" href=\"\"><i class=\"fab fa-twitter\"></i></a>\n");
      out.write("                                    <a class=\"btn btn-square btn-primary mx-1\" href=\"\"><i class=\"fab fa-instagram\"></i></a>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"text-center p-4 mt-3\">\n");
      out.write("                                <h5 class=\"fw-bold mb-0\">Trần Đình Quân</h5>\n");
      out.write("                                <small>SQL Designer</small>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-lg-2 col-md-4 wow fadeInUp\" data-wow-delay=\"0.7s\">\n");
      out.write("                        <div class=\"rounded shadow overflow-hidden\">\n");
      out.write("                            <div class=\"position-relative\">\n");
      out.write("                                <img class=\"img-fluid\" src=\"img/Hiệu.jpg\" alt=\"\">\n");
      out.write("                                <div class=\"position-absolute start-50 top-100 translate-middle d-flex align-items-center\">\n");
      out.write("                                    <a class=\"btn btn-square btn-primary mx-1\" href=\"\"><i class=\"fab fa-facebook-f\"></i></a>\n");
      out.write("                                    <a class=\"btn btn-square btn-primary mx-1\" href=\"\"><i class=\"fab fa-twitter\"></i></a>\n");
      out.write("                                    <a class=\"btn btn-square btn-primary mx-1\" href=\"\"><i class=\"fab fa-instagram\"></i></a>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"text-center p-4 mt-3\">\n");
      out.write("                                <h5 class=\"fw-bold mb-0\">Trần Đình Hiệu</h5>\n");
      out.write("                                <small>FE-Information</small>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!-- Team End -->\n");
      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!-- Footer Start -->\n");
      out.write("        <div class=\"container-fluid bg-dark text-light footer wow fadeIn\" data-wow-delay=\"0.1s\">\n");
      out.write("            <div class=\"container pb-5\">\n");
      out.write("                <div class=\"row g-5\">\n");
      out.write("                    <div class=\"col-md-6 col-lg-4\">\n");
      out.write("                        <div class=\"bg-primary rounded p-4\">\n");
      out.write("                            <a href=\"index.html\"><h1 class=\"text-white text-uppercase mb-3\">Hotelier</h1></a>\n");
      out.write("                            <p class=\"text-white mb-0\">\n");
      out.write("\t\t\t\t\t\t\t\tDownload <a class=\"text-dark fw-medium\" href=\"https://htmlcodex.com/hotel-html-template-pro\">Hotelier – Premium Version</a>, build a professional website for your hotel business and grab the attention of new visitors upon your site’s launch.\n");
      out.write("\t\t\t\t\t\t\t</p>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-md-6 col-lg-3\">\n");
      out.write("                        <h6 class=\"section-title text-start text-primary text-uppercase mb-4\">Contact</h6>\n");
      out.write("                        <p class=\"mb-2\"><i class=\"fa fa-map-marker-alt me-3\"></i>123 Street, New York, USA</p>\n");
      out.write("                        <p class=\"mb-2\"><i class=\"fa fa-phone-alt me-3\"></i>+012 345 67890</p>\n");
      out.write("                        <p class=\"mb-2\"><i class=\"fa fa-envelope me-3\"></i>info@example.com</p>\n");
      out.write("                        <div class=\"d-flex pt-2\">\n");
      out.write("                            <a class=\"btn btn-outline-light btn-social\" href=\"\"><i class=\"fab fa-twitter\"></i></a>\n");
      out.write("                            <a class=\"btn btn-outline-light btn-social\" href=\"\"><i class=\"fab fa-facebook-f\"></i></a>\n");
      out.write("                            <a class=\"btn btn-outline-light btn-social\" href=\"\"><i class=\"fab fa-youtube\"></i></a>\n");
      out.write("                            <a class=\"btn btn-outline-light btn-social\" href=\"\"><i class=\"fab fa-linkedin-in\"></i></a>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-lg-5 col-md-12\">\n");
      out.write("                        <div class=\"row gy-5 g-4\">\n");
      out.write("                            <div class=\"col-md-6\">\n");
      out.write("                                <h6 class=\"section-title text-start text-primary text-uppercase mb-4\">Company</h6>\n");
      out.write("                                <a class=\"btn btn-link\" href=\"\">About Us</a>\n");
      out.write("                                <a class=\"btn btn-link\" href=\"\">Contact Us</a>\n");
      out.write("                                <a class=\"btn btn-link\" href=\"\">Privacy Policy</a>\n");
      out.write("                                <a class=\"btn btn-link\" href=\"\">Terms & Condition</a>\n");
      out.write("                                <a class=\"btn btn-link\" href=\"\">Support</a>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-md-6\">\n");
      out.write("                                <h6 class=\"section-title text-start text-primary text-uppercase mb-4\">Services</h6>\n");
      out.write("                                <a class=\"btn btn-link\" href=\"\">Food & Restaurant</a>\n");
      out.write("                                <a class=\"btn btn-link\" href=\"\">Spa & Fitness</a>\n");
      out.write("                                <a class=\"btn btn-link\" href=\"\">Sports & Gaming</a>\n");
      out.write("                                <a class=\"btn btn-link\" href=\"\">Event & Party</a>\n");
      out.write("                                <a class=\"btn btn-link\" href=\"\">GYM & Yoga</a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"copyright\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-md-6 text-center text-md-start mb-3 mb-md-0\">\n");
      out.write("                            &copy; <a class=\"border-bottom\" href=\"#\">Your Site Name</a>, All Right Reserved. \n");
      out.write("\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t<!--/*** This template is free as long as you keep the footer author’s credit link/attribution link/backlink. If you'd like to use the template without the footer author’s credit link/attribution link/backlink, you can purchase the Credit Removal License from \"https://htmlcodex.com/credit-removal\". Thank you for your support. ***/-->\n");
      out.write("\t\t\t\t\t\t\tDesigned By <a class=\"border-bottom\" href=\"https://htmlcodex.com\">HTML Codex</a>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-md-6 text-center text-md-end\">\n");
      out.write("                            <div class=\"footer-menu\">\n");
      out.write("                                <a href=\"\">Home</a>\n");
      out.write("                                <a href=\"\">Cookies</a>\n");
      out.write("                                <a href=\"\">Help</a>\n");
      out.write("                                <a href=\"\">FQAs</a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!-- Footer End -->\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- Back to Top -->\n");
      out.write("        <a href=\"#\" class=\"btn btn-lg btn-primary btn-lg-square back-to-top\"><i class=\"bi bi-arrow-up\"></i></a>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <!-- JavaScript Libraries -->\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.4.1.min.js\"></script>\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("    <script src=\"lib/wow/wow.min.js\"></script>\n");
      out.write("    <script src=\"lib/easing/easing.min.js\"></script>\n");
      out.write("    <script src=\"lib/waypoints/waypoints.min.js\"></script>\n");
      out.write("    <script src=\"lib/counterup/counterup.min.js\"></script>\n");
      out.write("    <script src=\"lib/owlcarousel/owl.carousel.min.js\"></script>\n");
      out.write("    <script src=\"lib/tempusdominus/js/moment.min.js\"></script>\n");
      out.write("    <script src=\"lib/tempusdominus/js/moment-timezone.min.js\"></script>\n");
      out.write("    <script src=\"lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js\"></script>\n");
      out.write("\n");
      out.write("    <!-- Template Javascript -->\n");
      out.write("    <script src=\"js/main.js\"></script>\n");
      out.write('\n');
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
