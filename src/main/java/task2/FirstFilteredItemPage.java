package task2;

import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class FirstFilteredItemPage {
    By thisPageTitle = By.id("largeiteminfo_item_name");//название соответствует предыдущей страницу
    By gameFilterValue = By.id("largeiteminfo_game_name");
    By immortalFilter = By.id("largeiteminfo_item_type");
    By lifestealerFilter = By.xpath("//*[@class='descriptor'][1]"); //текст Used by : Lifestealer

    public String getName() {
        return WebDriverSingleton.getInstance().getDriver().findElement(thisPageTitle).getText();
    }
    public List<String> getFilters() {
        List<String> list = new ArrayList<>();
        list.add(WebDriverSingleton.getInstance().getDriver().findElement(gameFilterValue).getText());
        list.add(WebDriverSingleton.getInstance().getDriver().findElement(lifestealerFilter).getText());
        list.add(WebDriverSingleton.getInstance().getDriver().findElement(immortalFilter).getText());
        return list;
    }

}
