package common.tests;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import screens.CommonScreen;
import screens.HomeScreen;
import screens.LeagueScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import java.lang.reflect.Method;

import java.net.URL;
import utilities.ConfigReader;
import utilities.DriverUtilities;
import utilities.GeneralUtilities;

public class BaseTest {
  public AppiumDriver<MobileElement> driver;
  private ExtentReports extent;
  public ExtentTest test;

  public HomeScreen hs;
  public LeagueScreen ls;
  public CommonScreen cs;
  public DriverUtilities du;
  public GeneralUtilities gu = new GeneralUtilities();


  @BeforeClass
  public void setup() throws Exception {

    ExtentSparkReporter sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/ExtentReport.html");
    sparkReporter.config().setDocumentTitle("Appium Test Report");
    sparkReporter.config().setReportName("My Appium Test Report");
    sparkReporter.config().setTheme(com.aventstack.extentreports.reporter.configuration.Theme.STANDARD);

    extent = new ExtentReports();
    extent.attachReporter(sparkReporter);

    ConfigReader configReader = new ConfigReader("src/test/resources/config.properties");

    DesiredCapabilities caps = new DesiredCapabilities();
    // Set desired capabilities.
    caps.setCapability(MobileCapabilityType.PLATFORM_NAME, configReader.getProperty("platformName"));
    caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, configReader.getProperty("platformVersion"));
    caps.setCapability(MobileCapabilityType.DEVICE_NAME, configReader.getProperty("deviceName"));
    caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, configReader.getProperty("automationName"));
    caps.setCapability(MobileCapabilityType.APP, gu.getFilePath(configReader.getProperty("app")));
    caps.setCapability(MobileCapabilityType.FULL_RESET, configReader.getProperty("fullReset"));
    driver = new AppiumDriver<>(new URL(configReader.getProperty("appiumUrl")), caps);
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    du = new DriverUtilities(driver);
    cs = new CommonScreen(du);
    hs = new HomeScreen(du);
    ls = new LeagueScreen(du);
  }

  @BeforeMethod
  public void beforeMethod(Method method) {
    test = extent.createTest(method.getName());
  }

  @AfterMethod
  public void afterMethod(ITestResult result) {
    if (result.getStatus() == ITestResult.FAILURE) {
      test.fail(result.getThrowable());
    } else if (result.getStatus() == ITestResult.SKIP) {
      test.skip("Test Skipped: " + result.getThrowable());
    } else {
      test.pass("Test passed");
    }
  }


  @AfterClass
  public void teardown() {
    if (driver != null) {
      driver.quit();
    }
    extent.flush();
  }

}
