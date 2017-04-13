package testbox;

import java.sql.SQLException;

import org.testng.annotations.Test;

public class NewTest {
	
  @Test
  public void f() throws SQLException {
	  
	  Assist ast=new Assist();
	  CoreLogic cl=new CoreLogic();
	  
	  cl.setDBConnectionParams("KPRAD", "Virgin123", "SIBPPD", "PPD", "8080", "PPD");
	  cl.makeDBConnection();
	  cl.showData(cl.retrieveData(ast.getSQLQuery(1, 10)));
	  
  }
}
