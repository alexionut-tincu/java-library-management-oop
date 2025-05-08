public class Author extends Person {
    private String nationality;

    public Author(String name, String nationality) {
        super(name);
        this.nationality = nationality;
    }

    public String getNationality() {
        return nationality;
    }
}