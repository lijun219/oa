package com.office.oa.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

/**
 * 实体基类
 * 
 * @author huan.tao
 * 
 */
@MappedSuperclass
@Getter
@Setter
public class BaseEntity {

	public static final String CREATE_DATE_PROPERTY_NAME = "createDate";// "创建日期"属性名称
	public static final String MODIFY_DATE_PROPERTY_NAME = "modifyDate";// "修改日期"属性名称
	public static final String ON_SAVE_METHOD_NAME = "onSave";// "保存"方法名称
	public static final String ON_UPDATE_METHOD_NAME = "onUpdate";// "更新"方法名称

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id; // ID

	@Column(name = "create_date",insertable = true, updatable = false, nullable = false)
	private Date createDate;// 创建时间

	@Column(name = "modify_date",insertable = true, updatable = true, nullable = false)
	protected Date modifyDate;// 修改日期
	
	@Transient
	public void onSave() {
	}

	@Transient
	public void onUpdate() {
	}
}
