package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EcommerceLoginTest {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        // Masaüstündeki chromedriver yolu
        System.setProperty("webdriver.chrome.driver", "C:/Users/MONSTER/Desktop/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void loginTest() throws InterruptedException {
        // Test edeceğin e-ticaret sitesi URL'si
        driver.get("https://www.saucedemo.com/");

        // Kullanıcı adı alanını bul ve yaz
        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");

        // Şifre alanını bul ve yaz
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        // Giriş butonuna tıkla
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        // 2 saniye beklet (sayfanın yüklenmesi için)
        Thread.sleep(2000);

        // Basit bir kontrol: sayfa başlığında "Swag Labs" var mı diye bak
        String title = driver.getTitle();
        assert title.contains("Swag Labs");
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
