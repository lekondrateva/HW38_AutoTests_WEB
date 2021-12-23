package com.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public record FillTheFieldPage (WebDriver webDriver){
    public void findFieldAndInput (String xpath, String data) {
        final var nameInput = webDriver.findElement(By.xpath(xpath));
        nameInput.sendKeys(data);
    }
}
