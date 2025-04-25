package src.com.javatechie.lambda.example;

import com.javatechie.lambda.example.Book;

import java.util.Comparator;
import java.util.List;

class BookService {

    public List<Book> getBooksInSort() {
        List<Book> books = new BookDAO().getBooks();
        //second approach
//        books.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
        //3rd approach
        books.sort(Comparator.comparing(Book::getName));
        return books;
    }

    public static void main(String[] args) {
        System.out.println(new BookService().getBooksInSort());
    }

}

//First approach
//class MyComparator implements Comparator<Book> {
//
//    @Override
//    public int compare(Book o1, Book o2) {
//        return o2.getName().compareTo(o1.getName());
//    }
//}
