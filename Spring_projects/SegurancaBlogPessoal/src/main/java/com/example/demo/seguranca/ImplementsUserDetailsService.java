package com.example.demo.seguranca;

import javax.transaction.Transactional;
import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;


@Repository //--> Anotação para gerar persistencia dos métodos do repositorio
@Transactional //--> Anotação para fazer transação de dados dentro do banco de dados.
public class ImplementsUserDetailsService implements UserDetailsService { //--> classe que implementa a interface UserDetailsService( interface para retornar dados referentes ao usuario ).

	@Autowired // --> Anotação que injeta os métodos e a classe de repositorio 
	private UsuarioRepository usuarioRepository;
	
	@Override // --> Anotação que sobreescreve método
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException { //--> Método da interface UserDetailsService que recebe a informação de login do Usuario.

		Usuario usuario = usuarioRepository.findByLogin(login); //--> Método do usuarioRepository que procura a informação de login dentro da tabela usuario.
		
		if(usuario == null){ //--> caso o método não escontre a informação, retorna uma mensagem
			throw new UsernameNotFoundException("Usuario(a) não encontrado(a)!");
		}
		return new User(usuario.getUsername(), usuario.getPassword(), true, true, true, true, usuario.getAuthorities()); //--> Retorna as informações do usuario como autenticadas.
	}

}
