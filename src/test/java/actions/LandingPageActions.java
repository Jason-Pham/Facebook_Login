package actions;

import actions.BaseActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

import static helpers.Utils.click;
import static helpers.Utils.sendKeys;

public class LandingPageActions extends BaseActions {
    public void Fill(String data_test, String value) throws IOException {
        WebElement input_identifier = baseActionsDriver.findElement(By.xpath("//input[@data-testid='"+data_test+"']"));
        sendKeys(input_identifier, value);
    }

    public void Click(String data_test) throws IOException {
        WebElement input_identifier = baseActionsDriver.findElement(By.xpath("//*[@data-testid='"+data_test+"']"));
        click(input_identifier);
    }

    public String GetCurrentUrl(){
        return baseActionsDriver.getCurrentUrl();
    }
}