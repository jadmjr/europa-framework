package controlador;

import org.junit.Assert;
import br.com.cedro.europa.configuracao.Config;
import br.com.cedro.europa.dominio.Google;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;

public class Controle extends Config {

	// TELAS
	Google google;

	public Controle() {
		inicializaNavegador();
		inicializaEvidencia();
	}
	// GOOGLE
	@Dado("^o endereco do Google \"([^\"]*)\"$")
	public void o_endere_o_do_Google(String endereco) {
		abrirURL(endereco);
		google = new Google(driver);
		evidencia.print("O endero do Google", driver);
	}

	@Dado("^pesquisar o valor \"([^\"]*)\"$")
	public void pesquisar_o_valor(String valor) {
		preencherCampo(google.getCampoDePesquisa(), valor);
		evidencia.print("Pesquisar o valor", driver);
	}

	@Dado("^clicar no botao pesquisa$")
	public void clicar_no_botao_pesquisa() {
		esperarAparecer(google.getBotaoPesquisar());
		clicarEmElemento(google.getBotaoPesquisar());
		evidencia.print("Clicar no botão pesquisar", driver);
	}

	@Entao("^verificar se o primerio resultado e a pagina do Linkedin$")
	public void verificar_se_o_primerio_resultado_e_a_pagina_do_Linkedin() {
		String resultadoEsperado = "https://br.linkedin.com/";
		String resultado = pegarTexto(google.getLinkPrimeiroResultado());
		Assert.assertEquals(resultadoEsperado, resultado);
		evidencia.print("Verificar se o primeiro resultado é: " + resultadoEsperado, driver);
		finalizarEvidencia();
	}

}
