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
import model.entity.Room;
import model.service.RoomService;

@WebServlet(name = "ListChooseRoomController", urlPatterns = {"/list_choose_room"})
public class ListChooseRoomController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListChooseRoomController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListChooseRoomController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Room> listRoom = new ArrayList<Room>();
        String timeIn = request.getParameter("time_in");
        String timeOut = request.getParameter("time_out");
        String roomType = request.getParameter("room_type");
        int maxPeople = Integer.parseInt(request.getParameter("max_people"));

        listRoom = RoomService.getChoosenRoom(roomType, maxPeople);
        request.setAttribute("listChoosenRoom", listRoom);
        request.setAttribute("time_in", timeIn);
        request.setAttribute("time_out", timeOut);
        request.setAttribute("room_type", roomType);
        request.setAttribute("people", maxPeople);
        request.getRequestDispatcher("list_choose_room.jsp").forward(request, response);

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
