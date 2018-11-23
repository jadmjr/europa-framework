package controlador;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.cedro.europa.configuracao.Config;
import br.com.cedro.europa.configuracao.Evidencia;
import br.com.cedro.europa.dominio.Cadastro;
import br.com.cedro.europa.dominio.Login;
import br.com.cedro.europa.dominio.TelaInicial;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;

public class Controle extends Config {
	Evidencia evidencia;
	// TELAS
	Cadastro cadastro;
	Login login;
	TelaInicial telaInicial;

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

	@Dado("^um e-mail \"([^\"]*)\"$")
	public void um_e_mail(String email) {
		login = new Login(driver);
		preencherCampo(login.getCampoEmail(), email);
		evidencia.adcionaParagrafo("Informar e-mail: " + email);
		evidencia.adcionaImagem(driver);
	}

	@Dado("^uma senha \"([^\"]*)\"$")
	public void uma_senha(String senha) {
		preencherCampo(login.getCampoSenha(), senha);
		evidencia.adcionaParagrafo("Informar a senha: " + senha);
		evidencia.adcionaImagem(driver);
	}

	@Dado("clicar no botao Entrar$")
	public void clicar_no_botão_Entrar() {
		clicarEmElemento(driver, login.getBotaoEntrar());
		evidencia.adcionaParagrafo("Clicar em Entrar");
		evidencia.adcionaImagem(driver);
	}

	@Entao("^confirmar a abertura da pagina inicial$")
	public void confirmar_a_abertura_da_pagina_inicial() {
		try {
			telaInicial = new TelaInicial(driver);
			Assert.assertNotNull(telaInicial);
			evidencia.adcionaParagrafo("Confirmar abertura de página");
			evidencia.adcionaImagem(driver);
		} catch (Exception e) {
			fail();
		}

	}

	@Entao("^confirmar alerta de usuario e senha invalido$")
	public void confirmar_alerta_de_usuario_e_senha_invalido() {
		Assert.assertNotNull(buscarPorClasse(driver, "alert-danger", true));
		evidencia.adcionaParagrafo("Confirmar alerta de usuário e senha inválido");
		evidencia.adcionaImagem(driver);
		evidencia.fecharDocumentoPDF();
	}

}
