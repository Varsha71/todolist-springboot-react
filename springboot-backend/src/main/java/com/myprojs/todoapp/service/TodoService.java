package com.myprojs.todoapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myprojs.todoapp.domain.TodoItem;
import com.myprojs.todoapp.repository.TodoRepository;

@Service
public class TodoService {
	@Autowired 
	private TodoRepository todoRepository;
	
	public List<TodoItem> fetchTodoItems(){
		return todoRepository.fetchTodoItems();
	}
	
	public TodoItem addItem() {
		TodoItem newIt=new TodoItem();
		newIt.setIsDone(false);
		
		//newIt.setTask("Task #");
		newIt= todoRepository.addTodo(newIt);
		newIt.setTask("Task #"+ newIt.getId());
		return newIt;
		
	}
//Optional <TodoItem> todoOpt
	public TodoItem updateItem(Integer id , TodoItem reqtodo) {
		Optional <TodoItem> todoOpt= todoRepository.fetchTodoItems().stream().filter(item -> item.getId().equals(id)).findAny();  // "-> here "
		
		if(todoOpt.isPresent()) {
			TodoItem item = todoOpt.get();
			item.setIsDone(reqtodo.getIsDone());
			item.setTask(reqtodo.getTask());
			//item.setId(reqtodo.getId());
			return item;
		}
		return null;
		
	}

	

}
