package com.lijun.oa.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
/****
 * 
 * @author lijun
 *
 */
@Entity
@Table(name = "post")
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class Post implements Serializable, Cloneable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1932642408298114052L;
	/***
	 * id
	 */
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer poId;
	/***
	 * 部门
	 */
	@Transient
	private Department department;
	/***
	 * 职位名称
	 */
	@Column(name = "po_name", length = 32)
	private String poName;
	
	@Column(name = "po_status", nullable = true)
	private Boolean poStatus;
	
	public Boolean getPoStatus() {
		return poStatus;
	}
	public void setPoStatus(Boolean poStatus) {
		this.poStatus = poStatus;
	}
	public Integer getPoId() {
		return poId;
	}
	public void setPoId(Integer poId) {
		this.poId = poId;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public String getPoName() {
		return poName;
	}
	public void setPoName(String poName) {
		this.poName = poName;
	}
	
	
}
