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
import model.entity.Food;
import model.service.FoodService;

@WebServlet(name = "FoodController", urlPatterns = {"/food"})

public class FoodController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        Cookie cookie = new Cookie("cart", "");
        cookie.setMaxAge(24*60*60);

        List<Food> listFood = new ArrayList<Food>();
        listFood = FoodService.getFood();

        int totalItem = listFood.size();
        int itemsPerPage = 8;
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

        request.setAttribute("listFood", listFood);
        request.setAttribute("itemsPerPage", itemsPerPage);
        request.setAttribute("maxPage", maxPage);
        request.setAttribute("page", page);

        request.getRequestDispatcher("food.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
