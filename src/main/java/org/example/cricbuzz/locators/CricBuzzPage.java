package org.example.cricbuzz.locators;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CricBuzzPage {
    WebDriver driver;
    public CricBuzzPage(WebDriver driver){
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a[contains(text(), 'table')]")
    WebElement table;

    @FindBy(css = "a#cb-plus-user-icon")
    WebElement account_login;

    @FindBy(xpath = "//a[@title='ICC Cricket World Cup 2023 Matches']")
    WebElement matchesBtn;

    @FindBy(xpath = "//a[text()='Stats']")
    WebElement statsBtn;

    @FindBy(css = "div#rankingDropDown")
    WebElement rankingDropDown;

    public void clickWebElement(){
        table.click();
    }


    public void scrollScreen(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)");
    }

    public void clickLogin(){
        account_login.click();
    }

    public void clickMatchesBtn(){
        matchesBtn.click();
    }

    public void clickStatsBtn(){
        statsBtn.click();
    }

    public WebElement getRankingDropDown(){
        return rankingDropDown;
    }
}
