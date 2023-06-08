package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FoodCartController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FoodCartController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cusID = request.getParameter("cusID");
        
        List<FoodCart> listOrder = new ArrayList<>();
        listOrder = FoodCartService.getFoodCart("CUS000002");
        long totalMoney = FoodCartService.getTotalPrice("CUS000002");
        int totalItem = FoodCartService.getTotalItem("CUS000002");
        
        request.setAttribute("listOrder", listOrder);
        request.setAttribute("totalPrice", totalMoney);
        request.setAttribute("totalItem", totalItem);
        
        
        System.out.println(totalItem);
        
        
        request.getRequestDispatcher("food_cart.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
