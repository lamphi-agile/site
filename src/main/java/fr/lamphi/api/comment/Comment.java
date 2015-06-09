package fr.lamphi.api.comment;

public class Comment {
	private int id;
	private int userid;
	private int lessonid;
	private String message;
	private String date;
	
	public Comment(){}
	
	public Comment(int id, int idUser, int idLesson, String message, String date){
		this.setId(id);
		this.setUserid(idUser);
		this.setLessonid(idLesson);
		this.setMessage(message);
		this.setDate(date);
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getLessonid() {
		return lessonid;
	}

	public void setLessonid(int lessonid) {
		this.lessonid = lessonid;
	}
	
}
