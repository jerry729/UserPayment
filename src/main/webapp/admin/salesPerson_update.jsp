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

<body>
<div class="wrapper">

    <jsp:include page="header.jsp"></jsp:include>

    <!-- Sidebar -->
    <jsp:include page="sidebar.jsp"></jsp:include>




    <div class="main-panel">
        <div class="content">
            <div class="page-inner">
                <div class="page-header">
                    <h4 class="page-title">业务员表修改</h4>
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
                            <a href="#">业务员表</a>
                        </li>
                        <li class="separator">
                            <i class="flaticon-right-arrow"></i>
                        </li>
                        <li class="nav-item">
                            <a href="#">修改</a>
                        </li>
                    </ul>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <form action="updateSalesPerson.do" method="post" enctype="multipart/form-data" ><!-- enctype="multipart/form-data" -->
                            <div class="card">
                                <div class="card-header">
                                    <div class="card-title">业务员表修改</div>
                                </div>
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col-md-6 col-lg-4">
                                                  <div class="form-group">
                                                      <label>id：</label>
                                                      <input   name="spid" class="form-control" placeholder="请输入id" value="${salesPerson.spid}">
                                                  </div>
                                                  <div class="form-group">
                                                      <label>姓名：</label>
                                                      <input   name="spname" class="form-control" placeholder="请输入姓名" value="${salesPerson.spname}">
                                                  </div>
                                                  <div class="form-group">
                                                      <label>性别：</label>
                                                      <input   name="spsex" class="form-control" placeholder="请输入性别" value="${salesPerson.spsex}">
                                                  </div>
                                                  <div class="form-group">
                                                      <label>年龄：</label>
                                                      <input   name="spage" class="form-control" placeholder="请输入年龄" value="${salesPerson.spage}">
                                                  </div>
                                                  <div class="form-group">
                                                      <label>职务：</label>
                                                      <input   name="spposition" class="form-control" placeholder="请输入职务" value="${salesPerson.spposition}">
                                                  </div>
                                                  <div class="form-group">
                                                      <label>用户名：</label>
                                                      <input   name="uname" class="form-control" placeholder="请输入用户名" value="${salesPerson.uname}">
                                                  </div>
                                                  <div class="form-group">
                                                      <label>密码：</label>
                                                      <input   name="pwd" class="form-control" placeholder="请输入密码" value="${salesPerson.pwd}">
                                                  </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="card-action">
                                    <button class="btn btn-success" type="submit" >提交</button>
                                </div>
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