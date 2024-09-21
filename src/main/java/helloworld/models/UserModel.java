package helloworld.models;

import java.io.Serializable;
import java.sql.Date;

public class UserModel implements Serializable {

	private static final long serialVersionUID = 1L;

	// khai báo các trường trong DB
	// tạo constructor
	// tạo getters and setters
	// override

	private int id;
	private String username;
	private String email;
	private String password;
	private String fullname;
	private String images;
	private String phone;
	private int status;
	private int roleid;
	private Date createdate;

	public UserModel() {
		super();
	}

	public UserModel(String username, String email, String password, String fullname, int status, int roleid) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.fullname = fullname;
		this.status = status;
		this.roleid = roleid;
	}

	public UserModel(String username, String email, String fullname) {
		super();
		this.username = username;
		this.email = email;
		this.fullname = fullname;
	}

	public UserModel(String username, String email, String password, String fullname, String images,
			String phone, int roleid, Date createdate) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.fullname = fullname;
		this.images = images;
		this.phone = phone;
		this.roleid = roleid;
		this.createdate = createdate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "UserModel [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", fullname=" + fullname + ", images=" + images + ", phone=" + phone + ", status=" + status
				+ ", roleid=" + roleid + ", createdate=" + createdate + "]";
	}

}
