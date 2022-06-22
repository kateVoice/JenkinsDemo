package task2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FirstGamePage {
    By firstGameName = By.xpath("//span[@itemprop='name']");
    By firstGameRelease = By.xpath("//*[@class='release_date']/div[@class='date']");
    By firstGamePrice = By.xpath("(//div[@class='discount_prices'])[1]");

    public Game getGame(){
        WebElement element = WebDriverSingleton.getInstance().getDriver().findElement(firstGameName);
        String name = element.getText();
        element = WebDriverSingleton.getInstance().getDriver().findElement(firstGameRelease);
        String release = element.getText();
        element = WebDriverSingleton.getInstance().getDriver().findElement(firstGamePrice);
        String price = element.getText();
        Game game = new Game(name, release, price);
        return  game;
    }
    public boolean isLoaded () {
        WebDriverWait wait = new WebDriverWait(WebDriverSingleton.getInstance().getDriver(), Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(firstGameName));
        return element.isDisplayed();
    }
}
