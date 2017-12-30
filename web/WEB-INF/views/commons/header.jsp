<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
    <base href="<%=basePath%>">
    <title>导航栏</title>
    <%--<script src="assets/js/jquery-1.12.3.min.js"></script>--%>
    <%--<script src="assets/js/bootstrap.min.js"></script>--%>
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
</head>

<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="student">学生选课系统</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="${param.target == 'student' ? 'active' : ''}">
                    <a href="student">学生首页 <span class="sr-only">(current)</span></a>
                </li>
                <li class="${param.target == 'course' ? 'active' : ''}">
                    <a href="course">课程首页</a>
                </li>

            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li><a href="student">登陆</a></li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
</body>
</html>
