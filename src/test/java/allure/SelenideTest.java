package allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.util.Map;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.linkText;

@Tag("remote")
public class SelenideTest extends BaseTest {



    @Test
    public void testIssueSearch() throws MalformedURLException {
//        SelenideLogger.addListener("allure", new AllureSelenide());
//        Configuration.remote="https://user1:1234@selenoid.autotests.cloud/wd/hub";
//        Configuration.browser="chrome";
//        Configuration.browserVersion="100.0";
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//
//        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
//                "enableVNC", true,
//                "enableVideo", true
//        ));
//
//        Configuration.browserCapabilities=capabilities;

        Selenide.open("https://github.com/");
        Selenide.sleep(5000);
        $(".header-search-button").click();
        $("#query-builder-test").sendKeys("eroshenkoam/allure-example");
        $("#query-builder-test").submit();

        $(linkText("eroshenkoam/allure-example")).click();
        $("#issues-tab").click();
        $(withText("#80")).should(Condition.exist);
    }
}
