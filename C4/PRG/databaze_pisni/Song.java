package databaze_pisni;

public class Song {
    private String name;
    private String author;
    private double length;   

    public Song(String name, String author, double length) {
        this.name = name;
        this.author = author;
        this.length = length;
    }

    public String getName() {
        return this.name;
    }

    public String getAuthor() {
        return this.author;
    }

    public double getLength() {
        return this.length;
    }
}
