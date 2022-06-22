package task2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class TopSellersPage {
    By checkPointTopSellersPage = By.xpath("//h2[@class='pageheader full']");
    By checkboxSteamOcLinux = By.xpath("//div[@data-loc='SteamOS + Linux']//span[@class='tab_filter_control_checkbox']");
    By gamersAmountMenu = By.xpath("//div[@data-collapse-name='category3']/div");
    By checkboxCopLaN = By.xpath("//div[@data-value='48']");
    By marksInput = By.id("TagSuggest");
    By checkboxMarkAction = By.xpath("//div[@data-value='19']");
    By selectedGamesCount = By.xpath("//div[@class='search_results_count']");
    By firstGame = By.xpath("//div[@data-panel='[]']/a[1]");
    By allGames = By.xpath("//div[@data-panel='[]']/a");
    By firstGameName = By.xpath("(//div[@data-panel = '[]']/a)[1]//span[@class = 'title']");
    By firstGameRelease = By.xpath("(//div[@data-panel = '[]']/a)[1]//div[@class = 'col search_released responsive_secondrow']");
    By firstGamePrice = By.xpath("//div[@data-panel='[]']/a[1]//div[(contains (@class, 'col search_price discounted responsive_secondrow')) or contains(@class, 'col search_price  responsive_secondrow')]");

    public WebElement getFirstGameName() {
        WebElement element = WebDriverSingleton.getInstance().getDriver().findElement(firstGameName);
        return element;
    }
    public boolean isLoaded () {
        WebElement element = WebDriverSingleton.getInstance().getDriver().findElement(checkPointTopSellersPage);
        return element.isDisplayed();
    }
    public void steamOcLinuxMark() {
        WebElement element = WebDriverSingleton.getInstance().getDriver().findElement(checkboxSteamOcLinux);
        element.click();
    }
    public boolean isSteamOcLinuxMarked () {
        WebElement element = WebDriverSingleton.getInstance().getDriver().findElement(checkboxSteamOcLinux);
        return element.isEnabled();
    }
    public void showGamersAmountMenu() {
        WebElement element = WebDriverSingleton.getInstance().getDriver().findElement(gamersAmountMenu);
        element.click();
    }
    public void coopLaNMark() {
        WebElement element = WebDriverSingleton.getInstance().getDriver().findElement(checkboxCopLaN);
        element.click();
    }
    public boolean isCoopLaNMarked() {
        WebElement element = WebDriverSingleton.getInstance().getDriver().findElement(checkboxSteamOcLinux);
        return element.isEnabled();
    }
    public void actionMark() {
        WebElement element = WebDriverSingleton.getInstance().getDriver().findElement(checkboxMarkAction);
        element.click();
    }
    public boolean isActionMarked () {
        WebElement element = WebDriverSingleton.getInstance().getDriver().findElement(checkboxMarkAction);
        return element.isEnabled();
    }
    public int gamesRealCount(){
        List<WebElement> links = WebDriverSingleton.getInstance().getDriver().findElements(allGames);
        Set<String> setUniqLinks  = new LinkedHashSet<>();
        for (WebElement element:
             links) { setUniqLinks.add(element.getAttribute("href"));
        }
        return setUniqLinks.size();
    }
    public int gamesCount() {
        WebElement element = WebDriverSingleton.getInstance().getDriver().findElement(selectedGamesCount);
        String str = element.getText();
        String gamesCount = "";
        for (int i = 0; i < str.length(); i++){
            char chars = str.charAt(i);
            if (Character.isDigit(chars)) {
                gamesCount = gamesCount + chars;
            }
        }
        return Integer.parseInt(gamesCount);
    }
    public void clickFirstGame(){
        WebDriverSingleton.getInstance().getDriver().findElement(firstGame).click();
    }
    public Game  getFirstGame(){
        WebElement element = WebDriverSingleton.getInstance().getDriver().findElement(firstGame);
        String name = WebDriverSingleton.getInstance().getDriver().findElement(firstGameName).getText();
        String release = WebDriverSingleton.getInstance().getDriver().findElement(firstGameRelease).getText();
        String price = WebDriverSingleton.getInstance().getDriver().findElement(firstGamePrice).getText();
        System.out.println(name +" / " + release + " / " + price);
        Game firstGame = new Game(name, release, price);
        return  firstGame;
    }
}