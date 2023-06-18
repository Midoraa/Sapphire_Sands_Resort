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

@WebServlet(name = "ProcessCartController", urlPatterns = {"/process"})
public class ProcessCartController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

//        Perform the function of ordering and saving to the data
        if (request.getParameter("num") == null || request.getParameter("foodID") == null ) {
//            If num or foodID is null so the system will perform function Order (It is code perform )
            
//          Chờ lấy orderID từ khi đăng nhập
            String orderID = "OD000005";
//            Get Cookie Cart and Save it into String txt
            String txt = "";
            Cookie[] arr = request.getCookies();

            if (arr != null) {
                for (Cookie c : arr) {
                    if (c.getName().equals("cart")) {
                        txt = c.getValue();
                        c.setMaxAge(0);
                        response.addCookie(c);
                    }
                    
                    FoodCartService.insertFoodOrder(orderID, txt);
                }
            }
            
            request.getRequestDispatcher("food").forward(request, response);
        }
        
//        Update number food change in Food Cart when read from Cookie
        int numUpdate = Integer.parseInt(request.getParameter("num"));
        String foodID = request.getParameter("foodID");

        String txt = "";
        Cookie[] arr = request.getCookies();

        if (arr != null) {
            for (Cookie c : arr) {
                if (c.getName().equals("cart")) {
                    txt = c.getValue();
                    c.setMaxAge(0);
                    response.addCookie(c);
                }
            }
        }

//        Function update amount food
        List<FoodCart> listCart = new ArrayList<>();
        listCart = FoodCartService.updateAmount(txt, foodID, numUpdate);
        
//        After update amount reset String txt to contain new Food Cart after update
        txt = null;

//        Contain Food Cart update in to txt
        for (FoodCart f : listCart) {
            if (txt == null) {
                txt = f.getFoodID() + ":" + f.getAmount();
            } else {
                txt = txt + "/" + f.getFoodID() + ":" + f.getAmount();
            }
        }
        
//        Create again Cookie Cart
        Cookie c = new Cookie("cart", txt);
        c.setMaxAge(24 * 60 * 60);
        response.addCookie(c);
        
//        Return foodcart to view Food Cart
        response.sendRedirect("foodcart");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String foodID = request.getParameter("foodID");

        String txt = "";
        Cookie[] arr = request.getCookies();

        if (arr != null) {
            for (Cookie c : arr) {
                if (c.getName().equals("cart")) {
                    txt = c.getValue();
                    c.setMaxAge(0);
                    response.addCookie(c);
                }
            }
        }

        List<FoodCart> listCart = new ArrayList<>();
        listCart = FoodCartService.deleteCart(txt, foodID);

        txt = null;

        for (FoodCart f : listCart) {

            if (txt == null) {
                txt = f.getFoodID() + ":" + f.getAmount();
            } else {
                txt = txt + "/" + f.getFoodID() + ":" + f.getAmount();
            }
        }

        Cookie c = new Cookie("cart", txt);
        c.setMaxAge(24 * 60 * 60);
        response.addCookie(c);

        response.sendRedirect("foodcart");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
