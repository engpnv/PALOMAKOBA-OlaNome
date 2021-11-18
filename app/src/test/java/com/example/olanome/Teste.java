package com.example.olanome;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Teste {

    private AndroidDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "K7AXB60350088V6");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        desiredCapabilities.setCapability("appPackage", "com.example.olanome");
        desiredCapabilities.setCapability("appActivity", "com.example.olanome.MainActivity");

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
    }

    @Test
    public void testarSpinner() {
        MobileElement el1 = (MobileElement) driver.findElementById("com.example.olanome:id/et_nome");
        el1.sendKeys("Pablo");
        MobileElement el2 = (MobileElement) driver.findElementById("com.example.olanome:id/bt_ok");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementById("com.example.olanome:id/tv_nomeInserido");
        el3.click();
        Assert.assertEquals("Olá, Bem vindo Pablo",el3.getText());

        MobileElement el4 = (MobileElement) driver.findElementById("com.example.olanome:id/et_nome");
        el4.clear();
        el4.sendKeys("Ana");
        MobileElement el5 = (MobileElement) driver.findElementById("com.example.olanome:id/sp_sexo");
        el5.click();
        MobileElement el6 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[2]");
        el6.click();
        (new TouchAction(driver)).tap(740, 1264).perform();
        MobileElement el7 = (MobileElement) driver.findElementById("com.example.olanome:id/tv_nomeInserido");
        el7.click();

        Assert.assertEquals("Olá, Bem vinda Ana",el7.getText());

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

