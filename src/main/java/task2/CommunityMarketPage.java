package task2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CommunityMarketPage {
    By thisPageElement = By.className("market_title_text");
    By showAdvancedOptions = By.className("market_search_advanced_button");
    By searchCommunityForm = By.id("market_advancedsearch_dialog");

    public boolean isLoaded(){
        WebElement element = WebDriverSingleton.getInstance().getDriver().findElement(thisPageElement);
        return element.isDisplayed();
    }
    public void showAdvancedOptionsBtn() {
        WebElement element = WebDriverSingleton.getInstance().getDriver().findElement(showAdvancedOptions);
        element.click();
    }
    public boolean searchCommunityFormLoaded() {
        WebElement element = WebDriverSingleton.getInstance().getDriver().findElement(searchCommunityForm);
        return element.isDisplayed();
    }
}
