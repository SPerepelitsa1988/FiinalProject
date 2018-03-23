package com.telesens.automationpractice.appmanager.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    protected void type(WebElement inputField, String value) {
        inputField.click();
        inputField.clear();
        inputField.sendKeys(value);
    }

    protected  void click(WebElement button) {
        button.click();
    }

    protected void selectByValue(WebElement select, String value) {
        new Select(select).selectByValue(value);
    }

    protected void selectByText(WebElement select, String text) {
        new Select(select).selectByVisibleText(text);
    }

    protected void allertAccept() {
        driver.switchTo().alert().accept();
    }

    protected List<String> extractTextFromElements(List<WebElement> elements) {
        List<String> textList = new ArrayList<>(elements.size());
        for(WebElement el : elements)
            textList.add(el.getText().trim());

        return textList;
    }
}
