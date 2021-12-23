package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public record UrlPage(WebDriver webDriver) {
    public void goUrl_xpath(String xpath) {
        webDriver.findElement(By.xpath(xpath)).click();
    }

    public void verifyLinkUrl(String targetUrl) {
        String curretnUrl = webDriver.getCurrentUrl();
        System.out.println(curretnUrl);
        assertEquals(curretnUrl, targetUrl);
    }

    public void verifyUrlOfElement (String xpath, String targetUrl) {
        WebElement LinkElement = webDriver.findElement(By.xpath(xpath));
        String hrefText = LinkElement.getAttribute("href");
        System.out.println(hrefText);
        assertEquals(hrefText, targetUrl);
    }
}
