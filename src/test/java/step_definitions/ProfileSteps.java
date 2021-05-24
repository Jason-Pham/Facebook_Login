package step_definitions;

import actions.ProfileActions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.testng.Assert;

import java.io.IOException;

public class ProfileSteps extends BaseSteps {

    @And("^User wait for profile page loaded$")
    public void userWaitForLoginPageLoaded() {
        profileActions.waitForPageToload();
    }

    @Then("^User should see the new \"([^\"]*)\" status on profile page$")
    public void userShouldSeeTheNewStatusOnLandingPage(String status) {
        profileActions.waitForPageToload();
        Assert.assertEquals(Status, profileActions.GetNewStatus(Status));
    }
}
