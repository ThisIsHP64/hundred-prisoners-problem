public class Prisoner {
    private int id;
    private Box box;

    public Prisoner(int id) {
        this.id = id;
    }

    public void setBox(Box box) {
        this.box = box;
    }

    public int getId() {
        return id;
    }
}
