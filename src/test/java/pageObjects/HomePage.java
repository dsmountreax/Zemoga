package pageObjects;

import cucumberAutomation.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class HomePage extends Base {

    private final By noThankYou= By.cssSelector("div.vifp-no-thankyou");
    private final By closeIconBanner=By.cssSelector("svg.cp-banner__icon-close--com");
    private final By sailTo=By.xpath("//span[@class='cdc-filters-tab-link-chevron']");
    private final By theBahamas=By.xpath("(//button[@data-tealium='cdc-filter-button'])[2]");
    private final By duration=By.xpath("//span[text()='Duration']");
    private final By sixNineDays=By.xpath("//button[text()[normalize-space()='6 - 9 Days']]");
    private final By searchCruises=By.xpath("//span[@class='cdc-filters-search-cta-title ng-binding']");

    public WebElement getSearchCruises() {
        return getElement(searchCruises);
    }

    public WebElement getSixNineDays() {
        return getElement(sixNineDays);
    }

    public WebElement getDuration() {
        return getElement(duration);
    }

    public HomePage() {super();

    }

    public WebElement getTheBahamas() {
        return getElement(theBahamas);
    }

    public WebElement getSailTo() {
        return getElement(sailTo);
    }

    public WebElement getCloseIconBanner() {
        return getElement(closeIconBanner);
    }

    public WebElement getNoThankYou() {
        return getElement(noThankYou);
    }

    public void doClickNoThankYou()
    {
        getNoThankYou().click();
    }

    public void doClickCloseIconBanner()
    {
        getCloseIconBanner().click();
    }

    public void doClickSailTo() {
        getSailTo().click();
    }

    public void doClickOnTheBahamas() throws InterruptedException {
        getTheBahamas().click();
    }

    public void doClickOnDuration() throws InterruptedException {
        Thread.sleep(3000); // it should be replaced with a wait
        getDuration().click();
    }

    public void doClickSixNineDays()
    {
        getSixNineDays().click();
    }

    public void doClickOnSearchCruises()
    {
        getSearchCruises().click();
    }

}
