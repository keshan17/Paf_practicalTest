package AdminService;

import AdminModel.Admin;






import javax.ws.rs.*;

import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
import com.mysql.cj.x.protobuf.MysqlxCrud.Order;

//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document; 

@Path("/Admin1") 
public class AdminService {
	
	Admin adminObj = new Admin();
	//check whether service work or not
	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_HTML)
	public String testService()
	 {
	 return "Hello";
	 } 
	//admin can view the doctors who registered the system via Doc http://localhost:8085/AdminService/AdminService/Admin/Doc
	@GET
	@Path("/Doc")
	@Produces(MediaType.TEXT_HTML)
	public String readDoctors()
	 {
	 return adminObj.readDoctors();
	 }
	
	@GET
	@Path("/patient")
	@Produces(MediaType.TEXT_HTML)
	public String readPatient()
	 {
	 return adminObj.readPatient();
	 }
	
	//admin can view the appointment who registered the system via Appointment http://localhost:8085/AdminService/AdminService/Admin/Appointment
	@GET
	@Path("/Appointment")
	@Produces(MediaType.TEXT_HTML)
	public String readAppointments()
	 {
	 return adminObj.readHospitals();
	 }
	
	//admin can view the hospital who registered the system via Appointment http://localhost:8085/AdminService/AdminService/Admin/hospital
	@GET
	@Path("/hospital")
	@Produces(MediaType.TEXT_HTML)
	public String readHospital()
	 {
	 return adminObj.readHospitals();
	 }
	
	//admin can create employees via status. status="doctor" like that
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertEmployees(@FormParam("name") String name,
	 @FormParam("nic") String nic,
	 @FormParam("email") String email,
	 @FormParam("pwd") String pwd,
	 @FormParam("status") String status)
	 
	 
	{
	 String output = adminObj.createEmployees(name, nic, email, pwd,status);
	return output;
	}
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateEmployeees(String adminData)
	{
	//Convert the input string to a JSON object
	 JsonObject adminObject = new JsonParser().parse(adminData).getAsJsonObject();
	//Read the values from the JSON object
	 String ename = adminObject.get("name").getAsString();
	 String enic = adminObject.get("nic").getAsString();
	 String eemail = adminObject.get("email").getAsString();
	 String epassword = adminObject.get("password").getAsString();
	 String estatus = adminObject.get("status").getAsString();
	
	 String output = adminObj.updateEmployees(ename, enic, eemail, epassword, estatus);
	return output;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	//admin can delete the employees via status1 and status2.status1="patient" status2="delete" like that
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteEmployees(String adminData)
	{
	//Convert the input string to an XML document
	 Document doc = Jsoup.parse(adminData, "", Parser.xmlParser());

	
	 String nic = doc.select("nic").text();
	 String status1 = doc.select("status1").text();
	 String status2 = doc.select("status2").text();
	 
	 
	 String output = adminObj.deleteEmployee(nic,status1,status2);
	return output;
	}
	
	
	
	
	

}
