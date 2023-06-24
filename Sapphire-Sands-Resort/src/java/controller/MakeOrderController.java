package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.entity.Contract;
import model.entity.Customer;
import model.entity.Room;
import model.service.OrderService;

@WebServlet(name = "MakeOrderController", urlPatterns = {"/makeorder"})
public class MakeOrderController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String roomID = request.getParameter("roomID");
        Room room = (Room) session.getAttribute("accept_room");
        Customer cus = (Customer) session.getAttribute("customer");
        Contract temporaryContract = (Contract) session.getAttribute("temporary_contract");
        OrderService.makeOrder(room, temporaryContract, cus);
        request.getRequestDispatcher("done_regist_room.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
