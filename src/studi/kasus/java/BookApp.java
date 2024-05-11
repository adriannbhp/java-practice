package studi.kasus.java;

import java.util.ArrayList; // Java Standard Classes : Mengimpor Class ArrayList untuk menyimpan koleksi buku
import java.util.HashMap; // Java Standard Classes : Mengimpor Class HashMap untuk menyimpan informasi peminjaman buku

class Book {

    // Java OOP : Menerapkan konsep encapsulation dengan mendeklasrasikan property private
    // Java Fundamentals : Menerapkan konsep data types seperti String dan int
    // Java Generics: Tidak ada penggunaan generics dalam kelas Book
    private String title;
    private String author;
    private String ISBN;
    private int year;
    private int availableCopies;

    // Java OOP : Menerapkan konsep constructor, getter, dan setter

    public Book(String title, String author, String ISBN, int year, int availableCopies) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.year = year;
        this.availableCopies = availableCopies;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }

    static class Library<T extends Book> {

        // Java Standard Classes : Menggunakan ArrayList dan HashMap untuk menyimpan informasi buku dan peminjaman
        private ArrayList<T> books; // ArrayList untuk menyimpan daftar buku dalam Library
        private HashMap<T, Boolean> bookAvailability; //HashMap untuk menyimpan status ketersediaan buku

        // Constructor untuk membuat object Library
        public Library() {
            books = new ArrayList<>(); // Inisialisasi ArrayList
            bookAvailability = new HashMap<>(); // Inisialisasi HashMap
        }

        // Java Fundamentals : Menggunakan operasi dasar pada ArrayList seperti add()
        // Java Standard Classes : Menggunakan operasi dasar pada HashMap seperti put()

        // Method untuk menambahkan buku ke dalam Library
        public void addBook(T book) {
            books.add(book);
            bookAvailability.put(book, true);
        }

        // Java Fundamentals : Penggunaan perulangan for-each untuk iterasi ArrayList
        // Java Fundamentals : Penggunaan Method equals() untuk membandingkan String

        // Method untuk mencari buku berdasarkan judul menggunakan for-each
        public T searchBook(String title) {
            for (T book : books) {
                if (book.getTitle().equals(title)) {
                    return book;
                }
            }
            return null;
        }

        // Java Standard Classes : Menggunakan method get() untuk mendapatkan nilai dari HashMap
        // Java Standard Classes : Menggunakan method put() untuk memperbarui nilai dalam HashMap
        // Java OOP : Menggunakan method setter untuk mengubah nilai property private

        // Method untuk meminjam buku
        public void borrowBook(T book) {
            if(bookAvailability.get(book)) { // Periksa ketersediaan buku
                bookAvailability.put(book, false); // Update status ketersediaan menjadi false
                book.setAvailableCopies(book.getAvailableCopies() - 1); // Kurangi jumlah salinan buku yang tersedia
                System.out.println("Book borrowed successfully!"); // Tampilkan pesan berhasil meminjam buku
            } else {
                System.out.println("Book not available for borrowing."); // Tampilkan ketika buku tidak tersedia
            }
        }
        // Method untuk mengembalikan buku
        public void returnBook(T book) {
            bookAvailability.put(book, true); // Update status ketersediaan buku menjadi true
            book.setAvailableCopies(book.getAvailableCopies() + 1); // Tambahkan jumlah salinan buku yang tersedia
            System.out.println("Book returned successfully"); // Tampilkan pesan berhasil mengembalikan buku
        }
    }
}

public class BookApp {
    // Java Fundamentals: Main method harus static dan memiliki signature yang benar
    public void main(String[] args) {
        // Create Library object
        Book.Library<Book> library = new Book.Library<>(); // Membuat object perusahaan

        // Create some books
        Book book1 = (new Book("Java Programming", "Eko", "12312321", 2021, 3)); // Membuat Object buku
        Book book2 = (new Book("Data Structure and Algorithms", "Adrian", "124324235", 2023, 7)); // Membuat Object buku


        // Add books to the library
        library.addBook(book1); // Menambahkan buku ke dalam perpustakaan
        library.addBook(book2); // Menambahkan buku ke dalam perpustakaan

        // Search for a book
        Book foundBook = library.searchBook("Java Programming"); // Mencari buku berdasarkan judul
        if(foundBook != null) { // Jika buku ditemukan
            System.out.println("Book found: " + foundBook.getTitle()); // Tampilkan judul buku yang ditemukan
        } else {
            System.out.println("Book not found."); // Tampilkan pesan buku tidak ditemukan
        }

        // Borrow a book
        if (foundBook != null) { // Jika buku ditemukan
            library.borrowBook(foundBook); // Meminjam buku
        }
    }
}
