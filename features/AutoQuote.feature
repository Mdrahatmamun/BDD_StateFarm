@autoQuote
Feature: Auto Quote Validation

@homeSteps
Scenario: Get a Auto Quote
Given user is in the homepage
When user input 14206 in zipcode
And click get a quote
And click continue
Then user will be in auto quote page


@dataDriven
Scenario Outline: Get a Auto Quote with different data
Given user is in the homepage
When user input <zipcode> in zipcode
And click get a quote
And click continue
Then user will be in auto <quote page>
And user will type their <first name> in first name field
And user will type their <middle name> in middle name field
And user will type their <last name> in last name field
And user will type their <address> in address field
And user will type their <dob> in dob field
And user will click at terms and condition
And user will click at vehicles button
Examples: 
|zipcode|quote page                         |first name|middle name  |last name |address          |dob          |
|14206	|"Welcome - Auto Quote - State Farm"|"md"      |"a"          |"ali"     |"984 Doat street"  |"09-07-1988" |
|14211	|"Welcome - Auto Quote - State Farm"|"saheed"   |"murad"      |"khan"    |"984 Doat street"  |"09-06-1987" |
|14215	|"Welcome - Auto Quote - State Farm"|"hasan"   |"mamun"      |"syed"    |"984 Doat street"  |"09-09-1977" |