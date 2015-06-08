package fr.lamphi.api;

public class Lesson {

	private String title;
	private String category;
	private String contenu;
	private String author;
	private String creationDate;
	private boolean certified;
	private int id;
	
	public Lesson(){}
	
	public Lesson(String titre, String category, String contenu, int id, String auteur, String dateCreate, boolean isValide){
		this.title=titre;
		this.category=category;
		this.id=id;
		this.author=auteur;
		this.creationDate=dateCreate;
		this.certified=isValide;
		this.contenu = contenu;
	}
	
	public String getTitle(){
		return title;
	}

	public String getCategory() {
		return category;
	}
	
	public int getId(){
		return id;
	}
	
	public String getAuthor(){
		return author;
	}
	
	public String getCreationDate(){
		return creationDate;
	}
	
	public boolean getCertified(){
		return certified;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	
	public void setTitle(String title){
		this.title=title;
	}
	
	public void setId(int id){
		this.id=id;
	}
	
	public void setAuthor(String author){
		this.author=author;
	}
	
	public void setCreationDate(String creationDate){
		this.creationDate=creationDate;
	}
	
	public void setValide(boolean certified){
		this.certified=certified;
	}
	
	public void setCertified(boolean certified) {
		this.certified=certified;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
}
