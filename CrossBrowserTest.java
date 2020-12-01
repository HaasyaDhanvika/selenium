package org.selenium.JenkinsMavenTest;
 
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
 
public class CrossBrowserTest {
    /* protected static ChromeDriver driver; */
    WebDriver driver = null;        
    String URL = "https://www.lambdatest.com";
    public static String status = "passed";    
    public static String username = "user-name";
    public static String access_key = "access-key";
    public static String expected_title = "Most Powerful Cross Browser Testing Tool Online | LambdaTest";
 
    @BeforeClass
    public void testSetUp() throws MalformedURLException {
        /* System.setProperty("webdriver.chrome.driver", "C:\\EdgeDriver\\chromedriver.exe"); */
        /*
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        */
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("build", "(Test -2) Maven Parallel Testing with Jenkins Pipeline");
        capabilities.setCapability("name", "(Test -2) Maven Parallel Testing with Jenkins Pipeline");
        capabilities.setCapability("platform", "Windows 10");
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("version","latest");
        capabilities.setCapability("tunnel",false);
        capabilities.setCapability("network",true);
        capabilities.setCapability("console",true);
        capabilities.setCapability("visual",true);
 
        driver = new RemoteWebDriver(new URL("http://" + username + ":" + access_key + "@hub.lambdatest.com/wd/hub"), capabilities);
        System.out.println("Started session");
    }
 
    @Test
    public void test_Selenium4_Geolocation() throws InterruptedException {
    driver.navigate().to(URL);
        driver.manage().window().maximize();
        try {
                String page_title = driver.getTitle();
                Assert.assertEquals(page_title, expected_title);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
 
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
