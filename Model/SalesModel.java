package Model;

import java.sql.Connection;

public class SalesModel {
	Connection con;
	
	public  SalesModel() throws Exception{
		con = DBCon.getConnection();
	}
	
	
	
	
	

}
