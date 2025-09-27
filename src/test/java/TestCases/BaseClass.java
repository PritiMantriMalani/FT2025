package TestCases;

import java.util.List;

import org.testng.annotations.BeforeClass;

import Route.Routes;
import io.restassured.RestAssured;

public class BaseClass 
{
	@BeforeClass
	public void SetUp()
	{
		RestAssured.baseURI = Routes.BASE_URL;
	}
	
	boolean isSortedDescending(List<Integer> list)
	{
		for(int i=0;i<list.size()-1;i++)
		{
			if(list.get(i)<list.get(i+1))
			{
				return false;
			}
		} return true;
	}
	
	boolean isSortedAscending(List<Integer> list)
	{
		for(int i=0;i<list.size()-1;i++)
		{
			if(list.get(i)>list.get(i+1))
			{
				return false;
			}
		} return true;
	}
	boolean isSortedCategoryAscending(List<String> categories)
	{
		for(int i=0;i<categories.size()-1;i++)
		{
	//		if(categories.get(i)>categories.get(i+1))
			{
				return false;
			}
		} return true;
	}

}
