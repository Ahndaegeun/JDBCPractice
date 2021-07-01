package ex1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String id = "HR";
		String pw = "0000";
		String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID BETWEEN 110 AND 120";
		
		Class.forName("oracle.jdbc.driver.OracleDriver"); // jdbc ����̹� ȣ��
		Connection con = DriverManager.getConnection(url, id, pw); // ����̹� ����
		Statement st = con.createStatement(); // 
		ResultSet rs = st.executeQuery(sql); // ���� ����
		
		while(rs.next()) {
			int empId = rs.getInt("EMPLOYEE_ID");
			String firstName = rs.getString("FIRST_NAME");
			String lastName = rs.getString("LAST_NAME");
			Date hireDate = rs.getDate("HIRE_DATE");
			
			System.out.println("ȸ����ȣ : " + empId + ",\t�̸� : " + firstName + " " + lastName + ",\t�Ի��� : " + hireDate);			
		}
		
		rs.close();
		st.close();
		con.close();
	}
}
