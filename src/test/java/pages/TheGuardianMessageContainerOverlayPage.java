package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import base.Keywords;
import exceptions.ApplicationException;

public class TheGuardianMessageContainerOverlayPage extends Keywords {
	private String messageContainerOverlay = "TheGuardian.MessageContainerOverlay.MessageContainerOverlay";
	private String btnYesIamHappy = "TheGuardian.MessageContainerOverlay.btnYesIamHappy";
	private String iFrameForMessageOverlay = "TheGuardian.MessageContainerOverlay.iFrameForMessageOverlay";

	/**
	 * Handles the unexpected popups in the Guardian homepage
	 *
	 * @throws ApplicationException
	 */
	public void verifyNavigatedToHomepage() throws ApplicationException {
		handleMessageContainerOverlay();
		handleChoiceCardBanner();
	}

	/**
	 * This Method clicks on close icon from 'Choice card banner'
	 *
	 * Used javascriptExecutor to interact with tye elements inside "shadow-root"
	 */
	public void handleChoiceCardBanner() {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = (WebElement) jsExecutor.executeScript(
				"return document.querySelector(\"#top > div.site-message--banner.remote-banner\").shadowRoot.querySelector(\"div > div > section > section > div > div.automat-vcfc7o > div > div > button\")");
		jsExecutor.executeScript("arguments[0].click();", element);
	}

	/**
	 * (To be improved..) Used co-ordinates to click on the button 'Yes, I am happy'
	 * (as a workaround) because the following methods to interact with the element
	 * didn't work.
	 *
	 * Cons- The co-ordinates varies device to device. hence individual co-ordinates
	 * to be captured for each device.
	 */
	public void handleMessageContainerOverlay() throws ApplicationException {
		swipe.tapByCoordinates(206, 1882);
	}

}