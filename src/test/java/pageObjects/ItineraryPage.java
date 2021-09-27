package pageObjects;

import cucumberAutomation.Base;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ItineraryPage extends Base {

    private final By itineraryDetailsWrapper=By.xpath("//div[@class='itinerary-day-tile']");
    private final By learnMoreButton=By.xpath("//span[contains(text(),'Learn More')]");
    private final By descriptionContent=By.xpath("//span[@class='description-content']");
    private final By closeOverlayWhite=By.xpath("//button[@class='overlay-close-wrapper close-overlay-white']");
    private final By bookNowButton=By.cssSelector("span.bottom-text.ng-binding");

    public WebElement getBookNowButton() {
        return getElement(bookNowButton);
    }

    public WebElement getCloseOverlayWhite() {
        return getElement(closeOverlayWhite);
    }

    public WebElement getDescriptionContent() {
        return getElement(descriptionContent);
    }

    public List<WebElement> getLearnMoreButtons() {
        return getElements(learnMoreButton);
    }

    public List<WebElement> getItineraryDetailsWrapper() {
        return getElements(itineraryDetailsWrapper);
    }

    public ItineraryPage() {super();
    }

    public void verifyAdditionalInfoEveryDay() throws InterruptedException {
        List<WebElement> tiles=getLearnMoreButtons();
        System.out.println(tiles.size());
        Thread.sleep(3000);
        for(int i=1;i<tiles.size();i++)
        {
            tiles.get(i).click();
            Thread.sleep(3000);
            System.out.println(getDescriptionContent().getText());
            Assert.assertFalse(getDescriptionContent().getText().isEmpty());
            getCloseOverlayWhite().click();
            /*JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,600)");*/
            Thread.sleep(3000);
        }
    }

    public void verifyBookNowIsPlacedIntoThePage()
    {
        Assert.assertEquals(getBookNowButton().getText(),"BOOK NOW");
    }
}
