package com.office.oa.model.security;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
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

}
