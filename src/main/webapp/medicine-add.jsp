<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Medicine</title>
<link rel="icon" type="image/png" sizes="16x16"
	href="./images/favicon.png">
<link rel="stylesheet"
	href="./vendor/owl-carousel/css/owl.carousel.min.css">
<link rel="stylesheet"
	href="./vendor/owl-carousel/css/owl.theme.default.min.css">
<link rel="stylesheet" href="./vendor/pickadate/themes/default.css">
<link rel="stylesheet" href="./vendor/pickadate/themes/default.date.css">
<link href="./vendor/jqvmap/css/jqvmap.min.css" rel="stylesheet">
<link href="./css/style.css" rel="stylesheet">
</head>
<body>

	<div id="main-wrapper">

		<!--**********************************
            Nav header start
        ***********************************-->
		<div class="nav-header">
			<a href="index.html" class="brand-logo"> <img class="logo-abbr"
				src="./images/logo.png" alt=""> <img class="logo-compact"
				src="./images/logo-text.png" alt=""> <img class="brand-title"
				src="./images/logo-text.png" alt="">
			</a>

			<div class="nav-control">
				<div class="hamburger">
					<span class="line"></span><span class="line"></span><span
						class="line"></span>
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
									${message} </span>

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
					<li><a class="has-arrow" href="javascript:void()"
						aria-expanded="false"><i class="icon icon-app-store"></i><span
							class="nav-text">Branch</span></a>
						<ul aria-expanded="false">
							<li><a href="./branch-add.jsp">Add</a></li>
							<li><a href="Branch?action=all">View</a></li>
							<li><a href="./branch-manage.jsp">Manage</a></li>

						</ul></li>
					<li><a class="has-arrow" href="javascript:void()"
						aria-expanded="false"><i class="icon icon-app-store"></i><span
							class="nav-text">Doctor</span></a>
						<ul aria-expanded="false">
							<li><a href="DoctorDetail?action=add">Add</a></li>
							<li><a href="DoctorDetail?action=all">View</a></li>
							<li><a href="./doctor-manage.jsp">Manage</a></li>

						</ul></li>
					<li><a class="has-arrow" href="javascript:void()"
						aria-expanded="false"><i class="icon icon-app-store"></i><span
							class="nav-text">Employee</span></a>
						<ul aria-expanded="false">
							<li><a href="Employee?action=add">Add</a></li>
							<li><a href="Employee?action=all">View</a></li>
							<li><a href="./employee-manage.jsp">Manage</a></li>

						</ul></li>
					<li><a class="has-arrow" href="javascript:void()"
						aria-expanded="false"><i class="icon icon-app-store"></i><span
							class="nav-text">Patient</span></a>
						<ul aria-expanded="false">
							<li><a href="Patient?action=add">Add</a></li>
							<li><a href="Patient?action=all">View</a></li>
							<li><a href="./patient-manage.jsp">Manage</a></li>

						</ul></li>
					<li><a class="has-arrow" href="javascript:void()"
						aria-expanded="false"><i class="icon icon-app-store"></i><span
							class="nav-text">Appointment</span></a>
						<ul aria-expanded="false">
							<li><a href="Appointment?action=add">Add</a></li>
							<li><a href="Appointment?action=all">View</a></li>
							<li><a href="./appointment-manage.jsp">Manage</a></li>

						</ul></li>
					<li><a class="has-arrow" href="javascript:void()"
						aria-expanded="false"><i class="icon icon-app-store"></i><span
							class="nav-text">Transfer</span></a>
						<ul aria-expanded="false">
							<li><a href="Transfer?action=add">Add</a></li>
							<li><a href="Transfer?action=all">View</a></li>
							<li><a href="./transfer-manage.jsp">Manage</a></li>

						</ul></li>
					<li><a class="has-arrow" href="javascript:void()"
						aria-expanded="false"><i class="icon icon-app-store"></i><span
							class="nav-text">Role</span></a>
						<ul aria-expanded="false">
							<li><a href="./role-add.jsp">Add</a></li>
							<li><a href="getAllRole?action=all">View</a></li>
							<li><a href="./role-manage.jsp">Manage</a></li>

						</ul></li>
					<li><a class="has-arrow" href="javascript:void()"
						aria-expanded="false"><i class="icon icon-app-store"></i><span
							class="nav-text">User</span></a>
						<ul aria-expanded="false">
							<li><a href="User?action=add">Add</a></li>
							<li><a href="User?action=all">View</a></li>
							<li><a href="./user-manage.jsp">Manage</a></li>
						</ul></li>
					<li><a class="has-arrow" href="javascript:void()"
						aria-expanded="false"><i class="icon icon-app-store"></i><span
							class="nav-text">Ward</span></a>
						<ul aria-expanded="false">
							<li><a href="Ward?action=add">Add</a></li>
							<li><a href="Ward?action=all">View</a></li>
							<li><a href="./ward-manage.jsp">Manage</a></li>
						</ul></li>
					<li><a class="has-arrow" href="javascript:void()"
						aria-expanded="false"><i class="icon icon-app-store"></i><span
							class="nav-text">Medicine</span></a>
						<ul aria-expanded="false">
							<li><a href="./medicine-add.jsp">Add</a></li>
							<li><a href="Medicine?action=all">View</a></li>
							<li><a href="./medicine-manage.jsp">Manage</a></li>
						</ul></li>
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
						<h4 class="card-title">Medicine Form</h4>
					</div>
					<div class="card-body">
						<div class="basic-form">
							<form action="Medicine" method="post">

								<div class="form-row">
									<div class="form-group col-md-6">
										<input type="hidden" name="action" value="add" /> <label>Medicine
											Name</label> <input type="text" name="medicineName"
											class="form-control" placeholder="Medicine Name" required>
									</div>
									<div class="form-group col-md-6">
										<label>Medicine Description</label> <input type="text"
											name="medicineDescription" class="form-control"
											placeholder="Description" required>
									</div>
									<div class="form-group col-md-6">
										<label>Manufacturing - Date</label> <input
											name="manufacturingDate"
											class="datepicker-default form-control" value="Select date"
											id="date" required>
									</div>
									<div class="form-group col-md-6">
										<label>Expiry - Date</label> <input
											name="expiryDate"
											class="datepicker-default form-control" value="Select date"
											id="date" required>
									</div>
									<div class="form-group col-md-6">
										<label>QTY </label> <input type="text" name="qty"
											class="form-control" placeholder="qty" required>
									</div>
								</div>

								<button type="submit" class="btn btn-success">Add
									medicine</button>
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
				<p>
					Copyright ? Designed &amp; Developed by Abishek</a> 2021
				</p>
				<p>Distributed by AK</p>
			</div>
		</div>

	</div>
	<!-- Required vendors -->
	<script src="./vendor/global/global.min.js"></script>
	<script src="./js/quixnav-init.js"></script>
	<script src="./js/custom.min.js"></script>

	<!-- momment js is must -->
	<script src="./vendor/moment/moment.min.js"></script>
	<!-- clockpicker -->
	<script src="./vendor/clockpicker/js/bootstrap-clockpicker.min.js"></script>


	<!-- pickdate -->
	<script src="./vendor/pickadate/picker.js"></script>
	<script src="./vendor/pickadate/picker.time.js"></script>
	<script src="./vendor/pickadate/picker.date.js"></script>


	<!-- Clockpicker init -->
	<script src="./js/plugins-init/clock-picker-init.js"></script>


	<script src="./js/plugins-init/pickadate-init.js"></script>


</body>
</html>