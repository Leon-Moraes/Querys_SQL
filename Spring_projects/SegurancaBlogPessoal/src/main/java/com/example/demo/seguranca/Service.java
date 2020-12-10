package com.example.demo.seguranca;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@org.springframework.stereotype.Service //-->  Anotação que persiste a lógica de negócios na classe. 
public class Service { //--> classe que cadastra o usuario e encrypta as suas informações sensiveis, como senha.

	@Autowired // --> Anotação que injeta os métodos e a classe de repositorio
	private UsuarioRepository repository;

	public Usuario CadastrarUsuario(Usuario usuario) { //--> Método de cadastro e encryptação das informações da tabela usuario.
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String senhaEncoder = encoder.encode(usuario.getSenha()); //--> Encryptador de informações
		usuario.setSenha(senhaEncoder);
		return repository.save(usuario);
	}
}