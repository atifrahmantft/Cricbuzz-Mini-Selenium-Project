package org.example.cricbuzz.locators;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage {
    WebDriver driver;
    public GooglePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "textarea#APjFqb")
    WebElement searchField;

    @FindBy(xpath = "//h3[contains(text(), \"Cricbuzz\")]")
    WebElement cricBuzzElement;

    public void sendKeysToSearchField(String key){
        searchField.sendKeys(key + Keys.ENTER);
    }

    public void clickToElement(){
        cricBuzzElement.click();
    }
}
