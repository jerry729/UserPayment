<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%--解决jsp页面中文乱码--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<div class="sidebar sidebar-style-2">
    <div class="sidebar-wrapper scrollbar scrollbar-inner">
        <div class="sidebar-content">
            <div class="user">
                <div class="avatar-sm float-left mr-2">
                    <%--<c:if test="${sessionScope.auser.img==null}">
                      <img src="../upload/zanwu.jpg" alt="navbar brand" class="avatar-img rounded-circle" width="50px;" height="50px;">
                    </c:if>
                    <c:if test="${sessionScope.auser.img!=null}">
                      <img src="../upload/${sessionScope.auser.img }" alt="avatar-img rounded-circle" class="navbar-brand" width="50px;" height="50px;">
                    </c:if>--%>
                </div>
                <div class="info">
                    <a data-toggle="collapse" href="#collapseExample" aria-expanded="true">
								<span>
									${sessionScope.auser.tname }
									<span class="user-level">(${sessionScope.auser.utype })</span>
									<span class="caret"></span>
								</span>
                    </a>
                    <div class="clearfix"></div>

                    <div class="collapse in" id="collapseExample">
                        <ul class="nav">
                            <%--<li>
                                <a href="#profile">
                                    <span class="link-collapse">My Profile</span>
                                </a>
                            </li>
                            <li>
                                <a href="#edit">
                                    <span class="link-collapse">Edit Profile</span>
                                </a>
                            </li>
                            <li>
                                <a href="#settings">
                                    <span class="link-collapse">Settings</span>
                                </a>
                            </li>--%>
                        </ul>
                    </div>
                </div>
            </div>
            <ul class="nav nav-primary">
                <li class="nav-item active">
                    <a data-toggle="collapse" href="#dashboard" class="collapsed" aria-expanded="false">
                        <i class="fas fa-home"></i>
                        <p>主页</p>
                        <span class="caret"></span>
                    </a>
                    <div class="collapse" id="dashboard">
                        <ul class="nav nav-collapse">
                            <li>
                                <a href="<%=basePath%>/admin/index2.jsp" target="_blank">
                                    <span class="sub-item">首页</span>
                                </a>
                            </li>
                            <%--<li>
                                <a href="../demo2/index.do">
                                    <span class="sub-item">样式2</span>
                                </a>
                            </li>--%>
                        </ul>
                    </div>
                </li>
                <%--<li class="nav-section">
							<span class="sidebar-mini-icon">
								<i class="fa fa-ellipsis-h"></i>
							</span>
                    <h4 class="text-section">组成</h4>
                </li>--%>
                <c:if test="${sessionScope.auser.utype=='管理员'}">
                    <li class="nav-item submenu">
                        <a data-toggle="collapse" href="#base">
                            <i class="fas fa-layer-group"></i>
                            <p>用户管理</p>
                            <span class="caret"></span>
                        </a>
                        <div class="collapse show" id="base">
                            <ul class="nav nav-collapse">
                                <li>
                                    <a href="userList_kh.do">
                                        <span class="sub-item">客户管理</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="userList.do">
                                        <span class="sub-item">业务员管理</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="showUserInfo.do">
                                        <span class="sub-item">个人信息管理</span>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </li>
                    <li class="nav-item submenu" >
                        <a data-toggle="collapse" href="#sidebarLayouts-commodity">
                            <i class="fas fa-th-list"></i>
                            <p>业务管理</p>
                            <span class="caret"></span>
                        </a>
                        <div class="collapse show" id="sidebarLayouts-commodity">
                            <ul class="nav nav-collapse">
                                <li>
                                    <a href="commodityList.do">
                                        <span class="sub-item">货物管理</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="contractsList.do">
                                        <span class="sub-item">合同管理</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="billsList.do">
                                        <span class="sub-item">账单管理</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="recordList.do">
                                        <span class="sub-item">回款记录管理</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="messageList.do">
                                        <span class="sub-item">预警信息管理</span>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </li>

                   <%-- <li class="nav-item">
                        <a data-toggle="collapse" href="#sidebarLayouts-bills">
                            <i class="fas fa-th-list"></i>
                            <p>账单管理</p>
                            <span class="caret"></span>
                        </a>
                        <div class="collapse" id="sidebarLayouts-bills">
                            <ul class="nav nav-collapse">
                                <li>
                                    <a href="billsList.do">
                                        <span class="sub-item">账单管理</span>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </li>
                    <li class="nav-item">
                        <a data-toggle="collapse" href="#sidebarLayouts-contracts">
                            <i class="fas fa-th-list"></i>
                            <p>合同管理</p>
                            <span class="caret"></span>
                        </a>
                        <div class="collapse" id="sidebarLayouts-contracts">
                            <ul class="nav nav-collapse">
                                <li>
                                    <a href="contractsList.do">
                                        <span class="sub-item">合同管理</span>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </li>
                    <li class="nav-item">
                        <a data-toggle="collapse" href="#sidebarLayouts-record">
                            <i class="fas fa-th-list"></i>
                            <p>回款记录管理</p>
                            <span class="caret"></span>
                        </a>
                        <div class="collapse" id="sidebarLayouts-record">
                            <ul class="nav nav-collapse">
                                <li>
                                    <a href="recordList.do">
                                        <span class="sub-item">回款记录管理</span>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </li>
                    <li class="nav-item">
                        <a data-toggle="collapse" href="#charts">
                            <i class="far fa-chart-bar"></i>
                            <p>预警信息管理</p>
                            <span class="caret"></span>
                        </a>
                        <div class="collapse" id="charts">
                            <ul class="nav nav-collapse">
                                <li>
                                    <a href="messageList.do">
                                        <span class="sub-item">预警信息管理</span>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </li>--%>
                </c:if>

                <c:if test="${sessionScope.auser.utype=='业务员'}">
                    <li class="nav-item  submenu">
                        <a data-toggle="collapse" href="#base">
                            <i class="fas fa-layer-group"></i>
                            <p>个人信息管理</p>
                            <span class="caret"></span>
                        </a>
                        <div class="collapse show" id="base">
                            <ul class="nav nav-collapse">
                                <li>
                                    <a href="userList_kh.do">
                                        <span class="sub-item">客户管理</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="showUserInfo.do">
                                        <span class="sub-item">个人信息管理</span>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </li>
                    <li class="nav-item submenu" >
                        <a data-toggle="collapse" href="#sidebarLayouts-commodity">
                            <i class="fas fa-th-list"></i>
                            <p>业务管理</p>
                            <span class="caret"></span>
                        </a>
                        <div class="collapse show" id="sidebarLayouts-commodity">
                            <ul class="nav nav-collapse">
                                <li>
                                    <a href="commodityList.do">
                                        <span class="sub-item">货物管理</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="contractsList.do">
                                        <span class="sub-item">合同管理</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="billsList.do">
                                        <span class="sub-item">账单管理</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="recordList.do">
                                        <span class="sub-item">回款记录管理</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="messageList.do">
                                        <span class="sub-item">预警信息管理</span>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </li>
                </c:if>




                <c:if test="${sessionScope.auser.utype=='客户'}">
                    <li class="nav-item">
                        <a data-toggle="collapse" href="#base">
                            <i class="fas fa-layer-group"></i>
                            <p>个人信息管理</p>
                            <span class="caret"></span>
                        </a>
                        <div class="collapse" id="base">
                            <ul class="nav nav-collapse">
                                <li>
                                    <a href="showUserInfo.do">
                                        <span class="sub-item">个人信息管理</span>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </li>
                    <li class="nav-item submenu" >
                        <a data-toggle="collapse" href="#sidebarLayouts-commodity">
                            <i class="fas fa-th-list"></i>
                            <p>业务管理</p>
                            <span class="caret"></span>
                        </a>
                        <div class="collapse show" id="sidebarLayouts-commodity">
                            <ul class="nav nav-collapse">
                                <li>
                                    <a href="contractsList.do">
                                        <span class="sub-item">合同管理</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="billsList.do">
                                        <span class="sub-item">账单管理</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="recordList.do">
                                        <span class="sub-item">回款记录管理</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="messageList.do">
                                        <span class="sub-item">预警信息管理</span>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </li>
                </c:if>

                <%-- <li class="mx-4 mt-2">
                        <a href="#" class="btn btn-primary btn-block"><span class="btn-label mr-2"> <i class="fa fa-heart"></i> </span>Buy Pro</a>
                    </li>--%>
            </ul>
        </div>
    </div>
</div>
<script>
    $(document).on('click','.nav-item > li',function(){
        $('.nav-item > li').removeClass('active');
        $(this).addClass('active');
    });

    $(document).ready(function(){
        $('.nav-item,.link_cz').find('li.home').on('click',function(){
            $('#nav_list,.link_cz').find('li.home').removeClass('active');
            $(this).addClass('active');
        })
    });
</script>
