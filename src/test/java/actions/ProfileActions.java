package actions;

import helpers.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

import static helpers.Utils.click;
import static helpers.Utils.sendKeys;

public class ProfileActions extends BaseActions {
    public void waitForPageToload() {
        Utils.waitForPageToLoad();
    }

    public String GetNewStatus(String data_test) {
        WebElement input_identifier = baseActionsDriver.findElement(By.xpath("//*[text() = '" + data_test + "']"));
        return input_identifier.getText();
    }
}