package pages;

import base.Keywords;
import exceptions.ApplicationException;
import helper.Tools;

public class GoogleSearchResultPage extends Keywords {

	private String listNewsHeadlines = "Google.SearchResults.listNewsHeadlines";
	private String listNewsDescriptionsInSpanTag = "Google.SearchResults.listNewsDescriptionsInSpanTag";
	private String listNewsDescriptionsInDivTag = "Google.SearchResults.listNewsDescriptionsInDivTag";

	/**
	 * This method will verify if the news is valid or not by below criteria. If,
	 * the search results is more than 2 => Valid Else, Invalid
	 */
	public void verifyIfTheNewsIsValid() throws ApplicationException {
		String searchTerm = System.getProperty("strFirstHeadlineText");

		Tools.verifyIfTheStringIsPresentInAList(listNewsHeadlines, listNewsDescriptionsInSpanTag,
				listNewsDescriptionsInDivTag, searchTerm.substring(0, searchTerm.length() / 2));
	}

}