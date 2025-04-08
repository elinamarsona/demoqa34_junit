package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;


public class TestBase {

    @BeforeAll
    static void setupConfig() {
        Configuration.pageLoadStrategy = "eager";
        //Configuration.holdBrowserOpen = true;

    }

    @AfterEach
    void afterEach() {
        Selenide.closeWebDriver();
    }
}

