package vn.iotstar.controllers.manager;

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
@WebServlet(urlPatterns = "/manager/home")
public class ManagerHomeController extends HttpServlet {
    CategoryService cateService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession();
        User u = (User) session.getAttribute("account");

        List<Category> list = cateService.findByUser(u.getId());
        req.setAttribute("listcate", list);

        RequestDispatcher rd = req.getRequestDispatcher("/views/manager/home.jsp");
        rd.forward(req, resp);
    }
}
