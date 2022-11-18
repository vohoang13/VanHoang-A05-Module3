package ss9.thuc_hanh;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletTuDien", urlPatterns = "/tudien")
public class ServletTuDien extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("ss9/thuc_hanh/tu_dien/tu_dien.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String word = request.getParameter("word");
        String distionary[] = {"hello","computer","how","book"};
        String vietnamese[] = {"xin chào","máy tính","thế nào","quyển vở"};
        String result="";
        for(int i=0; i < distionary.length; i++){
            if(distionary[i].equals(word)){
                result += vietnamese[i];
            }else {
                continue;
            }
        }
        if(result == ""){
            result += "Not found";
        }
        request.setAttribute("result", result );
        request.setAttribute("word", word);
        request.getRequestDispatcher("ss9/thuc_hanh/tu_dien/result.jsp").forward(request,response);
    }
}
