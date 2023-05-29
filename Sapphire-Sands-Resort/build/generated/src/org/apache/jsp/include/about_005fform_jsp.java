package org.apache.jsp.include;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class about_005fform_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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
      out.write("        <div class=\"container-xxl py-5 mb-5\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"text-center wow fadeInUp\" data-wow-delay=\"0.1s\">\n");
      out.write("                    <h6 class=\"section-title text-center text-primary text-uppercase\">Our Team</h6>\n");
      out.write("                    <h1 class=\"mb-5\">Explore Our <span class=\"text-primary text-uppercase\">Staffs</span></h1>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"row g-4 all\">\n");
      out.write("                    <div class=\"col-lg-2 col-md-4 wow fadeInUp\" data-wow-delay=\"0.1s\">\n");
      out.write("                        <div class=\"rounded shadow overflow-hidden\">\n");
      out.write("                            <div class=\"position-relative\">\n");
      out.write("                                <img class=\"img-fluid\" src=\"img/Trung.png\" alt=\"\">\n");
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
      out.write("                                <img class=\"img-fluid\" src=\"img/Bảo.png\" alt=\"\">\n");
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
      out.write("                                <img class=\"img-fluid\" src=\"img/Thành.png\" alt=\"\">\n");
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
      out.write("                                <img class=\"img-fluid\" src=\"img/Quân.png\" alt=\"\">\n");
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
      out.write("                                <img class=\"img-fluid\" src=\"img/Hiệu.png\" alt=\"\">\n");
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
