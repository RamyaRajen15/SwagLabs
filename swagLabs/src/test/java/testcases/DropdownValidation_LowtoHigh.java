//********************************************************************************************
//*                                                                                          *
//*   Project name: SwagLabs                                                         	     *
//*   Module : DropdownValidation                                                            *
//*   Description: Dropdown validation Price (Low to High)				    				 *
//*                                                                                          *

//********************************************************************************************
/*  

Test Steps
Step 1. Goto https://www.saucedemo.com/
Step 2. Enter Valid Username
Step 3. Enter valid Password
Step 4. Click login Button
Step 5. Click the dropdown
Step 6. Select Price (Low To High)
Step 7. Verify the Products are sorted Low to high price 
 */

package testcases;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownValidation_LowtoHigh {

	
	public static String username="standard_user";
	public static String password="secret_sauce";

	public static void main(String[] args)
	{
			
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		WebElement dropdownName=driver.findElement(By.className("product_sort_container"));
		Select dropDown=new Select(dropdownName);
		dropDown.selectByValue("lohi");
		List<WebElement> ProductName=driver.findElements(By.xpath("//div[@class='inventory_item']//div[@class='inventory_item_name']"));
		List<WebElement> productPrice=driver.findElements(By.xpath("//div[@class='inventory_item']//div[@class='inventory_item_price']"));
		int totalSize = ProductName.size();
		System.out.println("Number of products Displayed: "+totalSize);
		for (int i = 0; i < ProductName.size(); i++) {
			String NameofProduct = ProductName.get(i).getText();
			String Price = productPrice.get(i).getText();
			Double prodPrice=Double.parseDouble(Price.replaceAll("[^0-9+.]", ""));
			System.out.println(NameofProduct);
			System.out.println(prodPrice);
			
		}driver.close();

	}

}