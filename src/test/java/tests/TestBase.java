package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;



import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestBase {



    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://trendrealty.ru";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }

    @BeforeEach //избавялемся от попапа выбора города
    void choseCity() {
        openMainPage();
    }

    public TestBase openMainPage(){
        open("/");
        $(".welcomecity-select__buttons").$(byText("Санкт-Петербург")).click();

        return this;
    }

    @AfterEach
    void closeDriver() {
        Selenide.closeWebDriver();
    }
}
