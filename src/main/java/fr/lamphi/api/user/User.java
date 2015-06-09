package fr.lamphi.api.user;

public class User {
	private int id;
	private String name;
	private String surname;
	private String pseudo;
	private String email;
	private String status;
	private String password;
	private String sex;
	

	public User(int id, String name, String surname, String status, String pseudo, String email, String password, String sex) {
		this.id = id;
		this.name = name;		
		this.surname = surname;
		this.status = status;
		this.pseudo = pseudo;
		this.email = email;
		this.password = password;
		this.sex = sex;		
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

	public String toString() {
		return surname + " " + name;
				
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}
