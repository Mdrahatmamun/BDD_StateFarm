package stateFarm.bdd.objects;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import stateFarm.bdd.common.CommonFunctions;
import stateFarm.bdd.utils.AutoData;

public class AutoQuote {
	CommonFunctions commons;
	WebDriver driver;

	public AutoQuote(WebDriver driver, CommonFunctions commons) {
		PageFactory.initElements(driver, this);
		this.commons = commons;
		this.driver = driver;
	}

	@FindBy(css = "input#first_name")
	WebElement firstNamElement;

	@FindBy(name = "middleName")
	WebElement middleNamElement;

	@FindBy(css = "input#last_name")
	WebElement lastNamElement;

	@FindBy(css = "input#street1")
	WebElement addressElement;

	@FindBy(css = "input#date_of_birth")
	WebElement dobElement;

	@FindBy(xpath = "//div[@class='-oneX-terms-and-conditions-checkbox marginBottom40 marginTop1']")
	WebElement acceptTermsElement;

	@FindBy(name = "nextVehicles")
	WebElement nextVehiclesElement;
	
	public void verifyTitle(String expectedTitle) {
		assertEquals(commons.getTitle(driver), expectedTitle);
	}
	
	public void typeFirstName(String firstname) {
		commons.inputValues(firstNamElement, firstname);
	}

	public void typeMiddleName(String middlename) {
		commons.inputValues(middleNamElement, middlename);
	}

	public void typeLastName(String lastname) {
		commons.inputValues(lastNamElement, lastname);
	}

	public void typeAddrerss(String address) {
		commons.inputValues(addressElement, address);
	}

	public void typeDob(String dob) {
		commons.inputValues(dobElement, dob);
	}

	public void clickAtTermsCondition() {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", acceptTermsElement);
		commons.click(acceptTermsElement);
	}

	public void clickNextVehicles() {
		commons.click(nextVehiclesElement);
	}

	public void getQuoteSteps(String firstname, String middlename, String lastname, String address, String dob) {
		typeFirstName(firstname);
		typeMiddleName(middlename);
		typeLastName(lastname);
		typeAddrerss(address);
		typeDob(dob);
		clickAtTermsCondition();
		clickNextVehicles();

	}
	
	
	public void getQuoteSteps(AutoData autoData) {
		typeFirstName(autoData.getFirstName());
		typeMiddleName(autoData.getMiddleName());
		typeLastName(autoData.getLastName());
		typeAddrerss(autoData.getLastName());
		typeDob(autoData.getDob());
		clickAtTermsCondition();
		clickNextVehicles();

	}

}