package task2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class SearchCommunityForm {
    By thisPageElement = By.id("market_advancedsearch_filters");
    By allGames = By.id("app_option_0_selected");
    By dota2Game = By.id("app_option_570");
    By selectHeroBtn = By.xpath("//select[contains(@name, 'Hero')]");
    By heroLifeStealer = By.xpath("//option[contains(@value, 'hero_life_stealer')]");
    By rarityImmortalCheckBox = By.id("tag_570_Rarity_Rarity_Immortal");
    By searchInput = By.id("advancedSearchBox");
    By searchButton = By.xpath("//div[@class='market_advancedsearch_bottombuttons']//span");
    By dota2Filter = By.xpath("//div[@class='market_search_results_header']//a[1]");
    By lifeStealerFilter = By.xpath("//div[@class='market_search_results_header']//a[2]");
    By rarityImmortalFilter = By.xpath("//div[@class='market_search_results_header']//a[3]");
    By goldenFilter = By.xpath("//div[@class='market_search_results_header']//a[4]");
    By listOfFilters = By.xpath("//div[@class='market_search_results_header']//a[@class='market_searchedForTerm']"); //list of filters after deletion
    By firstItem = By.id("result_0_name");
    By secondItem = By.id("result_1_name");
    By thirdItem = By.id("result_2_name");
    By fourthItem = By.id("result_3_name");
    By fifthItem =  By.id("result_4_name");
    By filtersList = By.xpath("//div[@class='market_search_results_header']//a");

    public boolean isLoaded(By by) {
        return (WebDriverSingleton.getInstance().getDriver().findElement(by).isDisplayed());
    }
    public void searchInputValue (String value) {
        WebDriverSingleton.getInstance().getDriver().findElement(searchInput).sendKeys(value);
    }
    public void searchBtnClick() {
        WebDriverSingleton.getInstance().getDriver().findElement(searchButton).click();
    }
    public List<String> firstFiveItems () {
        List<String> list = new ArrayList<>();
        list.add(WebDriverSingleton.getInstance().getDriver().findElement(firstItem).getText());
        list.add(WebDriverSingleton.getInstance().getDriver().findElement(secondItem).getText());
        list.add(WebDriverSingleton.getInstance().getDriver().findElement(thirdItem).getText());
        list.add(WebDriverSingleton.getInstance().getDriver().findElement(fourthItem).getText());
        list.add(WebDriverSingleton.getInstance().getDriver().findElement(fifthItem).getText());
        return list;
    }
    public void filtersClear(String value) {
        WebElement elem = null;
        List<WebElement> list = WebDriverSingleton.getInstance().getDriver().findElements(filtersList);
        for (WebElement element : list) {
            if (element.getText().contains(value)) {
                elem = element;
            }
        }
        elem.click();
    }
    public void clickElement(By selector) {
        WebDriverSingleton.getInstance().getDriver().findElement(selector).click();
    }
    public List<String> getListOfFilters () {
        List<WebElement> list = WebDriverSingleton.getInstance().getDriver().findElements(listOfFilters);
        List<String> listFilters = new ArrayList<>();
        for (WebElement element : list) {
            listFilters.add(element.getText());
        }
        return listFilters;
    }
    public String getFirstItemName(){
        return WebDriverSingleton.getInstance().getDriver().findElement(firstItem).getText();
    }
}
