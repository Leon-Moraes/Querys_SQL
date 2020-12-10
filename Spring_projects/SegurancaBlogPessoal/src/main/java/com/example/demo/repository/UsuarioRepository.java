package com.example.demo.repository;

import com.example.demo.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

//interface que herda Jpa Repository<Nome da tabela, tipo do ID da tabela> e faz persistencia das informações da tabela Usuario.
public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    //Métodos para encontrar o usuario pela informação de login
    Usuario findByLogin(String login);
}
