package helloworld.configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnectSQL {
	private final String serverName = "DESKTOP-S8JM7SS\\NHUQUYNH";
	private final String dbName = "Ltwct2";
	private final String portNumber = "1433";
	private final String userID = "sa";
	private final String password = "nhuquynh30112004";

	public Connection getConnection() throws Exception {
		String url = "jdbc:sqlserver://" + serverName + ";databaseName=" + dbName;

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		return DriverManager.getConnection(url, userID, password);
	}

//	// Test chương trình. Kích phải chuột chọn run as->java application
//	public static void main(String[] args) {
//		try {
//			System.out.println(new DBConnectSQL().getConnection());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//}

	public static void main(String[] args) {
		DBConnectSQL DB = new DBConnectSQL();
		try {
			Connection conn = DB.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Users");
			while (rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " "
						+ rs.getString(4) + " " + rs.getBoolean(5));
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}