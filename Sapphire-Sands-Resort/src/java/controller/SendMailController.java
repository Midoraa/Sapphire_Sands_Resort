package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.service.EmailUtility;

@WebServlet(name = "SendMailController", urlPatterns = {"/send_mail"})
public class SendMailController extends HttpServlet {
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
            out.println("<title>Servlet SendMailController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SendMailController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String recipient = request.getParameter("recipient");
        String subject = "Hợp đồng đã được chấp thuận";
        String content = "Hợp đồng thuê phòng của bạn đã được quản lý của Sapphire Sands chấp thuận. Hãy chuẩn bị thật tốt để có một chuyến nghỉ dưỡng thật đáng nhớ !";
 
        try {
            EmailUtility.sendEmail(host, port, user, pass, recipient, subject,
                    content);
            System.out.println("The e-mail was sent successfully");
            request.getRequestDispatcher("result.jsp").forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("=======Loi gui email========");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
