package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.entity.Room;
import model.service.RoomService;

@WebServlet(name = "RoomDetailController", urlPatterns = {"/room_detail"})
public class RoomDetailController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String roomID = request.getParameter("roomID");
        if (roomID == null) {
            response.sendRedirect("room");
        }else{
            Room room = RoomService.getRoomByID(roomID);
            System.out.println(room);
            request.setAttribute("room", room);
            request.getRequestDispatcher("room_details.jsp").forward(request, response);
        }
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
