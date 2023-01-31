package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSerachPage {

    public GoogleSerachPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(name="q")
    public WebElement searchBox;

    @FindBy(linkText = "About")
    public WebElement aboutLink;

    @FindBy(xpath = "//a[@class='pHiOh']")
    public WebElement footerLinks;
}
