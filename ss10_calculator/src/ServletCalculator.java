import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletCalculator", urlPatterns = "/calculator")
public class ServletCalculator extends HttpServlet {
    private Calculate calculate = new Calculate();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float first = Float.parseFloat(request.getParameter("first"));
        float second = Float.parseFloat(request.getParameter("second"));
        double result = 0;
        String select = request.getParameter("select");
        result = calculate.getCalculate(first,second,select);
        request.setAttribute("first", first);
        request.setAttribute("second", second);
        request.setAttribute("select", select);
        request.setAttribute("result", result);
        request.getRequestDispatcher("/result.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
