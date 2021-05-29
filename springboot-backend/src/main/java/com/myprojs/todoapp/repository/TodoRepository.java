package com.myprojs.todoapp.repository;

import java.util.ArrayList;
import java.util.List;

import com.myprojs.todoapp.domain.TodoItem;
import org.springframework.stereotype.Repository;


@Repository
public class TodoRepository {
	private List<TodoItem> todoItems = new ArrayList<>();
	private Integer idCount=0;
	public List<TodoItem> fetchTodoItems(){
		if(todoItems.size()==0)
		{
			TodoItem item0= new TodoItem();
			item0.setId(++idCount);
			item0.setIsDone(true);
			item0.setTask("Generic task");
			todoItems.add(item0);
		}
		return todoItems;
	}
	public TodoItem addTodo(TodoItem todoItem) {
		//=new TodoItem();
		todoItem.setId(++idCount);
		todoItems.add(todoItem);
		return todoItem;
	}
	
}
