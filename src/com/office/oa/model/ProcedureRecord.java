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
/***
 * 流程记录
 * @author lijun
 *
 */
@Entity
@Table(name = "procedure_record ")
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class ProcedureRecord implements Serializable, Cloneable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3524185066271792338L;
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
	 * 流程审批状态
	 */
	@Column(name = "pr_approval_status", nullable = false)
	private Boolean prApprovalStatus;
	/***
	 * 创建时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date")
	private Date createDate;
	/***
	 * 审批时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "approval_date")
	private Date approvalDate;
	
//	/**
//	 * 审批部门
//	 */
//	@Column(name = "approval_department", nullable = false, length = 200)
//	private String approvalDepartment;
	
	/**
	 * 审批意见
	 */
	@Column(name = "approval_opinion", nullable = false, length = 200)
	private String approvalOpinion;
	/***
	 * 附件路径
	 */
	@Column(name = "attachment_path", length = 50)
	private String attachmentPath;
	
	
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
	public Boolean getPrApprovalStatus() {
		return prApprovalStatus;
	}
	public void setPrApprovalStatus(Boolean prApprovalStatus) {
		this.prApprovalStatus = prApprovalStatus;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getApprovalDate() {
		return approvalDate;
	}
	public void setApprovalDate(Date approvalDate) {
		this.approvalDate = approvalDate;
	}
	public String getApprovalOpinion() {
		return approvalOpinion;
	}
	public void setApprovalOpinion(String approvalOpinion) {
		this.approvalOpinion = approvalOpinion;
	}
	public String getAttachmentPath() {
		return attachmentPath;
	}
	public void setAttachmentPath(String attachmentPath) {
		this.attachmentPath = attachmentPath;
	}
	
}
