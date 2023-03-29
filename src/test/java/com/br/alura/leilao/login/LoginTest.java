package com.br.alura.leilao.login;

import org.junit.jupiter.api.*;

public class LoginTest {

    private LoginPage paginaDeLogin;

    private final String URL_LOGIN = "http://localhost:8080/login";

    @BeforeEach
    public void beforeEach() {
        this.paginaDeLogin = new LoginPage();
    }

    @AfterEach
    public void afterEach() {
        this.paginaDeLogin.fechar();
    }

    @Test
    public void deveriaEfetuarLoginComDadosValidos() {

        this.paginaDeLogin.preencheFormularioLogin("fulano", "pass");
        this.paginaDeLogin.submeteFormularioLogin();

        Assertions.assertNotEquals(paginaDeLogin.getURL(), URL_LOGIN);
        Assertions.assertEquals("fulano", this.paginaDeLogin.getNomeUsuarioLogado());

    }

    @Test
    public void naoDeveLogarComDadosInvalidos() {

        this.paginaDeLogin.preencheFormularioLogin("invalido", "senha inexistente");
        this.paginaDeLogin.submeteFormularioLogin();

        Assertions.assertEquals(this.paginaDeLogin.getURL(), URL_LOGIN + "?error");
        Assertions.assertEquals("Usuário e senha inválidos.", this.paginaDeLogin.getErrorAlert().getText());

        Assertions.assertNull(this.paginaDeLogin.getNomeUsuarioLogado());

    }

    @Test
    public void naoDeveAcessarPaginaRestritaSemEstarLogado() {


        this.paginaDeLogin.navegaParaPaginaDeLances();

        Assertions.assertEquals(this.paginaDeLogin.getURL(), URL_LOGIN);
        Assertions.assertFalse(this.paginaDeLogin.getPageSource().contains("Dados do Leilão"));

    }

}
