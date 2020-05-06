<%@page import="com.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.5.1.min.js"></script>
<script src="Components/main.js"></script>

<meta charset="UTF-8">
<title>Administration Portal</title>
</head>
<body>
	<div class="container">

		<form class="form-inline" method="post" action="search.jsp">
			<input type="text" name="roll_no" class="form-control"
				placeholder="Search roll no..">
			<button type="submit" name="save" class="btn btn-primary">Search</button>
		</form>
	</div>



	<br>
	<br>
	<fieldset>
		<div class="container">
			<div class="row">
				<div class="col-6">
					<h2>Administration</h2>
					<form id="usersForm" name="usersForm" method="post"
						action="admin.jsp">
						<legend>Create and Delete</legend>
						&nbsp;&nbsp; a &nbsp;&nbsp; <select name="status" id="status">
							<option value="0">--Select Type--</option>
							<option value="doctor">Doctor</option>
							<option value="patient">Patient</option>
							<option value="hospital">Hospital</option>
						</select> <br> <br> Name <input type="text" name="name" id="name"
							class="form-control form-control-sm"> <br> <br>
						NIC <input type="text" name="nic" id="nic"
							class="form-control form-control-sm"> <br> <br>
						Email <input type="email" name="email" id="email"
							class="form-control form-control-sm"> <br> <br>
						Phone Number <input type="text" name="pnumber" id="pnumber"
							class="form-control form-control-sm"> <br> <br>
						Password <input type="password" name="pwd" id="pwd"
							class="form-control form-control-sm"> <br> <br>
						<input id="submitusers" type="button" name="submitusers"
							value="save" class="btn btn-primary"> <input
							type="hidden" id="hidUsersIDSave" name="hidUsersIDSave" value="">
					</form>
					<div id="alertSuccess" class="alert alert-success"></div>
					<div id="alertError" class="alert alert-danger"></div>

					<br>
					<fieldset>
						<legend>Available Doctors</legend>

						<div id="divDocGrid">
							<p>
								<%
									Admin adminObject = new Admin();
									out.print(adminObject.readDoctors());
								%>
								<br> <br>

							</p>
						</div>

					</fieldset>
				</div>
			</div>
		</div>
	</fieldset>
	<br>
	<br>


	<br>
	<br>

	<fieldset>
		<legend>Registered Patients</legend>
		<div id="divPatientGrid">
			<p>
				<%
					Admin newobj = new Admin();
					out.print(newobj.readPatient());
				%>


			</p>
		</div>
	</fieldset>
	<br>
	<br>

	<fieldset>
		<legend>Available Hospitals</legend>
		<div id="divHosUsersGrid">
			<p>
				<%
					Admin newobj2 = new Admin();
					out.print(newobj2.readHospitals());
				%>

			</p>
		</div>
	</fieldset>
	<br>
	<br>



</body>
</html>