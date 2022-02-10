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
                    <h4 class="page-title">回款记录表添加</h4>
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
                            <a href="#">回款记录表列表</a>
                        </li>
                        <li class="separator">
                            <i class="flaticon-right-arrow"></i>
                        </li>
                        <li class="nav-item">
                            <a href="#">回款记录表</a>
                        </li>
                    </ul>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <form action="addRecord.do" method="post" ><!-- enctype="multipart/form-data" -->
                                <div class="card-header">
                                    <div class="card-title">添加回款记录表</div>
                                </div>
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col-md-12 col-lg-12">

                                            <div class="form-group">
                                                <label>合同号：</label>
                                                <input   name="ctrctid" class="form-control" placeholder="请输入合同号" value="${contracts.ctrctid}" readonly>
                                            </div>

                                            <div class="form-group">
                                                <label>回款时间：</label>
                                                <input  type="datetime-local" name="rcrdt" class="form-control" placeholder="请输入回款时间" required>
                                            </div>

                                            <div class="form-group">
                                                <label>欠款：</label>
                                                ${bills.arrear}
                                            </div>

                                            <div class="form-group">
                                                <label>回款金额：</label>
                                                <input   name="rcrdquant" min="1" value="1" class="form-control" placeholder="请输入回款金额" max=" ${bills.arrear}">
                                            </div>
                                            <div class="form-group">
                                                <label>账单号：</label>
                                                <input   name="billid" class="form-control" placeholder="请输入账单号" value="${bills.billid}" readonly>
                                            </div>

                                            <div class="form-group">
                                                <label>备注：</label>
                                                <textarea class="form-control" name="mark" ></textarea>
                                                <%--<input   name="mark" class="form-control" placeholder="请输入备注">--%>
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
