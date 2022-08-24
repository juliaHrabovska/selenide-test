package org.example;

import com.codeborne.selenide.Selenide;
import org.example.pageobject.pages.LoginPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static org.example.props.Properties.GIT_HUB_LOGIN;
import static org.example.props.Properties.GIT_HUB_PASSWORD;

public class AppTest {
    @Test
    public void gitHubLoginSimpleTest() {
        Selenide.open("https://www.github.com/login");
        $(By.id("login_field")).val(GIT_HUB_LOGIN);
        $(By.id("password")).val(GIT_HUB_PASSWORD);
        $(By.name("commit")).click();

        $(By.xpath("//summary[@class=\"Header-link\"]/img")).click();
        String userInformation = $(By.xpath("//strong[text()=\"juliaHrabovska\"]"))
                .shouldBe(exist, Duration.ofSeconds(10)).shouldBe(visible).text();

        Assert.assertEquals("User nick is not the same",
                "juliaHrabovska", userInformation);
    }

    @Test
    public void gitHubLoginTest() {
        String userInformation = new LoginPage()
                .open()
                .login(GIT_HUB_LOGIN, GIT_HUB_PASSWORD)
                .openProfileDropDown()
                .getUserInformationProfile();
        Assert.assertEquals("User nick is not the same", "juliaHrabovska", userInformation);
    }
}
