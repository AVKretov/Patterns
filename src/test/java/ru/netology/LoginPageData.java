package ru.netology;

import com.github.javafaker.Faker;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


public class LoginPageData {

    public static Person randomPerson() {
        Faker faker = new Faker(new Locale("ru"));
        Person person = new Person(faker.address().cityName(),faker.name().fullName(), faker.phoneNumber().cellPhone() );




        return person;
    }
    public static String generateDate(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

}



