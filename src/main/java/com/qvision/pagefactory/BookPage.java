package com.qvision.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookPage {

	@FindBy(xpath = "//div[@id='available']/h2")
	WebElement lblMensaje;

	@FindBy(xpath = "//tr[2]/td/input")
	WebElement txtJava;

	@FindBy(xpath = "//tr[3]/td/input")
	WebElement txtRuby;

	@FindBy(xpath = "//tr[4]/td/input")
	WebElement txtPhyton;

	@FindBy(xpath = "//input[@value= 'Add']")
	WebElement btnAgregar;

	@FindBy(id = "total")
	WebElement txtTotal;

	// metodo para validar titulo de BookPage
	public boolean validarLbl() {
		boolean isVisible = false;

		try {
			if (lblMensaje.isDisplayed()) {
				isVisible = true;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return isVisible;
	}

	// Metodo para llenar Formulario de Libros
	public void LlenarLibros(int java, int phyton, int ruby) {
		sendText(txtJava, java);
		sendText(txtRuby, phyton);
		sendText(txtPhyton, ruby);
		clickOnElement(btnAgregar);
	}

	// metodo obtener total
	public int obtenerTotal() {
		String total = txtTotal.getAttribute("value");
		int totalInt = Integer.parseInt(total);
		return totalInt;
	}

	// metodo generico para dar click en los elementos
	private void clickOnElement(WebElement element) {
		element.click();
	}

	// metodo generico para enviar texto a los imput
	private void sendText(WebElement element, int text) {
		element.clear();
		element.sendKeys(text + "");
	}

}
