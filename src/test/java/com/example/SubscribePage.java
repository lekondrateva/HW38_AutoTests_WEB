package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.restassured.RestAssured;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public record SubscribePage(WebDriver webDriver) {



    //span[@aria-labelledby='recaptcha-accessible-status']
    public void subscribe(String xpath, String email) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        final var emailInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        emailInput.sendKeys(email, Keys.ENTER);
    }

    public String getResultMessage(String xpath) {
        return webDriver.findElement(By.xpath(xpath)).getText();
    }
}
