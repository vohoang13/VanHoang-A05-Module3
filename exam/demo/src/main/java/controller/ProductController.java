package controller;

import model.Category;
import model.Product;
import responsitory.ProductRepository;
import service.CategoryService;
import service.ICategoryService;
import service.IProductService;
import service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductController", urlPatterns = "/product")
public class ProductController extends HttpServlet {
    IProductService iProductService = new ProductService();
    ICategoryService iCategoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "list":
                showList(req, resp);
                break;
            case "create":
                showCreate(req, resp);
                break;
            case "delete":
                doDeletes(req,resp);
                break;
            case "edit":
                try {
                    showEdit(req,resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                showList(req, resp);
        }
    }

    private void showEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = iProductService.findById(id);
        req.setAttribute("category", iCategoryService.findAll());
        req.setAttribute("p", product);
        req.getRequestDispatcher("Edit.jsp").forward(req, resp);
    }

    private void doDeletes(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        iProductService.deleteId(id);
        resp.sendRedirect("/product?action=list");
    }

    private void showCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categoryList = iCategoryService.findAll();
        req.setAttribute("category", categoryList);
        req.getRequestDispatcher("/create.jsp").forward(req, resp);
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categoryList = iCategoryService.findAll();
        req.setAttribute("category", categoryList);
        req.setAttribute("product", iProductService.findAll());
        req.getRequestDispatcher("/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            resp.sendRedirect("/product?action=list");
            return;
        }
        switch (action) {
            case "create":
                doCreate(req, resp);
                break;
            case "edit":
                doEdit(req,resp);
                break;
            default:
                resp.sendRedirect("/product?action=list");
        }
}

    private void doEdit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        float price = Float.parseFloat(req.getParameter("price"));
        int amount = Integer.parseInt(req.getParameter("amount"));
        String color = req.getParameter("color");
        String descriptions = req.getParameter("descriptions");
        int idCategory = Integer.parseInt(req.getParameter("idCategory"));
        Product product = new Product(id, name, price, amount, color, descriptions, idCategory);
        iProductService.editId(product);
        resp.sendRedirect("/product?action=list");
    }

    private void doCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        float price = Float.parseFloat(req.getParameter("price"));
        int amount = Integer.parseInt(req.getParameter("amount"));
        String color = req.getParameter("color");
        String descriptions = req.getParameter("descriptions");
        int idCategory = Integer.parseInt(req.getParameter("idCategory"));
        Product product = new Product(id, name, price, amount, color, descriptions, idCategory);
        iProductService.addNew(product);
        resp.sendRedirect("/product?action=list");
    }
}
