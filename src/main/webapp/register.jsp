<%@ page import="dao.UserDao" %><%--
  Created by IntelliJ IDEA.
  User: SMILE
  Date: 13-01-2023
  Time: 5:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>Đăng ký</title>
    <style>
        .req {
            color: red;
        }
    </style>
</head>
<body>
<%
    String error = (request.getAttribute("error")+"").equals("null")?"":(request.getAttribute("error")+"");
    String username = request.getParameter("username")+"";
    username = (username.equals("null"))?"":username;
    String email = request.getParameter("email")+"";
    email = (email.equals("null"))?"":email;
    String firstname = request.getParameter("firstname")+"";
    firstname = (firstname.equals("null"))?"":firstname;
    String fullname = request.getParameter("fullname")+"";
    fullname = fullname.equals("null")?"":fullname;
    String gender = request.getParameter("gender")+"";
    gender = (gender.equals("null"))?"":gender;
    String address = request.getParameter("address")+"";
    address = (address.equals("null"))?"":address;

%>
<div class="container ">
    <h1 class="text-center">Đăng ký tài khoản mới</h1>
    <div class="req" id="error">
        <%=error%>
    </div>
    <form class="form" action="do-register" method="post">
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="username">Tên đăng nhập</label><span class="req">*</span><span class="req" id="msg1">*</span>
                <input type="text" class="form-control" id="username" name="username" required="required" value="<%=username%>" onkeyup="checkUsername()">
            </div>
            <div class="form-group col-md-6">
                <label for="email">Email</label><span class="req">*</span>
                <input type="email" class="form-control" id="email" name="email" required="required" value="<%=email%>">
            </div>
        </div>

        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="password">Mật khẩu</label><span class="req">*</span>
                <input type="password" class="form-control" id="password" name="password" required="required">
            </div>
            <div class="form-group col-md-6">
                <label for="passwordRetype">Nhập lại mật khẩu</label><span class="req" id="msg">*</span>
                <input type="password" class="form-control" id="passwordRetype" name="passwordRetype"
                       required="required" onkeyup="checkPasswordEqual()">
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="firstname">Tên</label><span class="req">*</span>
                <input type="text" class="form-control" id="firstname" name="firstname" required="required" value="<%=firstname%>">
            </div>

            <div class="form-group col-md-6">
                <label for="fullname">Tên đầy đủ</label><span class="req">*</span>
                <input type="text" class="form-control" id="fullname" name="fullname" required="required" value="<%=fullname%>">
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="gender" class="form-label">Giới tính</label>
                <select class="form-control" id="gender" name="gender">
                    <option></option>
                    <option value="Nam">Nam</option>
                    <option value="Nữ">Nữ</option>
                </select>
            </div>

            <div class="form-group col-md-6">
                <label for="address">Địa chỉ</label>
                <input type="text" class="form-control" id="address" name="address" value="<%=address%>">
            </div>
        </div>
        <button type="submit" class="btn btn-primary" id="submit" name="submit">Đăng ký</button>
    </form>
</div>

<script>
    function checkPasswordEqual() {
        const password = document.getElementById("password").value;
        const passwordRetype = document.getElementById("passwordRetype").value;
        if (password != passwordRetype) {
            document.getElementById("msg").innerHTML = " Mật khẩu không khớp";
            return false;
        } else {
            document.getElementById("msg").innerHTML = "";
            return true;
        }
    }

</script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>
