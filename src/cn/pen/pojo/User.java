package cn.pen.pojo;

public class User {
	private int id;
	private String name;
	private String password;
	private String phone;
	private String sex;
	private String birthday;
	private String email;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", phone=" + phone + ", sex=" + sex
				+ ", birthday=" + birthday + ", email=" + email + "]";
	}
	
	public User(int id, String name, String password, String phone, String sex, String birthday, String email) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.sex = sex;
		this.birthday = birthday;
		this.email = email;
	}
	
	public User() {
		super();
	}
}
