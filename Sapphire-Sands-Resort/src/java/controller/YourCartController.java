package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.entity.FoodCart;
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
        String orderID = "OD000004";
        List<RoomCart> listRoomCart = new ArrayList<>();
        listRoomCart = YourCartService.getYourCartRoom(orderID);

        List<ServiceCart> listServiceCart = new ArrayList<>();
        listServiceCart = YourCartService.getYourCartService(orderID);

        List<FoodCart> listFoodCart = new ArrayList<>();
        listFoodCart = YourCartService.getYourCartFood(orderID);

        request.setAttribute("listRoom", listRoomCart);
        request.setAttribute("listService", listServiceCart);
        request.setAttribute("listFood", listFoodCart);

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
