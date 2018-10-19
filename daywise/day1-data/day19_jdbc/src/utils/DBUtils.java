package utils;

import java.sql.*;

public class DBUtils {
	public static Connection getConnection() throws Exception {
		// MYSql supplied Type IV jdbc connector
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
	}
}
