package com.example.demo.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity //--> Anotação que diz que essa classe é uma entidade de tabela.
public class Usuario implements UserDetails, Serializable{ //--> Classe que define os atributos de uma tabela.
//previne erros de versões sobrepostas
	private static final long serialVersionUID = 1L;

//atributos----------------------------------------------------------------
	@Id
	private String login;
	private String nomeCompleto;
	private String senha;
	
	@ManyToMany //--> Anotação que relaciona colunas em diferentes tabelas.
	@JoinTable(name = "usuarios_roles", joinColumns =  //--> Anotação que linka dados entre tabelas.
	@JoinColumn(name = "usuario_id", referencedColumnName = "login"), inverseJoinColumns = 
	@JoinColumn(name = "role_id", referencedColumnName = "nomeRole"))
	
	private List<Role> roles;

	
	@Override //--> Anotação que sobre escreve o método.
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return this.roles;  
	}
	@Override
	public String getPassword() {
		return this.senha;   	
	}
	
	@Override
	public String getUsername() {
		return this.login;  	
	}
	
	//-------- Métodos de segurança do Usuario ---------

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	// ------ fim dos Métodos de Segurança do usuario -------

//getter and setters-----------------------------------------------------------------
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
}