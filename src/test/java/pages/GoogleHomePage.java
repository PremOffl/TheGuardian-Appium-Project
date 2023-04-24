package pages;

import base.Keywords;
import exceptions.ApplicationException;
import helper.PropertyReader;
import helper.Tools;

public class GoogleHomePage extends Keywords {

	private String btnAcceptAllCookies = "Google.HomePage.btnAcceptAllCookies";
	private String txtSearch = "Google.HomePage.txtSearch";
	private String btnSearch = "Google.HomePage.btnSearch";

	/**
	 * This method will click on "Accept All" button from the pop-up => which is a
	 * one time pop-up when we open google.com for the first time
	 * 
	 * @throws ApplicationException
	 */
	public void clickAcceptAllCookies() throws ApplicationException {
		click.clickIfPresent(btnAcceptAllCookies);
	}

	/**
	 * This method opens the given URL in the browser
	 *
	 * @throws Exception
	 */
	public void openGoogleHomePage() throws Exception {
		Tools.openURL(PropertyReader.testDataOf("googleUrl"));
	}

	/**
	 * This method gets the earlier stored property value - "strFirstHeadlineText"
	 * And enter this text in the search box in google home-page
	 *
	 * @throws ApplicationException
	 */
	public void enterFirstNewsTitleInSearchBox() throws ApplicationException {
		type.data(txtSearch, System.getProperty("strFirstHeadlineText"));
		click.elementBy(btnSearch);
	}

}