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
		
		Class.forName("oracle.jdbc.driver.OracleDriver"); // jdbc 드라이버 호출
		Connection con = DriverManager.getConnection(url, id, pw); // 드라이버 연결
		Statement st = con.createStatement(); // 
		ResultSet rs = st.executeQuery(sql); // 쿼리 던짐
		
		while(rs.next()) {
			int empId = rs.getInt("EMPLOYEE_ID");
			String firstName = rs.getString("FIRST_NAME");
			String lastName = rs.getString("LAST_NAME");
			Date hireDate = rs.getDate("HIRE_DATE");
			
			System.out.println("회원번호 : " + empId + ",\t이름 : " + firstName + " " + lastName + ",\t입사일 : " + hireDate);			
		}
		
		rs.close();
		st.close();
		con.close();
	}
}
