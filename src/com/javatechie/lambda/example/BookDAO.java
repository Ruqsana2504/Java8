package src.com.javatechie.lambda.example;

import com.javatechie.lambda.example.Book;

import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    public List<Book> getBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book(101, "Core Java", 400));
        books.add(new Book(893, "WebService", 300));
        books.add(new Book(275, "Spring", 200));
        books.add(new Book(363, "Hibernate", 180));
        return books;
    }
}
