package step_definitions;

import actions.LandingPage.LandingPageActions;
import helpers.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import page_objects.LandingPage.LandingPage;

public class BaseSteps {

    protected WebDriver baseStepsDriver;
    protected LandingPageActions landingPageActions = new LandingPageActions();

    public BaseSteps() {
        baseStepsDriver = Hooks.driver;
        PageFactory.initElements(baseStepsDriver, LandingPage.class);
    }
}
