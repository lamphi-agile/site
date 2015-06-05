package fr.lamphi.api;

public class User {
	private String name;
	private String surname;
	private String status;
	
	private int id = 0;

	public User(int id, String name, String surname, String status) {
		this.id = id;
		this.name = name;
		this.setSurname(surname);
		this.setStatus(status);
	}

	public User() {
		
	}
	
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

	public boolean equals(Object u) {
		return name.equals(((User) u).name);
	}

	public String toString() {
		return id + ": " + surname + " " + name + " - " + status;
				
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
