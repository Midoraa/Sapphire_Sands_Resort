package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.entity.Contract;
import model.entity.Room;
import model.service.RoomService;

@WebServlet(name = "ContractAcceptController", urlPatterns = {"/confirm_contract"})
public class ConfirmContractController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ContractAcceptController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ContractAcceptController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String roomID = request.getParameter("roomID");
        String timeIn = request.getParameter("time_in");
        String timeOut = request.getParameter("time_out");
        int maxPeople = Integer.parseInt(request.getParameter("people"));
        Room room = RoomService.getRoomByID(roomID);   
        Contract temporary = new Contract(roomID, timeIn, timeOut, maxPeople);
        HttpSession session = request.getSession();
        session.setAttribute("temporary_contract", temporary);
        session.setAttribute("accept_room", room);
        request.setAttribute("time_in", timeIn);
        request.setAttribute("time_out", timeOut);
        request.setAttribute("people", maxPeople);
        request.getRequestDispatcher("confirm_contract.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
