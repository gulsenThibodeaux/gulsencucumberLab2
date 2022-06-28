package stepDefinitions;

import Utils.BrowserUtils;
import Utils.ConfigurationsReader;
import Utils.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import pages.Home;

import java.util.Map;

public class steps extends BrowserUtils{

public steps(){
    PageFactory.initElements(Driver.getDriver(),this);
}

    Home home=new Home();

    @Given("The user wants to see Guru demo site")
    public void the_user_wants_to_see_guru_demo_site() {

        Driver.getDriver().get(ConfigurationsReader.getProperties("demoURL"));
        BrowserUtils.waitForPageToLoad(2);

    }



    @Then("The user wants to verify {string} headerr")
    public void the_user_wants_to_verify_headerr(String string) throws InterruptedException {
        home.setAddTariff();
        Thread.sleep(3000);
        Assert.assertTrue(home.addHeader("Add Tariff Plans"));


    }

    @And("The user wants to submit")
    public void the_user_wants_to_submit()  {
        home.submit();

    }
    @Then("The user wants to Add Tariff Plan details as")
    public void the_user_wants_to_add_tariff_plan_details_as(Map<String,String> dataTable) {


        home.fillInputsField(dataTable);

    }

    @Then("The user wants to verify message as {string}")
    public void the_user_wants_to_verify_message_as(String string) {

    Assert.assertTrue(home.verifyHeader("Congratulation you add Tariff Plan"));

}
}

