package controller;

import model.BenhAn;
import model.BenhNhan;
import reponsitory.BenhAnRepository;
import reponsitory.IBenhAnRepository;
import service.BenhAnService;
import service.BenhNhanService;
import service.IBenhAnService;
import service.IBenhNhan;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "BenhAnController", urlPatterns = "/benhan")
public class BenhAnController extends HttpServlet {
    IBenhAnService iBenhAnService = new BenhAnService();
    IBenhNhan iBenhNhan = new BenhNhanService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if(action == null){
            action = "list";
        }

        switch (action){
            case "list":
                showList(request,response);
                break;
            case "edit":
                showEdit(request,response);
                break;
            case "delete":
                doDeletes(request,response);
                break;
            default:
                showList(request,response);
        }
    }

    private void doDeletes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maBenhAn = request.getParameter("mabenhan");
        iBenhAnService.delete(maBenhAn);
        response.sendRedirect("/benhan?action=list");
    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maBenhAn = request.getParameter("mabenhan");
        request.setAttribute("benhan",iBenhAnService.findById(maBenhAn));
        request.setAttribute("benhnhan",iBenhNhan.findAll());
        request.getRequestDispatcher("edit.jsp").forward(request,response);
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("benhan",iBenhAnService.findAll());
        request.setAttribute("benhnhan",iBenhNhan.findAll());
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if(action == null){
            response.sendRedirect("/benhan?action=list");
            return;
        }

        switch (action){
            case "edit":
                doEdit(request,response);
                break;
            default:
                showList(request,response);
        }
    }

    private void doEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maBA = request.getParameter("maBA");
        String maBN = request.getParameter("maBN");
        String name = request.getParameter("name");
        String ngayVao = request.getParameter("ngayVao");
        String ngayRa = request.getParameter("ngayRa");
        String lyDo = request.getParameter("lyDo");
        BenhAn benhAn = new BenhAn(maBA, maBN,name,ngayVao,ngayRa,lyDo);
        iBenhAnService.update(benhAn);
        response.sendRedirect("/benhan?action=list");
    }


}
