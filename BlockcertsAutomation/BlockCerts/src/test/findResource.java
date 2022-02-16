package test;

public class findResource {
		
		static String URL = "https://bcerts.iam-oauth.staging.blockcerts.com/";
		
		static String testEmail = "test10@abc.com";
		
		static String signInPageRecoverPasswordHlink = "https://accounts.stagingiam.blockcerts.com/Account/ForgotPassword";
		static String createNewAccountHlink = "https://accounts.stagingiam.blockcerts.com/Account/SignUp";
		static String loginRedirectHLink = "https://accounts.stagingiam.blockcerts.com/Account/Login";
		
		static String signInPageBcertsImg = "//img[@title=\"bcerts\"]";
		static String createAccountPageBcertsImg = "//img[@title='Blockcerts']//ancestor::a";
		static String signUpPageBcertsImg = "//img[@title='Blockcerts']//ancestor::a";
		
		static String signInPageInputEmail = "//input[@name=\"Username\"]";
		static String signInPageInputPassword = "//input[@name=\"Password\"]";
		
		static String signInPageCheckBox = "//label[@class=\"checkbox\"]";
		
		static String signInPageLoginButton = "//button[text()='Login']";
		
		static String signInPageRecoverPassword = "//a[text()='Recover your Password']";
		static String forgotPassword = "//h3[text()='Forgot your password']";
		
		static String signInPageCreateAccountButton = "//a[text()='Create your Account']";
		
		static String createAccountPageEmailInputField = "//input[@name='Email']";
		static String createAccountPageButton = "//button[text()='Create your Account']";
		static String createAccountPageloginInstead = "//a[text()='Login Instead']";
		
		static String signUpPageEmailField = "//input[@name='Email']";
		static String signUpPageMobileNumberField = "//input[@name='Phone']";
		static String signUpPageFirstNameField = "//input[@name='FirstName']";
		static String signUpPageLastNameField = "//input[@name='LastName']";
		static String signUpPagePasswordField = "//input[@name='Password']";
		static String signUpPageConfirmPasswordField = "//input[@name='ConfirmPassword']";
		static String signUpPageCreatebutton = "//button[text()='Create your Account']";
		static String signUpPageLoginInstead = "//a[text()='Login Instead']";
		
		static String signUpPageAlertMessage = "//*[@role='alert']";
		static String signUpPageCloseMessage = "//button[@class='close']";
	}
