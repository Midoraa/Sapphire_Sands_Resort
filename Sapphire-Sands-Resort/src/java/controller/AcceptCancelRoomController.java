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
@WebServlet(name = "AcceptCancelRoomController", urlPatterns = {"/accept_cancel_room"})
public class AcceptCancelRoomController extends HttpServlet {
    
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
            out.println("<title>Servlet AcceptCancelRoomController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AcceptCancelRoomController at " + request.getContextPath() + "</h1>");
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
        ManagerRepository.removeOrder(orderID);
        
        String cusID = request.getParameter("cusID");
        Customer cus = CustomerRepository.getCustomerByID(cusID);
        String subject = "Yêu cầu hủy phòng của bạn đã được xác nhận";
        String content = "Yêu cầu hủy phòng đã thành công! Cảm ơn quý khách đã tham gia sử dụng dịch vụ của Sapphire Sands, hẹn được phục vụ quý khách vào một ngày không xa.";
 
        try {
            EmailUtility.sendEmail(host, port, user, pass, cus.getCusEmail(), subject,
                    content);
            System.out.println("========The e-mail was sent successfully=======");
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
