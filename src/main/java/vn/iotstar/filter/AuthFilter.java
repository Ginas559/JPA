package vn.iotstar.filter;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.*;

import vn.iotstar.entity.User;

@WebFilter("/*")
public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);

        String path = req.getServletPath();

        // Cho phép public URL
        if (path.startsWith("/login") || path.startsWith("/register")
                || path.startsWith("/views/") || path.startsWith("/css")
                || path.startsWith("/js")) {
            chain.doFilter(request, response);
            return;
        }

        // Nếu chưa login
        if (session == null || session.getAttribute("account") == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        // Đã login → check role
        User user = (User) session.getAttribute("account");

        if (user.getRoleid() == 3 && path.startsWith("/admin")) {
            chain.doFilter(request, response);
            return;
        }
        if (user.getRoleid() == 2 && path.startsWith("/manager")) {
            chain.doFilter(request, response);
            return;
        }
        if (user.getRoleid() == 1 && path.startsWith("/user")) {
            chain.doFilter(request, response);
            return;
        }

        // Nếu truy cập /waiting thì cho phép
        if (path.startsWith("/waiting")) {
            chain.doFilter(request, response);
            return;
        }

        // Không khớp role và URL → đưa về /login thay vì /waiting (tránh loop)
        resp.sendRedirect(req.getContextPath() + "/login");
    }
}
