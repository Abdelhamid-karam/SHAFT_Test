package signUp;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.apache.commons.lang3.RandomStringUtils;

import com.shaft.driver.DriverFactory;
import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.element.ElementActions;
import com.shaft.tools.io.ExcelFileManager;
import com.shaft.validation.Validations;

public class SignUpGui {
	private WebDriver driver;
	private ExcelFileManager signUpData;
	private pageOpjectModel.signUpPage sign;
	String password = new Random().ints(10, 33, 122)
			.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

	public String randomestring() {
		String generatedstring = RandomStringUtils.randomAlphabetic(8);
		return (generatedstring);
	}

	@Test
	public void submitSignUpSuccessfully() {
		sign.submitSignUpForm(signUpData.getCellData("SignupdataPersonalInfo", "Data1"),
				signUpData.getCellData("SignupdataPersonalInfo", "Data2"), password,
				signUpData.getCellData("SignupdataPersonalInfo", "Data3"),
				signUpData.getCellData("SignupdataPersonalInfo", "Data4"),
				signUpData.getCellData("SignupdataPersonalInfo", "Data5"),
				signUpData.getCellData("SignupdataAdress", "Data1"),
				signUpData.getCellData("SignupdataAdress", "Data2"),
				signUpData.getCellData("SignupdataAdress", "Data3"),
				signUpData.getCellData("SignupdataAdress", "Data4"),
				signUpData.getCellData("SignupdataAdress", "Data5"),
				signUpData.getCellData("SignupdataAdress", "Data6"),
				signUpData.getCellData("SignupdataAdress", "Data7"),
				signUpData.getCellData("SignupdataAdress", "Data8"),
				signUpData.getCellData("SignupdataAdress", "Data9"),
				signUpData.getCellData("SignupdataAdress", "Data10"));

		Validations.verifyThat().object(driver.getCurrentUrl())
				.equalsIgnoringCaseSensitivity("http://automationpractice.com/index.php?controller=my-account")
				.perform();
	}

	@BeforeClass
	public void beforeClass() {
		signUpData = new ExcelFileManager(System.getProperty("testDataFolderPath") + "signUpData/testdataGUI.xlsx");
	}

	@BeforeMethod
	public void beforeMethod() {
		driver = DriverFactory.getDriver();
		sign = new pageOpjectModel.signUpPage(driver);
		BrowserActions.navigateToURL(driver, signUpData.getCellData("Environment URL", "Data1"));
		ElementActions.click(driver, By.xpath("//a[@class='login']"));
		ElementActions.type(driver, By.id("email_create"), randomestring() + signUpData.getCellData("Email", "Data1"));
		ElementActions.click(driver, By.id("SubmitCreate"));
	}

	@AfterMethod
	public void afterMethod() {
		sign.LogOut();
		BrowserActions.closeCurrentWindow(driver);
	}
}
