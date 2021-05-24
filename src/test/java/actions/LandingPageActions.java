package actions;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import helpers.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

import static helpers.Utils.click;
import static helpers.Utils.sendKeys;

public class LandingPageActions extends BaseActions {

    public String FillOnText(String value) throws IOException {
        WebElement input_identifier = baseActionsDriver.findElement(By.xpath("(//*[@data-block = 'true'])[last()]"));
        Lorem lorem = LoremIpsum.getInstance();
        String text = value + " " + lorem.getWords(10);
        sendKeys(input_identifier, text);

        return text;
    }

    public void ClickOnText(String data_test) throws IOException {
        WebElement input_identifier = baseActionsDriver.findElement(By.xpath("(//*[contains(text(), \"" + data_test + "\")])[1]"));
        click(input_identifier);
    }

    public void ClickOnPostButton() throws IOException {
        WebElement input_identifier = baseActionsDriver.findElement(By.xpath("(//*[@aria-label='Add to Your Post']/../../..//*[contains(text(), 'Post')])[2]"));
        click(input_identifier);
    }

    public void ClickOnSymbol(String data_test) throws IOException {
        WebElement input_identifier = baseActionsDriver.findElement(By.xpath("//*[@aria-label = '" + data_test + "']"));
        click(input_identifier);
    }

    public String GetCurrentUrl() {
        return baseActionsDriver.getCurrentUrl();
    }

    public String GetNewStatus(String data_test) {
        Utils.waitForPageToLoad();
        WebElement input_identifier = baseActionsDriver.findElement(By.xpath("//*[@data-pagelet=\"FeedUnit_0\"]//*[contains(text(), '" + data_test + "')]"));
        return input_identifier.getText();
    }

    public void waitForPageToload() throws IOException {
        Utils.waitForPageToLoad();
        Utils.elementExists("//*[@aria-atomic='true']//*[contains(text(), 'Posting')]");
    }

    public boolean postingStatusIsExecuting() throws IOException {
        return Utils.elementExists("//*[@aria-atomic='true']//*[contains(text(), 'Posting')]");
    }

    public void reloadPage() throws IOException {
        Utils.reloadPage();
    }

    public void clickOnProfileLink() throws IOException {
        //Click on arrow
        click(baseActionsDriver.findElement(By.xpath("(//*[@aria-label = 'Account'])[1]")));
        //Click on profile link
        click(baseActionsDriver.findElement(By.xpath("//*[text() = 'See your profile']")));
    }
}