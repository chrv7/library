package ru.chirva.project.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author Alexandr Chirva
 */
public class Book {

    private int id;

    private int person_id;

    @NotEmpty(message = "Название книги не должно быть пустым!")
    @Size(min = 2, max = 40, message = "Название книги должно содержать от 2 до 40 символов!")
    private String name;

    @Pattern(regexp = "[А-Я][а-я]+ [А-Я][а-я]+", message = "Имя автора должно соответствовать формату: Иванов Иван")
    private String author;

    @Min(value = 1901, message = "Год написания книги должен быть больше, чем 1901!")
    private int yearOfWriting;

    public Book() {}

    public Book(int id, int person_id, String name, String author, int yearOfWriting) {
        this.id = id;
        this.person_id = person_id;
        this.name = name;
        this.author = author;
        this.yearOfWriting = yearOfWriting;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearOfWriting() {
        return yearOfWriting;
    }

    public void setYearOfWriting(int yearOfWriting) {
        this.yearOfWriting = yearOfWriting;
    }
}
