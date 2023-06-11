/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.entity.Customer;
import model.service.CustomerService;

/**
 *
 * @author Admin
 */
@WebServlet(name = "CustomerRegisterController", urlPatterns = {"/customer_register"})
public class CustomerRegisterController extends HttpServlet {

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
            out.println("<title>Servlet CustomerRegisterController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CustomerRegisterController at " + request.getContextPath() + "</h1>");
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
        request.getRequestDispatcher("customer_register.jsp").forward(request, response);
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
        String accountID = CustomerService.generateNewID();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String cusName = request.getParameter("cusName");
        Date cusDOB = Date.valueOf(request.getParameter("cusDOB"));
        String cusPhone = request.getParameter("cusPhone");
        String cusEmail = request.getParameter("cusEmail");
        String cusCCCD = request.getParameter("cusCCCD");
        int cusType = Integer.parseInt(request.getParameter("cusType"));
        
        Customer cus = new Customer(accountID, username, password, 0, accountID, cusName, cusDOB, cusPhone, cusEmail, cusCCCD, cusType);
        System.out.println(cus);
        if (CustomerService.checkUserNameExist(username)) {
            request.setAttribute("message", "Tài khoản " + username + " đã tồn tại");
            request.getRequestDispatcher("customer_register.jsp").forward(request, response);
        }else{
            CustomerService.registerCustomer(cus);
            request.setAttribute("message", "Tạo tài khoản thành công vui lòng đăng nhập");
            response.sendRedirect("login");
        }
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
