package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.LoginInPage;

@DisplayName("Страница авториации")
public class LoginInTest extends TestBase{

    @CsvSource(value = {
            "ekulikova, Q!W@e3r4",
            "username, password"
    })
    @ParameterizedTest(name = "Авторизация под пользователем {0} с паролем {1}")
    @DisplayName("Проверка авторизации c правильным паролем с помощью @CsvSource")
     void userNiceAuthTest(String login, String pass){
             LoginInPage.openPage()
                     .usernameSet(login)
                     .passwordSet(pass)
                     .submitBtn()
                     .menuClick()
                     .profileClick()
                     .usernameCheck(login);
    }

    @ValueSource(strings = {
            "username", "ekulikova", "ekulikova1"
    })
    @ParameterizedTest(name = "Авторизация под пользователем  {0} без пароля")
    @DisplayName("Проверка авторизации без пароля с помощью @ValueSource")
    void withoutPassTest(String login){
        LoginInPage.openPage()
                .usernameSet(login)
                .submitBtn()
                .usernameGet(login);
    }

    @CsvFileSource(resources = "/regisration.csv")
    @ParameterizedTest(name = "Авторизация под пользователем  {0} с неправильным паролем {1}")
    @DisplayName("Проверка авторизации c неправильным паролем с помощью @CsvFileSource")
    void userBadAuthTest(String login, String pass){
             LoginInPage.openPage()
                     .usernameSet(login)
                     .passwordSet(pass)
                     .submitBtn()
                     .logPassError("Неверные учетные данные пользователя");
    }


}
