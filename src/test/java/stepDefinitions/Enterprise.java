/*
 * package stepDefinitions;
 * 
 * import org.openqa.selenium.By; import org.openqa.selenium.WebElement; import
 * org.openqa.selenium.support.ui.Select;
 * 
 * import TestBase.BaseClass; import io.cucumber.java.en.Given; import
 * io.cucumber.java.en.Then; import io.cucumber.java.en.When;
 * 
 * public class Enterprise extends BaseClass{
 * 
 * @Given("User scroll to the for Enterprise") public void
 * user_scroll_to_the_for_enterprise() { EP = new Enterprise(driver); //scroll
 * down For Enterprise EP.ForEnterprise(); }
 * 
 * @Given("click the enterprise link") public void click_the_enterprise_link() {
 * EP.clickEnterprise(); }
 * 
 * @When("Go to solution button") public void go_to_solution_button() {
 * EP.Solution(); }
 * 
 * @When("select the course for campus") public void
 * select_the_course_for_campus() { EP.ForCampus(); }
 * 
 * @When("user fill the ready to transform form") public void
 * user_fill_the_ready_to_transform_form() throws InterruptedException {
 * EP.Form();
 * 
 * EP.Fname(); EP.Lname(); EP.Email(); EP.PhoneNo(); EP.Institution();
 * 
 * //Using Select Thread.sleep(2000); Select Institutiontype=new
 * Select(driver.findElement(By.xpath("//*[@id='Institution_Type__c']")));
 * Institutiontype.selectByVisibleText("Other"); Thread.sleep(3000); Select
 * Jobrole=new Select(driver.findElement(By.xpath("//*[@id='Title']")));
 * Jobrole.selectByVisibleText("Student"); Thread.sleep(2000); Select
 * Department=new Select(driver.findElement(By.xpath("//*[@id='Department']")));
 * Department.selectByVisibleText("Continuing Education"); Thread.sleep(3000);
 * Select bestdescribes=new Select(driver.findElement(By.xpath(
 * "//*[@id='What_the_lead_asked_for_on_the_website__c']")));
 * bestdescribes.selectByVisibleText("Tech Support"); Thread.sleep(4000); Select
 * country=new Select(driver.findElement(By.xpath("//*[@id='Country']")));
 * country.selectByVisibleText("India"); Thread.sleep(3000); Select state=new
 * Select(driver.findElement(By.xpath("//*[@id='State']")));
 * state.selectByVisibleText("Tamil Nadu"); }
 * 
 * @Then("Submit the filled form") public void submit_the_filled_form() throws
 * InterruptedException { Thread.sleep(4000); EP.Submit(); }
 * 
 * @Then("Capture the error message") public void capture_the_error_message()
 * throws InterruptedException { Thread.sleep(4000); WebElement
 * errormsg=driver.findElement(By.xpath("//*[@id='ValidMsgEmail']"));
 * System.out.println("");
 * System.out.println("Error Message : "+errormsg.getText()+"\n"); } }
 */