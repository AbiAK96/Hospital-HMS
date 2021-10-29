<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All ward</title>
    <link rel="icon" type="image/png" sizes="16x16" href="./images/favicon.png">
    <link rel="stylesheet" href="./vendor/owl-carousel/css/owl.carousel.min.css">
    <link rel="stylesheet" href="./vendor/owl-carousel/css/owl.theme.default.min.css">
    <link href="./vendor/jqvmap/css/jqvmap.min.css" rel="stylesheet">
        <link href="./vendor/datatables/css/jquery.dataTables.min.css" rel="stylesheet">
    <link href="./css/style.css" rel="stylesheet">
</head>
<body>

	    <div id="main-wrapper">

        <!--**********************************
            Nav header start
        ***********************************-->
        <div class="nav-header">
            <a href="home.jsp" class="brand-logo">
                <img class="logo-abbr" src="./images/logo.png" alt="">
                <img class="logo-compact" src="./images/logo-text.png" alt="">
                <img class="brand-title" src="./images/logo-text.png" alt="">
            </a>

            <div class="nav-control">
                <div class="hamburger">
                    <span class="line"></span><span class="line"></span><span class="line"></span>
                </div>
            </div>
        </div>
        <!--**********************************
            Nav header end
        ***********************************-->

        <!--**********************************
            Header start
        ***********************************-->
        <div class="header">
            <div class="header-content">
                <nav class="navbar navbar-expand">
                    <div class="collapse navbar-collapse justify-content-between">
                        <div class="header-left">
                            <div class="search_bar dropdown">
                                <span class="search_icon p-3 c-pointer" data-toggle="dropdown">
                                    <i class="mdi mdi-magnify"></i>
                                    ${message}
                                </span>
                                <% 
			
			 if(session.getAttribute("deleteMessage") != null){
			 	String msg = session.getAttribute("deleteMessage").toString(); 
			 	out.println(msg);
			 	session.setAttribute("deleteMessage", "");
			 }
			
			%>
                            </div>
                        </div>
                    </div>
                </nav>
            </div>
        </div>
        <!--**********************************
            Header end ti-comment-alt
        ***********************************-->

        <!--**********************************
            Sidebar start
        ***********************************-->
        <div class="quixnav">
            <div class="quixnav-scroll">
                <ul class="metismenu" id="menu">
                    <li class="nav-label">Menu</li>
                    <li><a class="has-arrow" href="javascript:void()" aria-expanded="false"><i
                                class="icon icon-app-store"></i><span class="nav-text">Branch</span></a>
                        <ul aria-expanded="false">
                            <li><a href="./branch-add.jsp">Add</a></li>
                            <li><a href="Branch?action=all">View</a></li>
                            <li><a href="./branch-manage.jsp">Manage</a></li>

                        </ul>
                    </li>
                    <li><a class="has-arrow" href="javascript:void()" aria-expanded="false"><i class="icon icon-app-store"></i><span class="nav-text">Doctor</span></a>
                        <ul aria-expanded="false">
                            <li><a href="DoctorDetail?action=add">Add</a></li>
                            <li><a href="DoctorDetail?action=all">View</a></li>
                            <li><a href="./doctor-manage.jsp">Manage</a></li>

                        </ul>
                    </li>
                    <li><a class="has-arrow" href="javascript:void()" aria-expanded="false"><i class="icon icon-app-store"></i><span class="nav-text">Employee</span></a>
                        <ul aria-expanded="false">
                            <li><a href="Employee?action=add">Add</a></li>
                            <li><a href="Employee?action=all">View</a></li>
                            <li><a href="./employee-manage.jsp">Manage</a></li>

                        </ul>
                    </li>
                    <li><a class="has-arrow" href="javascript:void()" aria-expanded="false"><i class="icon icon-app-store"></i><span class="nav-text">Patient</span></a>
                        <ul aria-expanded="false">
                            <li><a href="Patient?action=add">Add</a></li>
                            <li><a href="Patient?action=all">View</a></li>
                            <li><a href="./patient-manage.jsp">Manage</a></li>

                        </ul>
                    </li>
                    <li><a class="has-arrow" href="javascript:void()" aria-expanded="false"><i class="icon icon-app-store"></i><span class="nav-text">Appointment</span></a>
                        <ul aria-expanded="false">
                            <li><a href="Appointment?action=add">Add</a></li>
                            <li><a href="Appointment?action=all">View</a></li>
                            <li><a href="./appointment-manage.jsp">Manage</a></li>

                        </ul>
                    </li>
                    <li><a class="has-arrow" href="javascript:void()" aria-expanded="false"><i class="icon icon-app-store"></i><span class="nav-text">Transfer</span></a>
                        <ul aria-expanded="false">
                            <li><a href="Transfer?action=add">Add</a></li>
                            <li><a href="Transfer?action=all">View</a></li>
                            <li><a href="./transfer-manage.jsp">Manage</a></li>

                        </ul>
                    </li>
                    <li><a class="has-arrow" href="javascript:void()" aria-expanded="false"><i class="icon icon-app-store"></i><span class="nav-text">Role</span></a>
                        <ul aria-expanded="false">
                           <li><a href="./role-add.jsp">Add</a></li>
                            <li><a href="getAllRole?action=all">View</a></li>
                            <li><a href="./role-manage.jsp">Manage</a></li>

                        </ul>
                    </li>
                       <li><a class="has-arrow" href="javascript:void()" aria-expanded="false"><i class="icon icon-app-store"></i><span class="nav-text">User</span></a>
                        <ul aria-expanded="false">
                           <li><a href="User?action=add">Add</a></li>
                            <li><a href="User?action=all">View</a></li>
                            <li><a href="./user-manage.jsp">Manage</a></li>
                        </ul>
                    </li>
                    <li><a class="has-arrow" href="javascript:void()" aria-expanded="false"><i class="icon icon-app-store"></i><span class="nav-text">Ward</span></a>
                        <ul aria-expanded="false">
                           <li><a href="Ward?action=add">Add</a></li>
                            <li><a href="Ward?action=all">View</a></li>
                            <li><a href="./ward-manage.jsp">Manage</a></li>
                        </ul>
                    </li>
                    <li><a class="has-arrow" href="javascript:void()" aria-expanded="false"><i class="icon icon-app-store"></i><span class="nav-text">Medicine</span></a>
                        <ul aria-expanded="false">
                           <li><a href="./medicine-add.jsp">Add</a></li>
                            <li><a href="Medicine?action=all">View</a></li>
                            <li><a href="./medicine-manage.jsp">Manage</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
        <!--**********************************
            Sidebar end
        ***********************************-->

        <!--**********************************
            Content body start
        ***********************************-->
        <div class="content-body">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-header">
                                <h4 class="card-title">All ward</h4>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table id="example2" class="display" style="width:100%">
                                        <thead>
											<tr>
												<th>Ward ID</th>
												<th>Ward type </th>
												<th>Branch ID </th>
												<th>Action</th>
											</tr>
						               </thead>
											<tbody style="color: black;">
												<tag:forEach var="ward" items="${wardList}">
													<tr>
														<td>${ward.wardId}</td>
														<td>${ward.wardType}</td>
														<td>${ward.branchId}</td>
														<td>
														<form action="Ward" method="post">
															<input type="hidden" name="action" value="delete">
															<input type="hidden" name="wardId" value="${ward.wardId}">
															<button class="btn btn-danger" type="submit" onclick="return confirm('Are you sure you want to delete this ward')">Delete</button>
														</form>
														</td>
													</tr>
												</tag:forEach>
											</tbody>
                                        <tfoot>
                                            <tr>
  												<th>Ward ID</th>
												<th>Ward type </th>
												<th>Branch ID </th>
                                                <th>Action</th>
                                            </tr>
                                        </tfoot>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
        </div>
        <!--**********************************
            Content body end
        ***********************************-->


        <!--**********************************
            Footer start
        ***********************************-->
        <div class="footer">
            <div class="copyright">
                <p>Copyright © Designed &amp; Developed by Abishek</a> 2021</p>
                <p>Distributed by AK</p> 
            </div>
        </div>



    </div>
    <script src="./vendor/global/global.min.js"></script>
    <script src="./js/quixnav-init.js"></script>
    <script src="./js/custom.min.js"></script>
    


    


    <!-- Datatable -->
    <script src="./vendor/datatables/js/jquery.dataTables.min.js"></script>
    <script src="./js/plugins-init/datatables.init.js"></script>

</body>
</html>