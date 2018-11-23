package br.com.cedro.europa.configuracao;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Config {

	public static WebDriver driver;
	public WebDriverWait wait;
	public JavascriptExecutor executor;
	public String pathChromeServer = "resources\\chromedriver\\chromedriver.exe";

	public void preencherCampo(WebElement campo, String valor) {
		campo.clear();
		campo.sendKeys(valor);
	}

	public void apagarCampo(WebElement campo) {
		campo.clear();
	}

	public void clicarEmElemento(WebDriver driver, WebElement elemento) {
		try {
			elemento.click();
		} catch (Exception e) {
			try {
				executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", elemento);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	public void selecionarPorTexto(WebElement select, String texto) {
		new org.openqa.selenium.support.ui.Select(select).selectByVisibleText(texto);
	}

	// PENSAR SOBRE FACILITAR AINDA MAIS A BUSCA DOS OBJETOS
	public WebElement buscarPorId(WebDriver driver, String id, Boolean esperar) {
		if (esperar == false)
			return driver.findElement(By.id(id));
		else {
			wait = new WebDriverWait(driver, 10);
			return wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
		}
	}

	public WebElement buscarPorClasse(WebDriver driver, String classe, Boolean esperar) {
		if (esperar == false)
			return driver.findElement(By.className(classe));
		else {
			wait = new WebDriverWait(driver, 10);
			return wait.until(ExpectedConditions.presenceOfElementLocated(By.className(classe)));
		}
	}

	public WebElement buscarPorNome(WebDriver driver, String nome, Boolean esperar) {
		if (esperar == false)
			return driver.findElement(By.name(nome));
		else {
			wait = new WebDriverWait(driver, 10);
			return wait.until(ExpectedConditions.presenceOfElementLocated(By.name(nome)));
		}
	}

	public WebElement buscarPorXpath(WebDriver driver, String xpath, Boolean esperar) {
		if (esperar == false)
			return driver.findElement(By.xpath(xpath));
		else {
			wait = new WebDriverWait(driver, 10);
			return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		}
	}

}
