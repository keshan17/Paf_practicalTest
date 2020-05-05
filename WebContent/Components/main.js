//hide alert
$(document).ready(function() {
	if ($("#alertSuccess").text().trim() == "") {
		$("#alertSuccess").hide();
	}
	$("#alertError").hide();
});

$(document).on("click", "#submitusers", function(event) {
	// Clear alerts---------------------
	$("#alertSuccess").text("");
	$("#alertSuccess").hide();
	$("#alertError").text("");
	$("#alertError").hide();
	// Form validation-------------------
	var status = validateItemForm();
	if (status != true) {
		$("#alertError").text(status);
		$("#alertError").show();
		return;
	}
	// If valid------------------------
	$("#usersForm").submit();
});
// UPDATE==========================================
$(document).on(
		"click",
		".btnUpdate",
		function(event) {
			$("#hidItemIDSave").val($(this).closest("tr").find('#hidUserIDUpdate').val());
			$("#name").val($(this).closest("tr").find('td:eq(0)').text());
			$("#nic").val($(this).closest("tr").find('td:eq(1)').text());
			$("#email").val($(this).closest("tr").find('td:eq(2)').text());
			$("#pwd").val($(this).closest("tr").find('td:eq(3)').text());
			$("#status").val($(this).closest("tr").find('td:eq(4)').text());
		});
// CLIENTMODEL=========================================================================
function validateItemForm() {
	// name
	if ($("#name").val().trim() == "") {
		return "Insert user name.";
	}
	// nic
	if ($("#nic").val().trim() == "") {
		return "Insert user NIC.";
	}
	// email-------------------------------
	if ($("#email").val().trim() == "") {
		return "Insert user email.";
	}
	
	// password-----------------------
	if ($("#pwd").val().trim() == "") {
		return "Insert user password.";
	}
	if ($("#status").val().trim() == "") {
		return "Insert user status.";
	}
	return true;
}
