import java.util.*;

public class LibraryService {
    private List<Book> books = new ArrayList<>();
    private Set<Reader> readers = new HashSet<>();
    private Set<Author> authors = new HashSet<>();
    private TreeSet<Book> sortedBooks = new TreeSet<>();
    private Map<Reader, List<Loan>> loans = new HashMap<>();

    public void addBook(Book book) {
        books.add(book);
        sortedBooks.add(book);
    }

    public void registerReader(Reader reader) {
        readers.add(reader);
    }

    public void listAllBooks() {
        for (Book b : sortedBooks) {
            System.out.println(b.getTitle() + " by " + b.getAuthor().getName() + (b.isBorrowed() ? " (Borrowed)" : "") + " - Section: " + b.getSection() + ", Genre: " + b.getGenre());
        }
    }

    public void listBorrowedBooks() {
        for (Book b : books) {
            if (b.isBorrowed()) {
                System.out.println(b.getTitle() + " by " + b.getAuthor().getName());
            }
        }
    }

    public void loanBookByIsbn(int readerId, String isbn, String dueDate) {
        Reader foundReader = null;
        for (Reader r : readers) {
            if (r.getId() == readerId) {
                foundReader = r;
                break;
            }
        }
        if (foundReader == null) {
            System.out.println("Reader not found.");
            return;
        }
        for (Book b : books) {
            if (b.getIsbn().equals(isbn)) {
                if (!b.isBorrowed()) {
                    b.setBorrowed(true);
                    Loan loan = new Loan(foundReader, b, dueDate);
                    loans.computeIfAbsent(foundReader, k -> new ArrayList<>()).add(loan);
                    System.out.println("Book loaned.");
                } else {
                    System.out.println("Book already borrowed.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void returnBookByIsbn(String isbn) {
        for (Book b : books) {
            if (b.getIsbn().equals(isbn)) {
                if (b.isBorrowed()) {
                    b.setBorrowed(false);
                    System.out.println("Book returned.");
                    return;
                } else {
                    System.out.println("Book is not borrowed.");
                    return;
                }
            }
        }
        System.out.println("Book not found.");
    }

    public void listReaders() {
        for (Reader r : readers) {
            System.out.println("Reader: " + r.getName() + ", ID: " + r.getId());
        }
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void listBooksByAuthor(String authorName) {
        for (Book b : books) {
            if (b.getAuthor().getName().equalsIgnoreCase(authorName)) {
                System.out.println(b.getTitle() + " (ISBN: " + b.getIsbn() + ")");
            }
        }
    }
}