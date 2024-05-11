package studi.kasus.java.v2.repository;

import studi.kasus.java.v2.entity.Book;
import studi.kasus.java.v2.entity.LibraryMember;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class LibraryRepository {
    private List<Book> books;
    private Map<Book, Integer> bookQuantity;
    private List<LibraryMember> members;
    private Map<LibraryMember, List<Book>> memberTransactions;

    public LibraryRepository() {
        this.books = new ArrayList<>();
        this.bookQuantity = new HashMap<>();
        this.members = new ArrayList<>();
        this.memberTransactions = new HashMap<>();
    }
}
