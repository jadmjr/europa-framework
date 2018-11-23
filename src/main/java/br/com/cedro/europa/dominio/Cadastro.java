package br.com.cedro.europa.dominio;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.cedro.europa.configuracao.Config;

public class Cadastro extends Config {

	WebElement linkHome, linkLogin, linkCadastro, campoNome, campoEmail, campoSenha, botaoCadastrar;

	public Cadastro(WebDriver driver) {

		wait = new WebDriverWait(driver, 10);
		executor = (JavascriptExecutor) driver;

		campoEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		campoNome = driver.findElement(By.id("nome"));
		campoSenha = driver.findElement(By.id("senha"));

		botaoCadastrar = driver.findElement(By.className("btn"));

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

	public WebElement getCampoNome() {
		return campoNome;
	}

	public void setCampoNome(WebElement campoNome) {
		this.campoNome = campoNome;
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

	public WebElement getBotaoCadastrar() {
		return botaoCadastrar;
	}

	public void setBotaoCadastrar(WebElement botaoCadastrar) {
		this.botaoCadastrar = botaoCadastrar;
	}

}
