package controller;

import dao.UserDao;

import model.User;
import util.Encode;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Random;

@WebServlet({"/do-register"})
public class Register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordRetype = request.getParameter("passwordRetype");
        String firstname = request.getParameter("firstname");
        String fullname = request.getParameter("fullname");
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
        String error="";
        String success="";
        String url="";
        request.setAttribute("username",username);
        request.setAttribute("email",email);
        request.setAttribute("firstname",firstname);
        request.setAttribute("fullname",fullname);
        request.setAttribute("gender",gender);
        request.setAttribute("address",address);
        UserDao dao = new UserDao();
        if(dao.findByUsername(username)) {
            error+="Tên đăng nhập đã tồn tại,vui lòng chọn tên khác.<br/>";
        }
        if(!password.equals(passwordRetype)) {
            error+="Mật khẩu không khớp.<br/>";
        }else {
            password= Encode.toSHA256(password);
        }
        request.setAttribute("error",error);
        System.out.println(error);
        if(error.length()>0) {
            url="/register.jsp";
        }else {
            Random rd = new Random();
            int userId = Math.abs((int) System.currentTimeMillis())/1000;
            User user = new User(userId,username,email,password,firstname,fullname,gender.equals("Nam")?1:0,address);
            dao.insertUser(user);
            success="Đăng ký tài khoản thành công";
            HttpSession session = request.getSession();
            session.setAttribute("success",success);
            url="/index.jsp";
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
