package com.matheus.to_do.repository;

import com.matheus.to_do.model.Status;
import com.matheus.to_do.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Todo_Repository extends JpaRepository<Todo,Integer> {
    // procura por id
    // salva um objeto na tabela
    void deleteById(Integer id); // deleta uma atividade por id
    List<Todo> findByStatus(Status status); // busca por status
    List<Todo> findByTituloContainingIgnoreCase(String titulo);
}
