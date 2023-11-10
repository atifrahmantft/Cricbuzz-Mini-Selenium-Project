package org.example.cricbuzz.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class RankingsPage {
    WebDriver driver;
    public RankingsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a#teams-tab")
    WebElement teamsTab;

    @FindBy(css = "a#teams-t20s-tab")
    WebElement teamsT20Tab;

    public void clickTeamsTab(){
        teamsTab.click();
    }
    public void clickTeamsT20Tab(){
        teamsT20Tab.click();
    }

    public List<String> getRankingT20Page(){
        List<WebElement> elements = driver.findElements(By.xpath("(//div[@class=\"cb-col cb-col-50 cb-lst-itm-sm text-left\"])[position() >=30 and position() < 40]"));
        List<String> strings = new ArrayList<>();
        for(WebElement element : elements){
            strings.add(element.getText());
        }
        return strings;
    }
}
