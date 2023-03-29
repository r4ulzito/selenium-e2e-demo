package com.br.alura.leilao;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;

    public BaseTest(WebDriver driver) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        if (driver == null) {
            this.driver = new ChromeDriver();
        } else {
            this.driver = driver;
        }

        this.driver.manage()
                .timeouts()
                .implicitlyWait(5, TimeUnit.SECONDS) // Encontrar elemento na tela
                .pageLoadTimeout(10, TimeUnit.SECONDS); // Carregar a página
    }

    public void fechar() {
        driver.quit();
    }
}
