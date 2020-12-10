package com.example.demo.seguranca;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration //--> Anotação para configuração de metodos BEAN pelo spring
@EnableWebSecurity //--> Anotação que permite extender os métodos do WebSecurityConfigurerAdapter

public class Security extends WebSecurityConfigurerAdapter{ //--> Classe de segurança de informações do usuario.

		@Autowired // --> Anotação que injeta os métodos e a classe de repositorio 
		private ImplementsUserDetailsService userDetailsService;
		
		@Override
		protected void configure(HttpSecurity http) throws Exception{ //--> Método que define que define os privilégios de cada PAPEL de um usuario, assim como as suas permissões e excessões. 
			http.csrf().disable().authorizeRequests()
			.antMatchers(HttpMethod.GET, "/").permitAll()
			.antMatchers(HttpMethod.POST, "/cadastrar").permitAll()
			
			.antMatchers(HttpMethod.GET, "/cadastrarTema").hasRole("ADMIN")
			.antMatchers(HttpMethod.POST, "/cadastrarTema").hasRole("ADMIN")					//Métodos que definem as URL permitidas para cada tipo de usuario.
			.antMatchers(HttpMethod.GET, "/formTema").permitAll()
			.antMatchers(HttpMethod.POST, "/formTema").hasRole("ADMIN")
			.anyRequest().authenticated()
			.and().formLogin().permitAll()
			.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
		}
		
@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception{ //--> Método que autentica as informações encryptadas da tabela Usuario.
	auth.userDetailsService(userDetailsService)
	.passwordEncoder(new BCryptPasswordEncoder());
}

	}
