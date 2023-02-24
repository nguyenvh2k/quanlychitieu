package controller;

import dao.ProductDao;
import model.Product;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "insert", value = "/insert")
public class Insert extends HttpServlet {
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
        String productname = request.getParameter("productname");
        String typename = request.getParameter("typename");
        String price = request.getParameter("price");
        String date = request.getParameter("date");
        int id = (int) (System.currentTimeMillis()/1000);
        int price_int = Integer.parseInt(price);
        String url = "/insert.jsp";
        String success = "";
        Product product = new Product(id,productname,typename,price_int,Date.valueOf(date),user);
        ProductDao dao = new ProductDao();
        if(dao.insert(product)==1) {
            url = "/dashbroad";
            success = "Thêm hóa đơn thành công !";
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        doGet(request,response);
    }
}
