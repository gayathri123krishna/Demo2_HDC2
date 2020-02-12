package day3.day3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Actions_demo
{
	//code to select second from search drop down
	
  @Test(enabled = false)
  public void f() throws InterruptedException
  {
	  WebDriver drive;
	  drive = act_demo.getDriver("abc");
	  drive.get("https://www.google.com");
		drive.manage().window().maximize();

	  WebElement sb = drive.findElement(By.name("q"));
	  //sb.sendKeys("accenture");
	  Actions act = new Actions(drive);
	  act.keyDown(sb, Keys.ALT).sendKeys("accenture").keyUp(Keys.ALT).build().perform();
	  Thread.sleep(3000);
	  act.sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).build().perform();
	  //act.sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).build().perform();

	  act.sendKeys(Keys.ENTER).build().perform();
  }
  
  //code to hover on add-ons and click on one of the options below
  
  @Test(enabled = false)
  public void move_to_element() throws InterruptedException
  {
	  WebDriver drive;
	  drive = act_demo.getDriver("abc");
	  drive.get("https://www.spicejet.com/");
	  drive.manage().window().maximize();
	  Thread.sleep(1000);
	  WebElement e12 = drive.findElement(By.xpath("//a[@id='highlight-addons']"));
	  Actions act2 = new Actions(drive);
	  act2.moveToElement(e12).build().perform();
	  
	  Thread.sleep(1000);
	  drive.findElement(By.xpath("//a[text()='MyFlexiPlan']")).click();
  }
  
  //code for right click
  
  @Test(enabled = false)
  public void rightclick() throws InterruptedException
  {
	  WebDriver drive;
	  drive = act_demo.getDriver("abc");
	  drive.get("https://www.google.com");
	  drive.manage().window().maximize();
	  Thread.sleep(1000);
	  WebElement e13 = drive.findElement(By.xpath("//a[text()='Gmail']"));
	  Actions act3 = new Actions(drive);
	  act3.contextClick(e13).build().perform();
  }
  
  //code for doublic click
  
  @Test(enabled = false)
  public void double_click() throws InterruptedException
  {
	  WebDriver drive;
	  drive = act_demo.getDriver("abc");
	  drive.get("http://demowebshop.tricentis.com/");
	  drive.manage().window().maximize();
	  Thread.sleep(1000);
	  WebElement e14 = drive.findElement(By.xpath("//span[text()='Sign up for our newsletter:']"));
	  Actions act4 = new Actions(drive);
	  act4.doubleClick(e14).build().perform();
	  String txtval = e14.getText();
	  System.out.println(txtval);
  }
  
  @Test
  public void drag_n_drop() throws InterruptedException
  {
	  WebDriver drive;
	  drive = act_demo.getDriver("abc");
	  drive.get("https://demos.telerik.com/aspnet-ajax/treeview/examples/overview/defaultcs.aspx");
	  drive.manage().window().maximize();
	  drive.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  WebElement src = drive.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceholder1_RadTreeView1\"]/ul/li/ul/li[3]/ul/li[1]/div/div/span"));
	  WebElement dst = drive.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceholder1_RadGrid1_ctl00\"]/tbody/tr/td"));
	  
	  Actions act5 = new Actions(drive);
	  act5.dragAndDrop(src, dst).build().perform();
	  WebElement s1 = drive.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceholder1_RadGrid1_ctl00\"]/tfoot/tr/td[2]"));
	  String a_val = s1.getText();
	  String e_val = "$3999";
	  Assert.assertEquals(a_val, e_val);
	  System.out.println("Drag n drop is success");
  }
  
  
}
