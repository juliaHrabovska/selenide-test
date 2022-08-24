package org.example.pageobject.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private SelenideElement userName = $(By.id("login_field"));

    private SelenideElement passwordField = $(By.id("password"));

    private SelenideElement sighInButton = $(By.name("commit"));

    public LoginPage open() {
        Selenide.open("https://www.github.com/login");
        return this;
    }

    public HomePage login(String userName, String password) {
        this.userName.val(userName);
        this.passwordField.val(password);
        sighInButton.click();

        return new HomePage();
    }
}
