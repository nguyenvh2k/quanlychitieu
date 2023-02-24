package controller;

import dao.ProductDao;
import model.Product;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "delete", value = "/delete")
public class Delete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("user");
        User user = null;
        if(obj!=null) {
            user = (User) obj;
        } else {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            ProductDao dao = new ProductDao();
            dao.delete(id);
        }catch (Exception e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/dashbroad").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
