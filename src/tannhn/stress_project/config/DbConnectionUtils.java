package tannhn.stress_project.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectionUtils {
	public static final String  DRIVER = "org.mariadb.jdbc.Driver";
	public static final String  URL = "jdbc:mariadb://localhost:3306/spring-boot-hibernate";
	public static final String  USERNAME= "root";
	public static final String  PASSWORD= "12345";
	public static Connection conn;
	
	public static Connection getConnection() {
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
		// testtttttt
	}
}
