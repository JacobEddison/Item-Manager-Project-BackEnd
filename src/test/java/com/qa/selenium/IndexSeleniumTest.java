package com.qa.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class IndexSeleniumTest {

    private ChromeDriver driver;


    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://35.189.78.116/");
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void createIndex() throws InterruptedException {
        WebElement nameField = driver.findElement(By.id("name"));
        nameField.sendKeys("Selenium Item");
        WebElement lightLevel = driver.findElement(By.id("light"));
        lightLevel.sendKeys("250");
        WebElement submitButton = driver.findElement(By.id("submit"));
        Thread.sleep(1000);
        submitButton.click();
        Thread.sleep(1000);

    }

//    @Test
//    public void deleteIndex() throws InterruptedException {
//        WebElement textBox = driver.findElementById("user-message");
//        textBox.sendKeys("nuyce box");
//        Thread.sleep(1000);
//        WebElement submitButton = driver.findElementById("get-input").findElement(By.className("btn"));
//        submitButton.click();
//        Thread.sleep(2000);
//        JavascriptExecutor scroll = (JavascriptExecutor) driver;
//        scroll.executeScript("window.scroll(0,200)");
//
//        WebElement int1 = driver.findElementById("sum1");
//        int1.sendKeys("5");
//        Thread.sleep(500);
//        WebElement int2 = driver.findElementById("sum2");
//        int2.sendKeys("6");
//        Thread.sleep(500);
//        WebElement addButton = driver.findElementById("gettotal").findElement(By.className("btn"));
//        addButton.click();
//        Thread.sleep(2000);
//
//    }
}