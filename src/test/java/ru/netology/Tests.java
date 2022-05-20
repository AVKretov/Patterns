package ru.netology;

import java.time.*;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

class Tests {

    public String generateDate(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }


    @BeforeEach
    void setUp() {
        open("http://localhost:9999");
    }


    @Test
    void happyPath() {

        LoginPage page = new LoginPage();
        page.inputRandomCity();
        page.inputDate(generateDate(3));
        page.inputRandomName();
        page.inputRandomPhone();
        page.checkAgreement();
        page.pressButton();
        $("[data-test-id='success-notification']").shouldBe(visible)
                .shouldHave(text("Встреча успешно запланирована на "));
        page.inputDate(generateDate(6));
        page.pressButton();
        page.succesNewDate();


    }
}