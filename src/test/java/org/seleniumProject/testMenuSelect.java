package org.seleniumProject;

	import static org.junit.Assert.*;

	import java.util.concurrent.TimeUnit;

	import org.junit.After;
	import org.junit.Before;
	import org.junit.Ignore;
	import org.junit.Test;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
	
public class testMenuSelect
{
	WebDriver driver;
		
		// JDD
		String login="j2ee";
		String pwd="j2ee";
		String idProduit ="FI-SW-02";
		String categorie ="Fish";
		String categorie_min=categorie.toLowerCase();
		String quantity="2";
		
//		@After
		public void tearDown()
		{
			driver.quit();
		}
		
		@Before
		public void setup() {
			driver = OutilTechnique.choisirNavigateur(ENavigateur.firefox);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
		@Test
		public void test() {


			
			//Accéder à l’application Jpetstore et se connecter en tant que j2ee/j2ee
			driver.get("http://localhost:8090/jpetstore-1.0.5-env2/");
			
			PageIndex page_index = PageFactory.initElements(driver, PageIndex.class);
			
			PageLogin page_login = page_index.clicSignIn(driver);
			
			page_login.saisiChampslogin(login, pwd);
			PageAccueil page_accueil= page_login.submitLogin(driver);
			assertTrue(page_accueil.btn_signout.isEnabled());
			assertEquals("Welcome ABC!", page_accueil.msg_bienvenue.getText());
			
//			PageAbstractBandeau bandeau_menu = PageFactory.initElements(driver, PageIndex.class);

			
			//Sélectionner la  catégorie Fish
		
//			PageCategory page_category = page_accueil.selectCat(driver, categorie_min) ;
//			assertEquals(categorie,page_category.titreCat.getText());

			//Sélectionner le produit de votre choix
//			PageProduit page_produit = page_category.selectionProduit(driver, idProduit) ;
			
			
			//Click sur bouton parametre
			PageParametre bandeau_menu = PageFactory.initElements(driver, PageParametre.class);
			bandeau_menu = bandeau_menu.clicParametre(driver) ;  //
			
			
			//Verif présence page
//			assertEquals("User Information", bandeau_menu.param_titre) ;
			
			WebElement menu = driver.findElement(By.name("account.languagePreference")) ;
			Select select = new Select(menu) ;
			select.selectByIndex(1) ;
			
			WebElement menu2 = driver.findElement(By.name("account.favouriteCategoryId")) ;
			Select select2 = new Select(menu2) ;	
			select2.selectByValue("REPTILES") ;

			WebElement checkbox = driver.findElement(By.name("account.listOption")) ;
			checkbox.click();

			WebElement keyword = driver.findElement(By.name("keyword")) ;
			keyword.sendKeys("Dogs") ;
			
			WebElement search = driver.findElement(By.xpath("//body//input[3]")) ;
			search.click() ;

			WebElement testsearch = driver.findElement(By.xpath("//b[contains(text(),'Product ID')]")) ;
			assertEquals("Product ID", testsearch.getText()) ;
			String s = "Dalmation" ;
			OutilsTech2 tab = new OutilsTech2 () ;
			tab.retournerNumeroDeLigne(s) ;
			
		}

		
}