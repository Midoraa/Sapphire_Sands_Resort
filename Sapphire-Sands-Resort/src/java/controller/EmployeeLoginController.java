package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.entity.Employee;
import model.service.EmployeeService;

@WebServlet(name = "EmployeeLoginController", urlPatterns = {"/employee_login"})
public class EmployeeLoginController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EmployeeLoginController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EmployeeLoginController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("employee_login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username  = request.getParameter("username");
        String password = request.getParameter("password");
        Employee emp = EmployeeService.login(username, password);
        System.out.println(emp);
        if (emp!=null) {
            Cookie userCookies = new Cookie("username", username);
            Cookie passCookies = new Cookie("password", password);
            userCookies.setMaxAge(60 * 60 * 24);    
            passCookies.setMaxAge(60 * 60 * 24);
            response.addCookie(userCookies);
            response.addCookie(passCookies);
            HttpSession session = request.getSession();
            session.setAttribute("employee", emp);
            if (emp.getRole()==3) {
                response.sendRedirect("manager.jsp");
            }else if(emp.getRole()==2){
                response.sendRedirect("admin.jsp");
            }else{
                response.sendRedirect("employee.jsp");
            }
        }else {
            System.out.println("Khong the dang nhap cho EMPLOYEE");
            request.setAttribute("thongbao", "Thông tin đăng nhập không chính xác");
            request.getRequestDispatcher("employee_login.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
