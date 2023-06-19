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
import model.entity.FoodCart;
import model.service.FoodCartService;

@WebServlet(name = "FoodCartController", urlPatterns = {"/foodcart"})
public class FoodCartController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
        request.getRequestDispatcher("food_cart.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}