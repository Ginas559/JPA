package jpa.Controllers.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

import jpa.dao.CategoryDao;
import jpa.dao.Impl.CategoryImpl;
import jpa.entity.Category;

@WebServlet(urlPatterns = {"/admin/category", "/CategoryServlet"})
public class CategoryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private CategoryDao categoryDao = new CategoryImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            categoryDao.delete(id);
            response.sendRedirect(request.getContextPath() + "/admin/category");
            return;
        }

        // Default: hiển thị danh sách
        List<Category> list = categoryDao.findAll();
        request.setAttribute("listCategory", list);
        request.getRequestDispatcher("/views/admin/category-list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String idStr = request.getParameter("id");
        String name = request.getParameter("name");

        if (idStr == null || idStr.isEmpty()) {
            // create
            Category cate = new Category();
            cate.setName(name);
            categoryDao.create(cate);
        } else {
            // update
            int id = Integer.parseInt(idStr);
            Category cate = categoryDao.findById(id);
            if (cate != null) {
                cate.setName(name);
                categoryDao.update(cate);
            }
        }

        response.sendRedirect(request.getContextPath() + "/admin/category");
    }
}
