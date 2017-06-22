	package bean;  
	import java.sql.*;  
public class FetchDao {

	public static void fetch(){  
 
	try{  
	Connection con=ConnectionProvider.getCon();  
	              
//	PreparedStatement ps=con.prepareStatement(  
//	    "select * from user432 where email=? and pass=?");  
//	  
//	ps.setString(1,bean.getEmail());  
//	ps.setString(2, bean.getPass());  
	Statement stmt=con.createStatement();  
	ResultSet rs=stmt.executeQuery("select * from user");  
	while(rs.next())  
	System.out.println(rs.getObject(1)+"  "+rs.getObject(2));  
	con.close();  
	}catch(Exception e){ e.printStackTrace();;}  
	}  
	}  
