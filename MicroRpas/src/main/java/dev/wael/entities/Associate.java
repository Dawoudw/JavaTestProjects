package dev.wael.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "associate")
public class Associate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "a_id")
	private int aId;
	@Column(name = "name")
	private String name;
	@Column(name = "points")
	private int points;

	public Associate() {
		// TODO Auto-generated constructor stub
		super();
	}

	public int getaId() {
		return aId;
	}

	public Associate(int aId, String name, int point) {
		super();
		this.aId = aId;
		this.name = name;
		this.points = point;
	}

	public void setaId(int aId) {
		this.aId = aId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoint() {
		return points;
	}

	public void setPoint(int point) {
		this.points = point;
	}

	@Override
	public String toString() {
		return "Associate [aId=" + aId + ", name=" + name + ", point=" + points + "]";
	}

}
