package actions;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

import static helpers.Utils.click;
import static helpers.Utils.sendKeys;

public class LandingPageActions extends BaseActions {
    public void FillOnText(String value) throws IOException {
        WebElement input_identifier = baseActionsDriver.findElement(By.xpath("(//*[@data-block = 'true'])[last()]"));
        Lorem lorem = LoremIpsum.getInstance();
        String text = lorem.getParagraphs(1, 1);

        sendKeys(input_identifier, value + text);
    }

    public void ClickOnText(String data_test) throws IOException {
        WebElement input_identifier = baseActionsDriver.findElement(By.xpath("(//*[contains(text(), \""+data_test+"\")])[1]"));
        click(input_identifier);
    }

    public void ClickOnPostButton() throws IOException {
        WebElement input_identifier = baseActionsDriver.findElement(By.xpath("(//*[contains(text(), 'Post')])[7]"));
        click(input_identifier);
    }

    public void ClickOnSymbol(String data_test) throws IOException {
        WebElement input_identifier = baseActionsDriver.findElement(By.xpath("//*[@aria-label = '"+data_test+"']"));
        click(input_identifier);
    }

    public String GetCurrentUrl(){
        return baseActionsDriver.getCurrentUrl();
    }

    public void GetNewStatus(String data_test) throws IOException {
        WebElement input_identifier = baseActionsDriver.findElement(By.xpath("//*[@data-pagelet=\"FeedUnit_0\"]//*[contains(text(), '"+data_test+"')]"));
        click(input_identifier);
    }
}