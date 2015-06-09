package fr.lamphi.api;

public class Lesson {

	private String title;
	private String contenu;
	private String creationDate;
	private int category;
	private int id;
	private int cptValide;
	private double note;
	private boolean certified;
	private User author;
	
	public Lesson(){}
		
	public Lesson(int id, String titre, String contenu, User auteur, String dateCreate, int category, boolean isValide, double note, int cptValide){
		this.id=id;
		this.title=titre;
		this.category=category;		
		this.author=auteur;
		this.creationDate=dateCreate;
		this.certified=isValide;
		this.contenu = contenu;
		this.note = note;
		this.cptValide=cptValide;
	}
	
	public int getCptValide() {
		return cptValide;
	}

	public void setCptValide(int cptValide) {
		this.cptValide = cptValide;
	}

	public double getNote() {
		return note;
	}

	public void setNote(double note) {
		this.note = note;
	}

	public String getTitle(){
		return title;
	}

	public int getCategory() {
		return category;
	}
	
	public int getId(){
		return id;
	}
	
	public User getAuthor(){
		return author;
	}
	
	public String getCreationDate(){
		return creationDate;
	}
	
	public boolean getCertified(){
		return certified;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	
	public void setTitle(String title){
		this.title=title;
	}
	
	public void setId(int id){
		this.id=id;
	}
	
	public void setAuthor(User author){
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
