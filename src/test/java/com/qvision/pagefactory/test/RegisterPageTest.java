package com.qvision.pagefactory.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.Alert;

import com.qvision.pagefactory.BookPage;
import com.qvision.pagefactory.LoginPage;
import com.qvision.pagefactory.RegisterPage;

import junit.framework.Assert;

public class RegisterPageTest {
	Alert alert;
	String print;
	WebDriver driver;
	LoginPage pageLogin;
	RegisterPage registerPage;
	String ExpectedResult2 = "Are you sure?";
	String ExpectedResult = "Registered Successfully";
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
		registerPage = PageFactory.initElements(driver, RegisterPage.class);
	}

	@Test
	public void test1() {
		registerPage.inicioRegistro();
		registerPage.crearUsuario("Rodrigo", "Admin", "Admin", "Calle 100 130 - 03", "Calle 100 130 - 03", 1);
		alert = driver.switchTo().alert();
		print = alert.getText();
		if (print.equals(ExpectedResult)) {
			Assert.assertEquals(ExpectedResult, print);
			System.out.println(print);
			alert.accept();
		}
	}

	@Test
	public void test2() {
		registerPage.inicioRegistro();
		registerPage.crearUsuario("Rodrigo", "Admin", "Admin", "Calle 100 130 - 03", "Calle 100 130 - 03", 2);
		alert = driver.switchTo().alert();
		print = alert.getText();
		if (print != ExpectedResult) {
			Assert.assertEquals(ExpectedResult2, print);
			System.out.println(print);
			alert.accept();
		}
	}

	@After
	public void closeBrowser() {
		driver.close();
		driver.quit();

	}

}
