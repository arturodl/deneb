package com.arct.parking.application.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.arct.parking.model.Usuario;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class CustomUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
	private final String ISSUER_INFO = "http://www.arct-aplications.com";
	private final String SUPER_SECRET_KEY = "arturodl";
	private final String HEADER_AUTHORIZACION_KEY = "Authorization";
	private final String TOKEN_BEARER_PREFIX = "Bearer ";
	private final long TOKEN_EXPIRATION_TIME = 864_000_000; // 10 day
	
	public CustomUsernamePasswordAuthenticationFilter(AuthenticationManager authenticationManager) {
		super.setAuthenticationManager(authenticationManager);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		System.out.println(">>>>>>> attempting for Authetication");
		List lista = null;
		try {
			Usuario credenciales = new ObjectMapper().readValue(request.getInputStream(), Usuario.class);
			lista = new ArrayList<>();
			return super.getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(
					credenciales.getUsername(), credenciales.getPassword(), lista));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication auth) throws IOException, ServletException {
		System.out.println(">>>>>>> successful Authetication");
		User user = (User)auth.getPrincipal();
		StringBuilder sAuthorities = null;
		
		
		for(GrantedAuthority authority: user.getAuthorities()){
			System.out.println(">> granted: "+authority);
			if(sAuthorities == null)
				sAuthorities = new StringBuilder();
			else
				sAuthorities.append(",");
			sAuthorities.append(authority);
		}
		
		
		String token = Jwts.builder().setIssuedAt(new Date()).setIssuer(ISSUER_INFO)
				.setSubject(user.getUsername())
				.claim("roles", sAuthorities.toString() )
				.setExpiration(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS512, SUPER_SECRET_KEY).compact();
		response.addHeader(HEADER_AUTHORIZACION_KEY, TOKEN_BEARER_PREFIX + " " + token);
	}
}
