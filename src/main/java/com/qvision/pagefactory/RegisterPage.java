package com.qvision.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DriverCommand;
import org.openqa.selenium.support.FindBy;

public class RegisterPage {

	@FindBy(xpath = "//*[@href='register.htm']")
	WebElement lblRegister;

	@FindBy(xpath = "//div[@class='d']/h4")
	WebElement lblMensaje;

	@FindBy(id = "uid")
	WebElement txtUserName;

	@FindBy(id = "pid")
	WebElement txtPassword;

	@FindBy(id = "pid2")
	WebElement txtRepeatPassword;

	@FindBy(xpath = "//input[@value='M']")
	WebElement radGenderM;

	@FindBy(xpath = "//input[@value='F']")
	WebElement radGenderF;

	@FindBy(id = "taid")
	WebElement txtAreaAdress;

	@FindBy(id = "btaid")
	WebElement txtAreaBillingAdress;
	
	@FindBy(xpath = "//select/option[1]")
	WebElement optionState1;
	
	@FindBy(xpath = "//select/option[2]")
	WebElement optionState2;

	@FindBy(xpath = "//select/option[3]")
	WebElement optionState3;

	@FindBy(name = "agree")
	WebElement checkTerminos;

	@FindBy(xpath = "//input[@value='Register']")
	WebElement btnRegister;

	@FindBy(xpath = "//input[@value='Cancel']")
	WebElement btnCancel;

	// metodo para iniciar registro
	public void inicioRegistro() {
		clickOnElement(lblRegister);
	}

	// metodo para validar titulo de BookPage
	public boolean validarLbl() {
		boolean isVisible = true;

		try {
			if (lblMensaje.isDisplayed()) {
				isVisible = false;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return isVisible;
	}

	// metodo para llenar Formulario
	public void crearUsuario(String user, String pass, String repeatPass, String adress, String adress2, int option) {

		sendText(txtUserName, user);
		sendText(txtPassword, pass);
		sendText(txtRepeatPassword, repeatPass);
		clickOnElement(radGenderM);
		sendText(txtAreaAdress, adress);
		sendText(txtAreaBillingAdress, adress2);
		clickOnElement(optionState2);
		clickOnElement(checkTerminos);
		switch (option) {
		case 1:
			  clickOnElement(btnRegister);
			  break;
		case 2:
			clickOnElement(btnCancel);
			break;

		default:
			break;
		}
	}

	// metodo generico para dar click en los elementos
	private void clickOnElement(WebElement element) {
		element.click();
	}

	// metodo generico para enviar texto a los imput
	private void sendText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

}
