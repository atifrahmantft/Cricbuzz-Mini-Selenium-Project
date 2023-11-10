package org.example.cricbuzz.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class StatPage {
    WebDriver driver;
    public StatPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='cb-text-link']")
    List<WebElement> most_runs;

    @FindBy(xpath = "//a[contains(text(), 'Most Sixes')]")
    WebElement mostSixesBtn;

    @FindBy(xpath = "//a[@class='cb-text-link']")
    List<WebElement> most_sixes;


    public List<WebElement> getMostRuns(){
        return most_runs;
    }


    public List<WebElement> getMostSixes(){
        return most_sixes;
    }

    public void clickMostSixesBtn(){
        mostSixesBtn.click();
    }
}
