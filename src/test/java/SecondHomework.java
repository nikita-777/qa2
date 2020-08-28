import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SecondHomework {
    @Test
    public void firstArticle() {
        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rus.delfi.lv");

        String text = driver.findElement(By.xpath(".//h1[contains(@class, 'headline__title')]")).getText();
        System.out.println(text);
    }

    @Test
    public void firstArticleCommentCount() {
        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rus.delfi.lv");

        String title = driver.findElement(By.xpath(".//a [contains(@class, 'comment-count')]")).getText();
        System.out.println(title);
    }
}



