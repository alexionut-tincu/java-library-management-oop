public class Loan {
    private Reader reader;
    private Book book;
    private String dueDate;

    public Loan(Reader reader, Book book, String dueDate) {
        this.reader = reader;
        this.book = book;
        this.dueDate = dueDate;
    }

    public Reader getReader() {
        return reader;
    }

    public Book getBook() {
        return book;
    }

    public String getDueDate() {
        return dueDate;
    }
}