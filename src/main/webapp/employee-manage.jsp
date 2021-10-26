<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage Employee</title>
    <link rel="icon" type="image/png" sizes="16x16" href="./images/favicon.png">
    <link rel="stylesheet" href="./vendor/owl-carousel/css/owl.carousel.min.css">
    <link rel="stylesheet" href="./vendor/owl-carousel/css/owl.theme.default.min.css">
    <link href="./vendor/jqvmap/css/jqvmap.min.css" rel="stylesheet">
    <link href="./css/style.css" rel="stylesheet">
</head>
<body>

	    <div id="main-wrapper">

        <!--**********************************
            Nav header start
        ***********************************-->
        <div class="nav-header">
            <a href="index.html" class="brand-logo">
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
                                    ${updateMessage}
                                    ${searchFeedBack}
                                </span>
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
                            <li><a href="./employee-add.jsp">Add</a></li>
                            <li><a href="./employee-all.jsp">View</a></li>
                            <li><a href="./employee-manage.jsp">Manage</a></li>

                        </ul>
                    </li>
                    <li><a class="has-arrow" href="javascript:void()" aria-expanded="false"><i class="icon icon-app-store"></i><span class="nav-text">Patient</span></a>
                        <ul aria-expanded="false">
                            <li><a href="./patient-add.jsp">Add</a></li>
                            <li><a href="./patient-all.jsp">View</a></li>
                            <li><a href="./patient-manage.jsp">Manage</a></li>

                        </ul>
                    </li>
                    <li><a class="has-arrow" href="javascript:void()" aria-expanded="false"><i class="icon icon-app-store"></i><span class="nav-text">Appointment</span></a>
                        <ul aria-expanded="false">
                            <li><a href="./appointment-add.jsp">Add</a></li>
                            <li><a href="./appointment-all.jsp">View</a></li>
                            <li><a href="./appointment-manage.jsp">Manage</a></li>

                        </ul>
                    </li>
                    <li><a class="has-arrow" href="javascript:void()" aria-expanded="false"><i class="icon icon-app-store"></i><span class="nav-text">Discharge</span></a>
                        <ul aria-expanded="false">
                            <li><a href="./discharge-add.jsp">Add</a></li>
                            <li><a href="./discharge-all.jsp">View</a></li>
                            <li><a href="./discharge-manage.jsp">Manage</a></li>

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
            <!-- row -->
            <div class="container-fluid">
                
                                       <div class="card">
                            <div class="card-header">
                                <h4 class="card-title">Manage employee</h4>
                                <div class="form-group col-md-6">
								<form action="getEmployee">
									<label for="employeeId">Enter Employee Id:</label>
									<input id="employeeId" type="number" name="employeeId" class="form-control" required/>
									<br/>
									<button type="submit" class="btn btn-info">Search</button>
								</form>
                                </div>
                            </div>
                            <div class="card-body">
                                <div class="basic-form">
                                    <form action="updateEmployee?action=update" method="post">
                                        <div class="form-row">
                                            <div class="form-group col-md-6">
                                                <label>Employee ID</label>
                                                <input id="employeeId" type="number" name="employeeId" readonly="readonly" class="form-control" value ="${employee.employeeId}" required/>
                                            </div>
                                                <div class="form-group col-md-6">
                                                <label>Name</label>
                                                <input id="employeeName" type="text" name="employeeName" class="form-control" value ="${employee.employeeName}" required/>
                                            </div>
                                            <div class="form-group col-md-6">
                                                <label>Address</label>
                                                <input id="employeeAddress" type="text" name="employeeAddress" class="form-control" value ="${employee.employeeAddress}" required/>
                                            </div>
                                            <div class="form-group col-md-6">
                                                <label>Email</label>
                                                <input id="employeeEmail" type="text" name="employeeEmail" class="form-control" value ="${employee.employeeEmail}" required/>
                                            </div>
                                            <div class="form-group col-md-6">
                                                <label>Contact</label>
                                                <input id="employeeTel" type="number" name="employeeTel" class="form-control" value ="${employee.employeeTel}" required/>
                                            </div>
                                            <div class="form-group col-md-6">
                                                <label>Role</label>
                                                <input id="roleId" type="number" name="roleId" class="form-control" value ="${employee.roleId}" required/>
                                            </div>
                                            <div class="form-group col-md-6">
                                                <label>Branch</label>
 												<input id="branchId" type="number" name="branchId" class="form-control" value ="${employee.branchId}" required/>
                                            </div>
                                        </div>

                                        <button type="submit" class="btn btn-primary">Update employee</button>
                                    </form>
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
                <p>Copyright � Designed &amp; Developed by Abishek</a> 2021</p>
                <p>Distributed by AK</p> 
            </div>
        </div>
        <!--**********************************
            Footer end
        ***********************************-->

        <!--**********************************
           Support ticket button start
        ***********************************-->

        <!--**********************************
           Support ticket button end
        ***********************************-->


    </div>
     <!-- Required vendors -->
    <script src="./vendor/global/global.min.js"></script>
    <script src="./js/quixnav-init.js"></script>
    <script src="./js/custom.min.js"></script>



    <script src="./js/dashboard/dashboard-1.js"></script>

</body>
</html>