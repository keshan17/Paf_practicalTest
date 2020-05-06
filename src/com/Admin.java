package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Admin {
	
	public Connection connect()
	{
		Connection con=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/newdb", "root", ""); 
			System.out.print("Successfully connected"); 
			
			
		}
		catch(Exception e)
		{
			System.out.print("error");
			e.printStackTrace(); 
		}
		return con;
	}
	
	public String readDoctors()




	{
		String output= "";
		
		
		
		try {
			Connection con=connect();
			
			if(con==null)
			{
				return "error while connecting to the database for reading";
			}
			
			output = "<table border='1'><tr><th>Doctor name</th>"
					 +"<th>Doctor nic</th>"
					 + "<th>doctor email</th>"
					 + "<th>Phone Number</th>"
					 + "<th>doctor password</th>"
					+ "<th>Register Date</th>"
					+ "<th>Update</th><th>Remove</th></tr>";
		
			
					
					
			String  query="select * from doctor_details";
			//String query2="select * from hospital_details";
			Statement stmtStatement=con.createStatement();
			//Statement stmtStatement2=con.createStatement();
			ResultSet rs=stmtStatement.executeQuery(query);
			//ResultSet rs2=stmtStatement2.executeQuery(query2);
			
			while (rs.next())
			{
				String did=Integer.toString(rs.getInt("doc_id"));
				String dname=rs.getString("doc_name");
				String dnic=rs.getString("doc_nic");
				String demail=rs.getString("doc_email");
				String dnum=Integer.toString(rs.getInt("doc_number"));
				String depwd=rs.getString("doc_password");
				String ddate=rs.getString("doc_date");
				
				output += "<tr><td><input id='hidUserIDUpdate' name='hidUserIDUpdate' type='hidden' value='" + did + "'>"+ dname + "</td>"; 
				
				output += "<td>" + dnic + "</td>"; 
				output += "<td>" + demail + "</td>"; 
				output += "<td>" + dnum + "</td>"; 
				output += "<td>" + depwd + "</td>";
				output += "<td>" + ddate + "</td>";
				
				
				output += "<td><input name='btnUpdate' type='button' value='Update' class='btnUpdate btn btn-secondary'</td>"
						+ "<td><input name='btnRemove' type='button'"
						+ "value='Remove' class='btnRemove btn btn-danger'  data-itemid='"
						+ did + "'>" + "</td></tr>"; 
						
				
			}
			con.close();
			
			output+="</table>";
			
		}
		catch(Exception e)
		{
			output="error while inserting the doctors";
			System.err.println(e.getMessage());
		}
		return output;	
		
		
	
	}
	
	
	public String readPatient()

	{

		{
			String output= "";
			
			
			
			try {
				Connection con=connect();
				
				if(con==null)
				{
					return "error while connecting to the database for reading";
				}
				
				output = "<table border='1'><tr><th>Patient name</th>"
						 +"<th>Patient nic</th>"
						 + "<th>Patient email</th>"
						 + "<th>Phone Number</th>"
						 + "<th>Patient password</th>"
				 		+ "<th>Registered date</th>"
				 		+ "<th>Update</th><th>Remove</th></tr>";
				
			
				
						
						
				String  query="select * from patient_details";
				//String query2="select * from hospital_details";
				Statement stmtStatement=con.createStatement();
				//Statement stmtStatement2=con.createStatement();
				ResultSet rs=stmtStatement.executeQuery(query);
				//ResultSet rs2=stmtStatement2.executeQuery(query2);
				
				while (rs.next())
				{
					String pid=Integer.toString(rs.getInt("patient_id"));
					String pname=rs.getString("patient_name");
					String pnic=rs.getString("patient_nic");
					String pemail=rs.getString("patient_email");
					String pnum=Integer.toString(rs.getInt("patient_number"));
					String pepwd=rs.getString("patient_pwd");
					String regDate=rs.getString("patient_date");
					
					output += "<tr><td><input id='hidUserIDUpdate' name='hidItemIDUpdate' type='hidden' value='" + pid + "'>"
							 + pname + "</td>"; 
					
				 
					output += "<td>" + pnic + "</td>"; 
					output += "<td>" + pemail + "</td>"; 
					output += "<td>" + pnum + "</td>"; 
					output += "<td>" + pepwd + "</td>";
					output += "<td>" + regDate + "</td>";
					
					output += "<td><input name='btnUpdate' type='button' value='Update' class='btnUpdate btn btn-secondary'</td>"
							+ "<td><input name='btnRemovePatient' type='button'"
							+ "value='Remove' class='btnRemove btn btn-danger' data-patientId='"
							+ pid + "'>" + "</td></tr>"; 
					
					
				}

				
				con.close();
				
				output+="</table>";
				
			}
			catch(Exception e)
			{
				output="error while reading the patient";
				System.err.println(e.getMessage());
			}
			return output;	
		}
		
	}
	public String readHospitals()
	{

		{
			String output= "";
			
			
			
			try {
				Connection con=connect();
				
				if(con==null)
				{
					return "error while connecting to the database for reading";
				}
				
				output = "<table border='1'><tr><th>Hospital username</th>"
						 +"<th>Hospital user nic</th>"
						 + "<th>Hospital user email</th>"
						 + "<th>Phone Number</th>"
						 + "<th>Hospital user password</th>"
				 		+ "<th>Registered date</th>"
				 		+ "<th>Update</th><th>Remove</th></tr>";
				
			
				
						
						
				String  query="select * from hospital_details";
				//String query2="select * from hospital_details";
				Statement stmtStatement=con.createStatement();
				//Statement stmtStatement2=con.createStatement();
				ResultSet rs=stmtStatement.executeQuery(query);
				//ResultSet rs2=stmtStatement2.executeQuery(query2);
				
				while (rs.next())
				{
					String hid=Integer.toString(rs.getInt("hos_id"));
					String hname=rs.getString("hos_name");
					String hnic=rs.getString("hos_nic");
					String hemail=rs.getString("hos_email");
					String hnum=Integer.toString(rs.getInt("hos_number"));
					String hpwd=rs.getString("hos_password");
					String regDate=rs.getString("hos_date");
					
					output += "<tr><td><input id='hidUserIDUpdate' name='hidItemIDUpdate' type='hidden' value='" + hid + "'>"
							 + hname + "</td>"; 
					
					output += "<td>" + hnic + "</td>"; 
					output += "<td>" + hemail + "</td>"; 
					output += "<td>" + hnum + "</td>"; 
					output += "<td>" + hpwd + "</td>";
					output += "<td>" + regDate + "</td>";
					
					output += "<td><input name='btnUpdate' type='button' value='Update' class='btnUpdate btn btn-secondary'</td>"
							+ "<td><input name='btnRemove' type='button'"
							+ "value='Remove' class='btnRemove btn btn-danger' data-itemid='"
							+ hid + "'>" + "</td></tr>"; 
					
				}

				
				con.close();
				
				output+="</table>";
				
			}
			catch(Exception e)
			{
				output="error while reading the patient";
				System.err.println(e.getMessage());
			}
			return output;	
		}
		
	}

	public String createEmployees(String name,String nic,String email,String pnumber,String pwd,String status)

	{
		String output="";
		if (status.equals("patient")) {
			//String output = "";
			try {
				//patientDatabase newp = new patientDatabase();
				Connection con= connect();
				if (con == null) 
				{
					
					return "Error while connectingto the database for inserting";
				}

				String query = " insert into patient_details (`patient_name`, `patient_nic`, `patient_email`,  `patient_number`,`patient_pwd`, `patient_date`) "
						+ "values(?, ?, ?, ?, ?,?)";
				Date date = Calendar.getInstance().getTime();
				DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
				String strDate = dateFormat.format(date);
				
				PreparedStatement preparedStmt = con.prepareStatement(query);

				preparedStmt.setString(1, name);
				preparedStmt.setString(2, nic);
				preparedStmt.setString(3, email);
				preparedStmt.setInt(4, Integer.parseInt(pnumber));
				preparedStmt.setString(5, pwd);
				preparedStmt.setString(6, strDate);
				

				preparedStmt.execute();
				con.close();
				
				
				System.out.print("i run insert patient");
				output = "Inserted Successfully to the Patient";
				
				String newPatient = readPatient();
				output = "{\"status\":\"successPATIENT\", \"data\": \"" + newPatient + "\"}";
				
			} catch (Exception e) {
				//output = "{\"status\":\"error\", \"data\": \"Error while inserting the patient.\"}"; 
				e.printStackTrace();
				System.out.print("i dont run insert patient");
				
			}
			//return output;
			
		}
		else if  (status.equals("doctor")) {
			//String output = "";
			 
				try {
					//patientDatabase newp = new patientDatabase();
					Connection conn =connect();

					if (conn == null) 
					{
						return "Error while connectingto the database for inserting";
					}

					String query = " insert into doctor_details (`doc_id`,`doc_name`, `doc_nic`, `doc_email`,`doc_number`, `doc_password`,`doc_date`) "
							+ "values(?,?, ?, ?, ?, ?,?)";

					Date date = Calendar.getInstance().getTime();
					DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
					String strDate = dateFormat.format(date);

					PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement(query);
					preparedStmt.setInt(1, 0);
					preparedStmt.setString(2, name);
					preparedStmt.setString(3, nic);
					preparedStmt.setString(4, email);
					preparedStmt.setInt(5, Integer.parseInt(pnumber));
					preparedStmt.setString(6, pwd);
					preparedStmt.setString(7, strDate);

					preparedStmt.execute();
					conn.close();
					output = "Inserted Successfully to the Doctor";
					
					String newDoctors = readDoctors();
					output = "{\"status\":\"successDOC\", \"data\": \"" + newDoctors + "\"}";
				} catch (Exception e) {
					 output = "{\"status\":\"error\", \"data\": \"Error while inserting the doctors.\"}"; 
					e.printStackTrace();
				}
				//return output;

			}
			else if(status.equals("hospital"))   {
				
				//String output = "";
				try {
					//patientDatabase newp = new patientDatabase();
					Connection conn = connect();

					if (conn == null) {
						return "Error while connectingto the database for inserting";
					}

					String query = " insert into hospital_details (`hos_name`, `hos_nic`, `hos_email`,`hos_number`,`hos_password`,hos_date) "
							+ "values(?,?,?,?,?,?)";
					
					Date date = Calendar.getInstance().getTime();
					DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
					String strDate = dateFormat.format(date);

					PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement(query);

					preparedStmt.setString(1, name);
					preparedStmt.setString(2, nic);
					preparedStmt.setString(3, email);
					preparedStmt.setInt(4, Integer.parseInt(pnumber));
					preparedStmt.setString(5, pwd);
					preparedStmt.setString(6, strDate);
					

					preparedStmt.execute();
					conn.close();
					System.out.printf("inserted");
					output = "Inserted Successfully to the hospital";
					
					String newHosUsers = readHospitals();
					output = "{\"status\":\"successHOSPITAl\", \"data\": \"" + newHosUsers + "\"}";
				} catch (Exception e) {
					output = "{\"status\":\"error\", \"data\": \"Error while inserting the Hos users.\"}"; 
					e.printStackTrace();
					System.out.printf("not inserted");
				}
				
				//return output;
			}
			
		
	
		return output;	
	}
	
	public String deleteDoctors(String docID)


	{
		String output="";
		
		
		try {
			Connection connection=connect();
			
			if(connection==null)
			{
				return "Error while connecting to the database for deleting.";
			}
			
			String query="delete from doctor_details where doc_id=?";
			
			PreparedStatement prepareStmt=connection.prepareStatement(query);
			
			prepareStmt.setInt(1, Integer.parseInt(docID));
			prepareStmt.execute();
			connection.close();
			System.out.println("deleted");
			output= "deleted successfully doctor";
			
			String newDoctors = readDoctors();
			output = "{\"status\":\"success\", \"data\": \"" + newDoctors + "\"}";
		}
		catch(Exception e)
		{
			output = "{\"status\":\"error\", \"data\": \"Error while deleting the doctors.\"}"; 
			System.out.println("not deleted");
			output="error while deleting the patient";
			System.err.println(e.getMessage());
		}
		
		
		
		return output;
	}
	public String deletePatient(String patientID)

	{
			String output="";
			
			try {
				Connection connection=connect();
				
				if(connection==null)
				{
					return "Error while connecting to the database for deleting.";
				}
				
				String query="delete from patient_details where patient_id=?";
				
				PreparedStatement prepareStmt=connection.prepareStatement(query);
				
				prepareStmt.setInt(1, Integer.parseInt(patientID));
				prepareStmt.execute();
				connection.close();
				System.out.println("deleted");
				output= "deleted successfully patient";
				
				String deletePatient = readPatient();
				output = "{\"status\":\"success\", \"data\": \"" + deletePatient + "\"}";
			}
			catch(Exception e)
			{
				System.out.println("not deleted");
				output="error while deleting the patient";
				System.err.println(e.getMessage());
			}
			return output;
			
		}
	public String deleteHospitalUsers(String hosID)
	{
			String output="";
			
			try {
				Connection connection=connect();
				
				if(connection==null)
				{
					return "Error while connecting to the database for deleting.";
				}
				
				String query="delete from hospital_details where hos_id=?";
				
				PreparedStatement prepareStmt=connection.prepareStatement(query);
				
				prepareStmt.setInt(1, Integer.parseInt(hosID));
				prepareStmt.execute();
				connection.close();
				System.out.println("deleted");
				output= "deleted successfully hospital User";
			}
			catch(Exception e)
			{
				System.out.println("not deleted");
				output="error while deleting the hospital";
				System.err.println(e.getMessage());
			}
			return output;
			
		}
		
	
	public String updateEmployees(String id,String name,String nic,String email,String pnumber,String password,String status)
	{
		String output="";
	
		 if(status.equals("doctor"))
		{
			try {
				Connection connection=connect();
				if(connection==null)
				{
					return "error while connecting to the database for updating";
				}
				
				String query="UPDATE doctor_details SET doc_name=?,doc_nic=?,doc_email=?,doc_number=?,doc_password=? "
						+ "where doc_id=? ";
						
						PreparedStatement pStatement=connection.prepareStatement(query);
						
						
						pStatement.setString(1, name);
						pStatement.setString(2, nic);
						pStatement.setString(3, email);
						pStatement.setInt(4, Integer.parseInt(pnumber)); 
						pStatement.setString(5, password);
						pStatement.setInt(6, Integer.parseInt(id)); 
						
						pStatement.execute();
						connection.close();
						System.out.println("updated");
						output="updated doctor successfully";
						String updateDoctors = readDoctors();
						output = "{\"status\":\"successDOC\", \"data\": \"" + updateDoctors + "\"}";
			}
			catch (Exception e) {
				// TODO: handle exception
				 output = "{\"status\":\"error\", \"data\": \"Error while updating the doctors.\"}"; 
				System.out.println("not updated");
				output="error while updating the appointment";
				System.err.println(e.getMessage());
			
			}
			
		}
		
		else if(status.equals("patient"))
		{
			try {
				Connection connection=connect();
				if(connection==null)
				{
					return "error while connecting to the database for updating";
				}
				
				String query="UPDATE patient_details SET patient_name=?,patient_nic=?,patient_email=?,patient_number=?,patient_pwd=? "
						+ "where patient_id=? ";
						
						PreparedStatement pStatement=connection.prepareStatement(query);
						
						//pStatement.setString(1, appointmentNum);
						pStatement.setString(1, name);
						pStatement.setString(2, nic); 
						pStatement.setString(3, email);
						pStatement.setInt(4, Integer.parseInt(pnumber)); 
						pStatement.setString(5, password);
						pStatement.setInt(6, Integer.parseInt(id)); 
						
						
						pStatement.execute();
						connection.close();
						System.out.println("updated");
						output="updated patient successfully";
						
						String updatePatient = readPatient();
						output = "{\"status\":\"successPATIENT\", \"data\": \"" + updatePatient + "\"}";
			}
			catch (Exception e) {
				 output = "{\"status\":\"error\", \"data\": \"Error while updating the patient.\"}"; 
				output="error while updating the appointment";
				System.err.println(e.getMessage());
			
			}
		}
		else if(status.equals("hospital"))
		{
			try {
				Connection connection=connect();
				if(connection==null)
				{
					return "error while connecting to the database for updating";
				}
				
				String query="UPDATE hospital_details SET hos_name=?,hos_nic=?,hos_email=?,hos_number=?,hos_password=? "
						+ "where hos_id=? ";
						
						PreparedStatement pStatement=connection.prepareStatement(query);
						
						//pStatement.setString(1, appointmentNum);
						pStatement.setString(1, name);
						pStatement.setString(2, nic); 
						pStatement.setString(3, email);
						pStatement.setInt(4, Integer.parseInt(pnumber)); 
						pStatement.setString(5, password);
						pStatement.setInt(6, Integer.parseInt(id)); 
						
						pStatement.execute();
						connection.close();
						
						output="updated hospital successfully";
						

						String updateHosUser = readHospitals();
						output = "{\"status\":\"successHOSPITAl\", \"data\": \"" + updateHosUser + "\"}";
			}
			catch (Exception e) {
				// TODO: handle exception
				output="error while updating the appointment";
				System.err.println(e.getMessage());
			
			}
			
			
		}
		return output;
	}
	
}
