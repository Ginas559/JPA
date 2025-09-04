package jpa.Controllers.admin;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jpa.entity.Category;
import jpa.services.CategoryService;
import jpa.services.Impl.CategoryServiceImpl;


@WebServlet(urlPatterns = {"/admin/categories"})
public class CategoryController extends HttpServlet{
	
	CategoryService cateService = new CategoryServiceImpl();
	
	private static long serialVersionID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Category> listCategory = cateService.findAll();
		req.setAttribute("listcate", listCategory);
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/categories.jsp");
		rd.forward(req, resp);
	}

}
