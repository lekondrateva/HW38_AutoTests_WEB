package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.NoSuchElementException;

public record ElementsPage (WebDriver webDriver) {
    public boolean existsElement(String xpath) {
        try {
            webDriver.findElement(By.xpath(xpath));
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }
}
