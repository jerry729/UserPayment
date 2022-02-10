<%@page import="com.util.Info"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-cn">

<jsp:include page="head.jsp"></jsp:include>

<script src="assets/js/reg.js"></script>
<body>
<div class="wrapper">

    <jsp:include page="header.jsp"></jsp:include>

    <!-- Sidebar -->
    <jsp:include page="sidebar.jsp"></jsp:include>




    <div class="main-panel">
        <div class="content">
            <div class="page-inner">
                <div class="page-header">
                    <h4 class="page-title">客户表添加</h4>
                    <ul class="breadcrumbs">
                        <li class="nav-home">
                            <a href="#">
                                <i class="flaticon-home"></i>
                            </a>
                        </li>
                        <li class="separator">
                            <i class="flaticon-right-arrow"></i>
                        </li>
                        <li class="nav-item">
                            <a href="#">客户表列表</a>
                        </li>
                        <li class="separator">
                            <i class="flaticon-right-arrow"></i>
                        </li>
                        <li class="nav-item">
                            <a href="#">客户表</a>
                        </li>
                    </ul>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <form action="addClients.do" method="post"  ><!-- enctype="multipart/form-data" -->
                                <div class="card-header">
                                    <div class="card-title">添加客户表</div>
                                </div>
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col-md-12 col-lg-12">

                                            <div class="form-group">
                                                <label>用户名：</label>
                                                <input   name="uname" class="form-control" placeholder="请输入用户名" required>
                                            </div>

                                            <div class="form-group">
                                                <label>密码：</label>
                                                <input   name="pwd" class="form-control" placeholder="请输入密码" required>
                                            </div>

                                            <div class="form-group">
                                                <label>姓名：</label>
                                                <input   name="cname" class="form-control" placeholder="请输入姓名" required>
                                            </div>

                                            <div class="form-group">
                                                <label>性别：</label>
                                                <input   name="csex" class="form-control" placeholder="请输入性别">
                                            </div>

                                            <div class="form-group">
                                                <label>电话：</label>
                                                <input   name="ctele" class="form-control" placeholder="请输入电话" required>
                                            </div>

                                            <div class="form-group">
                                                <label>地址：</label>
                                                <input   name="clocation" class="form-control" placeholder="请输入地址" required>
                                            </div>




                                        </div>
                                    </div>
                                </div>
                                <div class="card-action">
                                    <button class="btn btn-success">提交</button>
                                    <%--<button class="btn btn-danger">Cancel</button>--%>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <jsp:include page="footer.jsp"></jsp:include>

    </div>

    <!-- Custom template | don't include it in your project! -->
    <jsp:include page="set.jsp"></jsp:include>

    <!-- End Custom template -->
</div>
<!--   Core JS Files   -->
<jsp:include page="jscode.jsp"></jsp:include>
</body>
</html>
