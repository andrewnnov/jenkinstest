package allure;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class BaseTest {

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        //SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.remote="https://user1:1234@selenoid.autotests.cloud/wd/hub";
        Configuration.browser="chrome";
        Configuration.browserVersion="100.0";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //capabilities.setCapability("browserName", "chrome");
        //capabilities.setCapability("browserVersion", "100.0");
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        Configuration.browserCapabilities=capabilities;
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last_screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

    }
}
