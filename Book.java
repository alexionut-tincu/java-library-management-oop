public class Book implements Comparable<Book> {
    private String title;
    private Author author;
    private String isbn;
    private boolean borrowed;
    private String genre;
    private String section;

    public Book(String title, Author author, String isbn, String genre, String section) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.borrowed = false;
        this.genre = genre;
        this.section = section;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    public String getGenre() {
        return genre;
    }

    public String getSection() {
        return section;
    }

    @Override
    public int compareTo(Book other) {
        return this.title.compareTo(other.title);
    }
}