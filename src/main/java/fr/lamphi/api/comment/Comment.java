package fr.lamphi.api.comment;

public class Comment {
	private int id;
	private int idUser;
	private String message;
	private String date;
	private int idLesson;
	
	public Comment(){}
	
	public Comment(int id, int idUser, int idLesson, String message, String date ){
		this.setIdUser(idUser);
		this.setDate(date);
		this.setMessage(message);
		this.setId(id);
		this.setIdLesson(idLesson);
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getIdLesson() {
		return idLesson;
	}

	public void setIdLesson(int idLesson) {
		this.idLesson = idLesson;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
