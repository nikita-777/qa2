import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FourthHomework {
    private final By ARTICLE = By.tagName("article");
    private final By TITLE = By.xpath(".//h1[contains(@class, 'd-inline')]");
    private final By COMMENTS_COUNT = By.xpath(".//a[contains(@class,'d=print-none')]");

    private final By ARTICLE_PAGE_TITLE = By.xpath(".//h1[contains(@class, 'headline__title')]");
    private final By ARTICLE_PAGE_COMMENTS = By.xpath(".//a[contains(@class, 'comment-count')]");

    private final By COMMENTS_PAGE_COUNT = By.xpath(".//span[contains(@class, 'type-cnt')]");

    private final Logger LOGGER = LogManager.getLogger(this.getClass());


    @Test
    public void thirdArticle() {
        LOGGER.info("This test is checking titles and comment count");
        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");

        LOGGER.info("Opening browser");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        LOGGER.info("Opening home page");
        driver.get("https://rus.delfi.lv");

        LOGGER.info("Getting all articles");
        List<WebElement> articles = driver.findElements(ARTICLE);

        LOGGER.info("Get 3rd one");
        WebElement article = articles.get(2);

        LOGGER.info("Getting title");
        String homePageTitle = article.findElement(TITLE).getText();

        int homePageCommentsCount = 0;
        if (!article.findElements(COMMENTS_COUNT).isEmpty()) {
            homePageCommentsCount = parseCommentCount(article.findElement(COMMENTS_COUNT).getText());
        }
        System.out.println(homePageTitle + " " + homePageCommentsCount);

        article.findElement(TITLE).click();
        String articlePageTitle = driver.findElement(ARTICLE_PAGE_TITLE).getText();
        int articlePageCommentCount = Integer.parseInt(driver.findElement(ARTICLE_PAGE_COMMENTS).getText());

        Assertions.assertTrue(homePageTitle.startsWith(articlePageTitle), "Wrong title!");
        Assertions.assertEquals(homePageCommentsCount, articlePageCommentCount, "Wrong comment count");

        driver.findElement(ARTICLE_PAGE_COMMENTS).click();
        String commentsPageTitle = driver.findElement(ARTICLE_PAGE_COMMENTS).getText();
        int commentsPageCommentsCount = Integer.parseInt(driver.findElement(COMMENTS_PAGE_COUNT).getText());

        Assertions.assertTrue(homePageTitle.startsWith(commentsPageTitle));
        Assertions.assertEquals(homePageCommentsCount, commentsPageCommentsCount, "Wrong comment count");
    }


    private int parseCommentCount(String textToParse) {
        textToParse = textToParse.substring(1, textToParse.length() - 1);
        return Integer.parseInt(textToParse);
    }
}
