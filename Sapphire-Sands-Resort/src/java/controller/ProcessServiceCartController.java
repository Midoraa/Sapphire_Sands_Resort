package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.entity.ServiceCart;
import model.service.ServiceDouble;

@WebServlet(name = "ProcessServiceCartController", urlPatterns = {"/processServiceCart"})
public class ProcessServiceCartController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProcessServiceCartController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProcessServiceCartController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //        Lấy trạng thái ở client người dùng
        String statusWeb = request.getParameter("statusWeb");

//        Tạo chuỗi txt rỗng
        String txt = "";

//        Lấy giá trị Cookie ở trên Client Khách Hàng rồi gán giá trị vào 1 chuỗi và xóa Cookie đó
        Cookie[] arr = request.getCookies();
        if (arr != null) {
            for (Cookie o : arr) {
                if (o.getName().equals("cartService")) {
                    txt = txt + o.getValue();
                    o.setMaxAge(0);
                    response.addCookie(o);
                }
            }
        }
        System.out.println("Status Website: " + statusWeb);
//        Insert dữ liệu vào Data ServiceDetail
        if(statusWeb.equals(statusWeb == null)){
            
            response.sendRedirect("serviceCart");
        }
        else if(statusWeb.equals("order")){
//            String orderID = "OD000005";
            String orderID = request.getParameter("orderID");
            ServiceDouble.insertServiceDetail(txt, orderID);
            response.sendRedirect("serviceCart");  
        }     
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        Lấy trạng thái ở client người dùng
        String statusWeb = request.getParameter("statusWeb");

//        Tạo chuỗi txt rỗng
        String txt = "";

//        Lấy giá trị Cookie ở trên Client Khách Hàng rồi gán giá trị vào 1 chuỗi và xóa Cookie đó
        Cookie[] arr = request.getCookies();
        if (arr != null) {
            for (Cookie o : arr) {
                if (o.getName().equals("cartService")) {
                    txt = txt + o.getValue();
                    o.setMaxAge(0);
                    response.addCookie(o);
                }
            }
        }

//        Nếu trạng thái trên web rỗng
        if (statusWeb == null) {
            String serviceID = request.getParameter("serviceID");
//        Kiểm tra đầu vào của Service có bị rỗng hay không?
            if (serviceID != null) {
                if (txt.isEmpty()) {
                    txt = serviceID + ":" + 1;
                } else {
                    txt = txt + "/" + serviceID + ":" + 1;
                }
            }
//        Sửa lại Cookie cho đúng mãu: ID:Amount
            String cart = ServiceDouble.resetCookieCart(txt);

//        Thiết lập lại giá trị bằng cách tạo ra cookie mới
            Cookie c = new Cookie("cartService", cart);
            c.setMaxAge(24 * 60 * 60);
            response.addCookie(c);

//        Trả về trang Service để người dùng tiếp tục chọn dịch vụ muốn sử dụng
            response.sendRedirect("service");
//        request.getRequestDispatcher("service").forward(request, response);
        } 
//        Tăng giảm số lượng của 1 dịch vụ
        else if (statusWeb.equals("quantity")) {
            String serviceID = request.getParameter("serviceID");
            int numUpdate = Integer.parseInt(request.getParameter("num"));

            System.out.println("Service ID: " + serviceID + " Number Update: " + numUpdate);
            
            List<ServiceCart> list = new ArrayList<>();
            list = ServiceDouble.updateQuantityService(txt, serviceID, numUpdate);

            txt = null;

            for (ServiceCart s : list) {
                if (txt != null) {
                    txt = txt + "/" + s.getServiceID() + ":" + s.getAmount();
                } else {
                    txt = s.getServiceID() + ":" + s.getAmount();
                }
            }

            Cookie c = new Cookie("cartService", txt);
            c.setMaxAge(24 * 60 * 60);
            response.addCookie(c);
            
            response.sendRedirect("serviceCart");
        } 
//        Xóa 1 service khỏi Cart
        else if(statusWeb.equals("delete")){
            String serviceID = request.getParameter("serviceID");
            String cookie = ServiceDouble.deleteServiceCart(txt, serviceID);
            
            Cookie c = new Cookie("cartService", cookie);
            c.setMaxAge(24 * 60 * 60);
            response.addCookie(c);
            
            response.sendRedirect("serviceCart");
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}