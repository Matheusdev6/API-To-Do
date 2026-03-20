package com.matheus.to_do.controller;

import com.matheus.to_do.model.Status;
import com.matheus.to_do.model.Todo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.matheus.to_do.service.TodoService;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {
    private TodoService todoService;
    public  TodoController(TodoService todoService) {
        this.todoService = todoService;
    }
    @GetMapping("/listar")
    public ResponseEntity<List<Todo>> listarTodos(){
        return ResponseEntity.ok(todoService.listar());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Todo> buscarPorId(@PathVariable Integer id){
        Todo tarefa = todoService.findById(id);
        return ResponseEntity.ok(tarefa);
    }
    @GetMapping("/status")
    public ResponseEntity<List<Todo>> buscraPorStatus(@RequestParam Status status){
        List<Todo> tarefas = todoService.findByStatus(status);
        return ResponseEntity.ok(tarefas);
    }
    @GetMapping("/titulo")
    public ResponseEntity<List<Todo>> buscraPorTitulo(@RequestParam String  titulo){
        List<Todo> tarefas = todoService.findByTitulo(titulo);
        return ResponseEntity.ok(tarefas);
    }
    @PostMapping("/criar")
    public ResponseEntity<Todo> criar(@RequestBody Todo tarefa){
        Todo tarefaCriada = todoService.criar(tarefa);
        return ResponseEntity.status(HttpStatus.CREATED).body(tarefaCriada);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Todo> atualizar(Todo tarefa, @PathVariable Integer id){
        todoService.atualizar(id,tarefa);
        return ResponseEntity.ok(tarefa);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id){
        todoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
