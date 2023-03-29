package com.br.alura.leilao.login;

import com.br.alura.leilao.BaseTest;
import com.br.alura.leilao.leilao.LeiloesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class LoginPage extends BaseTest {

    public LoginPage() {
        super(null);
        String URL_LOGIN = "http://localhost:8080/login";
        driver.navigate().to(URL_LOGIN);

    }

    public LoginPage preencheFormularioLogin(String login, String senha) {
        driver.findElement(By.id("username")).sendKeys(login);
        driver.findElement(By.id("password")).sendKeys(senha);

        return this;
    }

    public LeiloesPage submeteFormularioLogin() {
        driver.findElement(By.id("login-btn")).click();
        return new LeiloesPage(driver);
    }

    public String getURL() {

        return this.driver.getCurrentUrl();
    }

    public String getNomeUsuarioLogado() {

        try {
            return driver.findElement(By.id("loged-username")).getText();
        } catch (NoSuchElementException ex) {

            return null;

        }
    }

    public WebElement getErrorAlert() {

        return driver.findElement(By.id("error-alert"));

    }

    public LoginPage navegaParaPaginaDeLances() {

        driver.navigate().to("http://localhost:8080/leiloes/2");

        return this;
    }

    public String getPageSource() {

        return driver.getPageSource();

    }
}
