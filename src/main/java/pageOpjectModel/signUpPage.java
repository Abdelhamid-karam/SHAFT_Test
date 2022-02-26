package pageOpjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.shaft.gui.element.ElementActions;

public class signUpPage {
	// personal info section
	private WebDriver driver;
	private By gender_Selection = By.xpath("//label[@for='id_gender1']");
	private By input_firstname = By.id("customer_firstname");
	private By input_lastname = By.id("customer_lastname");
	private By input_Password = By.id("passwd");
	private By input_BD_D = By.id("days");
	private By input_BD_M = By.id("months");
	private By input_BD_Y = By.id("years");
	// Adress section
	private By input_firstname_co = By.id("firstname");
	private By input_lastname_co = By.id("lastname");
	private By input_company = By.id("company");
	private By input_Adress = By.id("address1");
	private By input_City = By.id("city");
	private By input_phone = By.id("phone_mobile");
	private By input_alisEmail = By.id("alias");
	// submit button
	private By submit_button = By.id("submitAccount");
	// logo out button
	private By LogOut_button = By.xpath("//a[@title='Log me out']");

	public signUpPage(WebDriver driver) {
		this.driver = driver;
	}

	public void submitSignUpForm(String firstname, String lastname, String password, String day, String mounth,
			String year, String firstname_AD, String lastname_AD, String company, String Adress, String city,
			String country, String state, String postcode, String phone, String alisEmail) {
		ElementActions.click(driver, gender_Selection);
		ElementActions.type(driver, input_firstname, firstname);
		ElementActions.type(driver, input_lastname, lastname);
		ElementActions.type(driver, input_Password, password);
		ElementActions.typeAppend(driver, input_BD_D, day);
		ElementActions.typeAppend(driver, input_BD_M, mounth);
		ElementActions.typeAppend(driver, input_BD_Y, year);
		ElementActions.click(driver, By.id("uniform-newsletter"));
		ElementActions.click(driver, By.id("uniform-optin"));
		// Adress section
		ElementActions.type(driver, input_firstname_co, firstname_AD);
		ElementActions.type(driver, input_lastname_co, lastname_AD);
		ElementActions.type(driver, input_company, company);
		ElementActions.type(driver, input_Adress, Adress);
		ElementActions.type(driver, input_City, city);
		ElementActions.typeAppend(driver, By.id("id_country"), country);
		ElementActions.typeAppend(driver, By.id("id_state"), state);
		ElementActions.typeAppend(driver, By.id("postcode"), postcode);
		ElementActions.type(driver, input_phone, phone);
		ElementActions.type(driver, input_alisEmail, alisEmail);
		// submit
		ElementActions.click(driver, submit_button);

	}

	public void LogOut() {
		ElementActions.click(driver, LogOut_button);
	}

}
