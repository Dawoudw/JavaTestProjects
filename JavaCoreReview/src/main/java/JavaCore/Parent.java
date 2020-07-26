package JavaCore;

import java.util.Date;

public class Parent implements Comparable<Parent> {

	public Parent() {
		// TODO Auto-generated constructor stub
	}

	public int Id;
	public String Name;
	public Date DOB;

	public Parent(int id, String name, Date dOB) {
		super();
		Id = id;
		Name = name;
		DOB = dOB;
	}

	@Override
	public String toString() {
		return "Parent [Id=" + Id + ", Name=" + Name + ", DOB=" + DOB + "]";
	}

	public int compareTo(Parent o) {
		// TODO Auto-generated method stub
	 
			return this.Id - o.Id;
 
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	public void Print()
	{
		System.out.println(this.getClass().toString());
	}
 
}
