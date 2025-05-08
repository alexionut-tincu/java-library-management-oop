public class Reader extends Person {
    private int id;

    public Reader(String name, int id) {
        super(name);
        this.id = id;
    }

    public int getId() {
        return id;
    }
}