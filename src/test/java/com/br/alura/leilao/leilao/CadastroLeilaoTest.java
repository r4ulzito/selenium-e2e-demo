package com.br.alura.leilao.leilao;

import com.br.alura.leilao.login.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CadastroLeilaoTest {

    private LeiloesPage leiloesPage;
    private CadastroLeilaoPage cadastroLeilaoPage;

    @BeforeEach
    public void beforeEach() {
        LoginPage loginPage = new LoginPage();
        this.leiloesPage = loginPage.preencheFormularioLogin("fulano", "pass").submeteFormularioLogin();
        cadastroLeilaoPage = leiloesPage.acessarFormularioCadastroLeilao();
    }

    @AfterEach
    public void afterEach() {
        leiloesPage.fechar();
    }

    @Test
    public void deveCadastrarLeilao() {

        String hoje = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String nome = "Leilão do Dia " + hoje;
        String valor = "500.00";

        this.leiloesPage = cadastroLeilaoPage.cadastrarLeilao(nome, valor, hoje);

        Assertions.assertTrue(leiloesPage.isLeilaoCadastrado(nome, valor, hoje));

    }

    @Test
    public void deveValidarCadastroDeLeilao() {

        this.leiloesPage = cadastroLeilaoPage.cadastrarLeilao("", "", "");

        Assertions.assertFalse(this.cadastroLeilaoPage.isPaginaAtual());
        Assertions.assertTrue(this.leiloesPage.isPaginaAtual());
        Assertions.assertTrue(this.cadastroLeilaoPage.isMensagensDeValidacaoVisiveis());

    }

}
