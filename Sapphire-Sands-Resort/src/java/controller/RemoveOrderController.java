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

@WebServlet(name = "RemoveOrderController", urlPatterns = {"/remove_order"})
public class RemoveOrderController extends HttpServlet {

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

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RemoveOrderController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RemoveOrderController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String orderID = request.getParameter("orderID");
        ManagerRepository.removeOrder(orderID);
        
        String cusID = request.getParameter("cusID");
        Customer cus = CustomerRepository.getCustomerByID(cusID);
        String subject = "Hợp đồng bị từ chối";
        String content = "Hợp đồng thuê phòng của bạn đã bị từ chối vì một vài lý do bất đắt dĩ. Chúng tôi thành thật xin lỗi vì sự bất tiện này!";
 
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
