package step_definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.testng.Assert;

import java.io.IOException;

public class LandingPageSteps extends BaseSteps {

    @Then("^User shoul1d be on the \"([^\"]*)\" page$")
    public void userShouldBeOnThe(String page) {
        Assert.assertEquals(landingPageActions.GetCurrentUrl(), page);
    }

    @And("^User click on the \"([^\"]*)\" text element on landing page$")
    public void userClickOnText(String data_testid) throws IOException, InterruptedException {
        landingPageActions.ClickOnText(data_testid);
    }

    @And("^User click on the \"([^\"]*)\" symbol element on landing page$")
    public void userClickOnSymbol(String data_testid) throws IOException {
        landingPageActions.ClickOnSymbol(data_testid);
    }

    @And("^User fill the post with \"([^\"]*)\" on landing page$")
    public void userFillThePostWithOnLandingPage(String postValue) throws Throwable {
        landingPageActions.FillOnText(postValue);
    }
}
