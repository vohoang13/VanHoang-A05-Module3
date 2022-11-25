package controller;

import model.Book;
import model.Category;
import service.BookService;
import service.CategoryService;
import service.IBookService;
import service.ICategoryService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "BookController", urlPatterns = "/book")
public class BookController extends HttpServlet {
    private IBookService iBookService = new BookService();
    private ICategoryService iCategoryService = new CategoryService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if(action == null){
            action = "list";
        }

        switch (action){
            case "create" :
                showCreate(request,response);
                break;
            case "list":
                showList(request,response);
                break;
            case "update":
                showUpdate(request,response);
                break;
            case "delete":
                showDelete(request,response);
                break;
            case "listId":
                break;
            default:
                showList(request,response);
        }
    }

    private void showUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setAttribute("categories", iCategoryService.findAll());
        request.getRequestDispatcher("update.jsp").forward(request,response);
    }

    private void showDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.getRequestDispatcher("delete.jsp").forward(request,response);
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        request.setAttribute("category", iCategoryService.findAll());
        request.getRequestDispatcher("create.jsp").forward(request,response);
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setAttribute("book",iBookService.findAll());
        request.getRequestDispatcher("list.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if(action == null){
           response.sendRedirect("/book?action=list");
           return;
        }

        switch (action){
            case "create" :
                doCreate(request,response);
                break;
            case "update":
                doUpdate(request,response);
                break;
            case "delete":
                doDeletes(request,response);
                break;
            default:
                response.sendRedirect("/book?action=list");
        }

    }

    private void doUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String author = request.getParameter("author");
        String categoryId = request.getParameter("categoryId");
        Category category = iCategoryService.findById(categoryId);
        Book book = new Book(id,name,author,category);
        iBookService.update(id,book);
        response.sendRedirect("/book?action=list");
    }
    private void doDeletes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        iBookService.delete(id);
        response.sendRedirect("/book?action=list");
    }

    private void doCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String author = request.getParameter("author");
        String categoryId = request.getParameter("categoryId");
        Category category = iCategoryService.findById(categoryId);
        Book book = new Book(id,name,author,category);
        iBookService.create(book);
        response.sendRedirect("/book?action=list");
    }
}
