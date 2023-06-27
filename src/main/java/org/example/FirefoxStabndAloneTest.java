package org.example;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class FirefoxStabndAloneTest {
    @BeforeTest
    public void startDockerScale() throws IOException, InterruptedException {
        DockerTasks dt = new DockerTasks();
        dt.startFile();
    }

    @AfterTest
    public void stopDocker() throws IOException, InterruptedException {
        DockerTasks dt = new DockerTasks();
        dt.stopFile();
    }
    @Test
    public static void triggerChrome() throws MalformedURLException {

        URL url = new URL("http://localhost:4444/wd/hub");
        DesiredCapabilities cap = DesiredCapabilities.firefox();
        //RemoteWebDriver
        RemoteWebDriver driver = new RemoteWebDriver(url, cap);
        driver.get(String.valueOf("https://www.rahulshettyacademy.com/#/practice-project"));
        System.out.println(driver.getTitle());
    }
}