package controller;

import dao.ProductDao;
import model.Product;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "dashbroad", value = "/dashbroad")
public class DashBroad extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("user");
        User user = null;
        if(obj!=null) {
            user = (User) obj;
        } else {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
        try {
            ProductDao dao = new ProductDao();
            List<Product> list = dao.selectAll(user);
            request.setAttribute("list",list);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error: " + e.getMessage());
        }
        request.getRequestDispatcher("/dashbroad.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("user");
        User user = null;
        if(obj!=null) {
            user = (User) obj;
        }else
            if(user==null) {
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }
        try {
            ProductDao dao = new ProductDao();
            List<Product> list = dao.selectAll(user);
            request.setAttribute("list",list);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error: " + e.getMessage());
        }
        request.getRequestDispatcher("/dashbroad.jsp").forward(request, response);
    }
}
