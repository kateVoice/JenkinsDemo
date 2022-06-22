package task2;

import org.openqa.selenium.By;

public class Game {
    By gameName = By.xpath("//span[@itemprop='name']");
    By firstGameRelease = By.xpath("//*[@class='release_date']/div[@class='date']");
    By firstGamePrices = By.xpath("//div[contains(@class,'game_purchase_price')]");

    public Game() {
    }
    public Game(String name, String release, String price) {
    }
}
