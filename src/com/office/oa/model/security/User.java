package com.office.oa.model.security;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.office.oa.model.BaseEntity;

@Entity
@Table(name = "user")
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
@Getter
@Setter
public class User extends BaseEntity implements Serializable, Cloneable, UserDetails {

	private static final long serialVersionUID = 41703184163597680L;

	@Column(name = "username", length = 100, nullable = false, updatable = false, unique = true)
	String username;

	@Column(name = "password", length = 100, nullable = false)
	String password;

	@Column(name = "status", nullable = false)
	Integer status = 0;

	@Column(name = "login_date", nullable = false)
	Date loginDate = new Date();

	@Column(name = "login_ip", nullable = true)
	String loginIp;

	@Column(name = "expired", nullable = false)
	boolean accountNonExpired = false; // 账号是否未过期

	@Column(name = "locked", nullable = false)
	boolean accountNonLocked = false; // 账号是否未锁定

	@Column(name = "credentials_expired", nullable = false)
	boolean credentialsNonExpired = false; // 账号凭证是否未过期

	@Column(name = "enabled", nullable = false)
	boolean enabled = false; // 账号是否可用

	// 与Role的多对多关系
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(nullable = false)
	@JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "role_id") })
	Set<Role> roles = new HashSet<Role>();

	@Transient
	Collection<GrantedAuthority> authorities;

}
