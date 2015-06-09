package fr.lamphi.api.category;


public class Category {
	
	private int id; 
	private String name;
	private String image;
	private int parentId;
	
	public Category(){}
	
	public Category (int id, String name, String image, int parentId) {
		this.setName(name);
		this.setId(id);
		this.setParentId(parentId);
		this.setImage(image);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", image=" + image
				+ ", parentId=" + parentId + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	
	
	
}