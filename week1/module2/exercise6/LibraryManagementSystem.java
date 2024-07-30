package week1.module2.exercise6;
import java.util.ArrayList;
import java.util.List;

public class LibraryManagementSystem {
    private List<Book> books;

    public LibraryManagementSystem() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public Book linearSearchByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null; 
    }

    public Book binarySearchByTitle(String title) {
        int left = 0;
        int right = books.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Book midBook = books.get(mid);

            int comparison = title.compareToIgnoreCase(midBook.getTitle());

            if (comparison == 0) {
                return midBook;
            } else if (comparison < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return null; 
    }

    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();

        library.addBook(new Book("B001", "Java Programming", "John Doe"));
        library.addBook(new Book("B002", "Data Structures", "Jane Smith"));
        library.addBook(new Book("B003", "Algorithms", "Alice Johnson"));

        library.books.sort((b1, b2) -> b1.getTitle().compareToIgnoreCase(b2.getTitle()));

        System.out.println("Linear Search:");
        System.out.println(library.linearSearchByTitle("Data Structures"));

        System.out.println("Binary Search:");
        System.out.println(library.binarySearchByTitle("Data Structures"));
    }
}
