package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.LoginInPage;

@DisplayName("Страница авториации")
public class LoginInTest extends TestBase{

    @CsvSource(value = {
            "ekulikova, Q!W@e3r4",
            "username, password"
    })


    @ParameterizedTest(name = "Авторизация под пользователем {0} с паролем {1}")
    @DisplayName("Проверка авторизации c правильным паролем")
     void userNiceAuthTest(String login, String pass){
             LoginInPage.openPage()
                     .usernameSet(login)
                     .passwordSet(pass)
                     .submitBtn()
                     .menuClick()
                     .profileClick()
                     .usernameCheck(login);
    }

    @CsvSource(value = {
            "ekulikova, Q!W@e3r41",
            "username, password1"
    })

    @ParameterizedTest(name = "Авторизация под пользователем  {0} с паролем {1}")
    @DisplayName("Проверка авторизации c неправильным паролем")
    void userBadAuthTest(String login, String pass){
             LoginInPage.openPage()
                     .usernameSet(login)
                     .passwordSet(pass)
                     .submitBtn()
                     .logPassError("Неверные учетные данные пользователя");
    }


}
