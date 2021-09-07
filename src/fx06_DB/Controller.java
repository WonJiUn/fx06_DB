package fx06_DB;

import java.net.URL;
import java.util.ResourceBundle;

import Auser.LoginService;
import Auser.LoginServiceImpl;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class Controller implements Initializable {
	private Parent root;
	public static DBClass db;	//스태틱으로 만들었기 때문에 다른클래스에서도 공통적으로 사용할수 있다
	private common.db.DBClass comDB;
	private LoginService ls;
	
	public void setRoot(Parent root) {
		this.root = root;
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		db = new DBClass();
		comDB = new common.db.DBClass();
		ls = new LoginServiceImpl();
	}
	
	public void membership() {
		TextField id = (TextField)root.lookup("#memberId");
		TextField name = (TextField)root.lookup("#memberName");
		TextField pwd = (TextField)root.lookup("#memberPwd");
		
		MemberDTO dto = new MemberDTO();
		dto.setId(id.getText());
		dto.setPwd(pwd.getText());
		dto.setName(name.getText());
		
		int result = db.insert(dto);
		if(result == 1) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setContentText("회원가입에 성공하셨습니다");
			alert.show();
		}else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setContentText("동일한 아이디가 존재합니다");
			//테이블을 만들때 id에 primary key를 지정했기 때문
			alert.show();
		}
		
	}
	public void login() {
		ls.loginChk(root);
		/*
		TextField id = (TextField)root.lookup("#fxId");
		TextField pwd = (TextField)root.lookup("#fxPwd");
		MemberDTO dto = db.loginChk(id.getText());
		
		if(dto == null) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setContentText("존재하지 않는 아이디입니다");
			alert.show();
		}else {
			//사용자와 입력한 비밀번호와 데이터베이스에 저장된 비밀번호 비교
			if(dto.getPwd().equals(pwd.getText())) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setContentText("인증 성공!");
				alert.show();
			}else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setContentText("비밀번호가 틀렸습니다");
				alert.show();
			}
		}
		*/
	}
	

	
	
	
	
}

