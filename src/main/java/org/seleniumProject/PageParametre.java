package org.seleniumProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageParametre 
{
	
	@FindBy (xpath = "//img[@name='img_myaccount']")  //bouton parametre
	WebElement btn_param;
	
	@FindBy (xpath = "//h3")  //titre pour assert
	WebElement param_titre;
	
	public PageParametre clicParametre(WebDriver driver)
	{
		btn_param.click();
		return PageFactory.initElements(driver, PageParametre.class) ;
	}
	
	
	
	
	
	
}
