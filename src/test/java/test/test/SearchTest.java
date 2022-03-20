package test.test;

import org.testng.annotations.Test;

public class SearchTest extends TestBase{
	searchpage ser;

	@Test
	public void search() {
		
		
		String title="Apple iPhone 13 128GB 5G - Blue";
		ser = new searchpage(driver);
		
	    ser.searchddd(title);
	    validateWindow();
	}

}
