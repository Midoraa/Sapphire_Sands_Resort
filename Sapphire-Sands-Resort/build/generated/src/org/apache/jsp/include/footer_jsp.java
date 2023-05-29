package org.apache.jsp.include;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class footer_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!-- Footer Start -->\n");
      out.write("        <div class=\"container-fluid bg-dark text-light footer wow fadeIn mt-5\" data-wow-delay=\"0.1s\">\n");
      out.write("            <div class=\"container pb-5\">\n");
      out.write("                <div class=\"row g-5\">\n");
      out.write("                    <div class=\"col-md-6 col-lg-4\">\n");
      out.write("                        <div class=\"bg-primary rounded p-4\">\n");
      out.write("                            <a href=\"index.html\"><h1 class=\"text-white text-uppercase mb-3\">Sapphire Sands</h1></a>\n");
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
