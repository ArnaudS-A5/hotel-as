package org.seleniumProject;

import static org.junit.Assert.*;

import java.awt.Desktop.Action;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class testiFrame 
{
	WebDriver driver;
	WebDriverWait wait;
	
	@Before
	public void setup() throws Exception 
	{
		driver = OutilTechnique.choisirNavigateur(ENavigateur.firefox) ;
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS) ;
		BaseDeDonnee.deleteAllData("src/main/JDD/nettoyage.xml") ;
	}
	
	@After
	public void tearDown() throws Exception {
	driver.quit()  ;
	BaseDeDonnee.deleteAllData("src/main//JDD/nettoyage.xml") ;
	}
	
	@Test
	public void test() throws Throwable 
	{	
		
	// Ouverture de la page WEB
	driver.get("http://127.0.0.1/TutorialHtml5HotelPhp/") ;
	
	//Verif sur le titre attendu
	WebElement titre =driver.findElement(By.xpath("//a[contains(text(),'HTML5 Hotel Room Booking (JavaScript/PHP)')]")) ;
	assertEquals("HTML5 Hotel Room Booking (JavaScript/PHP)",titre.getText()) ;
	
	//click sur la 1ere cellule  //input[@id='name']
	driver.findElement(By.xpath("//div[@class='scheduler_default_scrollable']//div[2]//div[1]")).click() ;
	
	//Changement focus et verif de presence de l'iframe
	driver.switchTo().frame(0) ;
	assertEquals("New Reservation", driver.findElement(By.xpath("//h1[contains(text(),'New Reservation')]")).getText()) ;
	
	driver.findElement(By.xpath("//input[@id='name']")).sendKeys("resa 1") ;
	driver.findElement(By.xpath("//div[@class='space']//input")).click() ;
	
	//Retour sur la vue par defaut et verif de l'enregistrement
	driver.switchTo().defaultContent() ;
	
	WebElement resa = driver.findElement(By.xpath("//div[@class='scheduler_default_event_inner']")) ;
	assertTrue(resa.getText().contains("resa 1")) ;
	
	WebElement resadecalee = driver.findElement(By.xpath("//div[@id='dp']//div[2]//div[6]")) ;
	
	Actions drag = new Actions(driver) ;
	drag.clickAndHold(resa)
	.moveToElement(resadecalee)
	.release()
	.build()
	.perform();
	
	Thread.sleep(500);								
	assertTrue(driver.findElement(By.xpath("//div[@id='dp']/div[7]")).getText().contains("successful")) ;
	
	Thread.sleep(5000);
	assertFalse(driver.findElement(By.xpath("//div[@id='dp']/div[7]")).getText().contains("successful")) ;
	 
		
	
	WebElement focus_out = driver.findElement(By.xpath("//html")) ;
	WebElement focus_in = driver.findElement(By.xpath("//div[@class='scheduler_default_event_inner']"));
	
	Actions delete = new Actions(driver) ;
	delete.moveToElement(focus_out).build().perform() ;
	delete.moveToElement(focus_in).build().perform() ;
	WebElement croix_delete = driver.findElement(By.xpath("//div[contains(@class,'delete')]")) ;
	delete.moveToElement(croix_delete).click().build().perform() ;


	
	
	
	
	
	
	
	
	
	}
	
}
