package controller;

import dao.UserDao;
import model.User;
import util.Encode;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "login", value = "/login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        password = Encode.toSHA256(password);
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        UserDao dao = new UserDao();
        User userResult = dao.findByUsernameAndPassword(user);
        String url="/index.jsp";
        if(userResult!=null) {
            HttpSession session = request.getSession();
            session.setAttribute("user",userResult);
            url="/dashbroad";
        }else {
            request.setAttribute("error","Tên đăng nhập hoặc mật khẩu không chính xác");
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
        rd.forward(request,response);
    }
}
