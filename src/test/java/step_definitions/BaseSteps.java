package step_definitions;

import actions.LandingPageActions;
import actions.LoginPageActions;
import helpers.Hooks;
import org.openqa.selenium.WebDriver;

public class BaseSteps {

    protected WebDriver baseStepsDriver;
    protected LoginPageActions loginPageActions = new LoginPageActions();
    protected LandingPageActions landingPageActions = new LandingPageActions();

    public BaseSteps() {
        baseStepsDriver = Hooks.driver;
    }
}
