package org.example.pageobject.pages.modules;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ProfileDropDownModule {
    private SelenideElement userInformationProfile = $(By.xpath("//strong[text()=\"juliaHrabovska\"]"));

    public String getUserInformationProfile() {
        return userInformationProfile.shouldBe(visible).text();
    }
}
