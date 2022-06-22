package task2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebDriverSingleton {
    private static WebDriver driver;
    private static WebDriverSingleton instance = null;
    private WebDriverSingleton() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("incognito");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    public static WebDriverSingleton getInstance(){
        if (instance == null) {
            instance = new WebDriverSingleton();
        }
        return instance;
    }
    public WebDriver getDriver() {
        return driver;
    }
    public static void goTo(String link){
        WebDriver driver = WebDriverSingleton.getInstance().getDriver();
        driver.get(link);
    }
    public void close() {
        driver.quit();
    }
}






