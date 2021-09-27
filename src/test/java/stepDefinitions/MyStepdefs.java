package stepDefinitions;

import cucumberAutomation.Base;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.CruiseSearchPage;
import pageObjects.HomePage;
import pageObjects.ItineraryPage;

import java.io.IOException;

public class MyStepdefs {
    public WebDriver driver;
    private HomePage home = new HomePage();
    private CruiseSearchPage search = new CruiseSearchPage();
    private ItineraryPage itinerary=new ItineraryPage();


    @Given("User lands on carnival page")
    public void userLandsOnCarnivalPage() throws IOException {
        this.driver = Base.getDriver();
        driver.manage().window().maximize();
        System.out.println("Opening " + home.getPageTitle() + " page.");
        Assert.assertEquals(home.getPageTitle(),
                "Cruises | Carnival Cruise Deals: Caribbean, Bahamas, Alaska, Mexico",
                "User is not opening correct page");
    }

    @When("User closes offer modal")
    public void userClosesOfferModal() {
        home.doClickNoThankYou();
    }

    @And("User closes cookie banner")
    public void userClosesCookieBanner() {
        home.doClickCloseIconBanner();
    }

    @And("User clicks on Sail To filter")
    public void userClicksOnSailToFilter() throws InterruptedException {
        home.doClickSailTo();
    }

    @And("User clicks on The Bahamas button")
    public void userClicksOnTheBahamasButton() throws InterruptedException {
        home.doClickOnTheBahamas();
    }

    @And("User clicks on Duration to filter")
    public void userClicksOnDurationToFilter() throws InterruptedException {
        home.doClickOnDuration();
    }

    @And("User clicks on six to nine Days button")
    public void userClicksOnSixToNineDaysButton() throws InterruptedException {
        home.doClickSixNineDays();
    }

    @And("User clicks on search cruises")
    public void userClicksOnSearchCruises() {
        home.doClickOnSearchCruises();
    }

    @Then("User lands on cruise search page")
    public void userLandsOnCruiseSearchPage() throws InterruptedException {
        //Thread.sleep(3000);
        System.out.println("Opening " + search.getPageTitle() + " page.");
        Assert.assertEquals(search.getPageTitle(),
                "Cruise Search | Find Cruises for 2021-2024 | Carnival Cruise Line",
                "User is not opening correct page");
    }

    @When("User clicks on pricing filter")
    public void userClicksOnPricingFilter() {
        search.doClickOnPricingFilter();
    }

    @And("User slides minimum pointer")
    public void userSlidesMinimumPointer() throws InterruptedException {
        search.dragAndDropMinimumPointer();
    }

    @And("User slides maximum pointer")
    public void userSlidesMaximumPointer() throws InterruptedException {
        search.dragAndDropMaximumPointer();
    }

    @Then("The results are different")
    public void theResultsAreDifferent() {
        search.compareInitialAndFinalResults();
    }

    @Then("User verifies that the prices are from cheapest to expensive")
    public void userVerifiesThatThePricesAreFromCheapestToExpensive() {
        search.verifyPricesOrder();
    }


    @After
    public void afterSeleniumTest() {
        driver.close();
    }

    @When("User clicks on a trip")
    public void userClicksOnATrip() {
        search.doCLickOnItemPhoto();
    }

    @Then("User lands on itinerary page")
    public void userLandsOnItineraryPage() {
        System.out.println("Opening " + search.getPageTitle() + " page.");
        Assert.assertEquals(search.getPageTitle(),
                "7 Day Bahamas Cruise From Baltimore | Carnival Cruise Line",
                "User is not opening correct page");
    }

    @Then("User verify additional info about every day")
    public void userVerifyAdditionalInfoAboutEveryDay() throws InterruptedException {
        itinerary.verifyAdditionalInfoEveryDay();
    }

    @Then("User verify book now is placed into the page")
    public void userVerifyBookNowIsPlacedIntoThePage() {
        itinerary.verifyBookNowIsPlacedIntoThePage();
    }
}
