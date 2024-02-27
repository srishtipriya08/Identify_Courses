//package stepDefinitions;
//
//import java.util.List;
//
//import org.openqa.selenium.WebElement;
//
//import PageObjects.LearningLanguage;
//import PageObjects.WebDevelopment;
//import TestBase.BaseClass;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//public class Learning extends BaseClass{
//	
//	@Given("the user again navigate back to the homepage")
//	public void the_user_again_navigate_back_to_the_homepage() throws InterruptedException {
//		Thread.sleep(4000);
//		WD = new WebDevelopment(driver);
//		LL = new LearningLanguage(driver);
//		
//		LL.getHomePage();
//		
//	}
//
//	@When("user enter the learning language course")
//	public void user_enter_the_learning_language_course() {
//		LL.Search();
//		WD.clickButton();
//	}
//
//	@When("Click on language See more link")
//	public void click_on_language_see_more_link() throws InterruptedException {
//		Thread.sleep(4000);
//		WD.getSeeMore();
//		
////		All language name and its count
//		System.out.println("All language name and its count\n");
//		
//		List<WebElement> Count = LL.LanguageCount();
//		
//		for(int i=0;i<Count.size();i++) {
//			String getLanguage = Count.get(i).getText();
//			count1.add(getLanguage);
//			System.out.println((i+1)+". "+getLanguage+"\n");
//		}
//		
////		close language box
//		
//		LL.Close();
//	}
//
//	@When("Go to Level option")
//	public void go_to_level_option() {
//	  
//		System.out.println("Different level count\n");
//		List<WebElement> level = LL.LevelCount();
//		for(int i=0;i<level.size();i++) {
//			String getLevel = level.get(i).getText();
//			level1.add(getLevel);
//			System.out.println((i+1)+". "+getLevel+"\n");
//		}
//	}
//
//	@Then("User Navigate to the main page")
//	public void user_navigate_to_the_main_page() {
//		LL.getHomePage();
//	}
//}