package ru.chirva.project.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

/**
 * @author Alexandr Chirva
 */
public class Person {

    private int id;

    @Pattern(regexp = "[А-Я][а-я]+ [А-Я][а-я]+ [А-Я][а-я]+", message = "Ваше ФИО должно соответствовать формату: Иванов Иван Иванович")
    private String name;

    @Min(value = 1901, message = "Год рождения должен быть больше, чем 1900!")
    private int yearOfBirth;

    public Person() {}

    public Person(int id, String name, int yearOfBirth) {
        this.id = id;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }
}
