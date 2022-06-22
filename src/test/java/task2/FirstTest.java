package task2;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class FirstTest {
    AboutPage aboutPage = new AboutPage();
    StoreMainPage storeMainPage = new StoreMainPage();
    TopSellersPage topSellersPage = new TopSellersPage();
    FirstGamePage firstGamePage = new FirstGamePage();
    CommunityMarketPage  communityMarketPage = new CommunityMarketPage();
    SearchCommunityForm searchForm = new SearchCommunityForm();
    FirstFilteredItemPage firstFilteredItemPage = new FirstFilteredItemPage();
    Game game = new Game();

    @BeforeClass
    public void SetUp(){
        WebDriverSingleton.goTo(ConfProperties.getProperty("url"));
    }

    @Test
    public void Test1() {
       Assert.assertTrue(storeMainPage.isLoaded(), "Page Store/Main not Loaded");
       storeMainPage.goAboutPage();
       Assert.assertTrue(aboutPage.isLoaded(), "Page About not Loaded");
       Assert.assertTrue(aboutPage.onlineNum()>aboutPage.inGameNum(),  "Online < InGame persons");
       aboutPage.entryStoreMainPage();
       Assert.assertTrue(storeMainPage.isLoaded(), "Page Store/Main not Loaded");
    }

    @AfterTest
    public void close() {
        WebDriverSingleton.getInstance().getDriver().close();
    }

}
