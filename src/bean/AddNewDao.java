	package bean;  
	import java.sql.*;  
public class AddNewDao {

	public static boolean insert(User bean){  
	boolean status=false;  
	try{  
	Connection con=ConnectionProvider.getCon();  
	              
//	PreparedStatement ps=con.prepareStatement(  
//	    "select * from user432 where email=? and pass=?");  
//	  
//	ps.setString(1,bean.getEmail());  
//	ps.setString(2, bean.getPass());  
	PreparedStatement ps=con.prepareStatement(  
		    "insert into user (name,email,password) values (?,?,?)");  
	ps.setString(1,bean.getName());  
	ps.setString(2, bean.getEmail());  
	ps.setString(3,bean.getPass());  
	ResultSet rs=ps.executeQuery();  
	status=rs.next();  
	              
	}catch(Exception e){
		e.printStackTrace();
	}  
	  
	return status;  
	  
	}  
	}  
