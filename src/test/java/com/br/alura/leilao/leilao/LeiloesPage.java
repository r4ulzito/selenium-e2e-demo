package com.br.alura.leilao.leilao;

import com.br.alura.leilao.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LeiloesPage extends BaseTest {

    private final String URL_LEILOES = "http://localhost:8080/leiloes";
    private final String URL_CADASTRO_LEILAO = "http://localhost:8080/leiloes/new";

    public LeiloesPage(WebDriver loginDriver) {
        super(loginDriver);
    }

    public CadastroLeilaoPage acessarFormularioCadastroLeilao() {
        driver.navigate().to(URL_CADASTRO_LEILAO);
        return new CadastroLeilaoPage(driver);
    }

    public boolean isLeilaoCadastrado(String nome, String valor, String dataAbertura) {

        WebElement ultimaLinhaTabela = driver.findElement(By.cssSelector("#leiloes-table tbody tr:last-child"));

        WebElement colunaNome = ultimaLinhaTabela.findElement(By.cssSelector("td:nth-child(1)"));
        WebElement colunadDataAbertura = ultimaLinhaTabela.findElement(By.cssSelector("td:nth-child(2)"));
        WebElement colunaValor = ultimaLinhaTabela.findElement(By.cssSelector("td:nth-child(3)"));

        return colunaNome.getText().equals(nome) &&
                colunadDataAbertura.getText().equals(dataAbertura) &&
                colunaValor.getText().equals(valor);

    }

    public boolean isPaginaAtual() {

        return driver.getCurrentUrl().equals(URL_LEILOES);
    }
}
