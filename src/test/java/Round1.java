import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import static io.appium.java_client.touch.offset.PointOption.point;
import static io.appium.java_client.touch.WaitOptions.waitOptions;

public class Round1 {
    public AppiumDriver<MobileElement> driver;
    public WebDriverWait wait;

    //Elements
    String tutorialActivity = "//android.widget.FrameLayout/android.widget.RelativeLayout/" + "android.widget.FrameLayout/android.widget.ImageView";

    @BeforeMethod
    public void setup () throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "AB_Landscape");
        caps.setCapability("udid", "emulator-5554"); // Source: CMD -> "adb devices"
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "7.0");
        caps.setCapability("skipUnlock", "true");
        caps.setCapability("appPackage", "com.rovio.angrybirds");
        caps.setCapability("appActivity", "com.rovio.fusion.App");
        caps.setCapability("noReset", "false");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void basicTest () throws InterruptedException{
    //All code goes here

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.View")));

        Thread.sleep(10000);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(PointOption.point(1150, 780)).perform();

        Thread.sleep(10000);

        TouchAction touchAction2 = new TouchAction(driver);
        touchAction2.press(PointOption.point(610, 440)).moveTo(PointOption.point(200, 600)).release().perform();

        Thread.sleep(17000);



    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
