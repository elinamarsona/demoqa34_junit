package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CreateNewAccountPage {

    public static CreateNewAccountPage openPage() {
        open("https://auth.niffler.qa.guru");
        return new CreateNewAccountPage();
    }

    public static CreateNewAccountPage clickRegisterBtn() {
        $("#register-button").click();
        $(".header").shouldHave(text("Sign up"));
        return new CreateNewAccountPage();
    }

    private final SelenideElement username = $("#username"),
            password = $("#password"),
            passwordSubmit = $("#passwordSubmit"),
            registerBtn = $("#register-button"),
            repeatErrorMessage = $(".form__error"),
            incorrectConfirmPassErrorMessage = $(".form__error"),
            successfullyMessage = $(".form");

    public CreateNewAccountPage username(String value) {
        username.setValue(value);
        return this;
    }

    public CreateNewAccountPage password(String value) {
        password.setValue(value);
        return this;
    }

    public CreateNewAccountPage passwordSubmit(String value) {
        passwordSubmit.setValue(value);
        return this;
    }

    public CreateNewAccountPage registerBtn() {
        registerBtn.click();
        return this;
    }

    public CreateNewAccountPage repeatErrorMessage(String value) {
        repeatErrorMessage.shouldHave(text(value));
        return this;
    }

    public CreateNewAccountPage incorrectConfirmPassErrorMessage(String value) {
        incorrectConfirmPassErrorMessage.shouldHave(text(value));
        return this;
    }

    public CreateNewAccountPage successfullyMessage(String value) {
        successfullyMessage.shouldHave(text(value));
        return this;
    }
}
