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
import model.service.FoodService;

@WebServlet(name = "ProcessCartController", urlPatterns = {"/processFoodCart"})
public class ProcessCartController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    
            //        Lấy trạng thái ở client người dùng
        String statusWeb = request.getParameter("statusWeb");

//        Tạo chuỗi txt rỗng
        String txt = "";

//        Lấy giá trị Cookie ở trên Client Khách Hàng rồi gán giá trị vào 1 chuỗi và xóa Cookie đó
        Cookie[] arr = request.getCookies();
        if (arr != null) {
            for (Cookie o : arr) {
                if (o.getName().equals("cartFood")) {
                    txt = txt + o.getValue();
                    o.setMaxAge(0);
                    response.addCookie(o);
                }
            }
        }
        System.out.println("Status Website: " + statusWeb);
//        Insert dữ liệu vào Data ServiceDetail
        if(statusWeb.equals(statusWeb == null)){
            
            response.sendRedirect("foodCart");
        }
        else if(statusWeb.equals("order")){
//            String orderID = "OD000005";
            String orderID = request.getParameter("orderID");
            FoodService.insertOrderDetail(txt, orderID);
            response.sendRedirect("foodCart");  
        }     
    
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    String statusWeb = request.getParameter("statusWeb");

//        Tạo chuỗi txt rỗng
        String txt = "";

//        Lấy giá trị Cookie ở trên Client Khách Hàng rồi gán giá trị vào 1 chuỗi và xóa Cookie đó
        Cookie[] arr = request.getCookies();
        if (arr != null) {
            for (Cookie o : arr) {
                if (o.getName().equals("cartFood")) {
                    txt = txt + o.getValue();
                    o.setMaxAge(0);
                    response.addCookie(o);
                }
            }
        }

//        Nếu trạng thái trên web rỗng
        if (statusWeb == null) {
            String foodID = request.getParameter("foodID");
//        Kiểm tra đầu vào của Service có bị rỗng hay không?
            if (foodID != null) {
                if (txt.isEmpty()) {
                    txt = foodID + ":" + 1;
                } else {
                    txt = txt + "/" + foodID + ":" + 1;
                }
            }
//        Sửa lại Cookie cho đúng mãu: ID:Amount
            String cart = FoodService.resetCookieCart(txt);

//        Thiết lập lại giá trị bằng cách tạo ra cookie mới
            Cookie c = new Cookie("cartFood", cart);
            c.setMaxAge(24 * 60 * 60);
            response.addCookie(c);

//        Trả về trang Service để người dùng tiếp tục chọn dịch vụ muốn sử dụng
            response.sendRedirect("food");
//        request.getRequestDispatcher("service").forward(request, response);
        } 
//        Tăng giảm số lượng của 1 dịch vụ
        else if (statusWeb.equals("quantity")) {
            String foodID = request.getParameter("foodID");
            int numUpdate = Integer.parseInt(request.getParameter("num"));

            System.out.println("Food ID: " + foodID + " Number Update: " + numUpdate);
            
            List<FoodCart> list = new ArrayList<>();
            list = FoodService.updateQuantityFood(txt, foodID, numUpdate);

            txt = null;

            for (FoodCart s : list) {
                if (txt != null) {
                    txt = txt + "/" + s.getFoodID() + ":" + s.getAmount();
                } else {
                    txt = s.getFoodID() + ":" + s.getAmount();
                }
            }

            Cookie c = new Cookie("cartFood", txt);
            c.setMaxAge(24 * 60 * 60);
            response.addCookie(c);
            
            response.sendRedirect("foodCart");
        } 
//        Xóa 1 service khỏi Cart
        else if(statusWeb.equals("delete")){
            String foodID = request.getParameter("foodID");
            String cookie = FoodService.deleteFoodCart(txt, foodID);
            
            Cookie c = new Cookie("cartFood", cookie);
            c.setMaxAge(24 * 60 * 60);
            response.addCookie(c);
            
            response.sendRedirect("foodCart");
        }
    
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
