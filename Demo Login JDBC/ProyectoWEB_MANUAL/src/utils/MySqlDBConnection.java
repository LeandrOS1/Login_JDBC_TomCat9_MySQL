package utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlDBConnection {
	
		static {
			try{
				Class.forName("com.mysql.jdbc.Driver");
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}
		}
		
		public static Connection getConnection(){
			Connection cn = null;
			try{
				cn = DriverManager.getConnection("jdbc:mysql://localhost/instituto", "root","admin123");
				
			}catch(SQLException e){
				e.printStackTrace();
			}
			return cn;
		}
		
	}
	

