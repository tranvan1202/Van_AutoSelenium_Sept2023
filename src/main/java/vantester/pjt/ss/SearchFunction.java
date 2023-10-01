package vantester.pjt.ss;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class SearchFunction {
    static WebDriver driver;
   @BeforeEach
    public void Setup(String linkUrl) {
        String pathWebDriver = "D:\\Auto Test\\Setup\\chromedriver-win64\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",pathWebDriver);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.get(linkUrl);
        driver.navigate().to(linkUrl);
    }

   @Test
//    public void SearchAKeyWord(String keyWord) throws InterruptedException {
//       String locatorAcceptCookies = "//*[@id=\"header\"]/div[2]/div/div/div[2]/a";
//       if (driver.findElement(By.xpath(locatorAcceptCookies)).isDisplayed()) {
//           WebElement clickOnAcceptCookies = driver.findElement(By.xpath(locatorAcceptCookies));
//           clickOnAcceptCookies.click();
//       }
//
//       //Click nút search
//       String locatorSearchButton = "//body/div[@id='wrap']/nav[@id='component-id']/div[1]/div[6]/div[1]";
//       WebElement clickOnSearch = driver.findElement(By.xpath(locatorSearchButton));
//       clickOnSearch.click();
//       Thread.sleep(1000);
//
//        //Nhập keywords
//        String locatorInputKeyword = "gnb-search-keyword";
//        WebElement searchKeywordInput = driver.findElement(By.id(locatorInputKeyword));
//        searchKeywordInput.sendKeys(keyWord);
//        Thread.sleep(1000);
//
//        //Click button submit kết quả search
//        String locatorSubmitSearch = "//body/div[@id='wrap']/section[2]/div[3]/div[1]/form[1]/fieldset[1]/div[1]/button[3]";
//        WebElement clickSubmitSearch = driver.findElement(By.xpath(locatorSubmitSearch));
//        clickSubmitSearch.click();
//        Thread.sleep(1000);
//
//        String locatorSwitchToAll = "//body/div[@id='wrap']/section[3]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[1]";
//        WebElement clickAll = driver.findElement(By.xpath(locatorSwitchToAll));
//        clickAll.click();
//        Thread.sleep(3000);
//    }
    public void SearchKeywords() throws Exception {
       ArrayList<String> arrayKeywords = new ArrayList<String>();
       arrayKeywords.add("Fold5");
       arrayKeywords.add("Flip 5");
       arrayKeywords.add("Flip Fold 5");
       arrayKeywords.add("Phone");
       arrayKeywords.add("Large phone");
       for (int i=0; i<arrayKeywords.size(); i++) {
           driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
           String locatorAcceptCookies = "//a[contains(text(),'CHẤP NHẬN')]";
           Boolean isAcceptCookiesAppear = driver.findElements(By.xpath(locatorAcceptCookies)).size() > 0;
           if(isAcceptCookiesAppear) {
               WebElement clickOnAcceptCookies = driver.findElement(By.xpath(locatorAcceptCookies));
               clickOnAcceptCookies.click();
           };

           //Click nút search
           String locatorSearchButton = "//body/div[@id='wrap']/nav[@id='component-id']/div[1]/div[6]/div[1]";
           WebElement clickOnSearch = driver.findElement(By.xpath(locatorSearchButton));
           driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
           clickOnSearch.click();
           //Thread.sleep(2000);

           //Nhập keywords
           String locatorInputKeyword = "gnb-search-keyword";
           WebElement searchKeywordInput = driver.findElement(By.id(locatorInputKeyword));
           searchKeywordInput.sendKeys(arrayKeywords.get(i));
           driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
           //Thread.sleep(2000);

           //Click button submit kết quả search
           String locatorSubmitSearch = "//body/div[@id='wrap']/section[2]/div[3]/div[1]/form[1]/fieldset[1]/div[1]/button[3]";
           WebElement clickSubmitSearch = driver.findElement(By.xpath(locatorSubmitSearch));
           clickSubmitSearch.click();
           driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
           //Thread.sleep(1000);

           //Click sang tab Tất Cả
           String locatorSwitchToAll = "//*[@id=\"result-list-container\"]/div[1]/div/ul/li[1]";
           WebElement clickAll = driver.findElement(By.xpath(locatorSwitchToAll));
           clickAll.click();
           driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
           //Thread.sleep(2000);

           //Chụp ảnh
           TakeScreenshot takeScreenshot = new TakeScreenshot();
           Thread.sleep(2000);
           takeScreenshot.takeSnapShot(this.driver, "D:\\Screenshot\\"+arrayKeywords.get(i).toString()+"- VN (PC).png");

           driver.manage().window().setSize(new Dimension(390,1200));
           Thread.sleep(2000);
           takeScreenshot.takeSnapShot(this.driver, "D:\\Screenshot\\"+arrayKeywords.get(i).toString()+"- VN (MO).png");
           driver.manage().window().maximize();
       }
    }

   @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
