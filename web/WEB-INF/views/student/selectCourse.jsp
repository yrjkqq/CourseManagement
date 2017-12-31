<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
    <base href="<%=basePath%>">
    <title>选课页面</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <script src="assets/js/jquery-1.12.3.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
</head>

<body>
<%--todo 学生选择课程--%>
<div class="wrapper">
    <%--导航栏--%>
    <div class="row">
        <jsp:include page="../commons/header.jsp">
            <jsp:param name="target" value="student"/>
        </jsp:include>
    </div>
    <div class="content-wrapper ">
        <section class="content">
            <div class="row">
                <%-- 使用 from 表单包含到所有复选框; 将当前学生 id 返回--%>
                <form action="/student/selectCourse/${currentStudent.sid}" method="post">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <strong>课程列表</strong>
                            <div class="col-md-2 pull-right">
                                当前学生: ${currentStudent.sname}&nbsp;&nbsp;ID: ${currentStudent.sid}</div>
                        </div>
                        <table class="table table-hover table-bordered text-center">
                            <thead>
                            <tr>
                                <th style="text-align: center">选择</th>
                                <th style="text-align: center">编号</th>
                                <th style="text-align: center">课程名称</th>
                            </tr>
                            </thead>
                            <tbody>

                            <c:forEach items="${courses}" var="course">
                                <tr>
                                    <td>
                                            <%--将课程 id 作为参数传输, 保持同 name 不同 value, 用数组接受结果--%>
                                        <input type="checkbox" name="selectedCourse" value="${course.cid}"
                                            <%-- 所有已选课程需要为选中状态--%>
                                                <c:if test="${selectedCourses.contains(course)}">
                                                    checked="checked"
                                                </c:if>
                                        />
                                    </td>
                                    <td>${course.cid}</td>
                                    <td>${course.cname}</td>
                                </tr>
                            </c:forEach>

                            </tbody>
                        </table>
                        <div class="panel-footer">
                            <button type="submit" class="btn btn-primary btn-sm">提交</button>
                            <a role="button" class="btn btn-warning btn-sm" onclick="history.go(-1)">返回</a>
                        </div>
                    </div>
                </form>
            </div>
        </section>
    </div>
</div>
</body>
</html>
