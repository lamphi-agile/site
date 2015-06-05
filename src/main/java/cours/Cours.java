package cours;

public class Cours {

	private String titre;
	private String auteur;
	private String dateCreate;
	private boolean isValide;
	private int id;
	
	public Cours(String titre, int id, String auteur, String dateCreate, boolean isValide){
		this.titre=titre;
		this.id=id;
		this.auteur=auteur;
		this.dateCreate=dateCreate;
		this.isValide=isValide;
	}
	
	public String getTitre(){
		return titre;
	}
	
	public int getid(){
		return id;
	}
	
	public String getAuteur(){
		return auteur;
	}
	
	public String getDateCrea(){
		return dateCreate;
	}
	
	public boolean isValide(){
		return isValide;
	}
	
	public void setTitre(String titre){
		this.titre=titre;
	}
	
	public void setid(int id){
		this.id=id;
	}
	
	public void setAuteur(String auteur){
		this.auteur=auteur;
	}
	
	public void setDateCrea(String dateCrea){
		this.dateCreate=dateCrea;
	}
	
	public void setValide(boolean valide){
		this.isValide=valide;
	}
}
