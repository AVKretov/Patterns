package ru.netology;

import ru.netology.Person;

import com.github.javafaker.Faker;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;


public class LoginPageData {

    private final static String defaultCity = "Москва";
    private final static String defaultName = "Александр Пушкин";
    private final static String defaultPhone = "+79119998877";


    public static Person getDefaultPerson() {

        Person person = new Person();

        person.setCity(defaultCity);
        person.setName(defaultName);
        person.setPhone(defaultPhone);

        return person;
    }

    public static Person randomPerson() {

        Person person = new Person();
        Faker faker = new Faker(new Locale("ru"));

        person.setCity(faker.address().cityName());
        person.setName(faker.name().fullName());
        person.setPhone(faker.phoneNumber().cellPhone());


        return person;
    }

}



