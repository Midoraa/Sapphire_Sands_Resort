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
import model.entity.FoodCart;
import model.entity.OrderCart;
import model.repository.YourCartRepository;
import model.service.FoodService;

@WebServlet(name = "FoodCartController", urlPatterns = {"/foodCart"})
public class FoodCartController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        HttpSession session = request.getSession();
//
////
//        List<OrderCart> listOrderIDFromCusID = new ArrayList<>();
//        listOrderIDFromCusID = (List<OrderCart>) session.getAttribute("orderID");
////
//        String orderID = null;
////        
//        System.out.println(listOrderIDFromCusID.toString());
////        
//        for (OrderCart o : listOrderIDFromCusID) {
//            if (o.getOrStatus() == 0) {
//                if (orderID != null) {
//                    orderID = orderID + "/" + o.getOrderID() + ":" + o.getOrStatus();
//                } else {
//                    orderID = o.getOrderID() + ":" + o.getOrStatus();
//                }
//            }
//        }
////        System.out.println("Order ID read from session: " + orderID);
////        
//        List<OrderCart> listOrderID = YourCartService.getYourCartOrder(orderID);
//        
//        String txt = "";
//        System.out.println("First: " + txt);
//        Cookie[] arr = request.getCookies();
//
//        if(arr != null){
//            for (Cookie c : arr) {
//                if (c.getName().equals("cart")) {
//                    txt = c.getValue();
//                }
//            }
//        }
//
//
//        System.out.println("Second: " + txt);
//        
//        List<FoodCart> listCart = new ArrayList<>();
//        listCart = FoodCartService.getListCart(txt);
//
//        request.setAttribute("listCart", listCart);
//        request.setAttribute("listOrderID", listOrderID);
//        request.getRequestDispatcher("food_cart.jsp").forward(request, response);
        HttpSession session = request.getSession();
        Customer cus = (Customer) session.getAttribute("customer");

        if(cus.getAccountID() != null){
        String txt = "";
        Cookie[] arr = request.getCookies();
        if (arr != null) {
            for (Cookie o : arr) {
                if (o.getName().equals("cartFood")) {
                    txt = txt + o.getValue();
                }
            }
        }

        List<FoodCart> list = new ArrayList<>();
        list = FoodService.getFoodCart(txt);

        List<OrderCart> listRoom = YourCartRepository.getRoomByAccount(cus.getAccountID(), 0);

        request.setAttribute("listFoodCart", list);
        request.setAttribute("listRoom", listRoom);

        request.getRequestDispatcher("food_cart.jsp").forward(request, response);
        }
        response.sendRedirect("login");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
