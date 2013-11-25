package com.office.oa.model;

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
@Table(name = "menu")
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class Menu implements Serializable, Cloneable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5995387366488981168L;
	/***
	 * 
	 */
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer mId;
	/***
	 * 菜单编号
	 */
	@Column(name = "m_no", nullable = false)
	private Integer mNo;
	/***
	 * 菜单名
	 */
	@Column(name = "m_name", length = 32)
	private String mName;
	/***
	 * 父级菜单编号
	 */
	@Column(name = "m_parent", nullable = false)
	private Integer mParent;
	/***
	 * 菜单图片
	 */
	@Column(name = "m_image", length = 32)
	private String mImage;
	/***
	 * 菜单路径
	 */
	@Column(name = "m_path", length = 32)
	private String mPath;
	/***
	 * 菜单状态
	 */
	@Column(name = "m_status", nullable = true)
	private Boolean mStatus;
	/***
	 * 备注
	 */
	@Column(name = "m_Remark", length = 32)
	private String mRemark;

	public Integer getmId() {
		return mId;
	}

	public void setmId(Integer mId) {
		this.mId = mId;
	}

	public Integer getmNo() {
		return mNo;
	}

	public void setmNo(Integer mNo) {
		this.mNo = mNo;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public Integer getmParent() {
		return mParent;
	}

	public void setmParent(Integer mParent) {
		this.mParent = mParent;
	}

	public String getmImage() {
		return mImage;
	}

	public void setmImage(String mImage) {
		this.mImage = mImage;
	}

	public String getmPath() {
		return mPath;
	}

	public void setmPath(String mPath) {
		this.mPath = mPath;
	}

	public Boolean getmStatus() {
		return mStatus;
	}

	public void setmStatus(Boolean mStatus) {
		this.mStatus = mStatus;
	}

	public String getmRemark() {
		return mRemark;
	}

	public void setmRemark(String mRemark) {
		this.mRemark = mRemark;
	}
	
}
