package fr.lamphi.api;


public class Commentaires {
	private int idUser;
	private String date;
	private String contenu;
	private int id;
	private int idLesson;
	
	public Commentaires(){}
	
	public Commentaires(int id, int idUser, int idLesson, String contenu, String date ){
		this.setIdUser(idUser);
		this.setDate(date);
		this.setContenu(contenu);
		this.setId(id);
		this.setIdLesson(idLesson);
	}


	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
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
}
