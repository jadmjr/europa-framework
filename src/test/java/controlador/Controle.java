package controlador;

import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.cedro.europa.configuracao.Config;
import br.com.cedro.europa.configuracao.Evidencia;
import br.com.cedro.europa.dominio.Google;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;

public class Controle extends Config {
	Evidencia evidencia;
	// TELAS
	Google google;

	public Controle() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		System.setProperty("webdriver.chrome.driver", pathChromeServer);
		driver = new ChromeDriver(options);
		wait = new WebDriverWait(driver, 10);

	}

	@Dado("^url da pagina de login \"([^\"]*)\"$")
	public void url_pagina_de_login(String url) {
		driver.get(url);

		evidencia = new Evidencia();
		evidencia.geraPDF("ev_test_00");
		evidencia.adcionaParagrafo("Acessar a url: " + url);
		evidencia.adcionaImagem(driver);
	}

	// GOOGLE
	@Dado("^o endereco do Google \"([^\"]*)\"$")
	public void o_endere_o_do_Google(String endereco) {
		driver.get(endereco);
		google = new Google(driver);
	}

	@Dado("^pesquisar o valor \"([^\"]*)\"$")
	public void pesquisar_o_valor(String valor) {
		google.getCampoDePesquisa().sendKeys(valor);
	}

	@Dado("^clicar no botao pesquisa$")
	public void clicar_no_botao_pesquisa() {
		google.getBotaoPesquisar().click();
	}

	@Entao("^verificar se o primerio resultado e a pagina do Linkedin$")
	public void verificar_se_o_primerio_resultado_e_a_pagina_do_Linkedin() {
		String resultadoEsperado = "https://br.linkedin.com/";
		String resultado = google.getLinkPrimeiroResultado().getText();
		Assert.assertEquals(resultadoEsperado, resultado);
	}

}
