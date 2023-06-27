package org.example;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class FirefoxStabndAloneTest1 {
    @Test
    public static void triggerChrome1() throws MalformedURLException {

        URL url = new URL("http://localhost:4444/wd/hub");
        DesiredCapabilities cap = DesiredCapabilities.firefox();
        //RemoteWebDriver
        RemoteWebDriver driver = new RemoteWebDriver(url, cap);
        driver.get(String.valueOf("www.google.com"));
        System.out.println(driver.getTitle());
    }
}