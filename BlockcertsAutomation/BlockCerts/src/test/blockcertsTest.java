package test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class blockcertsTest {
	
	WebDriver driver;
	
	@Test(priority=0)
	public void launchBrowser() {
	  
		 try { 
		  
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\chromedriver.exe");
		  
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(findResource.URL);
		  
			Reporter.log("Chrome browser is launched successfully");
			System.out.println("Chrome browser is launched successfully");
		  
		}
	  
		catch(Exception e) {
		  
			Reporter.log("There is a problem with launching Chrome browser");
			System.out.println("There is a problem with launching Chrome browser");
			Assert.fail();
		}
	  
  	}
	
	
	
	
	
	@Test(priority=1)
	public void signInPageLogoTest() {
		
		try {
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			String logoHlink = driver.findElement(By.xpath(findResource.signInPageBcertsImg)).getAttribute("href");
			driver.findElement(By.xpath(findResource.signInPageBcertsImg)).click();
			
			if(logoHlink!=null) {
				
				Reporter.log("Redirected to Homepage successfully upon clicking Blockcerts Logo");
				System.out.println("Redirected to Homepage successfully upon clicking Blockcerts Logo");
				
			}
			
			else {
				
				Reporter.log("No hyperlink associated with Blockcerts Logo. Failed to redirect to Homepage upon clicking");
				System.out.println("No hyperlink associated with Blockcerts Logo. Failed to redirect to Homepage upon clicking");
				Assert.fail();
				
			}
		}
		
		catch(Exception e) {
			
			Reporter.log("Failed to redirect to Homepage upon clicking Blockcerts Logo");
			System.out.println("Failed to redirect to Homepage upon clicking Blockcerts Logo");
			Assert.fail();
			
		}
	  
	}
	
	@Test(priority=2)
	public void signInPagePlaceholderTest() {
		
		try {
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			String emailPlaceholder = driver.findElement(By.xpath(findResource.signInPageInputEmail)).getAttribute("placeholder");
			String passwordPlaceholder = driver.findElement(By.xpath(findResource.signInPageInputPassword)).getAttribute("placeholder");
			
			if(emailPlaceholder.equals("Type your Email") && passwordPlaceholder.equals("Type your Password")) {
				
				Reporter.log("Placeholder inside Email and Password fields is verified successfully");
				System.out.println("Placeholder inside Email and Password fields is verified successfully");
				
			}
			else {
				
				Reporter.log("Incorrect placeholder found");
				System.out.println("Incorrect placeholder found");
				Assert.fail();
				
			}
		}
		
		catch(Exception e) {
			
			Reporter.log("Unable to read Placeholder inside Email or Password fields");
			System.out.println("Unable to read Placeholder inside Email or Password fields");
			Assert.fail();
			
		}
	}
  
	@Test(priority=3)
	public void signInPageCheckBoxTest() {
		
		try {
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			WebElement checkBox = driver.findElement(By.xpath(findResource.signInPageCheckBox));
			
			if(checkBox.isSelected()) {
				
				Thread.sleep(3000);
				checkBox.click();
				
				Reporter.log("Able to select and deselect 'Remember my Credentials' checkbox");
				System.out.println("Able to select and deselect 'Remember my Credentials' checkbox");
				
			}
			
			else {
				
				Thread.sleep(3000);
				checkBox.click();
				
				Reporter.log("Able to select and deselect 'Remember my Credentials' checkbox");
				System.out.println("Able to select and deselect 'Remember my Credentials' checkbox");
				
			}
		}
		
		catch(Exception e) {
			
			Reporter.log("Unable to locate or error with 'Remember my Credentials' checkbox");
			System.out.println("Unable to locate or error with 'Remember my Credentials' checkbox");
			Assert.fail();
			
		}
	}
	
	@Test(priority=4)
	public void signInPageLoginButtonTest() {
		
		try {
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			WebElement buttonLogin = driver.findElement(By.xpath(findResource.signInPageLoginButton));
			
			if(!buttonLogin.isEnabled()) {
				
				Reporter.log("Login button is disabled as expected before Email and Password are entered");
				System.out.println("Login button is disabled as expected before Email and Password are entered");
			}
			
			else {
				
				Reporter.log("Login button is enabled before Email and Password are entered");
				System.out.println("Login button is enabled before Email and Password are entered");
				Assert.fail();
				
			}
			
			driver.findElement(By.xpath(findResource.signInPageInputEmail)).sendKeys("conihic135@balaket.com");
			Thread.sleep(3000);
			driver.findElement(By.xpath(findResource.signInPageInputPassword)).sendKeys("Test@111");
			Thread.sleep(3000);
			
			if(buttonLogin.isEnabled()) {
				
				Reporter.log("Login button is enabled as expected after entering Email and Password");
				System.out.println("Login button is enabled as expected after entering Email and Password");
			}
			
			else {
				
				Reporter.log("Login button is disabled even after entering Email and Password");
				System.out.println("Login button is disabled even after entering Email and Password");
				Assert.fail();
				
			}	
		}
		
		catch(Exception e) {
			
			Reporter.log("Unable to locate or error with Login button");
			System.out.println("Unable to locate or error with Login button");
			Assert.fail();
			
		}
	}
	
	@Test(priority=5)
	public void signInPageHyperlinksTest() {
		
		try {
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			List<WebElement> hlinks = driver.findElements(By.tagName("a"));
			
			if(hlinks.size()==2) {
				for(WebElement hlink:hlinks) {
					
					if(!(hlink.getText().equals("Recover your Password") || hlink.getText().equals("Create your Account"))) {
						
						Reporter.log("Error with either of the hyperlinks in the SignIn page");
						System.out.println("Error with either of the hyperlinks in the SignIn page");
						Assert.fail();
						
					}
				}
				
				Reporter.log("Only 2 hyperlinks are found as expected in the SignIn Page associated with 'Recover your Password' and 'Create your Account'");
				System.out.println("Only 2 hyperlinks are found as expected in the SignIn Page associated with 'Recover your Password' and 'Create your Account'");
			}
			
			else {
				
				Reporter.log("More than 2 hyperlinks are found in the SignIn Page");
				System.out.println("More than 2 hyperlinks are found in the SignIn Page");
				Assert.fail();
				
			}
				
		}
		
		catch(Exception e) {
			
			Reporter.log("Unable to locate hyperlinks in the SignIn Page");
			System.out.println("Unable to locate hyperlinks in the SignIn Page");
			Assert.fail();
			
		}
	}
	
	@Test(priority=6)
	public void signInPageRecoverPasswordTest() {
		
		try {
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			WebElement recoverPW = driver.findElement(By.xpath(findResource.signInPageRecoverPassword));
			
			recoverPW.click();
			Thread.sleep(3000);
			
			WebElement forgotPasswordText = driver.findElement(By.xpath(findResource.forgotPassword));
			
			if(forgotPasswordText.isDisplayed()) {
				
				Reporter.log("Click on 'Recover your Password' is redirecting the current browser window to Forgot Password page as expected");
				System.out.println("Click on 'Recover your Password' is redirecting the current browser window to Forgot Password page as expected");
				
			}
			
			else {
				
				Reporter.log("Click on 'Recover your Password' is not redirecting the current browser window to Forgot Password page");
				System.out.println("Click on 'Recover your Password' is not redirecting the current browser window to Forgot Password page");
				Assert.fail();
				
			}
			
			driver.navigate().to(findResource.URL);
			Thread.sleep(3000);
			
			Actions action = new Actions(driver);
			action.keyDown(Keys.SHIFT).click(driver.findElement(By.linkText("Recover your Password"))).keyUp(Keys.SHIFT).build().perform();
			
			ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(windowHandles.get(1));
			Thread.sleep(1000);
			driver.close();
			
			driver.switchTo().window(windowHandles.get(0));
			Thread.sleep(3000);
			
			Reporter.log("We are able to Right-Click on 'Recover your Password' and open the hyperlink in a new window sucessfully");
			System.out.println("We are able to Right-Click on 'Recover your Password' and open the hyperlink in a new window sucessfully");
		}
		
		catch(Exception e) {
			
			Reporter.log("Unable to locate or error with 'Recover your Password' hyperlink");
			System.out.println("Unable to locate or error with 'Recover your Password' hyperlink");
			Assert.fail();
		}
	}
	
	@Test(priority=7)
	public void signInPageCreateYourAccountButtonTest() {
		
		try {
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			WebElement createAccount = driver.findElement(By.xpath(findResource.signInPageCreateAccountButton));
			String createAccountHlink = createAccount.getAttribute("href");
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", createAccount);
			
			if(createAccountHlink.startsWith(findResource.createNewAccountHlink)) {
				
				Reporter.log("'Create your Account' button is associated with SignUp page's hyperlink as expected");
				System.out.println("'Create your Account' button is associated with SignUp page's hyperlink as expected");
				
			}
			
			else {
				
				Reporter.log("Hyperlink associated with 'Create your Account' button is incorrect or empty");
				System.out.println("Hyperlink associated with 'Create your Account' button is incorrect or empty");
				Assert.fail();
				
			}
			
			Actions action = new Actions(driver);
			action.keyDown(Keys.SHIFT).click(createAccount).keyUp(Keys.SHIFT).build().perform();
			
			ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(windowHandles.get(1));
			Thread.sleep(1000);
			
			driver.close();
			driver.switchTo().window(windowHandles.get(0));
			
			Reporter.log("We are able to Right-Click on 'Create your Account' and open the hyperlink in a new window sucessfully");
			System.out.println("We are able to Right-Click on 'Create your Account' and open the hyperlink in a new window sucessfully");
		}
		
		catch(Exception e) {
			
			Reporter.log("Unable to locate or error with 'Create your Account' button/hyperlink");
			System.out.println("Unable to locate or error with 'Create your Account' button/hyperlink");
			Assert.fail();
			
		}
	}
	
	@Test(priority=8)
	public void createAccountPageURLTest() {
		
		try {
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			driver.findElement(By.xpath(findResource.signInPageCreateAccountButton)).click();
			Thread.sleep(3000);
			
			if(driver.getCurrentUrl().startsWith(findResource.createNewAccountHlink)) {
				
				Reporter.log("Click on 'Create your Account' is redirecting the current browser window to Create Account page as expected");
				System.out.println("Click on 'Create your Account' is redirecting the current browser window to Create Account page as expected");
			
			}
			else {
				
				Reporter.log("Error with hyperlink associated with 'Create your Account' in SignIn page");
				System.out.println("Error with hyperlink associated with 'Create your Account' in SignIn page");
				Assert.fail();
			}
		}
		
		catch(Exception e) {
			
			Reporter.log("Unable to locate or error with 'Create your Account' button/hyperlink");
			System.out.println("Unable to locate or error with 'Create your Account' button/hyperlink");
			Assert.fail();
			
		}
	}
	
	@Test(priority=9)
	public void createAccountPageLogoTest() {
		
		try {
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			String logoHlink = driver.findElement(By.xpath(findResource.createAccountPageBcertsImg)).getAttribute("href");
			
			if(logoHlink.startsWith(findResource.loginRedirectHLink)) {
				
				Reporter.log("Blockcerts Logo hyperlink in Create Account page is associated with SignIn page as expected");
				System.out.println("Blockcerts Logo hyperlink in Create Account page is associated with SignIn page as expected");
				
			}
			else {
				
				Reporter.log("Error with hyperlink associated with Blockcerts Logo in Create Account page");
				System.out.println("Error with hyperlink associated with Blockcerts Logo in Create Account page");
				Assert.fail();
				
			}
		}
		
		catch(Exception e) {
			
			Reporter.log("Unable to locate or error with Blockcerts Logo in Create Account page");
			System.out.println("Unable to locate or error with Blockcerts Logo in Create Account page");
			Assert.fail();
			
		}
	}
	
	@Test(priority=10)
	public void createAccountPagePlaceholderTest() {
		
		try {
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			String emailFieldPlaceholder = driver.findElement(By.xpath(findResource.createAccountPageEmailInputField)).getAttribute("placeholder");
			
			if(emailFieldPlaceholder.equals("Email")) {
				
				Reporter.log("Placeholder inside Email field is verified successfully");
				System.out.println("Placeholder inside Email field is verified successfully");
				
			}
			else {
				
				Reporter.log("Error with placeholder inside Email field in Create Account page");
				System.out.println("Error with placeholder inside Email field in Create Account page");
				Assert.fail();
			}
			
		}
		catch(Exception e) {
			
			Reporter.log("Unable to locate or error with Email Placeholder in Create Account page");
			System.out.println("Unable to locate or error with Email Placeholder in Create Account page");
			Assert.fail();
			
		}
	}
	
	@Test(priority=11)
	public void createAccountPageButtonTest() {
		
		try {
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			WebElement createAccountButton = driver.findElement(By.xpath(findResource.createAccountPageButton));
			
			if(!(createAccountButton.isEnabled())) {
				
				Reporter.log("'Create your Account' button is disabled as expected in Create Account page");
				System.out.println("'Create your Account' button is disabled as expected in Create Account page");
				
			}
			
			else {
				
				Reporter.log("Error in displaying 'Create your Account' button in Create Account page");
				System.out.println("Error in displaying 'Create your Account' button in Create Account page");
				Assert.fail();
				
			}
		}
		catch(Exception e) {
			
			Reporter.log("Unable to locate or error with 'Create your Account' button in Create Account page");
			System.out.println("Unable to locate or error with 'Create your Account' button in Create Account page");
			Assert.fail();
			
		}
	}
	
	@Test(priority=12)
	public void createAccountPageLoginInsteadTest() {
		
		try {
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			String loginInsteadHlink = driver.findElement(By.xpath(findResource.createAccountPageloginInstead)).getAttribute("href");
			
			if(loginInsteadHlink.startsWith(findResource.loginRedirectHLink)) {
				
				Reporter.log("'Login Instead' link in Create Account page is displayed as expected with hyperlink associated with SignIn page");
				System.out.println("'Login Instead' link in Create Account page is displayed as expected with hyperlink associated with SignIn page");
				
			}
			
			else {
				
				Reporter.log("There is an error with hyperlink associated with 'Login Instead' in Create Account page");
				System.out.println("There is an error with hyperlink associated with 'Login Instead' in Create Account page");
				Assert.fail();
			}
		}
		catch(Exception e) {
			
			Reporter.log("Unable to locate or error with 'Login Instead' in Create Account page");
			System.out.println("Unable to locate or error with with 'Login Instead' in Create Account page");
			Assert.fail();
			
		}
	}
	
	@Test(priority=13)
	public void signUpPageLogoTest() {
		
		try {
			
			driver.findElement(By.xpath(findResource.createAccountPageEmailInputField)).sendKeys(findResource.testEmail);
			driver.findElement(By.xpath(findResource.createAccountPageButton)).click();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			String logoHlink = driver.findElement(By.xpath(findResource.signUpPageBcertsImg)).getAttribute("href");
			
			if(logoHlink.startsWith(findResource.loginRedirectHLink)) {
				
				Reporter.log("Blockcerts Logo hyperlink in SignUp page is associated with SignIn page as expected");
				System.out.println("Blockcerts Logo hyperlink in SignUp page is associated with SignIn page as expected");
				
			}
			else {
				
				Reporter.log("Error with hyperlink associated with Blockcerts Logo in SignUp page");
				System.out.println("Error with hyperlink associated with Blockcerts Logo in SignUp page");
				Assert.fail();
				
			}
		}
		
		catch(Exception e) {
			
			Reporter.log("Unable to locate or error with Blockcerts Logo in SignUp page");
			System.out.println("Unable to locate or error with Blockcerts Logo in SignUp page");
			Assert.fail();
			
		}
	}
	
	@Test(priority=14)
	public void signUpPagePlaceholderTest() {
		
		try {
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			String mobNoPlaceholder = driver.findElement(By.xpath(findResource.signUpPageMobileNumberField)).getAttribute("placeholder");
			String firstNamePlaceholder = driver.findElement(By.xpath(findResource.signUpPageFirstNameField)).getAttribute("placeholder");
			String lastNamePlaceholder = driver.findElement(By.xpath(findResource.signUpPageLastNameField)).getAttribute("placeholder");
			String passwordPlaceholder = driver.findElement(By.xpath(findResource.signUpPagePasswordField)).getAttribute("placeholder");
			String confirmPasswordPlaceholder = driver.findElement(By.xpath(findResource.signUpPageConfirmPasswordField)).getAttribute("placeholder");
			
			if(mobNoPlaceholder.equals("Mobile Number") && firstNamePlaceholder.equals("First Name") && 
			   lastNamePlaceholder.equals("Last Name") && passwordPlaceholder.equals("Password") && 
			   confirmPasswordPlaceholder.equals("Confirm your Password")) {
				
				Reporter.log("Placeholder inside all the fields are verified successfully");
				System.out.println("Placeholder inside all the fields field are verified successfully");
				
			}
			else {
				
				Reporter.log("Unable to find Placeholder inside one or more fields in the SignUp page");
				System.out.println("Unable to find Placeholder inside one or more fields in the SignUp page");
				Assert.fail();
			}
			
		}
		
		catch(Exception e) {
			
			Reporter.log("Unable to locate Placeholder inside one or more fields in the SignUp page");
			System.out.println("Unable to locate Placeholder inside one or more fields in the SignUp page");
			Assert.fail();
			
		}
	}
	
	@Test(priority=15)
	public void signUpPageCreateButtonTest() {
		
		try {
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			WebElement createButton = driver.findElement(By.xpath(findResource.signUpPageCreatebutton));
			
			if(createButton.isDisplayed()) {
				
				Reporter.log("'Create your Account' button is displayed in the SignUp page as expected");
				System.out.println("'Create your Account' button is displayed in the SignUp page as expected");
				
			}
			
			else {
				
				Reporter.log("Error in displaying 'Create your Account' button in the SignUp page");
				System.out.println("Error in displaying 'Create your Account' button in the SignUp page");
				Assert.fail();
				
			}
		}
		
		catch(Exception e) {
			
			Reporter.log("Unable to locate or error with 'Create your Account' button in the SignUp page");
			System.out.println("Unable to locate or error with 'Create your Account' button in the SignUp page");
			Assert.fail();
			
		}
	}
	
	@Test(priority=16)
	public void signUpPageLoginInsteadTest() {
		
		try {
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			String loginInsteadHlink = driver.findElement(By.xpath(findResource.signUpPageLoginInstead)).getAttribute("href");
			
			if(loginInsteadHlink.startsWith(findResource.loginRedirectHLink)) {
				
				Reporter.log("'Login Instead' link in SignUp page is displayed as expected with hyperlink associated with SignIn page");
				System.out.println("'Login Instead' link in SignUp page is displayed as expected with hyperlink associated with SignIn page");
				
			}
			
			else {
				
				Reporter.log("There is an error with hyperlink associated with 'Login Instead' in SignUp page");
				System.out.println("There is an error with hyperlink associated with 'Login Instead' in SignUp page");
				Assert.fail();
			}
		}
		catch(Exception e) {
			
			Reporter.log("Unable to locate or error with 'Login Instead' in SignUp page");
			System.out.println("Unable to locate or error with with 'Login Instead' in SignUp page");
			Assert.fail();
			
		}
	}
	
	@Test(priority=17)
	public void mandatoryFieldsTest() {
		
		try {
			
			driver.findElement(By.xpath(findResource.signUpPageCreatebutton)).click();
			Thread.sleep(3000);
			
			String alertMsg = driver.findElement(By.xpath(findResource.signUpPageAlertMessage)).getText();
		
			if(alertMsg.contains("Please review all entered details before submitting your request.")) {
				
				Reporter.log("Error message is displayed properly for missing mandatory fields");
				System.out.println("Error message is displayed properly for missing mandatory fields");
				
				driver.findElement(By.xpath(findResource.signUpPageCloseMessage)).click();
			}
			
			else {
				
				Reporter.log("Incorrect error message displayed for missing mandatory fields");
				System.out.println("Incorrect error message displayed for missing mandatory fields");
				driver.findElement(By.xpath(findResource.signUpPageCloseMessage)).click();
				Assert.fail();
				
			}
		}
		catch(Exception e) {
			
			Reporter.log("Error or unable to display message for missing mandatory fields");
			System.out.println("Error or unable to display message for missing mandatory fields");
			Assert.fail();
		}
	}
	
	@Test(priority=19)
	public void signUpPageEmailTest () {
		
		try {
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			
			WebElement emailField = driver.findElement(By.xpath(findResource.signUpPageEmailField));
			String emailPopulated = emailField.getAttribute("value");
			
			if(!(emailPopulated.equals(findResource.testEmail))) {
				
				Reporter.log("There is a mismatch in the email populated from Create Account page to the one in SignUp page");
				System.out.println("There is a mismatch in the email populated from Create Account page to the one in SignUp page");
				Assert.fail();
				
			}
			else if(emailField.isEnabled()) {
				
				Reporter.log("Email in SignUp page should be a disabled field");
				System.out.println("Email in SignUp page should be disabled field");
				Assert.fail();
				
			}
			else {
				
				Reporter.log("Email is populated as entered in the Create Account page and is disabled in the SignUp page");
				System.out.println("Email is populated as entered in the Create Account page and is disabled in the SignUp page");
			
			}
			
		}
		
		catch(Exception e) {
			
			Reporter.log("Unable to locate or error while validating Email field in the SignUp page");
			System.out.println("Unable to locate or error while validating Email field in the SignUp page");
			Assert.fail();
			
		}
	}
	
	@Test(priority=20) 
	public void signUpPageNegativeFieldValidation() {
		
		try {
			
			WebElement mobNoField = driver.findElement(By.xpath(findResource.signUpPageMobileNumberField));
			
			mobNoField.sendKeys("$#@123");
			Thread.sleep(3000);
			driver.findElement(By.xpath(findResource.signUpPageCreatebutton)).click();
			
			String mobValMessage = mobNoField.getAttribute("validationMessage");
			System.out.println(mobValMessage);
			
			if(mobValMessage.equals("Please match the requested format.")) {
				
				Reporter.log("Proper validation message is displayed for Mobile Number field");
				System.out.println("Proper validation message is displayed for Mobile Number field");
				
				mobNoField.clear();
			}
			
			else {
				
				Reporter.log("Validation message displayed for Mobile Number field is incorrect");
				System.out.println("Validation message displayed for Mobile Number field is incorrect");
				Assert.fail();
				
			}
		}
		
		catch(Exception e) {
			
			Reporter.log("Error in checking Validation message displayed for Mobile Number field");
			System.out.println("Error in checking Validation message displayed for Mobile Number field");
			Assert.fail();
		}
	}
	
	@Test(priority=21)
	public void signUpPagePositiveFieldValidation() {
		
		try {
			
			WebElement mobNoField = driver.findElement(By.xpath(findResource.signUpPageMobileNumberField));
			WebElement firstName = driver.findElement(By.xpath(findResource.signUpPageFirstNameField));
			WebElement lastName = driver.findElement(By.xpath(findResource.signUpPageLastNameField));
			WebElement password = driver.findElement(By.xpath(findResource.signUpPagePasswordField));
			WebElement confirmPassword = driver.findElement(By.xpath(findResource.signUpPageConfirmPasswordField));
			
			
			mobNoField.sendKeys("9900112233");
			Thread.sleep(1000);
			
			firstName.sendKeys("test1");
			Thread.sleep(1000);
			
			lastName.sendKeys("abc2");
			Thread.sleep(1000);
			
			password.sendKeys("Test@123");
			Thread.sleep(1000);
			
			confirmPassword.sendKeys("Test@123");
			Thread.sleep(1000);
			
			driver.findElement(By.xpath(findResource.signUpPageCreatebutton)).click();
			Thread.sleep(3000);
			
			String finalURL = "https://bcerts.iam-oauth.staging.blockcerts.com/Agreement.aspx";
			if(finalURL.equals(driver.getCurrentUrl())) {
				
				Reporter.log("New Account has been created successfully with the Email: "+findResource.testEmail);
				System.out.println("New Account has been created successfully with the Email: "+findResource.testEmail);
			}
			
		}
		
		catch(Exception e) {
			
			Reporter.log("Failed to create new user. Please review the input fields");
			System.out.println("Failed to create new user. Please review the input fields");
			Assert.fail();
			
		}
	}
}
