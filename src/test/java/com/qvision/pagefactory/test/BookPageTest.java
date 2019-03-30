package com.qvision.pagefactory.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import com.qvision.pagefactory.BookPage;
import com.qvision.pagefactory.LoginPage;

public class BookPageTest {

	WebDriver driver;
	LoginPage pageLogin;
	BookPage pageBook;
	private String baseURL = "http://sahitest.com/demo/training/login.htm";

	@Before
	public void cargarDriver() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("--incognito");
		driver = new ChromeDriver(options);
		driver.get(baseURL);
		pageLogin = PageFactory.initElements(driver, LoginPage.class);
		pageBook = PageFactory.initElements(driver, BookPage.class);
	}
	
	@Test
	public void test() {
		pageLogin.inicioSesion("test", "secret");
		pageBook.LlenarLibros (1,1,1);
		Assert.assertEquals("No son iguales",850, pageBook.obtenerTotal());
	}
	
	@After
	public void closeBrowser() {
		driver.close();
		driver.quit();
		
	} 


}
