package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.entity.Service;
import model.service.ServiceDouble;

@WebServlet(name = "ServiceController", urlPatterns = {"/service"})
public class ServiceController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Service> listService = new ArrayList<Service>();
        listService = ServiceDouble.getService();

//        Get total Food in List Food
        int totalItem = listService.size();
//        Paging: 1 page have 8 cart
        int itemsPerPage = 8;
//        Max page of List Food when paging
        int maxPage = totalItem % itemsPerPage == 0 ? (totalItem / itemsPerPage) : (totalItem / itemsPerPage + 1);
        int page;

        try {
            page = Integer.parseInt(request.getParameter("page"));
        } catch (Exception e) {
            page = 1;
            System.out.println(e);
        }

        int begin = (page - 1) * itemsPerPage;
        int end = itemsPerPage * page - 1;

        request.setAttribute("begin", begin);
        request.setAttribute("end", end);

        request.setAttribute("listService", listService);
        request.setAttribute("itemsPerPage", itemsPerPage);
        request.setAttribute("maxPage", maxPage);
        request.setAttribute("page", page);

//      Lấy giá trị cart từ thông tin   
        String serviceID = request.getParameter("serviceID");
        String amount = request.getParameter("quantity");
            
        String txt = "";
////        Lấy giá trị Cookie ở trên Client Khách Hàng rồi gán giá trị vào 1 chuỗi và xóa Cookie đó
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

        if (serviceID != null && amount != null) {
            if (txt.isEmpty()) {
                txt = serviceID + ":" + amount;
            } else {
                txt = txt + "/" + serviceID + ":" + amount;
            }
        }
//        
        Cookie c = new Cookie("cartService", txt);
        c.setMaxAge(24 * 60 * 60);
        response.addCookie(c);

        request.getRequestDispatcher("service_list.jsp").forward(request, response);
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
