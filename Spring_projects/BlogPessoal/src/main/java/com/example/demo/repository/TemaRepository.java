package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Tema;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TemaRepository extends JpaRepository<Tema, Long> {
    public List<Tema> findAllByDescricaoContainingIgnoreCase(String descricao);

}
    

