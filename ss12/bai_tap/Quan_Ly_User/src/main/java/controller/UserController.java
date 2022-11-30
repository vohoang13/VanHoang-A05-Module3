package controller;

import model.User;
import service.IUserService;
import service.UserService;

import javax.jws.soap.SOAPBinding;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserController", urlPatterns = "/user")
public class UserController  extends HttpServlet {
    private IUserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if(action == null){
            action = "list";
        }

        switch (action){
            case "create":
                showCreate(req,resp);
                break;
            case "list":
                showList(req,resp);
                break;
            case "update":
                showUpdate(req,resp);
                break;
            case "sort":
                showSort(req,resp);
                break;
            case "delete":
                showDelete(req,resp);
                break;
            case "searchCountry":
                showSearch(req,resp);
                break;
            case "findById":
                showListId(req,resp);
                break;
            case "updateByName":
                showUpdateName(req,resp);
                break;
            case "deleteName":
                showDeleteName(req,resp);
                break;
            case "addTransaction":
                showCreate(req,resp);
                break;
            default:
                showList(req,resp);
        }
    }

    private void showDeleteName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("deleteName.jsp").forward(req,resp);
    }

    private void showUpdateName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("updateName.jsp").forward(req,resp);
    }

    private void showListId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("searchId.jsp").forward(req,resp);
    }

    private void showSearch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("searchCountry.jsp").forward(req,resp);
    }

    private void showSort(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users",userService.sort());
        req.getRequestDispatcher("list.jsp").forward(req,resp);
    }

    private void showUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("update.jsp").forward(req,resp);
    }

    private void showDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("delete.jsp").forward(req,resp);
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users",userService.findAll());
        req.getRequestDispatcher("/list.jsp").forward(req,resp);
    }

    private void showCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/create.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if(action == null){
            action = "list";
        }

        switch (action){
            case "create":
                doCreate(req,resp);
                break;
            case "update":
                doUpdate(req,resp);
                break;
            case "delete":
                doDeletes(req,resp);
                break;
            case "searchCountry":
                doSearch(req,resp);
                break;
            case "findById":
                doShowId(req,resp);
                break;
            case "updateByName":
                doUpdateName(req,resp);
                break;
            case "deleteName":
                doDeleteName(req,resp);
                break;
            case "addTransaction":
                try {
                    doAddTransaction(req,resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                resp.sendRedirect("/user?action=list");
        }
    }

    private void doAddTransaction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String country = req.getParameter("country");
        User user = new User(id,name,email,country);
        userService.addUserTransaction(user);
        resp.sendRedirect("/user?action=list");
    }

    private void doDeleteName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        userService.deleteByName(name);
        resp.sendRedirect("/user?action=list");
    }

    private void doUpdateName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String country = req.getParameter("country");
        String email = req.getParameter("email");
        User user = new User(name,email,country);
        userService.updateByName(user);
        resp.sendRedirect("/user?action=list");
    }

    private void doShowId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        req.setAttribute("users",userService.findID(id));
        req.getRequestDispatcher("result.jsp").forward(req,resp);
    }

    private void doSearch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String country = req.getParameter("country");
        req.setAttribute("users",userService.searchByCountry(country));
        req.getRequestDispatcher("search_result.jsp").forward(req,resp);
    }

    private void doUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String country = req.getParameter("country");
        User user = new User(id,name,email,country);
        userService.update(user);
        resp.sendRedirect("/user?action=list");
    }

    private void doDeletes(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        userService.deleteId(id);
        resp.sendRedirect("/user?action=list");
    }

    private void doCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String country = req.getParameter("country");
        User user = new User(id,name,email,country);
        userService.addNew(user);
        resp.sendRedirect("/user?action=list");
    }
}
