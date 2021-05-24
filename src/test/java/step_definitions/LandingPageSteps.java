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
    public void userClickOnText(String data_testid) throws IOException {
        landingPageActions.ClickOnText(data_testid);
    }

    @And("^User click on the \"([^\"]*)\" symbol element on landing page$")
    public void userClickOnSymbol(String data_testid) throws IOException {
        landingPageActions.ClickOnSymbol(data_testid);
    }

    @And("^User fill the post with \"([^\"]*)\" on landing page$")
    public void userFillThePostWithOnLandingPage(String postValue) throws Throwable {
        Status = landingPageActions.FillOnText(postValue);
    }

    @Then("^User should see the new \"([^\"]*)\" status on landing page$")
    public void userShouldSeeTheNewStatusOnLandingPage(String status) throws Throwable {
        landingPageActions.waitForPageToload();
        Assert.assertFalse(landingPageActions.postingStatusIsExecuting());
        Assert.assertEquals(Status, landingPageActions.GetNewStatus(Status));
    }

    @And("^User click on the post button on landing page$")
    public void userClickOnThePostButtonOnLandingPage() throws IOException {
        landingPageActions.ClickOnPostButton();
    }

    @And("^User wait for landing page loaded$")
    public void userWaitForLoginPageLoaded() throws IOException {
        landingPageActions.waitForPageToload();
        Assert.assertFalse(landingPageActions.postingStatusIsExecuting());
        landingPageActions.waitForPageToload();
    }

    @And("^User reload the page$")
    public void userReloadThePage() throws IOException {
        landingPageActions.waitForPageToload();
        landingPageActions.reloadPage();
    }

    @And("^User click on the profile link$")
    public void userClickOnTheProfileLink() throws IOException {
        landingPageActions.clickOnProfileLink();
    }
}
