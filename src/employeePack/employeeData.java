package employeePack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class employeeData {
	String serverName = "jdbc.sqlserver://DESKTOP-P4F73D1\\SQLEXPRESS";
	String logIn = "sa";// sa =System Administrator
	String password ="1234";
	String database ="SuperTech";
	String ConnectionUrl = "serverName+logIn+password";
	@BeforeTest
	public void ServerConnection() throws ClassNotFoundException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		JOptionPane.showMessageDialog(null, "Connected to SQL Server");
		
	}
	@Test
	public void DataRetrieveFromEmployeeTable() throws SQLException {
		String msSqlStmnt ="select EMPLOYEE_ID,FIRST_NAME,LAST_NAME,HIRE_DATE from Employees";
		Connection con = DriverManager.getConnection(ConnectionUrl);
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery(msSqlStmnt);
		
		while(rs.next()) {
			System.out.println(rs.getInt(0)+ rs.getInt(1)+rs.getString("EMPLOYEE_ID")+rs.getString("FIRST_NAME")+ rs.getString("LAST_NAME")); 
		}
			
		con.close();	 //close connection
		
	}
}
