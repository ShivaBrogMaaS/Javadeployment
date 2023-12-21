package com.test.time.others;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cities")
public class City {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String name;
private String state_id;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getState_id() {
	return state_id;
}

public void setState_id(String state_id) {
	this.state_id = state_id;
}

}
