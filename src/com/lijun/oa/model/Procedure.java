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

/***
 * 流程实体类
 * @author lijun
 *
 */
@Entity
@Table(name = "procedure")
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class Procedure  implements Serializable, Cloneable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -327370384493857688L;
	/***
	 * 
	 */
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;
	/***
	 * 角色ID
	 */
	@Column(name = "role_id", nullable = false)
	private Integer roleId;
	/***
	 * 流程编号
	 */
	@Column(name = "pr_no", nullable = false)
	private Integer prNo;
	/***
	 * 流程执行角色的父级编号
	 */
	@Column(name = "parent_id", nullable = false)
	private int parentId;
	/***
	 * 流程状态
	 */
	@Column(name = "pr_status", nullable = true)
	private Boolean prStatus;
	
	public Boolean getPrStatus() {
		return prStatus;
	}
	public void setPrStatus(Boolean prStatus) {
		this.prStatus = prStatus;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public Integer getPrNo() {
		return prNo;
	}
	public void setPrNo(Integer prNo) {
		this.prNo = prNo;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	
}
