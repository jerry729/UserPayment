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
                    <h4 class="page-title">合同表添加</h4>
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
                            <a href="#">合同表列表</a>
                        </li>
                        <li class="separator">
                            <i class="flaticon-right-arrow"></i>
                        </li>
                        <li class="nav-item">
                            <a href="#">合同表</a>
                        </li>
                    </ul>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <form action="addContracts.do" method="post" ><!-- enctype="multipart/form-data" -->
                                <div class="card-header">
                                    <div class="card-title">添加合同表</div>
                                </div>
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col-md-12 col-lg-12">
                                            <div class="form-group">
                                                <label>合同名称：</label>
                                                <input   name="ctrctname" class="form-control" placeholder="请输入合同名称" required>
                                            </div>

                                            <div class="form-group">
                                                <label for="exampleFormControlSelect1">客户：</label>
                                                <select class="form-control" id="exampleFormControlSelect1" name="clientid">
                                                    <c:forEach items="${khlist}" var="k">
                                                        <option value="${k.id}">${k.tname}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>

                                            <%--<div class="form-group">
                                            <label>业务员 Id：</label>
                                            <input   name="spid" class="form-control" placeholder="请输入业务员 Id">
                                            </div>--%>

                                            <div class="form-group">
                                                <label>签订时间：</label>
                                                <input type="datetime-local"   name="signedt" class="form-control" placeholder="请输入签订时间" required>
                                            </div>

                                            <div class="form-group">
                                                <label>到期时间：</label>
                                                <input type="datetime-local"  name="expiret" class="form-control" placeholder="请输入到期时间" required>
                                            </div>

                                            <div class="form-group">
                                                <label >商品：</label>
                                                <select class="form-control"  name="comid">
                                                    <c:forEach items="${slist}" var="k">
                                                        <option value="${k.comid}">${k.comname}(库存：${k.reserve})</option>
                                                    </c:forEach>
                                                </select>
                                            </div>

                                            <div class="form-group">
                                                <label>商品数量(不可大于商品库存量)：</label>
                                                <input   name="comquant" class="form-control" placeholder="请输入商品数量" required>
                                            </div>

                                            <%--<div class="form-group">
                                            <label>合同总金额：</label>
                                            <input   name="amount" class="form-control" placeholder="请输入合同总金额" required>
                                            </div>

                                            <div class="form-group">
                                            <label>目前状态：</label>
                                            <input   name="status" class="form-control" placeholder="请输入目前状态">
                                            </div>
--%>
                                        </div>
                                    </div>
                                </div>
                                <div class="card-action">
                                    <button class="btn btn-success" >提交</button>
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
