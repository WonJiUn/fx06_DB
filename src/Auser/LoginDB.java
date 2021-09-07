package Auser;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import common.db.DBClass;
import fx06_DB.MemberDTO;

public class LoginDB {
	
	public MemberDTO loginChk(String inputId) {
		//select * from fx_member where id='111';
		String sql = "select * from fx_member where id=?";
		MemberDTO dto = null;
		try {
			PreparedStatement ps = DBClass.conn.prepareStatement(sql);
			ps.setString(1, inputId);
			
			//ResultSet은 배열과 비슷한 방식으로 가져온다
			//ResultSet은 select문에는 무조건 사용한다
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				dto = new MemberDTO();
				dto.setId(rs.getString("id"));
				dto.setPwd(rs.getString("pwd"));
				dto.setName(rs.getString("name"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return dto;
		//해당하는 아이디가 있으면 if문이 실행되어 new를 만나 객체를 생성하고 데이터를 가져오고, 없으면 null값 그대로
	}
}
