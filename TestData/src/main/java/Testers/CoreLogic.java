package testbox;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

public class CoreLogic {
	
	
	private String un,pwd,con_name,host,port,srvc_name;
	private Connection conn;
	
	public void setDBConnectionParams(String _un,String _pwd,String _con_name,
			String _host,String _port,String _srvc_name){
		
		un=_un;
		pwd=_pwd;
		con_name=_con_name;
		host=_host;
		port=_port;
		srvc_name=_srvc_name;
		
		
	}
	public void makeDBConnection(){
		
		String conn_str;
		
		/* Register driver class*/
		try {
			   Class.forName("oracle.jdbc.driver.OracleDriver");
			}
			catch(ClassNotFoundException ex) {
			   System.out.println("Error: unable to load driver class!");
			   ex.printStackTrace();
			   System.exit(1);
			}
			
		/*database URL formation - for Oracle DB*/
			
			conn_str="jdbc:oracle:thin:@"+host+":"+port+":"+srvc_name;
			
		/*Create DB connection object*/
			
			try {
				
				conn=DriverManager.getConnection(conn_str, un, pwd);
				
			} catch (SQLException e) {
				
				
				System.out.println("Could not establish DB connection, please check your connection string...");
				e.printStackTrace();
				
			}
	}
	
	public ResultSet retrieveData(String q) throws SQLException{
		
		ResultSet rs= null;
		PreparedStatement pstmt = null;
		
		try{
			
			pstmt=conn.prepareStatement(q);
			rs=pstmt.executeQuery();
			
			
		}catch(SQLException e){
			
			System.out.println("Problem during DB query, please try again...");
			e.printStackTrace();
		}
		finally{
			
			conn.close();
			pstmt.close();
			
		}
		return (rs);
		
		
		
	}
	public void showData(ResultSet rs) throws SQLException{
		
		try {
			
			int s=rs.getFetchSize();
			System.out.print(s);
			
		} catch (SQLException e) {
			
			System.out.println("Problem during retrieving data from DB...");
			e.printStackTrace();
		}
		finally{
			rs.close();
		}
	}
	
	
	

}
