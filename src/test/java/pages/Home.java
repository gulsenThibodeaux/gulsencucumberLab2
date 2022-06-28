package pages;

import Utils.BrowserUtils;
import Utils.ConfigurationsReader;
import Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;
import java.util.Properties;

public class Home extends BrowserUtils {
    public Home() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//header[@class='align-center']/h1")
    public WebElement verfyAddHeader;
    public boolean addHeader(String expectedAddHeader){
        if (verfyAddHeader.getText().equalsIgnoreCase(expectedAddHeader)){
            return true;
        }else{
            return false;
        }


}
    @FindBy(xpath = "//a[@href='addtariffplans.php'][1]")
    private WebElement addTariff;
    public void setAddTariff(){
        staticWait(2);
        addTariff.click();

    }

    @FindBy(id = "rental1")
    private WebElement monthlyRental;

    @FindBy(id = "local_minutes")
    public WebElement localMinutes;

    @FindBy(id = "inter_minutes")
    public WebElement international;

    @FindBy(id = "sms_pack")
    public WebElement sms;

    @FindBy(name = "minutes_charges")
    public WebElement localCharges;

    @FindBy(id = "inter_charges")
    public WebElement inter;

    @FindBy(id = "sms_charges")
    public WebElement charge;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement submitButton;
    public void submit(){
        submitButton.click();
    }
    @FindBy(xpath = "//h2")
    public WebElement header;
    public boolean verifyHeader(String cong){
        System.out.println(cong);
        System.out.println(header.getText());
        if (header.getText().equalsIgnoreCase(cong)){
            return true;
        }else{
            return false;
        }
    }


    public void fillInputsField(Map<String,String> datable) {
        monthlyRental.sendKeys(datable.get("Monthly Rental"));
        localMinutes.sendKeys(datable.get("Free Local Minutes"));
        inter.sendKeys(datable.get("Free International Minutes"));
        sms.sendKeys(datable.get("Free SMS Pack"));
        localCharges.sendKeys(datable.get("Local Per Minutes Charges"));
        international.sendKeys(datable.get("International Per Minutes Charges"));
        charge.sendKeys(datable.get("SMS Per Charges"));
    }
}
