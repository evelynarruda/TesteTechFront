package org.generation.BlogPessoal.model;

import java.util.Optional;

public class UsuarioLogin {
	
	private Long idUsuario;
	
	private String nome;
	
	private String email;
	
	private String senha;
	
	private String token;

	
	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Usuario get() {
		// TODO Auto-generated method stub
		return null;
	}

	public Optional<Object> map(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}