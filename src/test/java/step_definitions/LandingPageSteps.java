package step_definitions;

import cucumber.api.java.en.Then;
import org.testng.Assert;

public class LandingPageSteps extends BaseSteps {

    @Then("^User shoul1d be on the \"([^\"]*)\" page$")
    public void userShouldBeOnThe(String page) {
        Assert.assertEquals(landingPageActions.GetCurrentUrl(), page);
    }
}
