package stateFarm.bdd.objects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import stateFarm.bdd.common.CommonFunctions;
import stateFarm.bdd.utils.AutoData;


public class HomePage {

	CommonFunctions commons;
	WebDriver driver;

	public HomePage(WebDriver driver, CommonFunctions commons) {
		PageFactory.initElements(driver, this);
		this.commons = commons;
		this.driver = driver;
	}

	@FindBy(css = "input#quote-main-zip-code-input")
	WebElement enterZipCodElement;

	@FindBy(id = "quote-main-zip-btn")
	WebElement getQuotElement;
	
	@FindBy(id = "nyLegacyCloseLinkId")
	WebElement popUpElement;
	
	public void getCurrentUrl() {
		commons.getCurrentUrl(driver);
	}

	public void inputZipCode(String value) {
		commons.inputValues(enterZipCodElement, value);
	}

	public void clickAtGetQuote() {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getQuotElement);
		commons.click(getQuotElement);
	}
	
	public void clickAtPopUp() {
		commons.click(popUpElement);
	}

	public void homepageSteps(String value) {

		inputZipCode(value);
		clickAtGetQuote();
		clickAtPopUp();

	}

	public void homepageSteps(AutoData autoData) {

		inputZipCode(autoData.getZipCode());
		clickAtGetQuote();
		clickAtPopUp();
	}
	
	}
