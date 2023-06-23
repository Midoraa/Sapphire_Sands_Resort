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
import javax.servlet.http.HttpSession;
import model.entity.Customer;
import model.entity.OrderCart;
import model.entity.ServiceCart;
import model.repository.YourCartRepository;
import model.service.ServiceDouble;

@WebServlet(name = "ServiceCartController", urlPatterns = {"/serviceCart"})
public class ServiceCartController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        Customer cus = (Customer) session.getAttribute("customer");
        if(cus.getAccountID() != null){
        String txt = "";
        Cookie[] arr = request.getCookies();
        if (arr != null) {
            for (Cookie o : arr) {
                if (o.getName().equals("cartService")) {
                    txt = txt + o.getValue();
                }
            }
        }
        
        List<ServiceCart> list = new ArrayList<>();
        list = ServiceDouble.getServiceCart(txt);
        
        List<OrderCart> listRoom = YourCartRepository.getRoomByAccount(cus.getAccountID(), 0);
        
        request.setAttribute("listServiceCart", list);
        request.setAttribute("listRoom", listRoom);

        request.getRequestDispatcher("service_cart.jsp").forward(request, response);
        }
        
        response.sendRedirect("login");
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
