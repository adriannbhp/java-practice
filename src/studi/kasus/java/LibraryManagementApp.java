package studi.kasus.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class LibraryMember {
    private String memberId; // Java Fundamentals: Menggunakan tipe data String untuk ID anggota perpustakaan
    private String name; // Java Fundamentals: Menggunakan tipe data String untuk nama anggota perpustakaan
    private List<Book> borrowedBooks; // Java Fundamentals: Menggunakan ArrayList untuk menyimpan buku yang dipinjam oleh anggota

    public LibraryMember(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }
}

// Java Fundamentals: Membuat kelas Library untuk merepresentasikan perpustakaan
class Library {
    private List<Book> books; // Java Fundamentals: Menggunakan ArrayList untuk menyimpan daftar buku dalam perpustakaan
    private Map<Book, Integer> bookQuantity; // Java Fundamentals: Menggunakan HashMap untuk menyimpan jumlah salinan buku dalam perpustakaan
    private List<LibraryMember> members; // Java Fundamentals: Menggunakan ArrayList untuk menyimpan daftar anggota perpustakaan
    private Map<LibraryMember, List<Book>> memberTransactions; // Java Fundamentals: Menggunakan HashMap untuk menyimpan riwayat transaksi anggota perpustakaan

    // Java Generics: Constructor untuk membuat object perpustakaan
    public Library() {
        // Inisialisasi properti-properti perpustakaan
        this.books = new ArrayList<>();
        this.bookQuantity = new HashMap<>();
        this.members = new ArrayList<>();
        this.memberTransactions = new HashMap<>();
    }

    // Java Generics: Method untuk menambahkan buku ke dalam perpustakaan dengan jumlah tertentu
    public void addBook(Book book, int quantity) {
        books.add(book);
        bookQuantity.put(book, quantity);
    }

    // Java Generics: Method untuk menambahkan anggota baru ke dalam perpustakaan
    public void addMember(LibraryMember member) {
        members.add(member);
        memberTransactions.put(member, new ArrayList<>());
    }

    // Java Generics: Method untuk meminjam buku oleh anggota perpustakaan
    public void borrowBook(LibraryMember member, Book book) {
        if (bookQuantity.containsKey(book) && bookQuantity.get(book) > 0) {
            book.setAvailableCopies(book.getAvailableCopies() - 1);
            member.getBorrowedBooks().add(book);
            memberTransactions.get(member).add(book);
            bookQuantity.put(book, bookQuantity.get(book) - 1 );
            System.out.println("Book borrowed successfully by " + member.getName() + ": " + book.getTitle());
        } else {
            System.out.println("Book not available for borrowing: " + book.getTitle());
        }
    }

    // Java Generics: Method untuk mengembalikan buku oleh anggota perpustakaan
    public void returnBook (LibraryMember member, Book book) {
        if (member.getBorrowedBooks().contains(book)) {
            book.setAvailableCopies(book.getAvailableCopies() + 1);
            member.getBorrowedBooks().remove(book);
            memberTransactions.get(member).remove(book);
            bookQuantity.put(book, bookQuantity.get(book) + 1 );
            System.out.println("Book returned successfully by " + member.getName() + ": " + book.getTitle());
        } else {
            System.out.println("Book not borrowed by: " + book.getTitle());
        }
    }

    // Java Standard Classes: Method untuk menampilkan riwayat transaksi anggota perpustakaan
    public void displayMemberTransactions(LibraryMember member) {
        List<Book> transactions = memberTransactions.get(member);
        if (transactions != null && !transactions.isEmpty() ) {
            System.out.println("Transaction history for " + member.getName() + ":");
            for (Book book : transactions) {
                System.out.println("- " + book.getTitle());
            }
        } else {
            System.out.println("No transaction history for " + member.getName());
        }
    }
}
public class LibraryManagementApp {
    public static void main(String[] args) {
        Library library = new Library();

        // Adding books to the library
        Book book1 = new Book("Java Programming", "John Doe", "1234567890", 2022, 5);
        Book book2 = new Book("Data Structures and Algorithms", "Jane Smith", "0987654321", 2023, 3);
        library.addBook(book1, 5);
        library.addBook(book2, 3);

        // Adding library members
        LibraryMember member1 = new LibraryMember("001", "Alice");
        LibraryMember member2 = new LibraryMember("002", "Bob");
        library.addMember(member1);
        library.addMember(member2);

        // Borrowing books
        library.borrowBook(member1, book1);
        library.borrowBook(member1, book2);
        library.borrowBook(member2, book1);
        library.borrowBook(member2, book2);

        // Returning books
        library.returnBook(member1, book1);
        library.returnBook(member2, book2);

        // Displaying transaction history
        library.displayMemberTransactions(member1);
        library.displayMemberTransactions(member2);
    }
}
