<%@ page import="model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bảng điều khiển</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
        .container {
            max-width: 960px;
        }
    </style>
</head>
<body class="bg-light">
<%
    String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + request.getContextPath();
%>

<main class="container">
    <div class="toast" role="alert" aria-live="assertive" aria-atomic="true" data-bs-autohide="false">
        <div class="toast-header">
            <strong class="mr-auto">Bootstrap</strong>
            <small class="text-muted">11 mins ago</small>
            <button type="button" class="ml-2 mb-1 close" data-dismiss="toast" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
        <div class="toast-body">
            Thêm hóa đơn thành công!
        </div>
    </div>
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Bảng điều khiển</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="<%=url%>/insert.jsp">Thêm hóa đơn</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Thống kê</a>
                    </li>
                </ul>
                <form class="d-flex" role="search">
                    <%
                        Object obj = session.getAttribute("user");
                        User user = null;
                        if(obj!=null) {
                            user = (User) obj;
                        }
                        if (user!=null){%>
                    <div class="btn-group">
                        <button type="button dropstart" class="btn btn-info dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
                            Tài khoản
                        </button>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="#"> Thông báo </a></li>
                            <li><a class="dropdown-item" href="#">Thay đổi thông tin</a></li>
                            <li><a class="dropdown-item" href="">Đổi mật khẩu</a></li>
                            <li><hr class="dropdown-divider"></li>
                            <li><a class="dropdown-item" href="/logout">Đăng xuất</a></li>
                        </ul>
                    </div>
                </form>
            </div>
        </div>
    </nav>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">id</th>
            <th scope="col">Tên mặt hàng</th>
            <th scope="col">Loại</th>
            <th scope="col">Giá</th>
            <th scope="col">Ngày mua</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="todo" items="${list}">
            <tr>
                <td>
                    <c:out value="${todo.id}" />
                </td>
                <td>
                    <c:out value="${todo.name}" />
                </td>
                <td>
                    <c:out value="${todo.type}" />
                </td>
                <td>
                    <c:out value="${todo.price}" />
                </td>
                <td>
                    <c:out value="${todo.date_buy}" />
                </td>
                <td><a class="btn btn-primary"
                       href="<%=url%>/edit?id=<c:out value='${todo.id}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp; <a class="btn btn-danger"
                                                href="<%=url%>/delete?id=<c:out value='${todo.id}' />">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</main>
<%}%>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</body>
</html>