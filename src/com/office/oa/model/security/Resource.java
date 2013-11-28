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

import com.office.oa.model.EntityBase;

@Entity
@Table(name = "resource")
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
@Getter
@Setter
public class Resource extends EntityBase implements Serializable, Cloneable {

	private static final long serialVersionUID = 388239367363082150L;

	@Column(name = "name", nullable = true, length = 50)
	String name; // 资源名称

	@Column(name = "url", nullable = false, length = 255)
	String url; // 资源地址

	@Column(name = "module_id", nullable = false)
	Integer moduleId; // 资源模块ID

	@Column(name = "module_name", nullable = true)
	String moduleName; // 资源模块名称

	@Column(name = "comment", nullable = true)
	String comment;

	@Column(name = "show_to_menu", nullable = true)
	boolean showToMenu = false; // 是否显示为菜单

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinColumn(nullable = false)
	@JoinTable(name = "role_resource", joinColumns = { @JoinColumn(name = "resource_id") }, inverseJoinColumns = { @JoinColumn(name = "role_id") })
	Set<Role> roles = new HashSet<Role>();

}
