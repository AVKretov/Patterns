package ru.netology;

import org.openqa.selenium.Keys;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {


    void inputRandomCity() {
        $x("//input[@placeholder='Город']").setValue(LoginPageData.randomPerson().getCity());

    }


    void inputDate(String date) {
        $x("//input[@placeholder='Дата встречи']").sendKeys(Keys.CONTROL + "A");
        $x("//input[@placeholder='Дата встречи']").sendKeys(Keys.BACK_SPACE);
        $x("//input[@placeholder='Дата встречи']").
                setValue(date);
    }

    void inputPlusThreeDayDate() {
        $x("//input[@placeholder='Дата встречи']").sendKeys(Keys.CONTROL + "A");
        $x("//input[@placeholder='Дата встречи']").sendKeys(Keys.BACK_SPACE);
        $x("//input[@placeholder='Дата встречи']").
                setValue(LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));

    }

    void inputRandomName() {
        $x("//input[@name='name']").setValue(LoginPageData.randomPerson().getName());
    }


    void inputRandomPhone() {
        $x("//input[@name='phone']").
                setValue(LoginPageData.randomPerson().getPhone());
    }


    void checkAgreement() {
        $x("//*[@data-test-id='agreement']").click();
    }


    void pressButton() {
        $x("//span[text()='Запланировать']").click();

    }


    void succesNewDate() {
        $("[data-test-id='replan-notification'] .notification__content").shouldBe(visible)
                .shouldHave(text("У вас уже запланирована встреча на другую дату. Перепланировать?"));
        $("[data-test-id='replan-notification'] .button").click();
    }
}
