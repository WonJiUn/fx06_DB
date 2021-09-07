package Auser;


import common.alert.AlertClass;
import fx06_DB.MemberDTO;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

public class LoginServiceImpl implements LoginService {

	LoginDB db;
	public LoginServiceImpl() {
		db = new LoginDB();
	}
	@Override
	public void loginChk(Parent root) {
		
		TextField id = (TextField)root.lookup("#fxId");
		TextField pwd = (TextField)root.lookup("#fxPwd");
		
		MemberDTO dto = db.loginChk(id.getText());
		
		String msg = null;
		
		if(dto == null) {
			msg = "존재하지 않는 아이디입니다";
			
		}else {
			if(dto.getPwd().equals(pwd.getText())) {
				msg = "인증 성공!";
				
			}else {
				msg = "비밀번호가 틀렸습니다";
				
			}
		}
		AlertClass.alert(msg);
	}

}
