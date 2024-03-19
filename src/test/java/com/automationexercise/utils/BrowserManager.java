package com.automationexercise.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.IOException;

public class BrowserManager {

    public static WebDriver doBrowserSetup() throws IOException {
        WebDriver driver = null;
        String name = PropertiesLoader.loadProperty("browser.name");
        if (name.equalsIgnoreCase("Chrome")) {

            String pathExtension = PropertiesLoader.loadProperty("chrome.extension.adblock.path");
            String webDriverPath = PropertiesLoader.loadProperty("web.browser.driver");

            System.setProperty("webdriver.chrome.driver", webDriverPath);
            System.setProperty("webdriver.chrome.silentOutput", "true");
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("load-extension=" + pathExtension); //uBlock Origin
            chromeOptions.addArguments("--headless");
            driver = new ChromeDriver(chromeOptions);

        } else if (name.equalsIgnoreCase("Firefox")) {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments("--headless");
            firefoxOptions.addArguments("--private");
            driver = new FirefoxDriver(firefoxOptions);
        } else if (name.equalsIgnoreCase("Edge")) {
            EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.addArguments("--headless");
            edgeOptions.addArguments("--private");
            driver = new EdgeDriver(edgeOptions);
        }
        return driver;
    }
}
