package allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

@Tag("remote")
public class SelenideStepsTest extends BaseTest{

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE = 84;

    @Test
    public void testLambdaStep() {
        //SelenideLogger.addListener("allure", new AllureSelenide());

        step("Open main page", () ->{
            open("https://github.com/");
        });

        step("Find repo " + REPOSITORY, () -> {
            $(".header-search-button").click();
            $("#query-builder-test").sendKeys(REPOSITORY);
            $("#query-builder-test").submit();

        });

        step("Click on link of repo " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });

        step("Open issue tab ", () -> {
            $("#issues-tab").click();
        });

        step("Check issue tab with number " + ISSUE, () -> {
            $(withText("#" + ISSUE)).should(Condition.exist);
        });
    }
}
