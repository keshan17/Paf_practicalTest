//hide alert
$(document).ready(function() {

	$("#alertSuccess").hide();
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
	var type = ($("#hidUsersIDSave").val() == "") ? "POST" : "PUT";

	$.ajax({
		url : "AdminAPI",
		type : type,
		data : $("#usersForm").serialize(),
		dataType : "text",
		complete : function(response, status) {
			onItemSaveComplete(response.responseText, status);
		}
	});

});

function onItemSaveComplete(response, status) {
	if (status == "success") {
		var resultSet = JSON.parse(response);
		if (resultSet.status.trim() == "success") {
			$("#alertSuccess").text("Successfully saved.");
			$("#alertSuccess").show();
			$("#divDocGrid").html(resultSet.data);
			$("#divPatientGrid").html(resultSet.data);
		} else if (resultSet.status.trim() == "error") {
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	} else if (status == "error") {
		$("#alertError").text("Error while saving.");
		$("#alertError").show();
	} else {
		$("#alertError").text("Unknown error while saving..");
		$("#alertError").show();
	}
	$("#hidUsersIDSave").val("");
	$("#usersForm")[0].reset();
}

$(document).on("click", ".btnRemove", function(event) {
	$.ajax({
		url : "AdminAPI",
		type : "DELETE",
		data : "did=" + $(this).data("itemid"),
		dataType : "text",
		complete : function(response, status) {
			onItemDeleteComplete(response.responseText, status);
		}
	});
});

function onItemDeleteComplete(response, status) {
	if (status == "success") {
		var resultSet = JSON.parse(response);
		if (resultSet.status.trim() == "success") {
			$("#alertSuccess").text("Successfully deleted.");
			$("#alertSuccess").show();
			$("#divDocGrid").html(resultSet.data);
		} else if (resultSet.status.trim() == "error") {
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	} else if (status == "error") {
		$("#alertError").text("Error while deleting.");
		$("#alertError").show();
	} else {
		$("#alertError").text("Unknown error while deleting..");
		$("#alertError").show();
	}
}

// UPDATE==========================================
$(document).on("click",".btnUpdate",function(event)
		{
			$("#hidUserIDUpdate").val(
					$(this).closest("tr").find('#hidUserIDUpdate').val());
			$("#name").val($(this).closest("tr").find('td:eq(0)').text());
			$("#nic").val($(this).closest("tr").find('td:eq(1)').text());
			$("#email").val($(this).closest("tr").find('td:eq(2)').text());
			$("#pwd").val($(this).closest("tr").find('td:eq(3)').text());
			// $("#status").val($(this).closest("tr").find('td:eq(4)').text());
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
