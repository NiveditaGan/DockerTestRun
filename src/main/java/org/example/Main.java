package org.example;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        URL url = new URL("http://localhost:4444/wd/hub");
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        //RemoteWebDriver
        RemoteWebDriver driver = new RemoteWebDriver(url, cap);
        driver.get("https://www.rahulshettyacademy.com/#/practice-project");
        System.out.println(driver.getTitle());
    }
}