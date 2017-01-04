package com.rxwx.model;

import java.util.Date;

public class Admin extends BaseModel {

	String[] photos = new String[]{"https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2968346531,2530193382&fm=21&gp=0.jpg",
			"https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3294233922,2961186155&fm=21&gp=0.jpg",
			"https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1506126923,1760365564&fm=21&gp=0.jpg",
			"https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3158974790,3445907817&fm=21&gp=0.jpg",
			"https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=4240197964,392726488&fm=21&gp=0.jpg"};
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6284934955996667752L;
	
	
	private Integer id;
	private String account;
	private String name;
	private String password;
	private String phone;
	private String email;
	private Integer age;
	private Integer sex;
	private String photo;
	private Date createTime;
	private Integer status;
	
	public Admin(Integer id) {
		this.id = id;
	}
	
	public Admin() {
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String randomPhoto() {
		int index = (int)(Math.random()*5) ;
		return photos[index];
	}
	
}
