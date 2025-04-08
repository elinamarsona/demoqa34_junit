package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.*;

public class LoginInPage {

    public static LoginInPage openPage() {
        open("https://auth.niffler.qa.guru");
        $(".header").shouldHave(text("Log in"));
        return new LoginInPage();
    }

    private final SelenideElement username = $("input[name='username']"),
            password = $("input[name='password']"),
            submitBtn = $("#login-button"),
            //menuClick = $("svg[data-testid='PersonIcon']"),
            menuClick = $("button[aria-label='Menu']"),
            profileClick = $("a[href='/profile']"),
            usernameProfile = $ ("input[value]"),
            logPassError = $(".form__error");


    public LoginInPage usernameSet(String value) {
        username.setValue(value);
        return this;
    }
    public LoginInPage passwordSet(String value) {
        password.setValue(value);
        return this;
    }
    public LoginInPage submitBtn() {
        submitBtn.click();
        return this;
    }
    public LoginInPage menuClick(){
        menuClick.click();
        return this;
    }

    public LoginInPage profileClick(){
        profileClick.click();
        return this;
    }

    public LoginInPage usernameCheck(String value){
        usernameProfile.shouldHave(value(value));
        return this;
    }

    public LoginInPage logPassError(String value){
        logPassError.shouldHave(text(value));
        return this;
    }
}
