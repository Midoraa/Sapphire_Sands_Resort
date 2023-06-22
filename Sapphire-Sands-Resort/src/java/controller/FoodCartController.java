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
import model.entity.FoodCart;
import model.entity.OrderCart;
import model.service.FoodCartService;
import model.service.YourCartService;

@WebServlet(name = "FoodCartController", urlPatterns = {"/foodcart"})
public class FoodCartController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();

//
        List<OrderCart> listOrderIDFromCusID = new ArrayList<>();
        listOrderIDFromCusID = (List<OrderCart>) session.getAttribute("orderID");
//
        String orderID = null;
//        
        System.out.println(listOrderIDFromCusID.toString());
//        
        for (OrderCart o : listOrderIDFromCusID) {
            if (o.getOrStatus() == 0) {
                if (orderID != null) {
                    orderID = orderID + "/" + o.getOrderID() + ":" + o.getOrStatus();
                } else {
                    orderID = o.getOrderID() + ":" + o.getOrStatus();
                }
            }
        }
//        System.out.println("Order ID read from session: " + orderID);
//        
        List<OrderCart> listOrderID = YourCartService.getYourCartOrder(orderID);
        
        String txt = "";
        System.out.println("First: " + txt);
        Cookie[] arr = request.getCookies();

        if(arr != null){
            for (Cookie c : arr) {
                if (c.getName().equals("cart")) {
                    txt = c.getValue();
                }
            }
        }


        System.out.println("Second: " + txt);
        
        List<FoodCart> listCart = new ArrayList<>();
        listCart = FoodCartService.getListCart(txt);

        request.setAttribute("listCart", listCart);
        request.setAttribute("listOrderID", listOrderID);
        request.getRequestDispatcher("food_cart.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}