package stepdefinitions;

import static base.Keywords.enterurl;
import static base.Keywords.launchApplication;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import exceptions.ApplicationException;
import helper.PropertyReader;
import pages.GoogleHomePage;
import pages.GoogleSearchResultPage;
import pages.TheGuardianHomePage;
import pages.TheGuardianMessageContainerOverlayPage;

public class TheGuardianStepDef {

	private static TheGuardianMessageContainerOverlayPage theGuardianMessageContainerOverlay = new TheGuardianMessageContainerOverlayPage();
	private static TheGuardianHomePage theGuardianHomePage = new TheGuardianHomePage();
	private static GoogleHomePage googleHomePage = new GoogleHomePage();
	private static GoogleSearchResultPage googleSearchResultPage = new GoogleSearchResultPage();

	@Given("^I launch the url and navigate to (.*) section$")
	public void i_launch_the_url_and_navigate_to_tone_news_section(String path) throws Exception {
		launchApplication();
		enterurl(PropertyReader.testDataOf("url") + path);
		theGuardianMessageContainerOverlay.verifyNavigatedToHomepage();
	}

	@When("I select the first news in the guardians portal")
	public void i_select_the_first_news_in_the_guardians_portal() throws ApplicationException {
		theGuardianHomePage.getFirstHeadlineText();
	}

	@When("^Search in (.*) with the first news$")
	public void search_in_google_with_the_first_news(String source) throws Exception {
		if (source.equalsIgnoreCase("google")) {
			googleHomePage.openGoogleHomePage();
			googleHomePage.clickAcceptAllCookies();
			googleHomePage.enterFirstNewsTitleInSearchBox();
		}
	}

	@Then("I verify whether the first news article is valid or invalid")
	public void i_should_see_two_or_more_article_on_same_topic_getting_displayed() throws ApplicationException {
		googleSearchResultPage.verifyIfTheNewsIsValid();
	}

}
