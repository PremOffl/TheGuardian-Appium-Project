package pages;

import base.Keywords;
import exceptions.ApplicationException;

public class TheGuardianHomePage extends Keywords {

	private String LblFirstHeadlineText = "TheGuardian.HomePage.LblFirstHeadlineText";

	/**
	 * This method will store the First Headline news to variable->
	 * "LblFirstHeadlineText"
	 *
	 * @throws ApplicationException
	 */
	public void getFirstHeadlineText() throws ApplicationException {
		String strFirstHeadlineText = get.elementText(LblFirstHeadlineText);
		System.setProperty("strFirstHeadlineText", strFirstHeadlineText);
	}

}