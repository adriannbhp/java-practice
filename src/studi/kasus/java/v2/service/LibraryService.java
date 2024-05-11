//package studi.kasus.java.v2.service;
//
//import studi.kasus.java.v2.entity.Book;
//import studi.kasus.java.v2.entity.LibraryMember;
//import studi.kasus.java.v2.repository.LibraryRepository;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class LibraryService {
//    private LibraryRepository libraryRepository;
//
//    public LibraryService(LibraryRepository libraryRepository) {
//        this.libraryRepository = new LibraryRepository();
//    }
//
//
//    public void addBook(Book book, int quantity) {
//        books.add(book);
//        bookQuantity.put(book, quantity);
//    }
//
//    public void addMember(LibraryMember member) {
//        members.add(member);
//        memberTransactions.put(member, new ArrayList<>());
//    }
//
//    public void borrowBook(LibraryMember member, Book book) {
//        if (bookQuantity.containsKey(book) && bookQuantity.get(book) > 0) {
//            book.setAvailableCopies(book.getAvailableCopies() - 1);
//            member.getBorrowedBooks().add(book);
//            memberTransactions.get(member).add(book);
//            bookQuantity.put(book, bookQuantity.get(book) - 1 );
//            System.out.println("Book borrowed successfully by " + member.getName() + ": " + book.getTitle());
//        } else {
//            System.out.println("Book not available for borrowing: " + book.getTitle());
//        }
//    }
//
//    public void returnBook (LibraryMember member, Book book) {
//        if (member.getBorrowedBooks().contains(book)) {
//            book.setAvailableCopies(book.getAvailableCopies() + 1);
//            member.getBorrowedBooks().remove(book);
//            memberTransactions.get(member).remove(book);
//            bookQuantity.put(book, bookQuantity.get(book) + 1 );
//            System.out.println("Book returned successfully by " + member.getName() + ": " + book.getTitle());
//        } else {
//            System.out.println("Book not borrowed by: " + book.getTitle());
//        }
//    }
//
//    public void displayMemberTransactions(LibraryMember member) {
//        List<Book> transactions = memberTransactions.get(member);
//        if (transactions != null && !transactions.isEmpty() ) {
//            System.out.println("Transaction history for " + member.getName() + ":");
//            for (Book book : transactions) {
//                System.out.println("- " + book.getTitle());
//            }
//        } else {
//            System.out.println("No transaction history for " + member.getName());
//        }
//    }
//}
