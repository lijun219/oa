package com.office.oa.security.authentication.token;

import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class SimpleAuthenticationToken extends UsernamePasswordAuthenticationToken {

	private static final long serialVersionUID = 5996622414729944352L;

	public SimpleAuthenticationToken(Object principal, Object credentials) {
		super(principal, credentials);
	}

	public SimpleAuthenticationToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> collection) {
		super(principal, credentials);
	}

}
