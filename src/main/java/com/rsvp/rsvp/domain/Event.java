package com.rsvp.rsvp.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Event {
		//Generates ID automatically
		@Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
		//Creates attributes 
	    private Long id;
	 	private String name;
	    private String host;
	    private String date;
	    private String time;
	    private String location;
	    private String city;
	    
	    //Set Many to One relationship in H2/DB 
	    @ManyToOne
		// ignore one to many links in repository
	    @JsonIgnore
	    //create join column with category id
	    @JoinColumn(name = "categoryid")
	    private Category category;
	   
	    //Book class methods
	    public Event() {}

		public Event(String name, String host, String date, String time, String location, String city, Category category) {
			super();
			this.name = name;
			this.host = host;
			this.date = date;
			this.time = time;
			this.location = location;
			this.city = city;
			this.category = category;

		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getHost() {
			return host;
		}

		public void setHost(String host) {
			this.host = host;
		}

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public String getTime() {
			return time;
		}

		public void setTime(String time) {
			this.time = time;
		}

		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}
		
		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}
		public Category getCategory() {
			return category;
		}

		public void setCategory(Category category) {
			this.category = category;
		}
		@Override
		public String toString() {
			if (this.category != null)
			return "Event [id=" + id + ", name=" + name + ", host=" + host + ", date=" + date + ", time=" + time
					+ ", location=" + location + ", city=" + city + ", category=" + this.getCategory() + "]";
			else
			    return "Book [id=" + id + ", name=" + name + ", host=" + host + ", date=" + date + ", time=" + time
			         + ", location=" + location + ", city=" + city + "]";
		}
}
