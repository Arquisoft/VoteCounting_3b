package es.uniovi.asw.dbManagement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Jdbc {

/*  Configuration for Oracle 
	private static String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static String URL = "jdbc:oracle:thin:@156.35.94.99:1521:DESA";
	private static String USER = "";
	private static String PASS = "";
*/
/* Configuration for Hsqldb 
	
	private static String DRIVER = "org.hsqldb.jdbcDriver";
	private static String URL = "jdbc:hsqldb:hsql://localhost";
	private static String USER = "sa";
	private static String PASS = "";
	

	Configuration for h2*/

	private static final String DRIVER  ="org.h2.Driver";
	private static String URL = "jdbc:h2:~/test";
	private static String USER = "sa";
	private static String PASS = "";
	
	
	static {
		try {
			Class.forName( DRIVER );
			
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Driver not found in classpath", e);
		}
	}
	
	public static Connection getConnection() throws SQLException {
		
		return DriverManager.getConnection(URL, USER, PASS);
	}

	public static Connection createThreadConnection() throws SQLException{
		Connection con = getConnection();
		con.setAutoCommit( false );
		threadConnection.set(con);
		return con;
	}

	private static ThreadLocal<Connection> threadConnection = new ThreadLocal<Connection>();

	public static Connection getCurrentConnection() {
		return threadConnection.get();
	}

}