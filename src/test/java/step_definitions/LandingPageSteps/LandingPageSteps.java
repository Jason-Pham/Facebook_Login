package step_definitions.LandingPageSteps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import helpers.Constant;
import helpers.TestData.UrlEnvInfo;
import step_definitions.BaseSteps;

public class LandingPageSteps extends BaseSteps {
    @Given("^User is opening \"([^\"]*)\" page$")
    public void userIsOpeningLandingPage(String page) {
        if (page.equals("Facebook"))
            baseStepsDriver.navigate().to(UrlEnvInfo.facebook_prod);
        throw new PendingException();
    }

    @And("^User fill \"([^\"]*)\" with \"([^\"]*)\"$")
    public void userFill() throws InterruptedException {
        Thread.sleep(5000);
    }

    @And("^User click on the \"([^\"]*)\" button$")
    public void userClick() {

    }

    @Then("^User should be on the \"([^\"]*)\" page$")
    public void userShouldBeOnThe() {

    }
}
