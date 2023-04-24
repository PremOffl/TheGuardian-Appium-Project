package actions;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;

import base.Keywords;
import exceptions.ApplicationException;

/**
 * <h1>List of reusable methods for click actions.
 * <h1>
 *
 * @author Premnath Ayyadurai
 * @since 24 April 2023
 */
public class Click extends Keywords {

	private static Logger log = Logger.getLogger(Click.class);

	/**
	 * Clicks on elementBy locatorKey (String)
	 *
	 * @param locatorKey
	 * @throws ApplicationException
	 */
	public void elementBy(String locatorKey) throws ApplicationException {
		log.info("Click element [" + locatorKey + "]");
		try {
			get.elementBy(locatorKey).click();
		} catch (StaleElementReferenceException ex) {
			throw new ApplicationException("Exception occured in clicking element: " + locatorKey);
		}
		log.info("Click Successful!");
	}

	/**
	 * Clicks on elementBy locatorKey (By)
	 *
	 * @param locator
	 * @throws ApplicationException
	 */
	public void elementBy(By locator) throws ApplicationException {
		log.info("Click element [" + locator + "]");
		try {
			get.elementBy(locator).click();
		} catch (StaleElementReferenceException ex) {
			throw new ApplicationException("Exception occured in clicking element: " + locator);
		}
		log.info("Click Successful!");
	}

	/**
	 * Clicks on elementBy locatorKey (String), If its present in the page
	 *
	 * @param locatorKey
	 * @throws ApplicationException
	 */
	public void clickIfPresent(String locatorKey) throws ApplicationException {
		log.info("clickIfPresent [" + locatorKey + "]");
		try {
			if (get.elementBy(locatorKey).isDisplayed()) {
				get.elementBy(locatorKey).click();
			}
		} catch (StaleElementReferenceException ex) {
			throw new ApplicationException("Exception occured in clickIfPresent element: " + locatorKey);
		}
		log.info("Click Successful!");
	}

}
