package dev.wael.entities;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="listitem") 
public class ListItem {

	public ListItem() {
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * SELECT id, title, description, status, taskid, duedate FROM todo.listitem;
	 * SELECT tid, listname, creationdate, isdone FROM todo.tasklist;
	 */
	int Id;
	String Description;
	boolean Status;
	Instant Duedate;
//	
//	@ManyToOne 
//	TaskList Tasklist = new TaskList();

}
