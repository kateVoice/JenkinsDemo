package task2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AboutPage {
    By thisPageElement = By.id("about_greeting");
    By toStoreMainPage = By.xpath("//div[@class='supernav_container']/a[1]");
    By onlinePersonsCount = By.xpath("(//div[@class='online_stat'])[1]");
    By inGamePersonsCount = By.xpath("(//div[@class='online_stat'])[2]");

    public void entryStoreMainPage() {
        WebDriverSingleton.getInstance().getDriver().findElement(toStoreMainPage).click();
    }
    public int onlineNum() {
        WebElement element = WebDriverSingleton.getInstance().getDriver().findElement(onlinePersonsCount);
        String[] onlineArray = element.getText().split("\\s");
        String digits = "";
        for (int i = 0; i < onlineArray[2].length(); i++){
            char chars = onlineArray[2].charAt(i);
            if (Character.isDigit(chars)) {
                digits = digits + chars;
            }
        }
        return Integer.parseInt(digits);
    }
    public int  inGameNum (){
        WebElement element = WebDriverSingleton.getInstance().getDriver().findElement(inGamePersonsCount);
        String[] inGameArray = element.getText().split("\\s");
        String digits = "";
        for (int i = 0; i < inGameArray[2].length(); i++){
            char chars = inGameArray[2].charAt(i);
            if (Character.isDigit(chars)) {
                digits = digits + chars;
            }
        }
        return Integer.parseInt(digits);
    }
    public boolean isLoaded () {
        WebElement element = WebDriverSingleton.getInstance().getDriver().findElement(thisPageElement);
        return element.isDisplayed();
    }
}
