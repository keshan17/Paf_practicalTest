package AdminModel;

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
			
			output = "<table border=\"1\"><tr><th>Doctor name</th>"
					 +"<th>Doctor nic</th>"
					 + "<th>doctor email</th>"
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
				String depwd=rs.getString("doc_password");
				String ddate=rs.getString("doc_date");
				
				output += "<tr><td><input id=\"hidUserIDUpdate\"name=\"hidItemIDUpdate\"type=\"hidden\" value=\"" + did + "\">"
						 + dname + "</td>"; 
				//output += "<tr><td>" + dname + "</td>"; 
				output += "<td>" + dnic + "</td>"; 
				output += "<td>" + demail + "</td>"; 
				output += "<td>" + depwd + "</td>";
				output += "<td>" + ddate + "</td>";
				
				
				output += "<td><input name=\"btnUpdate\" type=\"button\"value=\"Update\" class=\"btnUpdate btn btn-secondary\"></td>";
				output += "<td><form method=\"post\" action=\"admin.jsp\">"
						+ "<input name=\"btnRemove\" type=\"submit\""
						+ "value=\"Remove\" class=\"btn btn-danger\">"
						+ "<input name=\"hidDocIDDelete\" type=\"hidden\""
						+ "value=\"" + did + "\">" + "</form></td></tr>";
				
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
				
				output = "<table border=\"1\"><tr><th>Patient name</th>"
						 +"<th>Patient nic</th>"
						 + "<th>Patient email</th>"
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
					String pepwd=rs.getString("patient_pwd");
					String regDate=rs.getString("patient_date");
					
					output += "<tr><td><input id=\"hidUserIDUpdate\"name=\"hidItemIDUpdate\"type=\"hidden\" value=\"" + pid + "\">"
							 + pname + "</td>";
					
				 
					output += "<td>" + pnic + "</td>"; 
					output += "<td>" + pemail + "</td>"; 
					output += "<td>" + pepwd + "</td>";
					output += "<td>" + regDate + "</td>";
					
					output += "<td><input name=\"btnUpdate\" "
							+ "type=\"button\" value=\"Update\" "
							+ "class=\" btnUpdate btn btn-secondary\"></td>"
							+ "<td><form method=\"post\" action=\"admin.jsp\">"
							+ "<input name=\"btnRemove\" type=\"submit\""
							+ "value=\"Remove\" class=\"btn btn-danger\">"
							+ "<input name=\"hidPatientIDDelete\" type=\"hidden\""
							+ "value=\"" + pid + "\">" + "</form></td></tr>";
					
					
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
				
				output = "<table border=\"1\"><tr><th>Hospital username</th>"
						 +"<th>Hospital user nic</th>"
						 + "<th>Hospital user email</th>"
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
					String hpwd=rs.getString("hos_password");
					String regDate=rs.getString("hos_date");
					
					output += "<tr><td><input id=\"hidUserIDUpdate\"name=\"hidItemIDUpdate\"type=\"hidden\" value=\"" + hid + "\">"
							 + hname + "</td>";
					
					output += "<td>" + hnic + "</td>"; 
					output += "<td>" + hemail + "</td>"; 
					output += "<td>" + hpwd + "</td>";
					output += "<td>" + regDate + "</td>";
					
					output += "<td><input name=\"btnUpdate\" "
							+ "type=\"button\" value=\"Update\" "
							+ "class=\" btnUpdate btn btn-secondary\"></td>"
							+ "<td><form method=\"post\" action=\"admin.jsp\">"
							+ "<input name=\"btnRemove\" type=\"submit\""
							+ "value=\"Remove\" class=\"btn btn-danger\">"
							+ "<input name=\"hidHosIDDelete\" type=\"hidden\""
							+ "value=\"" + hid + "\">" + "</form></td></tr>";
					
					
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

	public String createEmployees(String name,String nic,String email,String pwd,String status)


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

				String query = " insert into patient_details (`patient_name`, `patient_nic`, `patient_email`, `patient_pwd`, `patient_date`) "
						+ "values(?, ?, ?, ?, ?)";
				Date date = Calendar.getInstance().getTime();
				DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
				String strDate = dateFormat.format(date);
				
				PreparedStatement preparedStmt = con.prepareStatement(query);

				preparedStmt.setString(1, name);
				preparedStmt.setString(2, nic);
				preparedStmt.setString(3, email);
				preparedStmt.setString(4, pwd);
				preparedStmt.setString(5, strDate);

				preparedStmt.execute();
				con.close();
				
				
				System.out.print("i run insert patient");
				output = "Inserted Successfully to the Patient";
			} catch (Exception e) {
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

					String query = " insert into doctor_details (`doc_name`, `doc_nic`, `doc_email`, `doc_password`,`doc_date`) "
							+ "values(?, ?, ?, ?, ?)";

					Date date = Calendar.getInstance().getTime();
					DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
					String strDate = dateFormat.format(date);

					PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement(query);

					preparedStmt.setString(1, name);
					preparedStmt.setString(2, nic);
					preparedStmt.setString(3, email);
					preparedStmt.setString(4, pwd);
					preparedStmt.setString(5, strDate);

					preparedStmt.execute();
					conn.close();
					output = "Inserted Successfully to the Doctor";
				} catch (Exception e) {
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

					String query = " insert into hospital_details (`hos_name`, `hos_nic`, `hos_email`,`hos_password`,hos_date) "
							+ "values(?,?,?,?,?)";
					
					Date date = Calendar.getInstance().getTime();
					DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
					String strDate = dateFormat.format(date);

					PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement(query);

					preparedStmt.setString(1, name);
					preparedStmt.setString(2, nic);
					preparedStmt.setString(3, email);
					preparedStmt.setString(4, pwd);
					preparedStmt.setString(5, strDate);
					

					preparedStmt.execute();
					conn.close();
					System.out.printf("inserted");
					output = "Inserted Successfully to the hospital";
				} catch (Exception e) {
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
		}
		catch(Exception e)
		{
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
		
	
	public String updateEmployees(String id,String name,String nic,String email,String password,String status)
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
				
				String query="UPDATE doctor_details SET doc_name=?,doc_nic=?,doc_email=?,doc_password=? "
						+ "where doc_id=? ";
						
						PreparedStatement pStatement=connection.prepareStatement(query);
						
						//pStatement.setString(1, appointmentNum);
						pStatement.setString(1, name);
						pStatement.setString(1, nic);
						pStatement.setString(2, email);
						pStatement.setString(3, password);
						//pStatement.setString(4, id); 
						pStatement.setInt(4, Integer.parseInt(id)); 
						
						pStatement.execute();
						connection.close();
						System.out.println("updated");
						output="updated doctor successfully";
			}
			catch (Exception e) {
				// TODO: handle exception
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
				
				String query="UPDATE patient_details SET patient_name=?,patient_nic=?,patient_email=?,patient_pwd=? "
						+ "where patient_id=? ";
						
						PreparedStatement pStatement=connection.prepareStatement(query);
						
						//pStatement.setString(1, appointmentNum);
						pStatement.setString(1, name);
						pStatement.setString(2, nic); 
						pStatement.setString(3, email);
						pStatement.setString(4, password);
						pStatement.setInt(5, Integer.parseInt(id)); 
						
						
						pStatement.execute();
						connection.close();
						
						output="updated patient successfully";
			}
			catch (Exception e) {
				// TODO: handle exception
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
				
				String query="UPDATE hospital_details SET hos_name=?,hos_nic=?,hos_email=?,hos_pwd=? "
						+ "where hos_id=? ";
						
						PreparedStatement pStatement=connection.prepareStatement(query);
						
						//pStatement.setString(1, appointmentNum);
						pStatement.setString(1, name);
						pStatement.setString(2, nic); 
						pStatement.setString(3, email);
						pStatement.setString(4, password);
						pStatement.setInt(5, Integer.parseInt(id)); 
						
						pStatement.execute();
						connection.close();
						
						output="updated hospital successfully";
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
