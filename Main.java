import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibraryService library = new LibraryService();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nLibrary System - Choose an action:");
            System.out.println("1. Add Book");
            System.out.println("2. Register Reader");
            System.out.println("3. List All Books");
            System.out.println("4. Loan Book");
            System.out.println("5. Return Book");
            System.out.println("6. List Readers");
            System.out.println("7. Add Author");
            System.out.println("8. List Borrowed Books");
            System.out.println("9. List Books by Author");
            System.out.println("10. Exit");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Author name: ");
                    String authorName = scanner.nextLine();
                    System.out.print("Author nationality: ");
                    String nationality = scanner.nextLine();
                    System.out.print("ISBN: ");
                    String isbn = scanner.nextLine();
                    Author author = new Author(authorName, nationality);
                    System.out.print("Genre: ");
                    String genreName = scanner.nextLine();
                    Genre genre = new Genre(genreName);
                    System.out.print("Section: ");
                    String sectionName = scanner.nextLine();
                    Section section = new Section(sectionName);
                    Book book = new Book(title, author, isbn, genre.getName(), section.getName());
                    library.addBook(book);
                    System.out.println("Book added.");
                    break;
                case 2:
                    System.out.print("Reader name: ");
                    String readerName = scanner.nextLine();
                    System.out.print("Reader ID: ");
                    int readerId = Integer.parseInt(scanner.nextLine());
                    Reader reader = new Reader(readerName, readerId);
                    library.registerReader(reader);
                    System.out.println("Reader registered.");
                    break;
                case 3:
                    library.listAllBooks();
                    break;
                case 4:
                    System.out.print("Reader ID: ");
                    int loanReaderId = Integer.parseInt(scanner.nextLine());
                    System.out.print("Book ISBN: ");
                    String loanIsbn = scanner.nextLine();
                    System.out.print("Due date (YYYY-MM-DD): ");
                    String dueDate = scanner.nextLine();
                    library.loanBookByIsbn(loanReaderId, loanIsbn, dueDate);
                    break;
                case 5:
                    System.out.print("Book ISBN: ");
                    String returnIsbn = scanner.nextLine();
                    library.returnBookByIsbn(returnIsbn);
                    break;
                case 6:
                    library.listReaders();
                    break;
                case 7:
                    System.out.print("Author name: ");
                    String aName = scanner.nextLine();
                    System.out.print("Author nationality: ");
                    String aNat = scanner.nextLine();
                    Author newAuthor = new Author(aName, aNat);
                    library.addAuthor(newAuthor);
                    System.out.println("Author added.");
                    break;
                case 8:
                    library.listBorrowedBooks();
                    break;
                case 9:
                    System.out.print("Author name: ");
                    String searchAuthor = scanner.nextLine();
                    library.listBooksByAuthor(searchAuthor);
                    break;
                case 10:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}