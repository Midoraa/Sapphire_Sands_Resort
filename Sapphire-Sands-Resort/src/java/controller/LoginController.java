package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.entity.Customer;
import model.entity.Order;
import model.service.CustomerService;
import model.service.OrderService;

@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("new_login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Customer cus = CustomerService.login(username, password);
        System.out.println(cus);
        if (cus != null) {
            Cookie userCookies = new Cookie("username", username);
            Cookie passCookies = new Cookie("password", password);
            userCookies.setMaxAge(60 * 60 * 24);    
            passCookies.setMaxAge(60 * 60 * 24);
            response.addCookie(userCookies);
            response.addCookie(passCookies);
            HttpSession session = request.getSession();
            session.setAttribute("customer", cus);
            
            List<Order> listOrder = OrderService.getOrderByCustomerID(cus.getCusID());
            session.setAttribute("listOrder", listOrder);
            
            response.sendRedirect("home.jsp");
        } else {
            System.out.println("Khong the dang nhap");
            request.setAttribute("thongbao", "Thông tin đăng nhập không chính xác");
            request.getRequestDispatcher("new_login.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
