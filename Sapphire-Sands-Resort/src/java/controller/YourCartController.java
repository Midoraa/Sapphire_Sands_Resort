package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.entity.Customer;
import model.entity.FoodCart;
import model.entity.OrderCart;
import model.entity.RoomCart;
import model.entity.ServiceCart;
import model.service.YourCartService;

@WebServlet(name = "YourCartController", urlPatterns = {"/yourcart"})
public class YourCartController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        if (session.getAttribute("orderID").equals(null)) {
            response.sendRedirect("room");
        }
        Customer cus = (Customer) session.getAttribute("customer");
        List<OrderCart> listorderID = YourCartService.getYourCartOrder(cus.getCusID());

        String orderID = null;
        String orderID0 = null;
        String orderID1 = null;

        for (OrderCart o : listorderID) {
            if (orderID != null) {
                orderID = orderID + "/" + o.getOrderID() + ":" + o.getOrStatus();
            } else {
                orderID = o.getOrderID() + ":" + o.getOrStatus();
            }

            if (o.getOrStatus() == 0) {
                if (orderID0 != null) {
                    orderID0 = orderID0 + "/" + o.getOrderID() + ":" + o.getOrStatus();
                } else {
                    orderID0 = o.getOrderID() + ":" + o.getOrStatus();
                }
            } else {
                if (orderID1 != null) {
                    orderID1 = orderID1 + "/" + o.getOrderID() + ":" + o.getOrStatus();
                } else {
                    orderID1 = o.getOrderID() + ":" + o.getOrStatus();
                }
            }
        }

//        Đã Đặt
        if (orderID != null) {
            List<RoomCart> listRoomCart = YourCartService.getYourCartRoom(orderID);
            List<ServiceCart> listServiceCart = YourCartService.getYourCartService(orderID);
            List<FoodCart> listFoodCart = YourCartService.getYourCartFood(orderID);

            request.setAttribute("listRoom", listRoomCart);
            request.setAttribute("listService", listServiceCart);
            request.setAttribute("listFood", listFoodCart);
        }

//        Đã Thanh Toán
        if (orderID1 != null) {
            List<RoomCart> listRoomCart1 = YourCartService.getYourCartRoom(orderID1);
            List<ServiceCart> listServiceCart1 = YourCartService.getYourCartService(orderID1);
            List<FoodCart> listFoodCart1 = YourCartService.getYourCartFood(orderID1);

            request.setAttribute("listRoom1", listRoomCart1);
            request.setAttribute("listService1", listServiceCart1);
            request.setAttribute("listFood1", listFoodCart1);
        }

//        Chưa Thanh Toán
        if (orderID0 != null) {
            List<RoomCart> listRoomCart0 = YourCartService.getYourCartRoom(orderID0);
            List<ServiceCart> listServiceCart0 = YourCartService.getYourCartService(orderID0);
            List<FoodCart> listFoodCart0 = YourCartService.getYourCartFood(orderID0);

            request.setAttribute("listRoom0", listRoomCart0);
            request.setAttribute("listService0", listServiceCart0);
            request.setAttribute("listFood0", listFoodCart0);

            double totalPrice = YourCartService.getTotalPrice(orderID0);
            request.setAttribute("totalPrice", totalPrice);

            System.out.println("Total Price: " + totalPrice);
        }

        request.getRequestDispatcher("customer_ordered.jsp").forward(request, response);
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