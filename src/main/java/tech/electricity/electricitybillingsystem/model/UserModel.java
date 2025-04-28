package tech.electricity.electricitybillingsystem.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class UserModel {
	
	private Long userid;
	//@NotNull(message = "User number is mandatory") 
	@Pattern(regexp="^\\d{9,10}$",message= "invalid mobile number entered")
	private String userNumber;
	@NotBlank(message = "Name is mandatory")
	private String userName;
	@NotBlank(message = "Role is mandatory")
	private String userRole;
	@Pattern(regexp="^[a-zA-Z0-9_.#@$&]{5,20}",message="length must be 5")
	private String userPassword;

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", userNumber=" + userNumber + ", userName=" + userName + ", userRole="
				+ userRole + ", userPassword=" + userPassword + "]";
	}

	public String getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}
}
