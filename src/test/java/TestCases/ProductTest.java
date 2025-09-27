package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Payloads.Payload;
import PojoClass.Product;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.net.URI;
import java.util.List;

import Route.Routes;
import Utilities.ConfigReader;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ProductTest extends BaseClass
{
	ConfigReader configreader;
	//Get all product details
	//@Test
	public void getAllProducts()
	{ 
		given()
		
		.when()
			.get(Routes.GET_ALL_PRODUCTS)
		
		.then()
			.statusCode(200)
			.log().all();
	}
	// Get specific product by its ID
	//@Test
	public void getProductByID() throws Exception
	{
		 configreader = new ConfigReader();
		int productID = configreader.getIntProperty("productID");
		given()
		 	.pathParam("id", productID)
		.when()
			.get(Routes.GET_PRODUCTS_BY_ID)
			
		.then()
			.statusCode(200)
			.log().all();	
	}
	//Get some limited product
	//@Test
	public void getLimitedProduct() 
	{
		
		given()
			.pathParam("limit", 4)
			//.queryParam("limit", 3)
		.when()
			.get(Routes.GET_PRODUCT_WITH_LIMIT)
			//.get("https://fakestoreapi.com/products?limit=4")
		
		.then()
			.statusCode(200)
			.log().all();	
	}
	//Get product in order
	//@Test
	public void getSortedProduct()
	{
		given()
			.pathParam("order", "desc")
		.when()
			.get(Routes.GET_PRODUCT_BY_SORT)
		
		.then()
			.statusCode(200)
			.log().all();
	}
	//Get product in Descending order
	//@Test
	public void getSortedproductDesc()
	{
		Response response = given()
			.pathParam("order", "desc")	
		.when()
			.get(Routes.GET_PRODUCT_BY_SORT);
		List<Integer> productIDs = response.jsonPath().getList("id", Integer.class);
		
		isSortedDescending(productIDs);
		
		Assert.assertEquals(isSortedDescending(productIDs), true);	
	}
	//Get product in Ascending order
	//@Test
	public void getSortedproductAsc()
	{
		Response response = given()
			.pathParam("order", "asc")	
		.when()
			.get(Routes.GET_PRODUCT_BY_SORT);
		List<Integer> productIDs = response.jsonPath().getList("id", Integer.class);
		
		isSortedAscending(productIDs);
		
		Assert.assertEquals(isSortedAscending(productIDs), true);	
	}
	//Get all category product
	//@Test
	public void getAllCategoryProduct()
	{
		given()
		.when()
			.get(Routes.GET_ALL_CATEGORIES)
		.then()
			.statusCode(200)
			.log().all();
	}
	//Get Product with specific category
	//@Test
	public void getProductByCategory()
	{
		given()
			.pathParam("category", "jewelery")
		.when()
			.get(Routes.GET_PRODUCT_WITH_CATEGORY)
		.then()
			.statusCode(200)
			.body("category", everyItem(equalTo("jewelery")))
			.log().all();
	}
	//@Test
	public void getSortedCategoryproductAsc()
	{
		Response response = given()
			.pathParam("order", "asc")	
		.when()
			.get(Routes.GET_PRODUCT_WITH_CATEGORY);
		List<String> categories = response.jsonPath().getList("categories", String.class);
		
		isSortedCategoryAscending(categories);
		
		Assert.assertEquals(isSortedCategoryAscending(categories), true);	
	}
	//Create new Product
	//@Test
	public void createNewProduct() 
	{
		Product product = Payload.product_payload(); //to create random data
		given()
		
			.body(product)
			.contentType(ContentType.JSON)
		.when()
			.post(Routes.PRODUCT_CREATE)
		.then()
			.statusCode(201)
			.body("id", notNullValue())
			.body("title", equalTo(product.getTitle()))
			//.extract().jsonPath().getInt("id")
			.log().all();
	}
	//Update new Product
		@Test
		public void updateNewProduct() throws Exception 
		{
			Product updatedproduct = Payload.product_payload(); //to create random data
		    configreader = new ConfigReader();
		    int productId = configreader.getIntProperty("productId");
			given()
			
				.body(updatedproduct)
				.contentType(ContentType.JSON)
				.pathParam("id", productId)
			.when()
				.put(Routes.PRODUCT_UPDATE)
			.then()
				.statusCode(200)
				.body("title", equalTo(updatedproduct.getTitle()))
				.log().all();
			
		}
	
	
	
}
















