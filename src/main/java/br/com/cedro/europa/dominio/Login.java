package br.com.cedro.europa.dominio;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.cedro.europa.configuracao.Config;

public class Login extends Config {

	WebElement linkHome, linkLogin, linkCadastro, campoEmail, campoSenha, botaoEntrar;

	public Login(WebDriver driver) {

		wait = new WebDriverWait(driver, 10);
		executor = (JavascriptExecutor) driver;

		campoEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		campoSenha = driver.findElement(By.id("senha"));
		botaoEntrar = driver.findElement(By.tagName("button"));
		linkHome = driver.findElements(By.tagName("a")).get(0);
		linkLogin = driver.findElements(By.tagName("a")).get(1);
		linkCadastro = driver.findElements(By.tagName("a")).get(2);

	}

	public WebElement getLinkHome() {
		return linkHome;
	}

	public void setLinkHome(WebElement linkHome) {
		this.linkHome = linkHome;
	}

	public WebElement getLinkLogin() {
		return linkLogin;
	}

	public void setLinkLogin(WebElement linkLogin) {
		this.linkLogin = linkLogin;
	}

	public WebElement getLinkCadastro() {
		return linkCadastro;
	}

	public void setLinkCadastro(WebElement linkCadastro) {
		this.linkCadastro = linkCadastro;
	}

	public WebElement getCampoEmail() {
		return campoEmail;
	}

	public void setCampoEmail(WebElement campoEmail) {
		this.campoEmail = campoEmail;
	}

	public WebElement getCampoSenha() {
		return campoSenha;
	}

	public void setCampoSenha(WebElement campoSenha) {
		this.campoSenha = campoSenha;
	}

	public WebElement getBotaoEntrar() {
		return botaoEntrar;
	}

	public void setBotaoEntrar(WebElement botaoEntrar) {
		this.botaoEntrar = botaoEntrar;
	}

}
