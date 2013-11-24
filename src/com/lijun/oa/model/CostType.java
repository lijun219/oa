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

/****
 *费用类型
 * @author lijun
 *
 */
@Entity
@Table(name = "cost_type")
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class CostType implements Serializable, Cloneable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6172543041717032549L;
	/***
	 * id
	 */
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
	
	/**
	 * 费用类型
	 */
	@Column(name = "cost_type", nullable = false, length = 200)
	private String costType;
	/**
	 * 所示费用类型ID
	 */
	@Column(name = "parent_id", nullable = false)
	private int parentId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCostType() {
		return costType;
	}
	public void setCostType(String costType) {
		this.costType = costType;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	
}
