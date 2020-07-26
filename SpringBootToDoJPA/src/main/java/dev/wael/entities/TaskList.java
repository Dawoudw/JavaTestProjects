package dev.wael.entities;

import java.awt.List;
import java.time.Instant;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tasklist")
public class TaskList {

	public TaskList() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * SELECT id, title, description, status, taskid, duedate FROM todo.listitem;
	 * SELECT tid, listname, creationdate, isdone FROM todo.tasklist;
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tid")
	int Tid;
	@Column(name = "listname")
	String Listname;
	@Column(name = "creationdate")
	Instant Creationdate;
	@Column(name = "isdone")
	boolean Isdone;

	public TaskList(int tid, String listname, Instant creationdate, boolean isdone) {
		super();
		this.Tid = tid;
		this.Listname = listname;
		this.Creationdate = creationdate;
		this.Isdone = isdone;
	}

	@OneToMany
	ArrayList<ListItem> ListItems = new ArrayList<ListItem>();

	public int getTid() {
		return Tid;
	}

	public void setTid(int tid) {
		this.Tid = tid;
	}

	public String getListname() {
		return Listname;
	}

	public void setListname(String listname) {
		this.Listname = listname;
	}

	public Instant getCreationdate() {
		return Creationdate;
	}

	public void setCreationdate(Instant creationdate) {
		this.Creationdate = creationdate;
	}

	public boolean isIsdone() {
		return Isdone;
	}

	public void setIsdone(boolean isdone) {
		this.Isdone = isdone;
	}

	@Override
	public String toString() {
		return "TaskList [Tid=" + Tid + ", Listname=" + Listname + ", Creationdate=" + Creationdate + ", Isdone="
				+ Isdone + ", ListItems=" + ListItems + "]";
	}

}
