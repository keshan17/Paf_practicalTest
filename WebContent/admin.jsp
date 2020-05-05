<%@page import="AdminModel.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	if (request.getParameter("nic") != null) {
		Admin adminObj = new Admin();
		String stsMsg = "";

		if (request.getParameter("hidUsersIDSave") == "") {
			stsMsg = adminObj.createEmployees(request.getParameter("name"), request.getParameter("nic"),
					request.getParameter("email"), request.getParameter("pwd"), request.getParameter("status"));
		} else {
			stsMsg = adminObj.updateEmployees(request.getParameter("hidUsersIDSave"),
					request.getParameter("name"), request.getParameter("nic"), request.getParameter("email"),
					request.getParameter("pwd"), request.getParameter("status"));
			//request.getParameter("update_status"));

		}

		session.setAttribute("statusMsg", stsMsg);
		//response.sendRedirect("loginGui.jsp");

	}

	//delete
	if (request.getParameter("hidDocIDDelete") != null) {
		Admin adminObj = new Admin();
		String stsMsg = adminObj.deleteDoctors(request.getParameter("hidDocIDDelete"));
		session.setAttribute("statusMsg", stsMsg);
	}
	if (request.getParameter("hidPatientIDDelete") != null) {
		Admin adminObj = new Admin();
		String stsMsg = adminObj.deletePatient(request.getParameter("hidPatientIDDelete"));
		session.setAttribute("statusMsg", stsMsg);
	}
	if (request.getParameter("hidHosIDDelete") != null) {
		Admin adminObj = new Admin();
		String stsMsg = adminObj.deleteHospitalUsers(request.getParameter("hidHosIDDelete"));
		session.setAttribute("statusMsg", stsMsg);
	}
	//if (request.getParameter("hidUserIDDelete") != null)
	//{
	//Admin adminObj = new Admin();
	//String stsMsg = adminObj.deleteEmployee(request.getParameter("hidUserIDDelete"));
	//request.getParameter("status"),
	//request.getParameter("status2"));

	// session.setAttribute("statusMsg", stsMsg);
	//}
%>


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


	<h2>Administration</h2>
	<br>
	<br>
	<fieldset>
		<form id="usersForm" name="usersForm" method="post" action="admin.jsp">
			<legend>Create and Delete</legend>
			&nbsp;&nbsp; a &nbsp;&nbsp; <select name="status" id="status">
				<option value="patient">Patient</option>
				<option value="doctor">Doctor</option>
				<option value="hospital">Hospital</option>
			</select> <br> <br> Name <input type="text" name="name" id="name">
			<br> <br> NIC <input type="text" name="nic" id="nic">
			<br> <br> Email <input type="email" name="email" id="email">
			<br> <br> Password <input type="password" name="pwd"
				id="pwd"> <br> <br> <input type="button"
				name="submitusers" id="submitusers" value="save"
				class="btn btn-primary"> <input type="hidden"
				id="hidUsersIDSave" name="hidUsersIDSave" value="">
		</form>
		<div id="alertSuccess" class="alert alert-success"></div>
		<div id="alertError" class="alert alert-danger"></div>
		<%
			out.print(session.getAttribute("statusMsg"));
		%>
		<br>
	</fieldset>
	<br>
	<br>

	<fieldset>
		<legend>Available Doctors</legend>
		<p>
			<%
				Admin adminObject = new Admin();
				out.print(adminObject.readDoctors());
			%>

		</p>
	</fieldset>
	<br>
	<br>

	<fieldset>
		<legend>Registered Patients</legend>
		<p>
			<%
				Admin newobj = new Admin();
				out.print(newobj.readPatient());
			%>

		</p>
	</fieldset>
	<br>
	<br>

	<fieldset>
		<legend>Available Hospitals</legend>
		<p>
			<%
				Admin newobj2 = new Admin();
				out.print(newobj2.readHospitals());
			%>

		</p>
	</fieldset>
	<br>
	<br>


	<fieldset>
		<form method="post" action="admin.jsp">
			<legend>Update Employees</legend>
			<select name="update_status">
				<option value="patient">patient</option>
				<option value="doctor">doctor</option>
				<option value="hospital">hospital</option>
			</select> <br> <br> Name &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
				type="text" name="uname"><br> <br> Updated Nic
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" name="Unic"><br>
			<br> Email &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text"
				name="uemail"><br> <br> password
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" name="upassword"><br>
			<br> <input type="submit" name="update" value="Update">

		</form>
	</fieldset>
	<br>
	<br>
	<fieldset>
		<legend>Transfer</legend>
		<form>
			Appointment Number &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text"
				name="appoitnmentNumber"><br> <br> Doctor
			NIC&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" name="docNIC"><br>
			<br> Please Transfer this Appointment to
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text"
				name="appoitnmentNumber" placeholder="Transferring Doctor's NIC "><br>
			<br> <input type="submit" name="submit" value="Submit">
		</form>
	</fieldset>
</body>
</html>