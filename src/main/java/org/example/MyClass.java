package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyClass {
    protected static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/java/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        //username
        //driver.findElement(By.xpath("//input[@id =\"txtUsername\"]")).sendKeys("Admin");
        sendKeys(By.xpath("//input[@id =\"txtUsername\"]"),"Admin");  // calling user defined method

        //password
        //driver.findElement(By.xpath("//input[@name =\"txtPassword\"]")).sendKeys("admin123");
        sendKeys(By.xpath("//input[@name =\"txtPassword\"]"),"admin123");  // calling user define method

        //login button
       // driver.findElement(By.xpath("//input[@id = \"btnLogin\"]")).click();
        clickButton((By.xpath("//input[@id = \"btnLogin\"]")));

        driverUrlToBe("https://opensource-demo.orangehrmlive.com/index.php/dashboard",20); // callingexplicit waits

       // driver.quit();

    }

    // ------------------- User define method for code reusability-------------------------//
    public static void sendKeys(By by,String value){
        driver.findElement(by).sendKeys(value);
    }
    public static void clickButton(By by){
        driver.findElement(by).click();
    }

    // -------------------- webdriver waits --------------------------------
    public static void driverUrlToBe(String url, int time ){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.urlToBe(url));

        }
    }


