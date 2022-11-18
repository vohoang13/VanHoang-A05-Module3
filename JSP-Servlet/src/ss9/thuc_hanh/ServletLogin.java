package ss9.thuc_hanh;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletLogin", urlPatterns = "/login")
public class ServletLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("ss9/thuc_hanh/form_dang_ki/dang_ki.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        request.setAttribute("user", user);
        request.setAttribute("pass", pass);
        request.getRequestDispatcher("ss9/thuc_hanh/form_dang_ki/hello.jsp").forward(request, response);
    }
}
