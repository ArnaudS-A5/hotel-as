package org.seleniumProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class PageAbstractBandeau {

	@FindBy (xpath = "//img[@name='img_signin']")
	private WebElement btn_signin;
	
	@FindBy (xpath = "//img[@name='img_signout']")
	WebElement btn_signout;
	
	@FindBy (xpath = "//img[@name='img_myaccount']")  //bouton parametre
	WebElement btn_param;
	
	
	
	public PageLogin clicSignIn(WebDriver driver) {
		btn_signin.click();
		return PageFactory.initElements(driver, PageLogin.class) ;
	}
	
	
	public PageParametre clicParametre(WebDriver driver) {
		btn_param.click();
		return PageFactory.initElements(driver, PageParametre.class) ;
	}
	
	
	
	
}
