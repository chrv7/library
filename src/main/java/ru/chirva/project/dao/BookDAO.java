package ru.chirva.project.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.chirva.project.models.Book;

import java.util.List;

/**
 * @author Alexandr Chirva
 */
@Component
public class BookDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index() {
        return jdbcTemplate.query("SELECT id, name, author, year_of_writing FROM Book", new BeanPropertyRowMapper<>(Book.class));
    }

    public void save(Book book) {
        jdbcTemplate.update("INSERT INTO Book(name, author, year_of_writing) VALUES(?, ?, ?)", book.getName(),
                book.getAuthor(), book.getYearOfWriting());
    }

    public Book show(int id) {
        return jdbcTemplate.query("SELECT id, name, author, year_of_writing FROM Book WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Book.class))
                .stream().findAny().orElse(null);
    }

    public void update(int id, Book updatedBook) {
        jdbcTemplate.update("UPDATE Book SET name=? , author=?, year_of_writing=? WHERE id=?", updatedBook.getName(),
                updatedBook.getAuthor(), updatedBook.getYearOfWriting(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Book WHERE id=?", id);
    }

    public List<Book> searchBooks(int id) {
        return jdbcTemplate.query("SELECT * FROM Book WHERE person_id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Book.class));
    }

    public void dismiss(int id) {
        jdbcTemplate.update("UPDATE Book SET person_id=null where id=?", id);
    }

    public void assign(int id, int person_id) {
        jdbcTemplate.update("UPDATE BOOK SET person_id=? WHERE id=?", person_id, id);
    }
}
