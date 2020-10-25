package board;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	public DBConnect() {}
	
	public Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/kum-bang?serverTimezone=UTC";
		String id = "root";
		String pass = "rlaekfql05";
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,id,pass);
			System.out.println("DB 연결");
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return con;
	}
}
