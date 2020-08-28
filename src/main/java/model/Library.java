package model;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private String name;
    private String address;
    private List<Book> books = new ArrayList<Book>();
    private List<Reader> readers = new ArrayList<Reader>();

    public Library(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Reader> getReaders() {
        return readers;
    }

    public void addBook(Book book) {
        books.add(book);
    }
    public void addReader(Reader reader){
        readers.add(reader);
    }


}
