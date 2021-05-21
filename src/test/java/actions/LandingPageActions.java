package actions;

import actions.BaseActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

import static helpers.Utils.click;
import static helpers.Utils.sendKeys;

public class LandingPageActions extends BaseActions {
    public void FillOnText(String value) throws IOException {
        WebElement input_identifier = baseActionsDriver.findElement(By.xpath("(//*[@data-block = 'true'])[last()]"));
        sendKeys(input_identifier, value);
    }

    public void ClickOnText(String data_test) throws IOException, InterruptedException {
        WebElement input_identifier = baseActionsDriver.findElement(By.xpath("(//*[contains(text(), \""+data_test+"\")])[1]"));
        click(input_identifier);
    }

    public void ClickOnSymbol(String data_test) throws IOException {
        WebElement input_identifier = baseActionsDriver.findElement(By.xpath("//*[@aria-label = '"+data_test+"']"));
        click(input_identifier);
    }

    public String GetCurrentUrl(){
        return baseActionsDriver.getCurrentUrl();
    }
}