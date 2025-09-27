package Payloads;

import java.util.Random;

import com.github.javafaker.Faker;

import PojoClass.Product;

public class Payload 
//we need to create random data
{
	private static String categories[] = {"Electronics","Clothing","BeautyProd","Furniture","Books"};
	public static Product product_payload()
	{
		Faker faker = new Faker();
		Random random = new Random();
		String title = faker.commerce().productName();
		double price = Double.parseDouble(faker.commerce().price());
		String description = faker.lorem().sentence();
		String imageUrl = "https://i.pravatar.cc";
		String category = categories[random.nextInt(categories.length)];
		Product product = new Product(title, price, description, imageUrl,category);
		return product;
		
	}
	

}
