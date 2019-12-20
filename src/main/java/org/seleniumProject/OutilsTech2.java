package org.seleniumProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OutilsTech2
{	int row ; int col ;
	WebDriver driver ;
	WebElement element = driver.findElement(By.xpath("/table/tbody/tr["+row+"]/td["+col+"]"));
	
	public WebElement getCellule(int row, int col)
	{ 	
		  WebElement element = driver.findElement(By.xpath("/table/tbody/tr["+row+"]/td["+col+"]"));
		  return element;
	}

	
	public int retournerNumeroDeLigne(String s)
	{ 
		int ligneCourante = 1;
		
		List<WebElement> lignes = driver.findElements(By.xpath("//table/tbody/tr"));
		for(WebElement ligne : lignes){
		   List<WebElement> cases = ligne.findElements(By.xpath("td"));
		   if(cases.get(0).getText().equals(s)){
			return ligneCourante;	
		   }
	      ligneCourante++;
		}
		return -1 ;
	}

	
	
	
	
	
	
	
	

}