package com.qvision.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	@FindBy(name = "user")
	WebElement txtUsuario;

	@FindBy(name = "password")
	WebElement txtPasword;

	@FindBy(xpath = "//input[@class='button']")
	WebElement btnLogin;

	public void inicioSesion(String user, String password) {

		sendText(txtUsuario, user);
		sendText(txtPasword, password);
		clickOnElement(btnLogin);
	}

	//metodo generico para dar click en los elementos
	private void clickOnElement(WebElement element) {
		element.click();
	}
	
	//metodo generico para enviar texto a los imput
	private void sendText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

}
