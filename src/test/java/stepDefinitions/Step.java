package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Step {
    public static WebDriver driver;
    private static final String UserDir = System.getProperty("user.dir");
    private static WebDriverWait wait = null;

    public void initDriver(){
        System.setProperty("webdriver.chrome.driver", UserDir+"/src/test/resources/webdriver/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @Given("I am on the browser")
    public void iOnBrowser(){
        initDriver();
        Hook.scenario.log("Browser launched");
    }

    @When("I open Youtube Music URL")
    public void iOpenYoutubeUrl(){
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            driver.get("https://music.youtube.com/");
            Hook.scenario.log("Youtube Music Home page successfully open");
    }

    @Then("I should be in Youtube Music home page")
    public void youtubeMusicHomePage(){
        boolean page = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@aria-selected='true']/*[text()='Home']"))).isDisplayed();
        if (page != true){
            throw new Error("Home page did not load correctly.");
        }
        Hook.scenario.log("Correctly redirected to Youtube Music home page");
    }

    @And("I click the Explore button")
    public void clickExploreButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@tab-id='FEmusic_explore']"))).click();
        Hook.scenario.log("Explore button clicked");
    }

    @Then("I should be in Youtube Music explore page")
    public void youtubeMusicExplorePage(){
        boolean page = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@tab-id='FEmusic_explore' and @aria-selected='true']"))).isDisplayed();
        if (page != true){
            throw new Error("Home page did not load correctly.");
        }
        Hook.scenario.log("Youtube Music explore page successfully open");
    }

    @And("I click the search button")
    public void clickSearchButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='placeholder']"))).click();
        Hook.scenario.log("Search button clicked");
    }

    @And("^I add \"([^\"]*)\" on the search textbox$")
    public void addSearchItem(String texString) throws InterruptedException{
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='input']"))).sendKeys(texString);
        Hook.scenario.log(texString+" successfully inputed.");
    }

    @And("I click Enter on my keyboard")
    public void clickEnterKeyboard(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input"))).sendKeys(Keys.ENTER);
        Hook.scenario.log("Submit the form. . .");
    }

    @Then("^I should get the correct result from searching \"([^\"]*)\"$")
    public void getSearchResult(String texString){
        String str1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("((//*[@height-style_='MUSIC_RESPONSIVE_LIST_ITEM_HEIGHT_TALL'])[1]/div[2]/descendant::yt-formatted-string)[1]"))).getText();
        String str2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("((//*[@height-style_='MUSIC_RESPONSIVE_LIST_ITEM_HEIGHT_TALL'])[1]/div[2]/descendant::yt-formatted-string)[2]"))).getAttribute("title");

        if (!str1.contains(texString) || !str2.contains(texString)){
            Hook.scenario.log("Get the correct results.");   
        } else {
            throw new Error("Not expected results.");
        }
    }

}
