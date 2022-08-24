package org.example.pageobject.pages;

import com.codeborne.selenide.SelenideElement;
import org.example.pageobject.pages.modules.ProfileDropDownModule;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    private SelenideElement profileDropDownButton = $(By.xpath("//summary[@class=\"Header-link\"]/img"));

    public ProfileDropDownModule openProfileDropDown() {
        profileDropDownButton.click();
        return new ProfileDropDownModule();
    }
}
