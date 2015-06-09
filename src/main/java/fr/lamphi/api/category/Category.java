package fr.lamphi.api.category;


public class Category {
	
	private String category;
	private int id; 
	
	public Category (String category) {
			this.setCategory(category);
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "LessonDivision [category=" + category + "]";
	}
	
	
	
}