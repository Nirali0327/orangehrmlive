package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
        clickButton((By.xpath("//input[@id = \"btnLogin\"]"))); //login button

        driverUrlToBe("https://opensource-demo.orangehrmlive.com/index.php/dashboard",20); // callingexplicit waits
// ----------------------- Test for Admin tab << System user>> ---------------------//
        // click on a Admin tab on a header bar
        //driver.findElement(By.xpath("//b[.='Admin']")).click();
        clickButton(By.xpath("//b[.='Admin']"));
        // System users -- enter username
        sendKeys(By.name("searchSystemUser[userName]"),"Fiona.Grace");
        //  select user Role
        WebElement element1 = driver.findElement(By.id("searchSystemUser_userType"));
        Select dropdown1 = new Select(element1);
        dropdown1.selectByVisibleText("ESS");
        // enter employee name
        sendKeys(By.className("ac_input"),"Fiona.Grace");
        // select status
        WebElement element2 = driver.findElement(By.id("searchSystemUser_status"));
        Select dropdown2 = new Select(element2);
        dropdown2.selectByVisibleText("Enabled");
        // click search button
        clickButton(By.className("searchbutton"));


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


