<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
    <base href="<%=basePath%>">
    <title>课程首页</title>
    <script src="assets/js/jquery-1.12.3.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
</head>

<body>
<div class="container-fluid">
    <%--导航栏--%>
    <div class="row">
        <jsp:include page="../commons/header.jsp">
            <jsp:param name="target" value="course"/>
        </jsp:include>
    </div>
    <div class="container">
        <div class="row">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <strong>课程列表</strong>
                    <div class="btn-group pull-right" style="margin-top: -5px" role="group">
                        <%-- 使用模态框添加课程--%>
                        <a href="#myModal" data-toggle="modal" class="btn btn-sm btn-primary" role="button">添加</a>

                        <!-- Modal -->
                        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span></button>
                                        <h4 class="modal-title" id="myModalLabel">添加课程</h4>
                                    </div>
                                    <form action="course/add" class="form-horizontal" method="post">
                                        <div class="modal-body">
                                            <div class="form-group">
                                                <label class="col-md-2 control-label">课程名称:</label>
                                                <div class="col-md-10">
                                                    <input type="text" class="form-control" name="cname"
                                                           placeholder="COURSE NAME">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">取消
                                            </button>
                                            <button type="submit" class="btn btn-primary">提交</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <table class="table table-hover table-bordered text-center">
                    <thead>
                    <tr>
                        <th style="text-align: center">编号</th>
                        <th style="text-align: center">课程名称</th>
                        <th style="text-align: center">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${courses}" var="course">
                        <tr>
                            <td>${course.cid}</td>
                            <td>${course.cname}</td>
                            <td><a href="#" role="button" class="btn btn-danger btn-sm">删除</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>


</body>
</html>
