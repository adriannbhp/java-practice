package studi.kasus.java.v2.test;

import org.junit.Test;
import studi.kasus.java.v2.entity.Book;
import studi.kasus.java.v2.entity.LibraryMember;
import studi.kasus.java.v2.repository.LibraryRepository;
import studi.kasus.java.v2.service.LibraryService;

import static org.junit.Assert.assertEquals;

public class LibraryServiceTest {

    @Test
    public void testBorrowBook() {
        LibraryRepository libraryRepository = new LibraryRepository();
        LibraryService libraryService = new LibraryService(libraryRepository);

        // Menyiapkan data
        Book book = new Book("Java Programming", "John Doe", "1234567890", 2022, 5);
        LibraryMember member = new LibraryMember("001", "Alice");

        // Meminjam buku
        libraryService.borrowBook(member, book);

        // Mengambil daftar buku yang dipinjam oleh anggota perpustakaan
        int borrowedBooksCount = member.getBorrowedBooks().size();

        // Menggunakan assertEquals untuk memastikan bahwa jumlah buku yang dipinjam adalah 1
        assertEquals(1, borrowedBooksCount);
    }
}
