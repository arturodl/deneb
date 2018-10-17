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
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.arct.parking.model.security.Usuario;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class CustomBasicAuthenticationFilter extends BasicAuthenticationFilter {
	
	private final String ISSUER_INFO = "http://www.arct-aplications.com";
	private final String SUPER_SECRET_KEY = "arturodl";
	private final String HEADER_AUTHORIZACION_KEY = "Authorization";
	private final String TOKEN_BEARER_PREFIX = "Bearer ";
	private final long TOKEN_EXPIRATION_TIME = 864_000_000; // 10 day
	//private AuthenticationManager authenticationManager;
	
	public CustomBasicAuthenticationFilter(AuthenticationManager authenticationManager,
							AuthenticationEntryPoint authenticationEntryPoint) {
		super(authenticationManager, authenticationEntryPoint);		
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("doing Internal Filter");
		String header = req.getHeader(HEADER_AUTHORIZACION_KEY);
		if (header == null || !header.startsWith(TOKEN_BEARER_PREFIX)) {
			chain.doFilter(req, res);
			return;
		}
		UsernamePasswordAuthenticationToken authentication = getAuthentication(req);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		chain.doFilter(req, res);
	}

	private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
		String token = request.getHeader(HEADER_AUTHORIZACION_KEY);
		List<GrantedAuthority> authorities = null;
		GrantedAuthority authority = null;
		Claims claims = null;
		if (token != null) {
			// Se procesa el token y se recupera el usuario.
			claims = Jwts.parser()
							.setSigningKey(SUPER_SECRET_KEY)
							.parseClaimsJws(token.replace(TOKEN_BEARER_PREFIX, ""))
							.getBody();
			String user = claims.getSubject();
			
			if (user != null) {
				String roles = (String) claims.get("roles");
				authorities = createAuthoritiesList(roles);
				
				return new UsernamePasswordAuthenticationToken(user, null, authorities);
			}
			return null;
		}
		return null;
	}
	
	private List<GrantedAuthority> createAuthoritiesList(String roles) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		GrantedAuthority authority = null;
		String[] rolesArray = roles.split(",");
		
		for(String role : rolesArray){
			System.out.println(">> retriving granted: "+authority);
			authority = new SimpleGrantedAuthority(role);
			authorities.add(authority);
		}
		
		return authorities;
	}
	
	@Override
	protected void onSuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			Authentication authResult) throws IOException {
		// TODO Auto-generated method stub
		System.out.println(">>>>>> SuccessfulAuthentication");
		super.onSuccessfulAuthentication(request, response, authResult);		
	}
	
	@Override
	protected void onUnsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException failed) throws IOException {
		// TODO Auto-generated method stub
		System.out.println(">>>>>> UnSuccessfulAuthentication");
		super.onUnsuccessfulAuthentication(request, response, failed);
	}
}
