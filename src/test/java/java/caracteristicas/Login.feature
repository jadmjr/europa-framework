# language: pt
@Login
Funcionalidade: Login

  Cenario: Realizar Login com dados validos
    Dado url da pagina de login "https://seubarriga.wcaquino.me/login"
    E um e-mail "jadmjr@gmail.com"
    E uma senha "teste@europa"
    E clicar no botao Entrar
    Entao confirmar a abertura da pagina inicial

  Cenario: Realizar Login com dados inválidos
    Dado url da pagina de login "https://seubarriga.wcaquino.me/login"
    E um e-mail "jadmsjr@gmail.com"
    E uma senha "teste@europas"
    E clicar no botao Entrar
    Entao confirmar alerta de usuario e senha invalido
