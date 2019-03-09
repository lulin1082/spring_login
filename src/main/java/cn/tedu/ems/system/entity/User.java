package cn.tedu.ems.system.entity;

import java.util.Date;

public class User {

	private Integer id;// 用户id
	private String name;//姓名
	private String userName;// 用户名
	private String salt;//盐



	private String email;// 用户邮箱
	private String password;// 用户密码
	private Integer state;// 用户账号状态：0表示未激活，1表示激活
	private String code;// 激活码
	private Integer  gendar;//性别
	private Date zeit;
	private Float phase;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getSalt() {
		return salt;
	}



	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getGendar() {
		return gendar;
	}

	public void setGendar(Integer gendar) {
		this.gendar = gendar;
	}

	public Date getZeit() {
		return zeit;
	}

	public void setZeit(Date zeit) {
		this.zeit = zeit;
	}

	public Float getPhase() {
		return phase;
	}

	public void setPhase(Float phase) {
		this.phase = phase;
	}


	@Override
	public String toString() {
		return "User{" +
				"name='" + name + '\'' +
				", salt='" + salt + '\'' +
				", password='" + password + '\'' +
				'}';
	}
}

