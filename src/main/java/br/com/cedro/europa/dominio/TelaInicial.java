package br.com.cedro.europa.dominio;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.cedro.europa.configuracao.Config;

public class TelaInicial extends Config {

	WebElement alertaSucesso;

	public TelaInicial(WebDriver driver) {

		wait = new WebDriverWait(driver, 10);
		executor = (JavascriptExecutor) driver;

		alertaSucesso = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("alert-success")));

	}

	public WebElement getAlertaSucesso() {
		return alertaSucesso;
	}

	public void setAlertaSucesso(WebElement alertaSucesso) {
		this.alertaSucesso = alertaSucesso;
	}

}
