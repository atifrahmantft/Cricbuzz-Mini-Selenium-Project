package org.example.cricbuzz.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    @FindBy(xpath = "//input[@type = 'email']")
    WebElement inputEmail;

    @FindBy(css = "#cb-login-continue-button")
    WebElement continueBtn;

    void enterEmail(String email){
        inputEmail.sendKeys(email);
    }

    @FindBy(css="#cb-otp-btn")
    WebElement submitBtn;

    void clickContinue(){
        continueBtn.click();
    }

    void clickSubmitBtn(){
        submitBtn.click();
    }
}
