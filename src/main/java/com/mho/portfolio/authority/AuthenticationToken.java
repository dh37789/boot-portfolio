package com.mho.portfolio.authority;

import java.util.Collection;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class AuthenticationToken {
	private String user_mail;
	private Collection<Authority> authorites;
	private String token;

	@Builder
	public AuthenticationToken(String user_mail, Collection<Authority> authorites, String token) {
		this.user_mail = user_mail;
		this.authorites = authorites;
		this.token = token;
	}
}
