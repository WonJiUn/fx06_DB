package common.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBClass {
	//여러 클래스에서 공통적으로 쓰는 기능을 따로 빼서 가져옴
	//회원가입에서도 conn이 필요하고 로그인에서도 conn이 필요함
	//스태틱 변수로 만들어놓으면 어디서든 DBclass.conn으로 사용가능
	//기본 컨트롤러에서 객체생성은 해줘야 사용할 수 있다
	public static Connection conn;
	
	public DBClass() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@210.221.253.215:1521:xe","java4jo","4444");
			//conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","java2","1234");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
