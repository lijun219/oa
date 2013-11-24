package com.lijun.oa.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
@Entity
@Table(name = "role")
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class Role implements Serializable, Cloneable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7622686548118364561L;
	/***
	 * id
	 */
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;
	/***
	 * 角色编号
	 */
	@Column(name = "ro_no", nullable = false)
	private int roNo;
	/***
	 * 角色名称
	 */
	@Column(name = "ro_name", length = 32)
	private  String roName;
	
	/***
	 * 
	 */
	@Column(name = "ro_status", nullable = true)
	private Boolean roStatus;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getRoNo() {
		return roNo;
	}
	public void setRoNo(int roNo) {
		this.roNo = roNo;
	}
	public String getRoName() {
		return roName;
	}
	public void setRoName(String roName) {
		this.roName = roName;
	}
	public Boolean getRoStatus() {
		return roStatus;
	}
	public void setRoStatus(Boolean roStatus) {
		this.roStatus = roStatus;
	}

	
}
