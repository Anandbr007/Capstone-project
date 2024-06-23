package com.himalaya.tests;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import com.himalaya.base.ExcelRead;
import com.himalaya.base.ReusableFunctions;
import com.himalaya.pom.AccountDashboardPOM;
import com.himalaya.pom.CartPOM;
import com.himalaya.pom.CheckoutPOM;
import com.himalaya.pom.HimalayaGlobalPOM;
import com.himalaya.pom.HomePagePOM;
import com.himalaya.pom.LoginPOM;
import com.himalaya.pom.ProductPOM;
import com.himalaya.pom.RegisterPOM;
import com.himalaya.pom.SearchResultsPOM;
import com.himalaya.pom.StoreLocatorPOM;
import com.himalaya.utilities.ExtentReportsListener;



/**
 * Base test class to initialize WebDriver, data providers, and common objects.
 */
@Listeners(com.himalaya.utilities.ExtentReportsListener.class)
public class BaseTest implements ITestListener {
    ExtentReportsListener extentReportsListener = new ExtentReportsListener();
    public static WebDriver driver;
    public ReusableFunctions reusableFunctions;
    public LoginPOM login;
    public HomePagePOM home;
    public SearchResultsPOM searchResult;
    public StoreLocatorPOM store;
    public ProductPOM product;
    public CartPOM cart;
    public AccountDashboardPOM account;
    public CheckoutPOM checkout;
    public RegisterPOM reg;
    public HimalayaGlobalPOM global;

    /**
     * Method to execute before the test class.
     */
    @BeforeClass
    public void before() {
        // Initialize reusable functions and browser invocation before the test class
        driver = ReusableFunctions.invokeBrowser();
        reusableFunctions = new ReusableFunctions(driver);
        reusableFunctions.openBrowser("SiteURL");
        home = new HomePagePOM(driver);
        login = new LoginPOM(driver);
        searchResult = new SearchResultsPOM(driver);
        store = new StoreLocatorPOM(driver);
        product = new ProductPOM(driver);
        cart = new CartPOM(driver);
        checkout = new CheckoutPOM(driver);
        reg = new RegisterPOM(driver);
        global=new HimalayaGlobalPOM(driver);
    }

    /**
     * Data provider for valid login data.
     */
    @DataProvider(name = "validData")
    public String[][] validdata() throws IOException {
        String path = System.getProperty("user.dir") + "\\TestData\\Logindata.xlsx";
        String sheet = "Sheet1";
        return ExcelRead.excelHandling(path, sheet);
    }

    /**
     * Data provider for invalid login data.
     */
    @DataProvider(name = "invalidData")
    public String[][] invaliddata() throws IOException {
        String path = System.getProperty("user.dir") + "\\TestData\\Logindata.xlsx";
        String sheet = "Sheet2";
        return ExcelRead.excelHandling(path, sheet);
    }

    /**
     * Data provider for address data.
     */
    @DataProvider(name = "address")
    public String[][] Data() throws IOException {
        String path = System.getProperty("user.dir") + "\\TestData\\Addressdata.xlsx";
        String sheet = "Sheet1";
        return ExcelRead.excelHandling(path, sheet);
    }

    /**
     * Data provider for registration data.
     */
    @DataProvider(name = "register")
    public String[][] getRegisterdata() throws IOException {
        String path = System.getProperty("user.dir") + "\\TestData\\Registerdetails.xlsx";
        String sheetName = "Sheet1";
        return ExcelRead.excelHandling(path, sheetName);
    }

    /**
     * Method to capture screenshot in case of test pass or failure.
     */
    @AfterMethod
    public void captureScreenshotOfFail(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            try {
                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                Date d1 = new Date();
                FileUtils.copyFile(screenshot, new File(System.getProperty("user.dir") + "/screenshotsFail/" + d1.getTime() + "failed.jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                Date d1 = new Date();
                FileUtils.copyFile(screenshot, new File(System.getProperty("user.dir") + "/screenshotsPass/" + d1.getTime() + "passed.jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Method to close the browser after the test class.
     */
    @AfterClass
    public void teardown() {
        driver.quit();
    }

}
		






