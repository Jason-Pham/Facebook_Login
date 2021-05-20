package step_definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import helpers.TestData.UrlEnvInfo;
import org.testng.Assert;
import step_definitions.BaseSteps;

import java.io.IOException;

public class LoginPageSteps extends BaseSteps {
    @Given("^User is opening \"([^\"]*)\" page$")
    public void userIsOpeningLandingPage(String page) {
        if (page.equals("Facebook"))
            baseStepsDriver.navigate().to(UrlEnvInfo.facebook_prod);
    }

    @And("^User fill \"([^\"]*)\" with \"([^\"]*)\"$")
    public void userFill(String data_testid, String value) throws IOException {
        loginPageActions.Fill(data_testid, value);
    }

    @And("^User click on the \"([^\"]*)\" button$")
    public void userClick(String data_testid) throws IOException {
        loginPageActions.Click(data_testid);
    }

    @Then("^User should be on the \"([^\"]*)\" page$")
    public void userShouldBeOnThe(String page) {
        Assert.assertEquals(loginPageActions.GetCurrentUrl(), page);
    }
}
