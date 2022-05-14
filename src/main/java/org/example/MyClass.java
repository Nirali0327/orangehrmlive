package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class MyClass {
    protected static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/test/java/driver/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        //username
        driver.findElement(By.xpath("//input[@id =\"txtUsername\"]")).sendKeys("Admin");
        //password
        driver.findElement(By.xpath("//input[@name =\"txtPassword\"]")).sendKeys("admin123");
        //login button
        driver.findElement(By.xpath("//input[@id = \"btnLogin\"]")).click();
        driver.quit();

    }
    }

