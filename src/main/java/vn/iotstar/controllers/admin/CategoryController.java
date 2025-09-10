package vn.iotstar.controllers.admin;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import vn.iotstar.entity.Category;
import vn.iotstar.entity.User;
import vn.iotstar.services.CategoryService;
import vn.iotstar.services.impl.CategoryServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/admin/categories","/manager/categories","/user/categories"})
public class CategoryController extends HttpServlet {

    CategoryService cateService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "list";

        switch (action) {
            case "add":
                req.getRequestDispatcher("/views/category/add.jsp").forward(req, resp);
                break;
            case "edit":
                int idEdit = Integer.parseInt(req.getParameter("id"));
                Category cateEdit = cateService.findById(idEdit);
                req.setAttribute("cate", cateEdit);
                req.getRequestDispatcher("/views/category/edit.jsp").forward(req, resp);
                break;
            case "delete":
                int idDel = Integer.parseInt(req.getParameter("id"));
                cateService.delete(idDel);
                resp.sendRedirect(req.getRequestURI());
                break;
            default:
                HttpSession session = req.getSession();
                User u = (User) session.getAttribute("account");

                List<Category> list;
                if (req.getRequestURI().contains("/manager/")) {
                    list = cateService.findByUser(u.getId());
                } else {
                    list = cateService.findAll();
                }

                req.setAttribute("listcate", list);
                req.getRequestDispatcher("/views/category/list.jsp").forward(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String action = req.getParameter("action");
        if (action == null) action = "";

        HttpSession session = req.getSession();
        User u = (User) session.getAttribute("account");

        if ("add".equals(action)) {
            String name = req.getParameter("name");
            Category c = new Category();
            c.setCategoryname(name);
            c.setUser(u);  // gán user tạo
            cateService.create(c);
            resp.sendRedirect(req.getRequestURI());
        } else if ("edit".equals(action)) {
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            Category c = cateService.findById(id);

            // nếu là manager thì chỉ cho sửa category của mình
            if (u.getRoleid() == 2 && c.getUser().getId() != u.getId()) {
                resp.sendRedirect(req.getContextPath() + "/waiting");
                return;
            }
            c.setCategoryname(name);
            cateService.update(c);
            resp.sendRedirect(req.getRequestURI());
        }
    }
}
