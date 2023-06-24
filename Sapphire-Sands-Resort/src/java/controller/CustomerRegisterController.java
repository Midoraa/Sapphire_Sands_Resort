package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.entity.Customer;
import model.service.CustomerService;

@WebServlet(name = "CustomerRegisterController", urlPatterns = {"/customer_register"})
public class CustomerRegisterController extends HttpServlet {

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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("customer_register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
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
        } else {
            CustomerService.registerCustomer(cus);
            request.setAttribute("message", "Tạo tài khoản thành công vui lòng đăng nhập");
            response.sendRedirect("login");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
