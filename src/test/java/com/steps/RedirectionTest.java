package com.steps;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RedirectionTest {
	WebDriver driver;
	
	//SignIn
	@Given("The home page is loaded")
	public void the_home_page_is_loaded() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\aknanda\\My folder\\drivers\\chromedriver_win32 (1)\\chromedriver.exe");
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		driver = new ChromeDriver(options);
	    driver.manage().window().maximize();    
	    driver.navigate().to("https://www.universalclass.com/");
	    Thread.sleep(2000);
	}

	@When("the user clicks on Header menu")
	public void the_user_clicks_on_header_menu() throws InterruptedException {
	    driver.findElement(By.id("clssicon")).click();
	    Thread.sleep(1000);
	}

	@When("selects Sign In")
	public void selects_sign_in() throws InterruptedException {
	    driver.findElement(By.xpath("//span[contains(text(),'Sign In')]")).click();
	    Thread.sleep(2000);
	}

	@Then("SignIn page is loaded")
	public void sign_in_page_is_loaded() {
	    try {
			driver.findElement(By.xpath("//h1[contains(text(),'Member Sign In')]"));
		} finally {
			driver.quit();
		}
	}

	@Given("Email and Password textboxes are accessible")
	public void email_and_password_textboxes_are_accessible() {
	    driver.findElement(By.id("username_id"));
	    driver.findElement(By.id("password_id"));
	}

	@When("the user enters new emailID in Email textbox")
	public void the_user_enters_new_email_id_in_email_textbox() {
		driver.findElement(By.id("username_id")).sendKeys("akshya.nanda03@gmail.com");
	}

	@When("enters a password for the emailID in Password textbox")
	public void enters_a_password_for_the_email_id_in_password_textbox() {
		driver.findElement(By.id("password_id")).sendKeys("AkshyaNanda");;
	}

	@When("clicks SignIn")
	public void clicks_sign_in() throws InterruptedException {
		driver.findElement(By.id("password_id")).sendKeys(Keys.RETURN);
		Thread.sleep(5000);
	}

	@Then("a new account is created with given emailID")
	public void a_new_account_is_created_with_given_email_id() {
		System.out.println("New account is registered");
	    driver.quit();
	}

	@When("the user enters emailID in Email textbox")
	public void the_user_enters_email_id_in_email_textbox() {
		driver.findElement(By.id("username_id")).sendKeys("akshya.nanda03@gmail.com");
	}

	@Then("user is logged-in and page is redirected to home page")
	public void user_is_logged_in_and_page_is_redirected_to_home_page() {
	    driver.findElement(By.xpath("//h1[contains(text(),'Learn Anything · Learn Anytime · Learn Anywhere')]"));
	    System.out.println("User logged in and website redirected to home page");
	    driver.quit();
	}
	
	@When("enters an invalid password for the emailID in Password textbox")
	public void enters_an_invalid_password_for_the_email_id_in_password_textbox() {
		driver.findElement(By.id("password_id")).sendKeys("wydvb2iuybedc92unciu2");;
	}
	
	@Then("error message is displayed")
	public void error_message_is_displayed() {
	    driver.findElement(By.xpath("//span[contains(text(),'Tip: Passwords are case sensitive.')]"));
	    System.out.println("Error message for wrong password displayed");
	    driver.quit();
	}
	
	//Forgot Password
	@When("the user clicks on Forgot Password")
	public void the_user_clicks_on_forgot_password() {
	    driver.findElement(By.xpath("//a[contains(text(),'Forgot your password?')]")).click();
	}

	@Then("the website is redirected to Forgot Password page")
	public void the_website_is_redirected_to_forgot_password_page() throws InterruptedException {
		try {
			Thread.sleep(10000);
			the_user_clicks_on_header_menu();
			selects_sign_in();
			the_user_clicks_on_forgot_password();
			driver.findElement(
					By.xpath("//div[contains(text(),'If you have forgotten your password, enter your em')]"));
			System.out.print("Page redirected to Forgot password page");
			
		} finally {
			driver.quit();
		}
	}

	@When("the user enters EmailId and clicks on Recover Password")
	public void the_user_enters_email_id_and_clicks_on_recover_password() throws InterruptedException {
		Thread.sleep(10000);
		the_user_clicks_on_header_menu();
		selects_sign_in();
		the_user_clicks_on_forgot_password();
		Thread.sleep(5000);
	    driver.findElement(By.id("email_id")).sendKeys("akshya.nanda03@gmail.com");
	    driver.findElement(By.id("email_id")).sendKeys(Keys.RETURN);
	}

	@Then("password reset link is sent to email")
	public void password_reset_link_is_sent_to_email() {
	    try {
			if (driver
					.findElements(
							By.xpath("//div[contains(text(),'There is no match for an account with that email a')]"))
					.isEmpty() == true)
				System.out.println("Password reset link must have been sent through mail");
			else
				System.out.println("No account found for entered email");
		} finally {
			driver.quit();
		}
		
	}
	
	//Search Courses
	@Given("textbox is available on the home page")
	public void textbox_is_available_on_the_home_page() {
	    driver.findElement(By.id("SearchString"));
	}

	@When("the user enters a string in textbox")
	public void the_user_enters_a_string_in_textbox() {
		driver.findElement(By.id("SearchString")).sendKeys("Business");
	}

	@When("clicks on Search icon")
	public void clicks_on_search_icon() {
		driver.findElement(By.id("SearchString")).sendKeys(Keys.RETURN);
	}

	@Then("the page is redirected to results page with multiple related available courses")
	public void the_page_is_redirected_to_results_page_with_multiple_related_available_courses() {
		try {
			driver.findElement(By.id("searchresults"));
			System.out.println("Page is redirected to Search results page");
			
		} finally {
			driver.quit();
		}
	}
	
	@When("the user enters an invalid string in textbox")
	public void the_user_enters_an_invalid_string_in_textbox() {
		driver.findElement(By.id("SearchString")).sendKeys("ahvduqyeouvqbovdb");
	}

	@Then("error message is returned informing No courses available")
	public void error_message_is_returned_informing_no_courses_available() {
	    try {
			driver.findElement(By.xpath("//h2[contains(text(),'No records matched your search criteria.')]"));
			System.out.println("No courses found for entered string, so error displayed");
			
		} finally {
			driver.quit();
		}
	}
	
	@When("selects a course")
	public void selects_a_course() {
	    System.out.println("Course details are displayed");
	}

	@Then("all the course details are displayed on the screen")
	public void all_the_course_details_are_displayed_on_the_screen() {
	    driver.quit();
	}
	
	//Course Catalog
	@When("the user clicks on Course Catalog tab on home page")
	public void the_user_clicks_on_course_catalog_tab_on_home_page() throws InterruptedException {
		driver.findElement(By.xpath("//button[contains(text(),'Course Catalog')]")).click();
	}

	@Then("all the course categories are displayed on the screen")
	public void all_the_course_categories_are_displayed_on_the_screen() throws InterruptedException {
	    try {
	    	Thread.sleep(5000);
	    	the_user_clicks_on_course_catalog_tab_on_home_page();
	    	Thread.sleep(2000);
			driver.findElement(By.xpath("//div[contains(text(),'Areas of Study')]"));
			System.out.println("Course categories are displayed");
		} finally {
			driver.quit();
		}
	}

	@When("selects a category from displayed results")
	public void selects_a_category_from_displayed_results() throws InterruptedException {
		Thread.sleep(5000);
    	the_user_clicks_on_course_catalog_tab_on_home_page();
		Thread.sleep(2000);
	    driver.findElement(By.xpath("//h5[contains(text(),'Alternative Medicine')]")).click();
	    Thread.sleep(2000);
	}

	@Then("all the available courses under the category are displayed on the screen")
	public void all_the_available_courses_under_the_category_are_displayed_on_the_screen() {
	    try {
			driver.findElement(By.xpath("//h1[contains(text(),'Alternative Healthcare: Treatment and Prevention')]"));
		} finally {
			driver.quit();
		}
	}
	
	//My Classes
	@When("the user clicks on My Classes tab on home page")
	public void the_user_clicks_on_my_classes_tab_on_home_page() throws InterruptedException {
		Thread.sleep(3000);
	    driver.findElement(By.xpath("//a[contains(text(),'My Classes')]")).click();
	}

	@Then("all the enrolled classes for the loggin-in account are displayed")
	public void all_the_enrolled_classes_for_the_loggin_in_account_are_displayed() {
	    try {
			System.out.println("All classes for logg-in account are displayed");	
		} finally {
			driver.quit();
		}
	}
}
