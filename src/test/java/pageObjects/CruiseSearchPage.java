package pageObjects;

import cucumberAutomation.Base;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class CruiseSearchPage extends Base {

    private final By pricingFilter=By.xpath("(//span[@class='sfn-title__text ng-binding'])[2]");
    private final By minimumPointer=By.xpath("//span[@ng-style='minPointerStyle']");
    private final By results=By.xpath("//span[@class='sbsc-container__result-count ng-binding']");
    private String initialResults;
    private String finalResults;
    private final By prices=By.xpath("//span[@class='vrl-item__price-value ng-binding']");

    public List<WebElement> getPrices() {
        return getElements(prices);
    }

    public String getInitialResults() {
        return initialResults;
    }

    public String getFinalResults() {
        return finalResults;
    }

    public void setPreviousResults(String previousResults) {
        this.previousResults = previousResults;
    }

    private String previousResults;
    private final By maximumPointer=By.xpath("//span[@ng-style='maxPointerStyle']");

    public WebElement getMaximumPointer() {
        return getElement(maximumPointer);
    }

    public void setFinalResults(String finalResults) {
        this.finalResults = finalResults;
    }

    public void setInitialResults(String initialResults) {
        this.initialResults = initialResults;
    }

    public WebElement getResults() {
        return getElement(results);
    }

    public WebElement getMinimumPointer() {
        return getElement(minimumPointer);
    }

    public WebElement getPricingFilter() {
        return getElement(pricingFilter);
    }

    public void doClickOnPricingFilter()
    {
        getPricingFilter().click();
    }

    public void dragAndDropMinimumPointer() throws InterruptedException {
        Thread.sleep(3000); // it should be changed with a wait
        setInitialResults(getResults().getText());
        Actions action=new Actions(driver);
        action.dragAndDropBy(getMinimumPointer(),80,0).perform();
        Thread.sleep(3000); // it should be changed with a wait
        Assert.assertFalse(initialResults.contains(getResults().getText()));
    }

    public void dragAndDropMaximumPointer() throws InterruptedException {
        Thread.sleep(3000); // it should be changed with a wait
        setPreviousResults(getResults().getText());
        Actions action=new Actions(driver);
        action.dragAndDropBy(getMaximumPointer(),-500,0).perform();
        Thread.sleep(3000); // it should be changed with a wait
        Assert.assertFalse(previousResults.contains(getResults().getText()));
        setFinalResults(getResults().getText());
    }

    public void compareInitialAndFinalResults()
    {
        Assert.assertFalse(getFinalResults().contains(getInitialResults()));
    }

    public void verifyPricesOrder()
    {
        boolean flagOrder=true;
        List<WebElement> elements=getPrices();
        List<Integer> values=new ArrayList<>();
        for (WebElement element:elements) {
            if(!element.getText().contains(""))
            {values.add(Integer.parseInt(element.getText()));}
        }
        for(int i=0;i<values.size();i++)
        {
            if(values.get(i)>values.get(i+1))
            {
                flagOrder=false;
                break;
            }
        }
        Assert.assertTrue(flagOrder);
    }

}
