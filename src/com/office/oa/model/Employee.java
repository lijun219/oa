package com.office.oa.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@Entity
@Table(name = "employee")
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class Employee implements Serializable, Cloneable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4943162019893118267L;
	/***
	 * id
	 */
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
	/***
	 * 姓名		
	 */
	@Column(name = "name", length = 32)
	private String name;
	/***
	 * 性别	
	 */
	@Column(name = "sex", length = 4)
	private String sex;
	
	/***
	 * 年龄
	 */
	@Column(name = "age", length = 4)
	private String age;
	/***
	 * 手机
	 */
	@Column(name = "mobile", length = 12, unique = true)
	private String mobile;
	/***
	 * 账号
	 */
	@Column(name = "account", length = 32)
	private String account;
	/***
	 * 密码
	 */
	@Column(name = "password", length = 32)
	private String password;
	/***
	 * 生日
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "birthday", nullable = false)
	private Date birthday;
	
	/**
	 * 身份证号
	 */
	@Column(name = "id_card", length = 18)
	private String idCard;

	/***
	 * 邮箱
	 */
	@Column(name = "email", length = 32)
	private String email;
	/***
	 *入职时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "entryTime", nullable = false)
	private Date entryTime;
	/***
	 * 部门
	 */
	@Column(name = "department_id", nullable = false)
	private int departmentId;
	/***
	 * 职位
	 */
	@Column(name = "post_id", nullable = false)
	private int postId;
	/***
	 * 角色
	 */
	@Column(name = "role_id", nullable = false)
	private int roleId;
	/***
	 * 联系地址
	 */
	@Column(name = "address", length = 32)
	private String address;
	
	/**
	 * 创建时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time", nullable = false)
	private Date createTime;
	
	@Column(name = "em_status", nullable = true)
	private Boolean emStatus;
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

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Boolean getEmStatus() {
		return emStatus;
	}

	public void setEmStatus(Boolean emStatus) {
		this.emStatus = emStatus;
	}

	
	
}
