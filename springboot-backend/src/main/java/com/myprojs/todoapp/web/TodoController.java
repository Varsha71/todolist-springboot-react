package com.myprojs.todoapp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myprojs.todoapp.domain.TodoItem;
import com.myprojs.todoapp.service.TodoService;

@RestController
@CrossOrigin("http://localhost:3000")
public class TodoController {

@Autowired 
private TodoService todoService;
	
 @GetMapping("/api/todoitems")
 public ResponseEntity<?> fetchTodoItems(){
	 //return todoService.fetchTodoItems(); not returning this, ResponseEntity
	 List<TodoItem> todoItems = todoService.fetchTodoItems();
	 return ResponseEntity.status(HttpStatus.OK).body(todoItems);
	 
 }
 
@PostMapping("/api/todoitems")
public ResponseEntity<?> addItem(){
	TodoItem it=todoService.addItem();
	return ResponseEntity.ok(it);
}
 
@PutMapping("/api/todoitems/{id}")
public ResponseEntity<?> updateItem(@PathVariable Integer id, @RequestBody TodoItem reqtodo){
	TodoItem updatedItem= todoService.updateItem(id,reqtodo);
	return ResponseEntity.ok(updatedItem);
 }
 
 
}
