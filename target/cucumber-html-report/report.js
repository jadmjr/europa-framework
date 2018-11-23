$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("caracteristicas/PesquisaGoogle.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "# language: pt"
    }
  ],
  "line": 3,
  "name": "Realizar uma pesquisa no Google",
  "description": "",
  "id": "realizar-uma-pesquisa-no-google",
  "keyword": "Funcionalidade",
  "tags": [
    {
      "line": 2,
      "name": "@PesquisaGoogle"
    }
  ]
});
formatter.scenario({
  "line": 5,
  "name": "Realizar uma pesquisa no Google",
  "description": "",
  "id": "realizar-uma-pesquisa-no-google;realizar-uma-pesquisa-no-google",
  "type": "scenario",
  "keyword": "Cenario"
});
formatter.step({
  "line": 6,
  "name": "o endereco do Google \"https://www.google.com.br/\"",
  "keyword": "Dado "
});
formatter.step({
  "line": 7,
  "name": "pesquisar o valor \"Linkedin\"",
  "keyword": "E "
});
formatter.step({
  "line": 8,
  "name": "clicar no botao pesquisa",
  "keyword": "E "
});
formatter.step({
  "line": 9,
  "name": "verificar se o primerio resultado e a pagina do Linkedin",
  "keyword": "Entao "
});
formatter.match({
  "arguments": [
    {
      "val": "https://www.google.com.br/",
      "offset": 22
    }
  ],
  "location": "Controle.o_endere_o_do_Google(String)"
});
formatter.result({
  "duration": 14006288576,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Linkedin",
      "offset": 19
    }
  ],
  "location": "Controle.pesquisar_o_valor(String)"
});
formatter.result({
  "duration": 1242384264,
  "status": "passed"
});
formatter.match({
  "location": "Controle.clicar_no_botao_pesquisa()"
});
formatter.result({
  "duration": 3641411964,
  "status": "passed"
});
formatter.match({
  "location": "Controle.verificar_se_o_primerio_resultado_e_a_pagina_do_Linkedin()"
});
formatter.result({
  "duration": 273001176,
  "status": "passed"
});
});