<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Đăng nhập</title>
    <%
        String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                + request.getContextPath();
    %>
    <link href="<%=url%>/css/signin.css" rel="stylesheet">
    <style>
        .req{
            color: red;
        }
        .blue{
            color: cornflowerblue;
        }
    </style>
</head>
<body class="text-center">
<form class="form-signin" action="login" method="post">
    <img class="mb-4" src="<%=url%>/img/logo/logo.png" alt="" width="72" height="72">
    <h1 class="h3 mb-3 font-weight-normal">Đăng nhập</h1>
    <%
        String error = request.getAttribute("error")+"";
        if (error.equals("null")) {
            error="";
        }
        String success = session.getAttribute("success")+"";
        success = (success.equals("null"))?"":success;
    %>
    <div class="text-center"><span class="req"><%=error%></span></div>
    <div class="text-center"><span class="blue"><%=success%></span></div>
    <label for="username" class="sr-only">Tên đăng nhập</label>
    <input type="text" id="username" class="form-control" placeholder="Tên đăng nhập" name="username">
    <label for="password" class="sr-only">Mật khẩu</label>
    <input type="password" id="password" class="form-control" placeholder="Mật khẩu" name="password">
    <div class="checkbox mb-3">
        <label>
            <input type="checkbox" value="remember-me"> Ghi nhớ tài khoản
        </label>
    </div>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Đăng nhập</button>
    <a href="register.jsp">Đăng ký tài khoản mới</a>

    <p class="mt-5 mb-3 text-muted">&copy; 2017-2025</p>
</form>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>