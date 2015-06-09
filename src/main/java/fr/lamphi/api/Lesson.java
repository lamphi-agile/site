package fr.lamphi.api;

public class Lesson {

	private String title;
	private int category;
	private String content;
	private User author;
	private int idauthor;
	private String creationDate;
	private int id;
	private int cptValide;
	private double note;
	private boolean certified;
	
	public Lesson(){}
		
	public Lesson(int id, String titre, String contenu, User auteur, String dateCreate, int category, boolean isValide, double note, int cptValide){
		this.id=id;
		this.title=titre;
		this.category=category;		
		this.author=auteur;
		this.creationDate=dateCreate;
		this.certified=isValide;
		this.content = contenu;
		this.note = note;
		this.setCptValide(cptValide);
	}
	
	@Override
	public String toString() {
		return "Lesson [title=" + title + ", category=" + category
				+ ", content=" + content + ", author=" + author
				+ ", creationDate=" + creationDate + ", certified=" + certified
				+ ", id=" + id + ", note=" + note + "]";
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getIdauthor() {
		return idauthor;
	}

	public void setIdauthor(int idauthor) {
		this.idauthor = idauthor;
	}
	public int getCptValide() {
		return cptValide;
	}

	public void setCptValide(int cptValide) {
		this.cptValide = cptValide;
	}
}
