package com.rsvp.rsvp.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {
	//auto generate IDS
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	//created attributes
	private Long categoryid;
	private String name;
	
	//Set keys
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	private List<Event> events;
	
	//Category methods
	public Category() {}
	
	public Category(String name) {
		super();
		this.name = name;
	}

	public Long getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Long categoryid) {
		this.categoryid = categoryid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Event> getBooks() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	@Override
	public String toString() {
		return "Category [categoryid=" + categoryid + ", name=" + name + "]";
	}
}
