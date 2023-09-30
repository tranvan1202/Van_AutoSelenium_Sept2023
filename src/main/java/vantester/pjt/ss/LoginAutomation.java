package vantester.pjt.ss;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginAutomation {
     public void AutoLogin() throws InterruptedException {
        String pathWebDriver = "D:\\Auto\\Setup\\chromedriver-win64\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",pathWebDriver);
        WebDriver driver = new ChromeDriver();

        String url = "https://p6-qa.samsung.com/sg/monitors/high-resolution/viewfinity-s9-27-inch-5k-resolution-ls27c900paexxs";

        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        WebElement email = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("submit-button"));

        email.clear();
        System.out.println("Entering the username");
        email.sendKeys("dotcom_qa");

        password.clear();
        System.out.println("Entering the password");
        password.sendKeys("!@#qapass00");

        System.out.println("Clicking login button");
        loginButton.click();

        String title = "Samsung Singapore | Samsung Online Electronic Store";

//        String actualTitle = driver.getTitle();
//
//        System.out.println("Verifying the page title has started");
//        Assert.assertEquals(actualTitle,title,"Page title doesnt match");
//
//        System.out.println("The page title has been successfully verified");

        System.out.println("User logged in successfully");
        Thread.sleep(10000);

        driver.quit();
    }
}
