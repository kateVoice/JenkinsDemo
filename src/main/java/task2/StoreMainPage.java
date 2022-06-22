package task2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class StoreMainPage {
    By thisPageElement = By.xpath("//div[@id='store_nav_area']");
    By aboutPageLink = By.xpath("//div[@class='supernav_container']//a[@href='https://store.steampowered.com/about/?snr=1_4_4__global-header']");
    By newAndInterestingMenu = By.id("noteworthy_tab");
    By topSellersInPopMenu = By.xpath("//div[@id='noteworthy_flyout']//*[@class='popup_menu_item'][1]");
    By communityBtn  = By.xpath("//div[@class = 'supernav_container']/a[@href = 'https://steamcommunity.com/']");
    By marketCommunityInPopMenu =By.xpath("//div[@class='supernav_container']//a[@href='https://steamcommunity.com/market/']");

    public boolean isLoaded () {
        WebElement element = WebDriverSingleton.getInstance().getDriver().findElement(thisPageElement);
        return element.isDisplayed();
    }
    public void goAboutPage() {
        WebElement element = WebDriverSingleton.getInstance().getDriver().findElement(aboutPageLink);
        element.click();
    }
    public void goTopSellersFromPopMenu() {
        Actions action = new Actions(WebDriverSingleton.getInstance().getDriver());
        WebElement element = WebDriverSingleton.getInstance().getDriver().findElement(newAndInterestingMenu);
        WebElement element1 = new WebDriverWait(WebDriverSingleton.getInstance().getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(topSellersInPopMenu));
        action.moveToElement(element).build().perform();
        element1.click();
    }
    public void goCommunityMarketPopMenu() {
        Actions action = new Actions(WebDriverSingleton.getInstance().getDriver());
        WebElement element = WebDriverSingleton.getInstance().getDriver().findElement(communityBtn);
        WebElement element1 = WebDriverSingleton.getInstance().getDriver().findElement(marketCommunityInPopMenu);
        action.moveToElement(element).moveToElement(element1).click().build().perform();
    }
}
