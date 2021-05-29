package com.myprojs.todoapp.domain;

public class TodoItem {
	private String task;
	private Boolean isDone;
	private Integer id;

	
	public Boolean getIsDone() {
		return isDone;
	}
	public void setIsDone(Boolean isDone) {
		this.isDone = isDone;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	

}
