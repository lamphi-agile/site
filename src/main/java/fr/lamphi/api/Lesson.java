package fr.lamphi.api;

public class Lesson {

	private String title;
	private String author;
	private String creationDate;
	private boolean certified;
	private int id;
	
	public Lesson(){}
	
	public Lesson(String titre, int id, String auteur, String dateCreate, boolean isValide){
		this.title=titre;
		this.id=id;
		this.author=auteur;
		this.creationDate=dateCreate;
		this.certified=isValide;
	}
	
	public String getTitle(){
		return title;
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
}
