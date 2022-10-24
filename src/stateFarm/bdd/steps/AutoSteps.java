package stateFarm.bdd.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import stateFarm.bdd.base.BaseClass;


public class AutoSteps extends BaseClass {

	@When("click get a quote")
	public void click_get_a_quote() {
		homePage.clickAtGetQuote();

	}
	
	@When("click continue")
	public void click_continue() {
		homePage.clickAtPopUp();
	}

	@Then("user will be in auto quote page")
	public void user_will_be_in_auto_quote_page() {
		autoQuote.verifyTitle("Welcome - Auto Quote - State Farm");
	}

	@Then("user will be in auto {string}")
	public void user_will_be_in_auto(String string) {
		autoQuote.verifyTitle(string);

	}

	@Then("user will type their {string} in first name field")
	public void user_will_type_their_in_first_name_field(String string) {
		autoQuote.typeFirstName(string);

	}

	@Then("user will type their {string} in middle name field")
	public void user_will_type_their_in_middle_name_field(String string) {
		autoQuote.typeMiddleName(string);

	}

	@Then("user will type their {string} in last name field")
	public void user_will_type_their_in_last_name_field(String string) {
		autoQuote.typeLastName(string);

	}

	@Then("user will type their {string} in address field")
	public void user_will_type_their_in_address_field(String string) {
		autoQuote.typeAddrerss(string);

	}

	@Then("user will type their {string} in dob field")
	public void user_will_type_their_in_dob_field(String string) {
		autoQuote.typeDob(string);

	}

	@Then("user will click at terms and condition")
	public void user_will_click_at_terms_and_condition() {
		autoQuote.clickAtTermsCondition();

	}

	@Then("user will click at vehicles button")
	public void user_will_click_at_vehicles_button() {
		autoQuote.clickNextVehicles();

	}

}