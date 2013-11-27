package com.office.oa.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

/**
 * 实体基类
 * 
 * @author huan.tao
 * 
 */
@MappedSuperclass
public class EntityBase {

	public static final String CREATE_DATE_PROPERTY_NAME = "createDate";// "创建日期"属性名称
	public static final String MODIFY_DATE_PROPERTY_NAME = "modifyDate";// "修改日期"属性名称
	public static final String ON_SAVE_METHOD_NAME = "onSave";// "保存"方法名称
	public static final String ON_UPDATE_METHOD_NAME = "onUpdate";// "更新"方法名称

	private String id; // ID
	private Date createDate;// 创建时间
	protected Date modifyDate;// 修改日期

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(updatable = false)
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	@Transient
	public void onSave() {
	}

	@Transient
	public void onUpdate() {
	}
}
