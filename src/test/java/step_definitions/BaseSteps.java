package step_definitions;

import actions.LandingPageActions;
import actions.LoginPageActions;
import actions.ProfileActions;
import helpers.Hooks;
import org.openqa.selenium.WebDriver;

public class BaseSteps {

    protected WebDriver baseStepsDriver;
    protected LoginPageActions loginPageActions = new LoginPageActions();
    protected LandingPageActions landingPageActions = new LandingPageActions();
    protected ProfileActions profileActions = new ProfileActions();
    protected String Status;

    public BaseSteps() {
        baseStepsDriver = Hooks.driver;
    }
}
