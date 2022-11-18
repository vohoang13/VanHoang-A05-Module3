package ss9.bai_tap;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletDiscount", urlPatterns = "/display")
public class ServletDiscount extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("ss9/bai_tap/discount.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productDes = request.getParameter("productDes");
        int price = Integer.parseInt(request.getParameter("price"));
        int percent = Integer.parseInt(request.getParameter("percent"));
        double discountAmount = price * percent * 0.01;
        double discountPrice = price - discountAmount;
        request.setAttribute("productDes",productDes);
        request.setAttribute("discountAmount",discountAmount);
        request.setAttribute("discountPrice",discountPrice);
        request.getRequestDispatcher("ss9/bai_tap/display_discount.jsp").forward(request,response);
    }
}
