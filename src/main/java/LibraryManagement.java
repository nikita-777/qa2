import model.Book;
import model.Library;

public class LibraryManagement {
    public static void main(String[] args) {
        Library library = new Library("Hacker Lib", "Bolderajs");

        library.addBook(new Book("How to be dead", "Dmitry"));
        library.addBook(new Book("How to buy hlebushek", "USSR"));
        library.addBook(new Book("Dance, bebbbi, dance", "Alice"));

        for (Book book: library.getBooks()) {
            System.out.println(book.getName());
        }
    }


}
