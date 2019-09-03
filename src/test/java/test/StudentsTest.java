package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StudentsTest {
    private WebDriver driver;
    String url = "http://37.59.228.229:3000/";
    @Before
    public void beforeMethod() {
        driver = new ChromeDriver();
    }
    @Test
    public void testMethod() throws InterruptedException {
        driver.get(url);
        driver.findElement(By.cssSelector("i.mdi-content-add")).click();
        driver.findElement(By.cssSelector("div.main-content input#icon_prefix")).clear();
        driver.findElement(By.cssSelector("div.main-content input#icon_prefix")).sendKeys("Harry Potter");
        driver.findElement(By.cssSelector("div.main-content input#icon_telephone")).clear();
        driver.findElement(By.cssSelector("div.main-content input#icon_telephone")).sendKeys("987654321");
        driver.findElement(By.cssSelector("div.main-content a.save-btn")).click();
        WebElement c = driver.findElement(By.cssSelector("#user-list"));
        Thread.sleep(5000);  // без 5 секунд мой созданный юзер не успевает упасть в список и проверка не проходит
        Assert.assertTrue(c.getText().contains("Harry Potter"));





    }
    @After
    public void afterMethod() {
        driver.quit();
    }

}
