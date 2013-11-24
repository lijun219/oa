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
@Table(name = "department")
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class Department implements Serializable, Cloneable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3029677639365994331L;
	/***
	 * id
	 */
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
	/***
	 * 部门编号
	 */
	@Column(name = "de_no", nullable = false)
	private int deNo;
	/***
	 * 部门名称
	 */
	@Column(name = "de_name", length = 32)
	private String deName;
	/***
	 * 父级部门编号
	 */
	@Column(name = "parent_id", nullable = false)
	private int parentId;
	
	@Column(name = "de_status", nullable = true)
	private Boolean deStatus;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDeNo() {
		return deNo;
	}
	public void setDeNo(int deNo) {
		this.deNo = deNo;
	}
	public String getDeName() {
		return deName;
	}
	public void setDeName(String deName) {
		this.deName = deName;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public Boolean getDeStatus() {
		return deStatus;
	}
	public void setDeStatus(Boolean deStatus) {
		this.deStatus = deStatus;
	}


}
