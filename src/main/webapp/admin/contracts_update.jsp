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
                    <h4 class="page-title">合同表修改</h4>
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
                            <a href="#">合同表</a>
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
                        <form action="updateContracts.do" method="post" ><!-- enctype="multipart/form-data" -->
                            <div class="card">
                                <div class="card-header">
                                    <div class="card-title">合同表修改</div>
                                </div>
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col-md-6 col-lg-4">
                                            <div class="form-group">
                                                <label>合同名称：</label>
                                                <input   name="ctrctname" class="form-control" placeholder="请输入合同名称" value="${contracts.ctrctname}">
                                            </div>
                                            <div class="form-group">
                                                <label for="exampleFormControlSelect1">客户：</label>
                                                <select class="form-control" id="exampleFormControlSelect1" name="clientid">
                                                    <c:forEach items="${khlist}" var="k">
                                                        <option value="${k.id}" <c:if test="${k.id==contracts.clientid}">selected</c:if> > ${k.tname}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <div class="form-group">
                                                <label>签订时间：</label>
                                                <input   name="signedt" class="form-control" placeholder="请输入签订时间" value="${contracts.signedt}" required>
                                            </div>
                                            <div class="form-group">
                                                <label>到期时间：</label>
                                                <input   name="expiret" class="form-control" placeholder="请输入到期时间" value="${contracts.expiret}" required>
                                            </div>

                                            <div class="form-group">
                                                <label >商品：</label>
                                                <select class="form-control"  name="comid">
                                                    <c:forEach items="${slist}" var="k">
                                                        <option value="${k.comid}" <c:if test="${k.comid==contracts.comid}">selected</c:if> >${k.comname}(库存：${k.reserve})</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <div class="form-group">
                                                <label>商品数量：</label>
                                                <input   name="comquant" class="form-control" placeholder="请输入商品数量" value="${contracts.comquant}">
                                            </div>
                                            <div class="form-group">
                                                <label >状态：</label>
                                                <select class="form-control"  name="clientid">
                                                    <option value="${contracts.status}" > ${contracts.status}</option>
                                                    <option value="已还款" > 已还款</option>
                                                    <option value="待还款" > 待还款</option>
                                                </select>
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
