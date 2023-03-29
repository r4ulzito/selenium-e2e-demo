package com.br.alura.leilao;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloWoldSelenium {

    @Test
    public void hello() {

        //Instalação do Driver
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        //Abre o navegador
        WebDriver browser = new ChromeDriver();
        //Navega até o endereço
        browser.navigate().to("http://localhost:8080/leiloes");
        // Fecha o navegador
        browser.quit();
    }

}
