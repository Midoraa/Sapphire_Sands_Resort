package org.apache.jsp.include;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <link href=\"../img/favicon.ico\" rel=\"icon\">\n");
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
      out.write("    <link href=\"../lib/animate/animate.min.css\" rel=\"stylesheet\">\n");
      out.write("    <link href=\"../lib/owlcarousel/assets/owl.carousel.min.css\" rel=\"stylesheet\">\n");
      out.write("    <link href=\"../lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css\" rel=\"stylesheet\" />\n");
      out.write("\n");
      out.write("    <!-- Customized Bootstrap Stylesheet -->\n");
      out.write("    <link href=\"../css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("    <!-- Template Stylesheet -->\n");
      out.write("    <link href=\"../css/style.css\" rel=\"stylesheet\">\n");
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
