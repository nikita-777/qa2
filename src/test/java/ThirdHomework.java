import org.apache.logging.log4j.core.util.SystemClock;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ThirdHomework {
    private final By ARTICLE = By.tagName("article");
    private final By TITLE = By.xpath(".//h1[contains(class, 'headline__title')]");

    @Test
    public void thirdArticle() {
        //Some changes here
        final String TITLE_TO_FIND = "Выборы в Риге: KNAB начал 10 проверок о возможном нарушении правил агитации"

        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rus.delfi.lv");

        //get all articles
        List<WebElement> articles = driver.findElements(ARTICLE);

        //find given article by text
        for (WebElement article : articles){

        }
        //click on it

        //find article title

        //check it

        String text = driver.findElement(By.xpath(".//h1[contains(@class, 'headline__title')]")).getText();


    }

}