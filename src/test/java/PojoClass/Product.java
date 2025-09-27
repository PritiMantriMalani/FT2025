package PojoClass;

public class Product 
{
	private String title;
	private double price;
	private String discription;
	private String image;
	private String category;
	//constructor
	public Product(String title, double price, String discription, String image,String category)
	{
		this.title = title;
		this.price = price;
		this.discription = discription;
		this.image = image;
		this.category = category;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
}
