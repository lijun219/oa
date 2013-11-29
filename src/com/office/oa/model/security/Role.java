package com.office.oa.model.security;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.office.oa.model.BaseEntity;

/**
 * 角色
 * 
 * @author huan.tao
 * 
 */
@Entity
@Table(name = "role")
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
@Getter
@Setter
public class Role extends BaseEntity implements Serializable, Cloneable {

	private static final long serialVersionUID = 2199269777825531301L;

	@Column(name = "name", nullable = false, length = 32)
	String name;

	@Column(name = "no", nullable = false, length = 32)
	String no = "";

	@Column(name = "comment", nullable = true, length = 1000)
	String comment;

	@Column(name = "status", nullable = false)
	Integer status = 0;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinColumn(nullable = false)
	@JoinTable(name = "role_resource", joinColumns = { @JoinColumn(name = "role_id") }, inverseJoinColumns = { @JoinColumn(name = "resource_id") })
	Set<Resource> resources = new HashSet<Resource>();
	

}
