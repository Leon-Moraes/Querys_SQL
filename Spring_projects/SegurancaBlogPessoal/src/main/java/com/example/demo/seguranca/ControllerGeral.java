package com.example.demo.seguranca;

import com.example.demo.model.Tema;
import com.example.demo.repository.TemaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller //--> Anotação que define que essa classe é do tipo Controller, classe para requisições e métodos de interação com o usuario.
public class ControllerGeral {

    @Autowired // --> Anotação que injeta os métodos e a classe de repositorio 
    private TemaRepository repository;

    // --------------- Métodos CRUD -----------------//

    @GetMapping("/")
    public String login() {
        return "index";
    }

    @GetMapping(value = "/cadastrarTema")
    public String form() {
        return "formTema";

    }

    @PostMapping(value = "/cadastrarTema")
    public String form(Tema tema) {
        repository.save(tema);
        return "redirect:/cadastrarTema";
    }

    // ------------- Fim Métodos CRUD ---------------//
}
