package com.matheus.to_do.service;

import com.matheus.to_do.model.Todo;
import com.matheus.to_do.model.Status;
import org.springframework.stereotype.Service;
import com.matheus.to_do.repository.Todo_Repository;
import java.util.List;


@Service
public class TodoService {
    private final Todo_Repository todo_repository;
    public TodoService(Todo_Repository todo_repository) {
        this.todo_repository = todo_repository;
    }
    public List<Todo> listar(){
        return todo_repository.findAll();
    }
    public Todo findById(Integer id){
        return todo_repository.findById(id).orElseThrow(RuntimeException::new);
    }
    public List<Todo>  findByStatus(Status status){
        return todo_repository.findByStatus(status);
    }
    public List<Todo> findByTitulo(String titulo){
        return todo_repository.findByTituloContainingIgnoreCase(titulo);
    }
    public Todo criar(Todo tarefa){
        return todo_repository.save(tarefa);
    }
    public void atualizar(Integer id, Todo tarefa){
        Todo tarefa_existente = findById(id);
        tarefa_existente.setTitulo(tarefa.getTitulo());
        tarefa_existente.setPrioridade(tarefa.getPrioridade());
        tarefa_existente.setStatus(tarefa.getStatus());
        todo_repository.save(tarefa);
    }
    public void deletar(Integer id){
        findById(id);
        todo_repository.deleteById(id);
    }
}
