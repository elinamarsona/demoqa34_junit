package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.CreateNewAccountPage;

import java.util.Locale;

@DisplayName("Регистрация пользователя")
public class CreateNewAccountTest extends TestBase {

    private final Faker faker = new Faker(new Locale("en"));
    String username = faker.name().username(),
            password = faker.name().username();


    @DisplayName("Регистрация нового пользователя")
    @Test
    void signUpUser(){
        CreateNewAccountPage.openPage()
                .clickRegisterBtn()
                .username(username)
                .password(password)
                .passwordSubmit(password)
                .registerBtn()
                .successfullyMessage("Congratulations! You've registered!");

    }

    @DisplayName("Повторная регистрация пользователя")
    @Test
    void repeatSignUpUser(){
        CreateNewAccountPage.openPage()
                .clickRegisterBtn()
                .username(username)
                .password(password)
                .passwordSubmit(password)
                .registerBtn()
                .repeatErrorMessage("Username `" + username + "` already exists");
    }

    @DisplayName("Неверный ввод подтверждения пароля")
    @Test
    void incorrectConfirmPassSignUpUser(){
        CreateNewAccountPage.openPage()
                .clickRegisterBtn()
                .username(username)
                .password(password)
                .passwordSubmit(password + "1")
                .registerBtn()
                .incorrectConfirmPassErrorMessage("Passwords should be equal");
    }
}
