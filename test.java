/////**
//// * Created by gloria on 17/1/22.
//// */
////
////
//import io.appium.java_client.AppiumDriver;
////
////
//import io.appium.java_client.MobileElement;
//import io.appium.java_client.remote.MobileCapabilityType;
//import org.openqa.selenium.By;
////import org.openqa.selenium.DeviceRotation;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.remote.CapabilityType;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
//
//import java.net.URL;
////
////
////import java.net.MalformedURLException;
////import java.net.URL;
////import java.util.HashMap;
////import java.util.concurrent.TimeUnit;
////
////public class test {
////    public static void main(String[] args) throws MalformedURLException {
//
////
////    }
////
////
////}
////import org.junit.After;
////import org.junit.Before;
////import org.junit.Test;
////import org.openqa.selenium.*;
////import org.openqa.selenium.remote.DesiredCapabilities;
////import java.net.URL;
////import java.util.concurrent.TimeUnit;
////import io.appium.java_client.AppiumDriver;
////import io.appium.java_client.MobileElement;
////import io.appium.java_client.ios.IOSDriver;
////import org.openqa.*;
//
//public class test {
//
//    private WebDriver driver;
//
//    public static void main(String[] args) throws Exception {
//
////        public void setUp() throws Exception {
//            WebDriver webDriver;
//            DesiredCapabilities capabilities = new DesiredCapabilities();
//            // capabilities.setCapability("device", "iPhone Simulator");
//            //capabilities.setCapability(CapabilityType.BROWSER_NAME,"iOS");
//            capabilities.setCapability(CapabilityType.VERSION,"11.2.2");
//            capabilities.setCapability(CapabilityType.PLATFORM,"iOS");
//            capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//            capabilities.setCapability("deviceName", "李腾のiPhone");
//            capabilities.setCapability("platformName", "ios");
//            capabilities.setCapability(MobileCapabilityType.APP,"com.tt.xinfang");
//            webDriver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"),capabilities);
////        }
//    }
//
//
//
//}

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;

import java.awt.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class test {

    private static IOSDriver driver;
    public static void main(String[] args) throws Exception {


         // 设置设备的属性
        DesiredCapabilities capabilities = new DesiredCapabilities();

        // 设置平台 Android
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("automationName", "XCUITest");
        // 设置设备的名称，真机或者模拟器的, 设备连接电脑，在命令行输入adb  devices  查看即可
        capabilities.setCapability("deviceName", "李腾のiPhone");
        // 设置Android系统的版本号，例如 4.3  4.4
        capabilities.setCapability("platformVersion", "11.2.2");
        //capabilities.setCapability("platformVersion", "6.0");
        capabilities.setCapability("udid", "65130f5b9a17e7476c90cb4cb7ed0aab6acee33a");

        // 设置apk的包名
        capabilities.setCapability("bundleId", "com.liteng.AppiuTestDemo");
//        capabilities.setCapability("bundleId", "jp.co.smbc.direct");

        // 加载驱动,ip,填写相应的ip和端口  例如   http://172.16.11.120:4720
        driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"),
                        capabilities);
        //输出判断结果
//        driver.findElement(By.id("username")).clear();
//        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.id("Confirm")).click();
        driver.findElement(By.id("WebView")).click();
        TimeUnit.SECONDS.sleep(5);
//        driver.findElementByXPath("//XCUIElementTypeLink[@name=\"关注\"]").click();
        MobileElement el2 = (MobileElement) driver.findElementByXPath("//XCUIElementTypeOther[@name=\"百度一下\"]/XCUIElementTypeSearchField");
        el2.sendKeys("hello");
        TimeUnit.SECONDS.sleep(3);
        MobileElement el3 = (MobileElement) driver.findElementByXPath("//XCUIElementTypeButton[@name=\"百度一下\"]");
        el3.click();
        TimeUnit.SECONDS.sleep(3);

//        MobileElement el4 = (MobileElement)driver.findElementsByLinkText("hello_百度翻译");
//        el4.click();

//        TimeUnit.SECONDS.sleep(5);
//        MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("1");
//        el1.click();
//        el1.click();
//        el1.click();
//        el1.click();
//        driver.switchTo().alert().accept();
//        TimeUnit.SECONDS.sleep(5);
//        MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("契約者番号");
//        el2.click();
//        MobileElement el3 = (MobileElement) driver.findElementByAccessibilityId("店・口座番号");
//        el3.click();
//        MobileElement el3 = (MobileElement)driver.findElementsByXPath("//XCUIElementTypeOther[@name=\"SMBC Mobile Application\"]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeTextField[1]");
//        el3.sendKeys("123");

    }
//    @Test
//    public void loginWithMicroBlog() throws InterruptedException {
//
////        WebElement loginButton = driver.findElement(By.id("com.zhihu.android:id/login"));
////        loginButton.click();
////        WebElement login = driver.findElement(By.id("android:id/login-wraps"));
////        login.click();
////        MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("20°大连 20°/13° ");
////        el1.click();
////        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
////        // swipe to right
////        driver.findElementById("com.jlxf.jlxfj:id/index_img_btn")
////                .click();
////        driver.findElementById("com.zhihu.android:id/btn_social").click();
////        driver.findElementById("com.zhihu.android:id/login_weibo").click();
////        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
////        Thread.sleep(15000);
//        Set<String> context = driver.getContextHandles();
//        for (String contextName : context) {
//            System.out.println(contextName);
//
//        }
//        driver.context("WEBVIEW");
//        System.out.println(driver.getPageSource());
////        driver.findElementsByClassName("android.widget.EditText").get(0).sendKeys(
////                userName);
////        driver.findElementsByClassName("android.widget.EditText").get(1).sendKeys(
////                password);
////        driver.findElementByXPath("//android.view.View[contains(@content-desc,'登录')]").click();
//
//    }
}
