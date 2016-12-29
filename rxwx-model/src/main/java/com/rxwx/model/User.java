package com.rxwx.model;

public class User extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6589905214470538755L;

	
	public final static Integer STATUS_INACTIVE = 0;
	public final static Integer STATUS_ACTIVATE = 1;
	public final static Integer STATUS_DISABLE = 2;

	private Long id;
	private String username;
	private String password;
	private String photo;
	private Integer sex;
	private String email;
	private Integer status;
	private String phone;
	
	@Override
	public String toString() {
		return "姓名:"+this.getUsername()+"邮箱:"+this.getEmail()+"手机:"+this.getPhone();
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}



	public Integer getStatus() {
		return status;
	}



	public void setStatus(Integer status) {
		this.status = status;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	

}
