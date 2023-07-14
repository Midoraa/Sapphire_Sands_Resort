/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.entity.Customer;
import model.repository.CustomerRepository;
import model.repository.ManagerRepository;
import model.service.EmailUtility;

/**
 *
 * @author Admin
 */
@WebServlet(name = "AcceptContractController", urlPatterns = {"/accept_contract"})
public class AcceptContractController extends HttpServlet {

    private String host;
    private String port;
    private String user;
    private String pass;

    public void init() {
        // reads SMTP server setting from web.xml file
        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        user = context.getInitParameter("user");
        pass = context.getInitParameter("pass");
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AcceptContractController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AcceptContractController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String orderID = request.getParameter("orderID");
        String cusID = request.getParameter("cusID");
        String roomID = request.getParameter("roomID");
        System.out.println(orderID + cusID + roomID);
        ManagerRepository.acceptOrder(orderID, cusID, roomID);

        Customer cus = CustomerRepository.getCustomerByID(cusID);
        String subject = "Hợp đồng đã được chấp thuận";
        String htmlContent = "<!DOCTYPE html>\n"
                + "<html>\n"
                + "\n"
                + "<head>\n"
                + "    <title>Tạo mã QR bằng JavaScript</title>\n"
                + "    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css\">\n"
                + "    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/qrious/4.0.2/qrious.min.js\"></script>\n"
                + "    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css\">\n"
                + "</head>\n"
                + "\n"
                + "<body>\n"
                + "\n"
                + "    <div style=\"width: 90%;margin-right: auto;margin-left: auto;\">\n"
                + "        <div style=\"width: 30%;margin-right: auto;margin-left: auto;\">\n"
                + "            <img width=\"100%\" style=\"margin: 30px 0;\" src=\"https://raw.githubusercontent.com/Midoraa/Sapphire_Sands_Resort/Thanh-All-Cart/Sapphire-Sands-Resort/web/img/sapphire-sands-low-resolution-logo-color-on-transparent-background.png?token=GHSAT0AAAAAACCUA43UEYAWMPYSWBXABKO2ZFCM6GA\" alt>\n"
                + "        </div>\n"
                + "        <div style=\"margin-right: auto;margin-left: auto;border: 2px solid black; padding: 65px;\">\n"
                + "            <div style=\"background: #f9dedc; border-radius: 5px; margin-bottom: 30px; padding: 50px;\">\n"
                + "                <h1 style=\"text-align: center; margin-top: 30px; font-size: 55px;\">\n"
                + "                    <strong>Cảm ơn bạn đã lựa chọn Sapphire Sands Resort</strong>\n"
                + "                </h1>\n"
                + "                <div style=\"margin: 0 50px;\">\n"
                + "                    <div style=\"margin-bottom: 1.5rem;--bs-gutter-x: 1.5rem;--bs-gutter-y: 0;display: flex;flex-wrap: wrap;margin-top: calc(-1 * var(--bs-gutter-y));margin-right: calc(-.5 * var(--bs-gutter-x));margin-left: calc(-.5 * var(--bs-gutter-x));\">\n"
                + "                        <div style=\"margin: 1.5rem;flex: 1 0 0%;\">\n"
                + "                            <p>\n"
                + "                                Chúng tôi mong chờ được đón tiếp bạn tại\n"
                + "                                Sapphire Sands và mang đến cho bạn một kỳ nghỉ\n"
                + "                                đáng nhớ và thư giãn tuyệt vời nhất.\n"
                + "                                Hãy sẵn sàng để khám phá vẻ đẹp của khu nghỉ\n"
                + "                                dưỡng chúng tôi và tận hưởng những trải nghiệm\n"
                + "                                tuyệt vời mà chúng tôi mang đến.\n"
                + "                            </p>\n"
                + "                        </div>\n"
                + "                    </div>\n"
                + "                    <div style=\"width: 100%; margin-bottom: 1.5rem;\">\n"
                + "                        <img width=\"100%\"\n"
                + "                            src=\"https://image-tc.galaxy.tf/wijpeg-ek8uw4pacbv3epfl6cbsptnd7/922359-hd-l2-studios-sunseeker-phase-2-restaurant-c2-ppl.jpg?width=1920\"\n"
                + "                            alt>\n"
                + "                    </div>\n"
                + "                </div>\n"
                + "\n"
                + "            </div>\n"
                + "            <div>\n"
                + "                <h4>Đây là mã của bạn: <strong>{orderID}</strong></h4>\n"
                + "            </div>\n"
                + "\n"
                + "        </div>\n"
                + "        <div style=\"margin-right: auto;margin-left: auto;margin-top: 40px;text-align: center;\">\n"
                + "\n"
                + "            <div style=\"display: flex;justify-content: center;margin-top: 1rem; width: 100%;\">\n"
                + "                <a href=\"#\">\n"
                + "                    <svg style=\"width: 100px; fill: #757575; size: 100px;\" xmlns=\"http://www.w3.org/2000/svg\"\n"
                + "                        height=\"1em\" viewBox=\"0 0 576 512\">\n"
                + "                        <path\n"
                + "                            d=\"M549.655 124.083c-6.281-23.65-24.787-42.276-48.284-48.597C458.781 64 288 64 288 64S117.22 64 74.629 75.486c-23.497 6.322-42.003 24.947-48.284 48.597-11.412 42.867-11.412 132.305-11.412 132.305s0 89.438 11.412 132.305c6.281 23.65 24.787 41.5 48.284 47.821C117.22 448 288 448 288 448s170.78 0 213.371-11.486c23.497-6.321 42.003-24.171 48.284-47.821 11.412-42.867 11.412-132.305 11.412-132.305s0-89.438-11.412-132.305zm-317.51 213.508V175.185l142.739 81.205-142.739 81.201z\" />\n"
                + "                    </svg>\n"
                + "                </a>\n"
                + "                <a href=\"#\">\n"
                + "                    <svg style=\"width: 100px; fill: #757575; size: 100px;\" xmlns=\"http://www.w3.org/2000/svg\"\n"
                + "                        height=\"1em\" viewBox=\"0 0 512 512\">\n"
                + "                        <path\n"
                + "                            d=\"M504 256C504 119 393 8 256 8S8 119 8 256c0 123.78 90.69 226.38 209.25 245V327.69h-63V256h63v-54.64c0-62.15 37-96.48 93.67-96.48 27.14 0 55.52 4.84 55.52 4.84v61h-31.28c-30.8 0-40.41 19.12-40.41 38.73V256h68.78l-11 71.69h-57.78V501C413.31 482.38 504 379.78 504 256z\" />\n"
                + "                    </svg>\n"
                + "                </a>\n"
                + "                <a href=\"#\">\n"
                + "                    <svg style=\"width: 100px; fill: #757575; size: 100px;\" xmlns=\"http://www.w3.org/2000/svg\"\n"
                + "                        height=\"1em\" viewBox=\"0 0 512 512\">\n"
                + "                        <path\n"
                + "                            d=\"M459.37 151.716c.325 4.548.325 9.097.325 13.645 0 138.72-105.583 298.558-298.558 298.558-59.452 0-114.68-17.219-161.137-47.106 8.447.974 16.568 1.299 25.34 1.299 49.055 0 94.213-16.568 130.274-44.832-46.132-.975-84.792-31.188-98.112-72.772 6.498.974 12.995 1.624 19.818 1.624 9.421 0 18.843-1.3 27.614-3.573-48.081-9.747-84.143-51.98-84.143-102.985v-1.299c13.969 7.797 30.214 12.67 47.431 13.319-28.264-18.843-46.781-51.005-46.781-87.391 0-19.492 5.197-37.36 14.294-52.954 51.655 63.675 129.3 105.258 216.365 109.807-1.624-7.797-2.599-15.918-2.599-24.04 0-57.828 46.782-104.934 104.934-104.934 30.213 0 57.502 12.67 76.67 33.137 23.715-4.548 46.456-13.32 66.599-25.34-7.798 24.366-24.366 44.833-46.132 57.827 21.117-2.273 41.584-8.122 60.426-16.243-14.292 20.791-32.161 39.308-52.628 54.253z\" />\n"
                + "                    </svg>\n"
                + "                </a>\n"
                + "                <a href=\"#\">\n"
                + "                    <svg style=\"width: 100px; fill: #757575; size: 100px;\" xmlns=\"http://www.w3.org/2000/svg\"\n"
                + "                        height=\"1em\" viewBox=\"0 0 448 512\">\n"
                + "                        <path\n"
                + "                            d=\"M224.1 141c-63.6 0-114.9 51.3-114.9 114.9s51.3 114.9 114.9 114.9S339 319.5 339 255.9 287.7 141 224.1 141zm0 189.6c-41.1 0-74.7-33.5-74.7-74.7s33.5-74.7 74.7-74.7 74.7 33.5 74.7 74.7-33.6 74.7-74.7 74.7zm146.4-194.3c0 14.9-12 26.8-26.8 26.8-14.9 0-26.8-12-26.8-26.8s12-26.8 26.8-26.8 26.8 12 26.8 26.8zm76.1 27.2c-1.7-35.9-9.9-67.7-36.2-93.9-26.2-26.2-58-34.4-93.9-36.2-37-2.1-147.9-2.1-184.9 0-35.8 1.7-67.6 9.9-93.9 36.1s-34.4 58-36.2 93.9c-2.1 37-2.1 147.9 0 184.9 1.7 35.9 9.9 67.7 36.2 93.9s58 34.4 93.9 36.2c37 2.1 147.9 2.1 184.9 0 35.9-1.7 67.7-9.9 93.9-36.2 26.2-26.2 34.4-58 36.2-93.9 2.1-37 2.1-147.8 0-184.8zM398.8 388c-7.8 19.6-22.9 34.7-42.6 42.6-29.5 11.7-99.5 9-132.1 9s-102.7 2.6-132.1-9c-19.6-7.8-34.7-22.9-42.6-42.6-11.7-29.5-9-99.5-9-132.1s-2.6-102.7 9-132.1c7.8-19.6 22.9-34.7 42.6-42.6 29.5-11.7 99.5-9 132.1-9s102.7-2.6 132.1 9c19.6 7.8 34.7 22.9 42.6 42.6 11.7 29.5 9 99.5 9 132.1s2.7 102.7-9 132.1z\" />\n"
                + "                    </svg>\n"
                + "                </a>\n"
                + "            </div>\n"
                + "        </div>\n"
                + "    </div>\n"
                + "\n"
                + "</body>\n"
                + "\n"
                + "</html>\n";
        htmlContent = htmlContent.replace("{orderID}", orderID);
        try {
            EmailUtility.sendEmail(host, port, user, pass, cus.getCusEmail(), subject,
                    htmlContent);
            System.out.println("The e-mail was sent successfully");
        } catch (Exception ex) {
            System.out.println(ex);
            System.out.println("=======Loi gui email========");
        }

        response.sendRedirect("manager.jsp");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
