package com.slbruno.forum.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {

	@Autowired
	private AutenticacaoService autenticacaoService;
	
	/*
	 * Para a classe AutenticacaoController.java injetar corretamente o 
	 * 
	 * 	@Autowired
	 *	private AuthenticationManager authManager;
	 */
	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	
	// Autenticação
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(autenticacaoService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	// Autorização
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/topicos").permitAll()
		.antMatchers(HttpMethod.GET, "/topicos/*").permitAll()
		.antMatchers(HttpMethod.POST, "/auth").permitAll()
		.anyRequest().authenticated()
		.and().csrf().disable()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		/* só serve para login tradicional com formulário para sessão
		 * .and().formLogin();
		 */
		
		/* PARA TOKEN jwt
		 * .antMatchers(HttpMethod.POST, "/auth").permitAll()
		 * 
		 * .and().csrf().disable()
		 * .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		 */
	}

	// recusros estáticos: js, css, imagens
	@Override
	public void configure(WebSecurity web) throws Exception {
	}
	
	// Só para fins didáticos, gerar a senha criptografada e colocar no data.sql
	/*
	public static void main(String[] args) {
		System.out.print(new BCryptPasswordEncoder().encode("123456"));
	}
	*/
	
}
