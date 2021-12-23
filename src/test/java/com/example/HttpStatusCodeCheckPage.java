package com.example;

import org.openqa.selenium.WebDriver;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public record HttpStatusCodeCheckPage(WebDriver webDriver) {

    public void GetResponseCode(String url) throws IOException {
        int expectedStatusCode=200;
        webDriver.get(url);
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        HttpURLConnection c = (HttpURLConnection) new URL(url).openConnection();
        // set the HEAD request with setRequestMethod
        c.setRequestMethod("HEAD");
        // connection started and get response code
        c.connect();
        int r = c.getResponseCode();
        System.out.println(r);
        assertEquals(r, expectedStatusCode);
    }
}

