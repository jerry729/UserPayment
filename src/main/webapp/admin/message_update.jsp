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
                    <h4 class="page-title">预警修改</h4>
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
                            <a href="#">预警</a>
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
                        <form action="updateMessage.do" method="post"  ><!-- enctype="multipart/form-data" -->
                            <div class="card">
                                <div class="card-header">
                                    <div class="card-title">预警修改</div>
                                </div>
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col-md-6 col-lg-4">
                                                <div class="form-group">
                                                    <label >预警名：</label>
                                                    <input type="text" class="form-control" id="name" name="name" value="${message.name}" placeholder="请输入预警名"  >
                                                    <input type="hidden" value="${message.id}" name="id">
                                                </div>
                                                  <div class="form-group">
                                                      <label>发送人：</label>
                                                      ${usersYw.tname}
                                                  </div>
                                                  <div class="form-group">
                                                      <label>接受人：</label>
                                                      ${usersKh.tname}
                                                  </div>
                                                  <div class="form-group">
                                                      <label>发送内容：</label>
                                                      <textarea class="form-control" id="note" rows="5" name="note">${message.note}</textarea>
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
